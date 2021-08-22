package week3.day1.assignments;

public class AxisBank extends BankInfo {

	public void Deposit() {
		System.out.println("Deposit amount is changed to 7000");

	}

	public static void main(String[] args) {
		BankInfo info = new BankInfo();
		info.Deposit();
		info.fixed();
		info.saving();

		AxisBank bnk = new AxisBank();
		bnk.Deposit();
		bnk.fixed();
		bnk.saving();

	}
}
