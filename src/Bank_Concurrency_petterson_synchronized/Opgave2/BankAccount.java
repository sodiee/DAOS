package Bank_Concurrency_petterson_synchronized.Opgave2;

import java.util.concurrent.Semaphore;

public class BankAccount {

	private Semaphore s = new Semaphore(1);
	private double balance;

	public void setBalance(double amount, String action) {
		try {
			s.acquire();
		if (action.equals("c")) {
				balance = balance + amount;
			}
			if (action.equals("d")) {
				balance = balance - amount;
			}
			s.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public double getBalance() {
		return balance;
	}
}
