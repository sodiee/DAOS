package Bank_Concurrency_petterson_synchronized.Opgave1;

import java.util.concurrent.Semaphore;

public class BankAccount {

	private Semaphore s = new Semaphore(1);
	private double balance;

	public void setBalance(double amount, String action) {
		if (action.equals("c")) {
			balance = balance + amount;
		}
		if (action.equals("d")){
			balance = balance - amount;
		}
		
	}

	public double getBalance() {
		return balance;
	}
}
