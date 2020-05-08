import java.util.Scanner;

public class QAEmployee extends Employee {
	private int qaGeneralLevel;

	public QAEmployee() {
		super();
	}

	public int getQaGeneralLevel() {
		return qaGeneralLevel;
	}

	public void setQaGeneralLevel(int qaGeneralLevel) {
		this.qaGeneralLevel = qaGeneralLevel;
	}

	@Override
	public void addDetailsForEmployee() {

		super.addDetailsForEmployee();
		System.out.println("Please type in the general level of QA knowings for the new employee: ");
		Scanner scan = new Scanner(System.in);
		setQaGeneralLevel(scan.nextInt());
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nGeneral level of QA : %s", qaGeneralLevel);
	}
}
