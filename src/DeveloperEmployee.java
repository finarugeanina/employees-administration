import java.util.Scanner;

public class DeveloperEmployee extends Employee {
	private int devGeneralLevel;

	public DeveloperEmployee() {
		super();
	}

	public int getDevGeneralLevel() {
		return devGeneralLevel;
	}

	public void setDevGeneralLevel(int devGeneralLevel) {
		this.devGeneralLevel = devGeneralLevel;
	}

	@Override
	public void addDetailsForEmployee() {

		super.addDetailsForEmployee();
		System.out.println("Please type in the general level of Developer knowings for the new employee: ");
		Scanner scan = new Scanner(System.in);
		setDevGeneralLevel(scan.nextInt());
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nGeneral level of Developer Knowings : %s", devGeneralLevel);
	}
}
