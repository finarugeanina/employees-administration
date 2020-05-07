import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class QATeamLead extends QAEmployee {
	private int qaExperience;
	public final static String title = "QATL";

	public int getQAexperience() {
		return qaExperience;
	}

	public void setQAexperience(int qAexperience) {
		qaExperience = qAexperience;
	}



	@Override
	public void addDetails() {
		super.addDetails();
		System.out.println("Please type in the QA experience of the new employee");
		try (Scanner scan = new Scanner(System.in)) {
		this.qaExperience = scan.nextInt();
		scan.close();
	}
	}

	@SuppressWarnings("unchecked")
	public void writeJSONFileForQATeamLeadEmployee(QATeamLead qaTeamLead, String filename) throws Exception {
		JSONObject employeeDetails = new JSONObject();
		employeeDetails.put("Name", qaTeamLead.getName());
		employeeDetails.put("Employee Id", qaTeamLead.getEmployeeId());
		employeeDetails.put("CNP", qaTeamLead.getCNP());
		employeeDetails.put("Gender", qaTeamLead.getGender());
		employeeDetails.put("General QA Level", qaTeamLead.getQaGeneralLevel());
		employeeDetails.put("QA Experience", qaTeamLead.getQAexperience());
		Files.write(Paths.get(filename), employeeDetails.toJSONString().getBytes());
		System.out.println(
				"You have added a new QA Team Lead employee with: " + qaTeamLead + "\nin your " + filename
						+ " document");
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nQa experience: %s", qaExperience);
	}
}
