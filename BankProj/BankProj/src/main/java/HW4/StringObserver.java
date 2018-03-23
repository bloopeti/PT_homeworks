package HW4;

import java.util.Observable;
import java.util.Observer;

public class StringObserver implements Observer {
	private Account ov = null;
	
	public StringObserver(Account ov)
	{
		this.ov = ov;
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		if (obs == ov)
	    {
			System.out.println(ov.getAmount());
	    }
	}
}
