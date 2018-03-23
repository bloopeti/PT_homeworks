package HW4;

import java.util.HashMap;

public class Start {

	static Bank b = new Bank();
	
	public static void main(String[] args) {
		//String deafultPath = "D:\\Uni work\\Java Projects\\30423_ZavaczkiPeter_Homework4\\Persons.ser";
		//String deafultPathAcc = "D:\\Uni work\\Java Projects\\30423_ZavaczkiPeter_Homework4\\Accounts.ser";
		String deafultPathBank = "D:\\Uni work\\Java Projects\\30423_ZavaczkiPeter_Homework4\\Bank.ser";
		//b.populatePersons(deafultPath);
		//b.populateAccounts(deafultPathAcc);
		b = b.deserializeBank(deafultPathBank);
		
		PersonGUI demoP = new PersonGUI();
		AccountGUI demoA = new AccountGUI();
		//b.addPerson("John Doe");
		//b.addPerson("Jane Dos");

		//b.savePersons(deafultPath);
		//b.serializeBank(deafultPathBank);
		
		demoP.createGUI();
		demoA.createGUI();
		
		//b.removePerson(1);
//		Person p = new Person();
//		for (HashMap.Entry<Integer, Person> entry : b.persons.entrySet()) {
//			p = entry.getValue();
//			System.out.println(p.toString());
//		}
		
		//b.addAccount(2, 100, 1);
		//b.addAccount(1, 150, 2);
		//b.addAccount(2, 200, 2);
//		b.addAccount(1, 250, 1);
		
		//b.addPerson("John Uno");
//		for (HashMap.Entry<Integer, Person> entry : b.persons.entrySet()) {
//			p = entry.getValue();
//			System.out.println(p.toString());
//		}

		//b.removePerson(1);
		//b.removePerson(2);
		//b.removePerson(3);

//		for (HashMap.Entry<Integer, Person> entry : b.persons.entrySet()) {
//			p = entry.getValue();
//			System.out.println(p.toString());
//		}
		
		//b.populatePersons(deafultPath);
		//b = b.deserializeBank(deafultPathBank);
		//
//		for (HashMap.Entry<Integer, Person> entry : b.persons.entrySet()) {
//			p = entry.getValue();
//			System.out.println(p.toString());
//		}
		

		b.serializeBank(deafultPathBank);
//		b.savePersons(deafultPath);
//		b.saveAccounts(deafultPathAcc);
	}

}