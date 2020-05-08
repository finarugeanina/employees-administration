import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class EmployeesAdministrationApp {

	public static void main(String[] args) {

		switch (chooseAnOptionFromMainMenu()) {
		case 1:
			addNewEmployee();
			break;
		case 2:
			viewAllEmployees();
			break;
		case 3:
			searchEmployee();
			break;
		case 4:
			deleteEmployee();
			break;
		case 5:
			updateEmployee();
			break;
		case 6:
			convertEmployee();
			break;
		case 7:
			System.out.println("Bye Bye!");
			break;
		}
	}

	private static void addNewEmployee() {
		System.out.println("Please select the type of the new employee:"
				+ "\n1. QA Employee"
				+ "\n2. Developer Employee"
				+ "\n3. QA Team Lead Employee " + "\n4. Developer Team Lead Employee" + "\n5. Project Manager");
			Scanner scan = new Scanner(System.in);
			int typeOfTheEmployee = scan.nextInt();

			switch (typeOfTheEmployee) {
			case 1: {
				QAEmployee qa = new QAEmployee();
				System.out.println("Enter the QA employee data");
				qa.addDetailsForEmployee();
				writeJson(qa);
				break;
			}
			case 2: {
				DeveloperEmployee dev = new DeveloperEmployee();
				System.out.println("Enter the Developer employee data");
				dev.addDetailsForEmployee();
				writeJson(dev);
				break;
			}
			case 3: {
				QATeamLead qaTeamLead = new QATeamLead();
				System.out.println("Enter the QA Team Lead employee data");
				qaTeamLead.addDetailsForEmployee();
				writeJson(qaTeamLead);
				break;
			}
			case 4: {
				DeveloperTeamLead developerTeamLead = new DeveloperTeamLead();
				System.out.println("Enter the Developer Team Lead employee data");
				developerTeamLead.addDetailsForEmployee();
				writeJson(developerTeamLead);
				break;
			}
			case 5: {
				ProjectManager projectManager = new ProjectManager();
				System.out.println("Enter the Project Manager employee data");
				projectManager.addDetailsForEmployee();
				writeJson(projectManager);
				break;
			}
			}
			scan.close();
	}

	private static void writeJson(Object obj) {
		Method[] methods = obj.getClass().getMethods();
		HashMap<String, Object> employeeDetails = new HashMap<String, Object>();
		for (Method method : methods) {
			if (method.getName().startsWith("get") && !method.getName().equals("getClass")) {
				try {
					employeeDetails.put(method.getName().replace("get", ""), method.invoke(obj));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		JSONObject employeeDetailsJson = new JSONObject(employeeDetails);
		try {
			Files.write(Paths.get("employees.json"), employeeDetailsJson.toJSONString().getBytes());
		} catch (IOException e) {
			System.out.println("The file wasn't created");
		}
		System.out.println("You have added a new " + obj.getClass().getName() + " with: " + obj
				+ "\nin your employees.json document");
	}

	private static int chooseAnOptionFromMainMenu() {
		Map<Integer, String> options = new HashMap<>();
		options.put(1, ". Add a new employee");
		options.put(2, ". View all employees");
		options.put(3, ". Search an employee");
		options.put(4, ". Delete an employee");
		options.put(5, ". Update existing employee");
		options.put(6, ". Convert the type of an employee");
		options.put(7, ". Exit Application");

		System.out.println("Hello! Please select an option:\n" + "1. Add a new employee\n" + "2. View all employees\n"
				+ "3. Search an employee\n" + "4. Delete an employee\n" + "5. Update existing employee\n"
				+ "6. Convert the type of an employee\n" + "7. Exit Application");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		System.out.println("You have selected " + number + options.get(number));
		return number;
	}
	
	private static void convertEmployee() {
		System.out.println("Please type in the employeeId of the employee you want to convert: ");
	}

	private static void updateEmployee() {
		System.out.println("Please type in the employeeId of the employee you want to edit: ");
	}

	private static void deleteEmployee() {
		System.out.println("Please type in the employeeId of the employee you want to delete: ");
	}

	private static void searchEmployee() {
		System.out.println("Search an employee after:\n1. Name\n2.EmployeeId");
	}
	
	private static void viewAllEmployees() {
		System.out.println("This is the list of all employees: ");
	}
}
