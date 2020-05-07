import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class DeveloperEmployee extends Employee {
	private int devGeneralLevel;
	public final static String title = "DEV";

	public DeveloperEmployee() {
		super();
	}


	public int getDevGeneralLevel() {
		return devGeneralLevel;
	}

	public void setDevGeneralLevel(int devGeneralLevel) {
		this.devGeneralLevel = devGeneralLevel;
	}


	@Override
	public void addDetails() {
		super.addDetails();
		System.out.println("Please type in the general level of Developer knowings for the new employee: ");
		Scanner scan = new Scanner(System.in);
		this.devGeneralLevel = scan.nextInt();

	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nGeneral level of Developer Knowings : %s", devGeneralLevel);

	}

	@SuppressWarnings("unchecked")
	public void writeJSONFileForDevEmployee(DeveloperEmployee dev, String filename) throws Exception {
		JSONObject employeeDetails = new JSONObject();
		employeeDetails.put("Name", dev.getName());
		employeeDetails.put("Employee Id", dev.getEmployeeId());
		employeeDetails.put("CNP", dev.getCNP());
		employeeDetails.put("Gender", dev.getGender());
		employeeDetails.put("General Developer Level", dev.getDevGeneralLevel());
		System.out
				.println(
						"You have added a new Developer employee with: " + dev + "\nin your " + filename + " document");

		Files.write(Paths.get(filename), employeeDetails.toJSONString().getBytes());
	}

}
