package HW4;

import java.io.Serializable;
import java.util.Observable;

public class Account extends Observable implements Serializable {

	protected int id;
	protected int amount;
	protected int ownerId;

	public Account() {
		super();
	}
	
	/**
	 * @param id
	 * @param amount
	 * @param ownerId
	 */
	public Account(int id, int amount, int ownerId) {
		super();
		this.id = id;
		this.amount = amount;
		this.ownerId = ownerId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * @return the ownerId
	 */
	public int getOwnerId() {
		return ownerId;
	}
	
	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", amount=" + amount + ", ownerId=" + ownerId + "]";
	}

}
