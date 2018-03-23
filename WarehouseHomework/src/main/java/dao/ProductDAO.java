package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import connection.ConnectionFactory;
import model.Product;

public class ProductDAO 
{

	protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO product (name,nr)"
			+ " VALUES (?,?)";
	private final static String findStatementString = "SELECT * FROM product where id = ?";
	private final static String deleteStatementString = "DELETE FROM product WHERE id = ?";
	private final static String editStatementString = "UPDATE product SET name = ?, nr = ? WHERE id = ?";
	private final static String findAllStatementString = "SELECT * FROM product";
	private final static String decStatementString = "UPDATE product SET nr = nr - ? WHERE id = ?";

	public static Product findById(int productId) 
	{
		Product toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try 
		{
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, productId);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			int nr = rs.getInt("nr");
			toReturn = new Product(productId, name, nr);
		} 
		catch (SQLException e) 
		{
			LOGGER.log(Level.WARNING,"ProductDAO:findById " + e.getMessage());
		} 
		finally 
		{
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}

	public static int insert(Product product) 
	{
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try 
		{
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, product.getName());
			insertStatement.setInt(2, product.getNr());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) 
			{
				insertedId = rs.getInt(1);
			}
		} 
		catch (SQLException e) 
		{
			LOGGER.log(Level.WARNING,"ProductDAO:findById " + e.getMessage());
		} 
		finally 
		{
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	
	public static Product delete(int id) 
	{
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement deleteStatement = null;
		Product deleted = null;
		try 
		{
			deleted = findById(id);
			
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setInt(1, id);
			deleteStatement.executeUpdate();
		} 
		catch (SQLException e) 
		{
			LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
		} 
		finally 
		{
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
		return deleted;
	}

	public static int edit(Product product) 
	{
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement editStatement = null;
		int editedId = -1;
		try 
		{
			editStatement = dbConnection.prepareStatement(editStatementString, Statement.RETURN_GENERATED_KEYS);
			editStatement.setString(1, product.getName());
			editStatement.setInt(2, product.getNr());
			editStatement.setInt(3, product.getId());
			editStatement.executeUpdate();

			ResultSet rs = editStatement.getGeneratedKeys();
			if (rs.next()) 
			{
				editedId = rs.getInt(1);
			}
		} 
		catch (SQLException e) 
		{
			LOGGER.log(Level.WARNING, "ProductDAO:edit " + e.getMessage());
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
				String name = rs.getString("name");
				int nr = rs.getInt("nr");
				System.out.println("id: " + id + " name: " + name + " nr: " + nr);
				toReturn++;
			}
		} 
		catch (SQLException e) 
		{
			LOGGER.log(Level.WARNING,"ProductDAO:findAll " + e.getMessage());
		} 
		finally 
		{
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findAllStatement);
			ConnectionFactory.close(dbConnection);
		}
		return returning;
	}
	
	public static int dec(int id, int nr) 
	{
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement decStatement = null;
		int decedNr = -1;
		@SuppressWarnings("unused")
		int decedId = -1;

		Product deced = null;
		try 
		{
			deced = findById(id);
			if (deced.getNr() - nr < 0)
			{
//				System.out.println("Not enough products for this order!");

				decStatement = dbConnection.prepareStatement(decStatementString, Statement.RETURN_GENERATED_KEYS);
				decStatement.setInt(1, deced.getNr());
				decStatement.setInt(2, id);
				decStatement.executeUpdate();
				decedNr = deced.getNr();
			}
			else
			{
			decStatement = dbConnection.prepareStatement(decStatementString, Statement.RETURN_GENERATED_KEYS);
			decStatement.setInt(1, nr);
			decStatement.setInt(2, id);
			decStatement.executeUpdate();
			decedNr = nr;
			}
			ResultSet rs = decStatement.getGeneratedKeys();
			if (rs.next()) 
			{
				decedId = rs.getInt(1);
			}
		} 
		catch (SQLException e) 
		{
			LOGGER.log(Level.WARNING, "ProductDAO:edit " + e.getMessage());
		} 
		finally 
		{
			ConnectionFactory.close(decStatement);
			ConnectionFactory.close(dbConnection);
		}
		return decedNr;
	}
}
