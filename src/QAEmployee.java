import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class QAEmployee extends Employee {
	private int qaGeneralLevel;
	public final static String title = "QA";

	public QAEmployee() {
		super();
	}


	public int getQaGeneralLevel() {
		return qaGeneralLevel;
	}

	public void setQaGeneralLevel(int qaGeneralLevel) {
		this.qaGeneralLevel = qaGeneralLevel;
	}


	@Override
	public void addDetails() {
		super.addDetails();
		System.out.println("Please type in the general level of QA knowings for the new employee: ");
		Scanner scan = new Scanner(System.in);
		this.qaGeneralLevel = scan.nextInt();
	}

	@SuppressWarnings("unchecked")
	public void writeJSONFileForQaEmployee(QAEmployee qa, String filename) throws Exception {
		JSONObject employeeDetails = new JSONObject();
		employeeDetails.put("Name", qa.getName());
		employeeDetails.put("Employee Id", qa.getEmployeeId());
		employeeDetails.put("CNP", qa.getCNP());
		employeeDetails.put("Gender", qa.getGender());
		employeeDetails.put("General QA Level", qa.getQaGeneralLevel());
		System.out.println("You have added a new QA employee with: " + qa + "\nin your " + filename + " document");

		Files.write(Paths.get(filename), employeeDetails.toJSONString().getBytes());
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nGeneral level of QA : %s", qaGeneralLevel);
	}

}
