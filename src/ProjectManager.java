import java.util.Scanner;

public class ProjectManager extends Employee {
	protected int pmExperience;

	public ProjectManager() {
		super();
	}

	public int getPMExperience() {
		return pmExperience;
	}

	public void setPMExperience(int pmExperience) {
		this.pmExperience = pmExperience;
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
