import java.util.Scanner;

public class QATeamLead extends QAEmployee {
	private int qaExperience;
	Scanner scan = new Scanner(System.in);

	public int getQAexperience() {
		return qaExperience;
	}

	public void setQAexperience(int qaExperience) {
		if (qaExperience < 1 || qaExperience > 20) {
			System.out.println("Please re-enter a value between 1 and 20: ");
			setQAexperience(scan.nextInt());
		} else {
			this.qaExperience = qaExperience;
		}
	}

	@Override
	public void addDetailsForEmployee() {
		super.addDetailsForEmployee();
		System.out.println("Please type in the QA experience of the new employee");
		setQAexperience(scan.nextInt());
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nQa experience: %s", qaExperience);
	}
}
