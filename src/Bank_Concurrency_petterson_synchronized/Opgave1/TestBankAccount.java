package Bank_Concurrency_petterson_synchronized.Opgave1;

public class TestBankAccount {

	private static int turn;

	private static boolean[] flag;

	public static void main(String[] args) {
		flag = new boolean[2];
		flag[0] = false;
		flag[1] = false;
		turn = 1;


		BankAccount ba = new BankAccount();
			BankAccountTraad bat1 = new BankAccountTraad(ba);
			BankAccountTraad2 bat2 = new BankAccountTraad2(ba);
			
			bat1.start();
			bat2.start();
		}

		public static boolean getFlag(int indeks) {
		return flag[indeks];
		}

		public static int getTurn() {
		return turn;
		}

		public static void setFlag(int indeks, boolean vaerdi) {flag[indeks] = vaerdi;}

		public static void setTurn(int setValue) {
		turn = setValue;
		}
}
