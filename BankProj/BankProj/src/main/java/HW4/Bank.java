package HW4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Bank implements BankProc, Serializable {

	public Map<Integer, Person> persons = new HashMap<Integer, Person>();
	public Map<Integer, Account> accounts = new HashMap<Integer, Account>();
	//public List<MonitoredData> monitoredData = new ArrayList<MonitoredData>();
	
	
	public void addPerson(String name) {
		int key = this.persons.size() + 1;
		this.persons.put(key, new Person(key, name));
	}
	
	public void addPerson(Person p) {
		int key = this.persons.size() + 1;
		this.persons.put(key, p);
	}
	
	public Person removePerson(int key) {
		Person p = (Person) persons.get(key);
		this.persons.remove(key);
		return p;
	}

	public void addAccount(int type, int amount, int ownerId) {
		assert amount > 0;
		assert (type == 1) || (type == 2);
		int key = this.accounts.size() + 1;
		Account a = null;
		if (type == 1)//saving
		{
			a = new SavingAccount(key, amount, ownerId, 0.1, LocalDateTime.now());
			this.accounts.put(key, a);
		}
		else if (type == 2)//spending
		{
			a = new SpendingAccount(key, amount, ownerId);
			this.accounts.put(key, a);
		}
		StringObserver so = new StringObserver((Account)a);
		a.addObserver(so);
		this.persons.get(key).attach(so);
	}
	
	public void addAccount(Account a, int type) {
		int key = this.accounts.size() + 1;
		if (type == 1)//saving
		{
			this.accounts.put(key, (SavingAccount) a);
		}
		else if (type == 2)//spending
		{
			this.accounts.put(key, (SpendingAccount) a);
		}
		StringObserver so = new StringObserver(a);
		a.addObserver(so);
		this.persons.get(key).attach(so);
	}

	public void depositAccount(int inKey, int type, int amount, int ownerId) {
		int key = inKey;
		Object o = accounts.get(key);
		SavingAccount sva = new SavingAccount();
		SpendingAccount spa = new SpendingAccount();
		if(accounts.get(key).getClass() == spa.getClass())
		{
			spa = (SpendingAccount) o;
			spa.deposit(amount);
		}
		else if(accounts.get(key).getClass() == sva.getClass())
		{
			sva = (SavingAccount) o;
			sva.deposit(amount);
		}
		
		this.accounts.put(key, accounts.get(key));
	}
	
	public void withdrawAccount(int inKey, int type, int amount, int ownerId) {
		int key = inKey;
		Object o = accounts.get(key);
		SavingAccount sva = new SavingAccount();
		SpendingAccount spa = new SpendingAccount();
		if(accounts.get(key).getClass() == spa.getClass())
		{
			spa = (SpendingAccount) o;
			spa.withdraw(amount);
			this.accounts.put(key, spa);
		}
		else if(accounts.get(key).getClass() == sva.getClass())
		{
			sva = (SavingAccount) o;
			sva.withdraw(amount);
			this.accounts.put(key, sva);
		}
		
	}
	
	public Object removeAccount(int key) {
		assert key > 0;
		SavingAccount sva = new SavingAccount();
		SpendingAccount spa = new SpendingAccount();
		//////////////////////////////////POSSIBLE ERROR////////////////////////////////////////////////////////////////////
		if(accounts.get(key).getClass() == spa.getClass())
		{
			spa = (SpendingAccount) accounts.get(key);
			this.accounts.remove(key);
			return spa;
		}
		else if(accounts.get(key).getClass() == sva.getClass())
		{
			sva = (SavingAccount) accounts.get(key);
			this.accounts.remove(key);
			return sva;
		}
		
		return null;
	}

	public void serializeBank(String path)
	{
		try {
			FileOutputStream fo = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(this);
			out.close();
			fo.close();
			System.out.println("t was written in " + path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Bank deserializeBank(String path)
	{
		Bank b = new Bank();
		try {
			FileInputStream fi = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fi);
			b = (Bank) in.readObject();
			in.close();
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public void serializePerson(String path, Person p)
	{
		try {
			FileOutputStream fo = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(p);
			out.close();
			fo.close();
			System.out.println("t was written in " + path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Person deserializePerson(String path)
	{
		Person p = new Person();
		try {
			FileInputStream fi = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fi);
			p = (Person) in.readObject();
			in.close();
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public void serializeSavingAccount(String path, SavingAccount p)
	{
		try {
			FileOutputStream fo = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(p);
			out.close();
			fo.close();
			System.out.println("t was written in " + path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SavingAccount deserializeSavingAccount(String path)
	{
		SavingAccount p = new SavingAccount();
		try {
			FileInputStream fi = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fi);
			p = (SavingAccount) in.readObject();
			in.close();
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public void serializeSpendingAccount(String path, SpendingAccount p)
	{
		try {
			FileOutputStream fo = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(p);
			out.close();
			fo.close();
			System.out.println("t was written in " + path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SpendingAccount deserializeSpendingAccount(String path)
	{
		SpendingAccount p = new SpendingAccount();
		try {
			FileInputStream fi = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fi);
			p = (SpendingAccount) in.readObject();
			in.close();
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return p;
	}

	public void savePersons(String path)
	{
		Person p = new Person();
		try
		{
			FileOutputStream fo = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fo);
			
			for (HashMap.Entry<Integer, Person> entry : this.persons.entrySet()) {
				p = entry.getValue();
				out.writeObject(p);
			}
	
			out.close();
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void populatePersons(String path)
	{
		Person p = new Person();
		try {
			FileInputStream fi = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fi);
			
			while((p = (Person) in.readObject()) != null)
			{
				addPerson(p);
			}
			
			in.close();
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void saveAccounts(String path)
	{
		Object p = new Account();
		
		try {
			FileOutputStream fo = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fo);
			
			for (HashMap.Entry<Integer, Account> entry : this.accounts.entrySet()) {
				p = entry.getValue();
				if(p.getClass() == SavingAccount.class)
					out.writeObject((SavingAccount) p);
				else if(p.getClass() == SpendingAccount.class)
					out.writeObject((SpendingAccount) p);
			}
			
			out.close();
			fo.close();
			System.out.println("t was written in " + path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void populateAccounts(String path)
	{
		Object p = new Account();
		try {
			FileInputStream fi = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fi);
			
			while((p = in.readObject()) != null)
			{
				if(p.getClass() == SavingAccount.class)
				{
					addAccount((Account)p, 1);
				}
				else if(p.getClass() == SpendingAccount.class)
				{
					addAccount((Account)p, 2);
				}
			}
			
			in.close();
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public DefaultTableModel toTableModelPerson() {
		Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("Name");
	    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	    for (Map.Entry<Integer, Person> entry : this.persons.entrySet()) {
	    	Vector<Object> vector = new Vector<Object>();
	    	vector.add(entry.getValue().getId());
	    	vector.add(entry.getValue().getName());
	        model.addRow(vector);
	    }
	    return model;
	}
	
	public JTable createPersonsTable()
	{
		JTable t = new JTable(toTableModelPerson());
		return t;
	}
	
	public DefaultTableModel toTableModelAccount() {
	    DefaultTableModel model = new DefaultTableModel(new Object[] { "ID", "Amount", "Owner", "Type" }, 0);
	    for (Map.Entry<Integer, Account> entry : this.accounts.entrySet()) {
	        model.addRow(new Object[] { entry.getKey(), entry.getValue().getAmount(), 
	        		entry.getValue().getOwnerId(), entry.getValue().getClass().toString() });
	    }
	    return model;
	}
	
	public JTable createAccountsTable()
	{
		JTable t = new JTable(toTableModelPerson());
		return t;
	}

}
