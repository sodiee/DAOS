package Bank_Concurrency_petterson_synchronized.Opgave1;

public class BankAccountTraad extends Thread {

	private BankAccount ba;

	public BankAccountTraad(BankAccount ba) {
		this.ba = ba;
	}

	public void run() {
		int i = 0;
		while (i < 4) {
			try {
				this.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			TestBankAccount.setFlag(0, true);
			TestBankAccount.setTurn(1);
			while (TestBankAccount.getFlag(1) && TestBankAccount.getTurn() == 1) {}
				ba.setBalance(100, "c");
				TestBankAccount.setFlag(0, false);
				i++;
		}
		System.out.println("Balancen er: " + ba.getBalance());
	}

}
