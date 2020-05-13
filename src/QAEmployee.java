import java.util.Scanner;

public class QAEmployee extends Employee {
	private int qaGeneralLevel;
	Scanner scan = new Scanner(System.in);

	public int getQaGeneralLevel() {
		return qaGeneralLevel;
	}

	public void setQaGeneralLevel(int qaGeneralLevel) {
		if (qaGeneralLevel < 1 || qaGeneralLevel > 10) {
			System.out.println("Please re-enter a value between 1 and 10: ");
			setQaGeneralLevel(scan.nextInt());
		} else {
			this.qaGeneralLevel = qaGeneralLevel;
		}
	}

	@Override
	public void addDetailsForEmployee() {
		super.addDetailsForEmployee();
		System.out.println("Please type in the general level of QA knowings for the new employee: ");
		setQaGeneralLevel(scan.nextInt());
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nGeneral level of QA : %s", qaGeneralLevel);
	}
}
