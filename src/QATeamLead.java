import java.util.Scanner;

public class QATeamLead extends QAEmployee {
	private int qaExperience;

	public int getQAexperience() {
		return qaExperience;
	}

	public void setQAexperience(int qAexperience) {
		qaExperience = qAexperience;
	}

	@Override
	public void addDetailsForEmployee() {

		super.addDetailsForEmployee();
		System.out.println("Please type in the QA experience of the new employee");
		try (Scanner scan = new Scanner(System.in)) {
			setQAexperience(scan.nextInt());
		}
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nQa experience: %s", qaExperience);
	}
}
