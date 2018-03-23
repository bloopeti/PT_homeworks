package HW4;

public interface BankProc {
	public void addPerson(String name);
	public Person removePerson(int key);

	/**
	 * @pre amount > 0
	 * @pre (type == 1) || (type == 2)
	 */
	public void addAccount(int type, int amount, int ownerId);
	/**
	 * @pre key > 0
	 */
	public Object removeAccount(int key);
}
