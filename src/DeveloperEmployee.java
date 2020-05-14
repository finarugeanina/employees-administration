import java.util.Scanner;

public class DeveloperEmployee extends Employee {
	private int devGeneralLevel;
	Scanner scan = new Scanner(System.in);

	public int getDevGeneralLevel() {
		return devGeneralLevel;
	}

	public void setDevGeneralLevel(int devGeneralLevel) {
		if (devGeneralLevel < 1 || devGeneralLevel > 10) {
			System.out.println("Please re-enter a value between 1 and 10: ");
			setDevGeneralLevel(scan.nextInt());
		} else {
			this.devGeneralLevel = devGeneralLevel;
		}
	}

	@Override
	public void addDetailsForEmployee() {
		super.addDetailsForEmployee();
		System.out.println("Please type in the general level of Developer knowings for the new employee: ");
		setDevGeneralLevel(scan.nextInt());
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nGeneral level of Developer Knowings : %s", devGeneralLevel);
	}
}
