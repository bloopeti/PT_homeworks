package HW4;

import java.time.LocalDateTime;

public class SavingAccount extends Account {

	private double interest;
	private LocalDateTime time;
	
	
	public SavingAccount() {
		super();
	}
	
	/**
	 * @param id
	 * @param amount
	 * @param ownerId
	 * @param interest
	 * @param time
	 */
	public SavingAccount(int id, int amount, int ownerId, double interest, LocalDateTime time) {
		super(id, amount, ownerId);
		this.interest = interest;
		this.time = time;
	}

	/**
	 * @return the interest
	 */
	public double getInterest() {
		return interest;
	}

	/**
	 * @param interest the interest to set
	 */
	public void setInterest(double interest) {
		this.interest = interest;
	}

	/**
	 * @return the time
	 */
	public LocalDateTime getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	/**
	 * @param amount
	 * @return
	 */
	public int deposit(int amount) {
		if (time.plusMinutes(1).compareTo(LocalDateTime.now()) > 0)
		{
			System.out.println("Not enough time has passed");
			return -1;
		}
		else
		{
			int newAmount = super.amount += amount;
			this.time = LocalDateTime.now();
			setChanged();
			notifyObservers();
			return newAmount;
		}
	}
	
	/**
	 * @param amount
	 * @return
	 */
	public int withdraw(int amount) {
		if (time.plusMinutes(1).compareTo(LocalDateTime.now()) > 0)
		{
			System.out.println("Not enough time has passed");
			return -1;
		}
		else
		{
			int newAmount = super.amount -= amount;
			this.time = LocalDateTime.now();
			setChanged();
			notifyObservers();
			return newAmount;
		}
	}

	/**
	 * @return
	 */
	public double getInterestAmount() {
		return super.amount*interest;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SavingAccount [interest=" + interest + ", time=" + time + ", id=" + id + ", amount=" + amount
				+ ", ownerId=" + ownerId + "]";
	}
}
