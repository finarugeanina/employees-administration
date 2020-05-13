import java.util.Scanner;

public class ProjectManager extends Employee {
	protected int pmExperience;

	public int getPMExperience() {
		return pmExperience;
	}

	public void setPMExperience(int pmExperience) {
		if (pmExperience < 1 || pmExperience > 20) {
			System.out.println("Please re-enter a value between 1 and 20: ");
			setPMExperience(scan.nextInt());
		} else {
			this.pmExperience = pmExperience;
		}
	}

	@Override
	public void addDetailsForEmployee() {
		super.addDetailsForEmployee();
		System.out.println("Please type in the PM Experience for the new employee: ");
		try (Scanner scan = new Scanner(System.in)) {
			setPMExperience(scan.nextInt());
		}
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nPM Experience : %s", pmExperience);
	}
}
