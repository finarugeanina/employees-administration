import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class ProjectManager extends Employee {
	protected int pmExperience;
	public final static String title = "PM";

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
	public void addDetails() {
		super.addDetails();
		System.out.println("Please type in the PM Experience for the new employee: ");
		Scanner scan = new Scanner(System.in);
		this.pmExperience = scan.nextInt();
		scan.close();
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nPM Experience : %s", pmExperience);

	}

	@SuppressWarnings("unchecked")
	public void writeJSONFileForProjectManagerEmployee(ProjectManager projectManager, String filename)
			throws IOException {
		JSONObject employeeDetails = new JSONObject();
		employeeDetails.put("Name", projectManager.getName());
		employeeDetails.put("Employee Id", projectManager.getEmployeeId());
		employeeDetails.put("CNP", projectManager.getCNP());
		employeeDetails.put("Gender", projectManager.getGender());
		employeeDetails.put("PM Experience", projectManager.getPMExperience());
		Files.write(Paths.get(filename), employeeDetails.toJSONString().getBytes());
		System.out.println("You have added a new Developer Team Lead employee with: " + projectManager + "in your "
				+ filename + " document");

	}

}
