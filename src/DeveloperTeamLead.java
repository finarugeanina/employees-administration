import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class DeveloperTeamLead extends DeveloperEmployee {
	private int developerExperience;
	public final static String title = "DEVTL";

	public int getDeveloperExperience() {
		return developerExperience;
	}

	public void setDeveloperExperience(int devExperience) {
		developerExperience = devExperience;
	}



	@Override
	public void addDetails() {
		super.addDetails();
		System.out.println("Please type in the Developer experience of the new employee");
		Scanner scan = new Scanner(System.in);
		this.developerExperience = scan.nextInt();
		scan.close();
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nDeveloper experience: %s", developerExperience);
	}

	@SuppressWarnings("unchecked")
	public void writeJSONFileForDeveloperTeamLeadEmployee(DeveloperTeamLead developerTeamLead, String filename)
			throws IOException {
		JSONObject employeeDetails = new JSONObject();
		employeeDetails.put("Name", developerTeamLead.getName());
		employeeDetails.put("Employee Id", developerTeamLead.getEmployeeId());
		employeeDetails.put("CNP", developerTeamLead.getCNP());
		employeeDetails.put("Gender", developerTeamLead.getGender());
		employeeDetails.put("General Developer Level", developerTeamLead.getDevGeneralLevel());
		employeeDetails.put("Developer Experience", developerTeamLead.getDeveloperExperience());
		Files.write(Paths.get(filename), employeeDetails.toJSONString().getBytes());
		System.out.println("You have added a new Developer Team Lead employee with: " + developerTeamLead
				+ "\nin your "
				+ filename + " document");
	}
}
