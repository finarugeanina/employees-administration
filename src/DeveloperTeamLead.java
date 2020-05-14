import java.util.Scanner;

public class DeveloperTeamLead extends DeveloperEmployee {
	private int developerExperience;

	public int getDeveloperExperience() {
		return developerExperience;
	}

	public void setDeveloperExperience(int developerExperience) {
		if (developerExperience < 1 || developerExperience > 20) {
			System.out.println("Please re-enter a value between 1 and 20: ");
			setDeveloperExperience(scan.nextInt());
		} else {
			this.developerExperience = developerExperience;
		}
	}

	@Override
	public void addDetailsForEmployee() {
		super.addDetailsForEmployee();
		System.out.println("Please type in the Developer experience of the new employee");
		try (Scanner scan = new Scanner(System.in)) {
			setDeveloperExperience(scan.nextInt());
		}
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nDeveloper experience: %s", developerExperience);
	}
}
