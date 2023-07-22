package Bank_Concurrency_petterson_synchronized.Opgave3;

public class BankAccountTraad2 extends Thread {

	private BankAccount ba;

	public BankAccountTraad2(BankAccount ba) {
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
				ba.setBalance(100, "d");
				i++;
		}
		System.out.println("Balancen er: " + ba.getBalance());
	}

}
