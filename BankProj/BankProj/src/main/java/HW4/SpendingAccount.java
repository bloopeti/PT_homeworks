package HW4;


public class SpendingAccount extends Account {

	public SpendingAccount() {
		super();
	}
	
	/**
	 * @param id
	 * @param amount
	 * @param ownerId
	 */
	public SpendingAccount(int id, int amount, int ownerId) {
		super(id, amount, ownerId);
		// TODO Auto-generated constructor stub
	}

	public int deposit(int amount) {
		int newAmount = super.amount += amount;
		setChanged();
		notifyObservers();
		return newAmount;
	}
	
	public int withdraw(int amount) {
		int newAmount = super.amount -= amount;
		setChanged();
		notifyObservers();
		return newAmount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SpendingAccount [id=" + id + ", amount=" + amount + ", ownerId=" + ownerId + "]";
	}
}
