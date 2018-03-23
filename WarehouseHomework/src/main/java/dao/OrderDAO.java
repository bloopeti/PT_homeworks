package dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import connection.ConnectionFactory;
import model.Order;

public class OrderDAO 
{

	protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO warehouse.order (client,product,nr)"
			+ " VALUES (?,?,?)";
	private final static String findStatementString = "SELECT * FROM warehouse.order where id = ?";
	private final static String deleteStatementString = "DELETE FROM warehouse.order WHERE id = ?";
	private final static String editStatementString = "UPDATE warehouse.order SET client = ?, product = ?, nr = ? WHERE id = ?";
	private final static String findAllStatementString = "SELECT * FROM warehouse.order";

	public static Order findById(int orderId) 
	{
		Order toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try 
		{
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, orderId);
			rs = findStatement.executeQuery();
			rs.next();

			String client = rs.getString("client");
			String product = rs.getString("product");
			int nr = rs.getInt("nr");
			toReturn = new Order(orderId, client, product, nr);
		} 
		catch (SQLException e) 
		{
			LOGGER.log(Level.WARNING,"OrderDAO:findById " + e.getMessage());
		} 
		finally 
		{
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	
	private static void createDocument(String[] order)
	{
	   final PDPage singlePage = new PDPage();
	   final PDFont courierBoldFont = PDType1Font.COURIER_BOLD;
	   final int fontSize = 12;
	   try (final PDDocument document = new PDDocument())
	   {
	      document.addPage(singlePage);
	      final PDPageContentStream contentStream = new PDPageContentStream(document, singlePage);
	      contentStream.beginText();
	      contentStream.setFont(courierBoldFont, fontSize);
	      
	      contentStream.newLineAtOffset(150, 750);
	      contentStream.showText(order[0]);
	      contentStream.newLineAtOffset(0, -fontSize * 1.5f);
	      contentStream.showText(order[1]);
	      contentStream.newLineAtOffset(0, -fontSize * 1.5f);
	      contentStream.showText(order[2]);
	      contentStream.newLineAtOffset(0, -fontSize * 1.5f);
	      contentStream.showText(order[3]);
	      
	      contentStream.endText();
	      contentStream.close();  // Stream must be closed before saving document.
	      document.save(new File("Order.pdf"));
	   }
	   catch (IOException ioEx)
	   {
		   LOGGER.log(Level.WARNING,"Exception while trying to create simple document - " + ioEx.getMessage());
	   }
	}

	public static int insert(Order order) 
	{
		Connection dbConnection = ConnectionFactory.getConnection();

		String[] bill = {"", "", "", ""};
		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try 
		{
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, order.getClient());
			insertStatement.setString(2, order.getProduct());
			insertStatement.setInt(3, order.getNr());
			@SuppressWarnings("unused")
			String findStatementLoc = insertStatement.toString(); 
//			System.out.println(findStatementLoc);
			insertStatement.executeUpdate();
			
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) 
			{
				insertedId = rs.getInt(1);
			}
			bill[0] = bill[0] + "Bill no." + insertedId + "        ";
			bill[1] = bill[1] + "Client: " + order.getClient() + ";s ";
			bill[2] = bill[2] + "Product: " + order.getProduct() + "; ";
			bill[3] = bill[3] + "Nr: " + order.getNr();
			createDocument(bill);
		} 
		catch (SQLException e) 
		{
			LOGGER.log(Level.WARNING, "OrderDAO:insert " + e.getMessage());
		} 
		finally 
		{
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	
	public static Order delete(int id) 
	{
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement deleteStatement = null;
		Order deleted = null;
		try 
		{
			deleted = findById(id);
			
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setInt(1, id);
			deleteStatement.executeUpdate();
		} 
		catch (SQLException e) 
		{
			LOGGER.log(Level.WARNING, "OrderDAO:insert " + e.getMessage());
		} 
		finally 
		{
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
		return deleted;
	}
	
	public static int edit(Order order) 
	{
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement editStatement = null;
		int editedId = -1;
		try 
		{
			editStatement = dbConnection.prepareStatement(editStatementString, Statement.RETURN_GENERATED_KEYS);
			editStatement.setString(1, order.getClient());
			editStatement.setString(2, order.getProduct());
			editStatement.setInt(3, order.getNr());
			editStatement.setInt(4, order.getId());
			editStatement.executeUpdate();

			ResultSet rs = editStatement.getGeneratedKeys();
			if (rs.next()) 
			{
				editedId = rs.getInt(1);
			}
		} 
		catch (SQLException e) 
		{
			LOGGER.log(Level.WARNING, "OrderDAO:edit " + e.getMessage());
		} 
		finally 
		{
			ConnectionFactory.close(editStatement);
			ConnectionFactory.close(dbConnection);
		}
		return editedId;
	}

	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    java.sql.ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);
	}
	
	public static DefaultTableModel findAll() 
	{
		@SuppressWarnings("unused")
		int toReturn = 0;
		DefaultTableModel returning = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findAllStatement = null;
		ResultSet rs = null;
		try 
		{
			findAllStatement = dbConnection.prepareStatement(findAllStatementString);
			rs = findAllStatement.executeQuery();
			returning = buildTableModel(rs);
			while(rs.next())
			{
				int id = rs.getInt("id");
				String client = rs.getString("client");
				String product = rs.getString("product");
				int nr = rs.getInt("nr");
				System.out.println("id: " + id + " client: " + client + " product: " + product + " nr: " + nr);
				toReturn++;
			} 
		} 
		catch (SQLException e) 
		{
			LOGGER.log(Level.WARNING,"OrderDAO:findAll " + e.getMessage());
		} 
		finally 
		{
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findAllStatement);
			ConnectionFactory.close(dbConnection);
		}
		return returning;
	}
}
