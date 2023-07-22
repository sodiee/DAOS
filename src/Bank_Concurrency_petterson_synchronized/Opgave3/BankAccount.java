package Bank_Concurrency_petterson_synchronized.Opgave3;

import java.util.concurrent.Semaphore;

public class BankAccount {

	private Semaphore semaphore = new Semaphore(2);

	private double balance;

	public void setBalance(double amount, String action) {
		try {
			semaphore.acquire();
			if (action.equals("c")) {
				balance = balance + amount;
			}
			if (action.equals("d")){
				balance = balance - amount;
			}
			semaphore.release();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		
	}

	public double getBalance() {
		return balance;
	}
}
