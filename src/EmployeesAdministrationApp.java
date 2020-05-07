import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeesAdministrationApp {

	public static void main(String[] args) throws Exception {

		// Choose an option from Main Menu

		int number = chooseAnOptionFromMainMenu();
		Scanner scan = new Scanner(System.in);


		switch (number) {
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
		case 7:
			System.out.println("Bye Bye!");

		}
		scan.close();
	}

	private static void addNewEmployee() throws Exception {
		{
			System.out.println(
					"Please select the type of the new employee:"
							+ "\n1. QA Employee"
							+ "\n2. Developer Employee"
							+ "\n3. QA Team Lead Employee "
					+ "\n4. Developer Team Lead Employee"
					+ "\n5. Project Manager");
			Scanner scan = new Scanner(System.in);
			int typeOfTheEmployee = scan.nextInt();

			switch (typeOfTheEmployee) {
			case 1:
			{	
				addQAEmployee();
				break;
			}
			case 2: {
				addDeveloperEmployee();
				break;
			}
			case 3: {
				addQATeamLeadEmployee();
				break;
			}

			case 4: {
				addDeveloperTeamLeadEmployee();
				break;
			}

			case 5: {
				addProjectManagerEmployee();
				break;
			}

			}
			scan.close();

		}
	}


	private static void addQAEmployee() throws Exception {
		QAEmployee qa = new QAEmployee();
		System.out.println("Enter the QA employee data");
		qa.addDetails();
		qa.writeJSONFileForQaEmployee(qa, "employees.json");

	}

	private static void addDeveloperEmployee() throws Exception {
		DeveloperEmployee dev = new DeveloperEmployee();
		System.out.println("Enter the Developer employee data");
		dev.addDetails();
		dev.writeJSONFileForDevEmployee(dev, "employees.json");
	}

	private static void addQATeamLeadEmployee() throws Exception {
		QATeamLead qaTeamLead = new QATeamLead();
		System.out.println("Enter the QA Team Lead employee data");
		qaTeamLead.addDetails();
		qaTeamLead.writeJSONFileForQATeamLeadEmployee(qaTeamLead, "employees.json");
	}

	private static void addDeveloperTeamLeadEmployee() throws Exception {
		DeveloperTeamLead developerTeamLead = new DeveloperTeamLead();
		System.out.println("Enter the Developer Team Lead employee data");
		developerTeamLead.addDetails();
		developerTeamLead.writeJSONFileForDeveloperTeamLeadEmployee(developerTeamLead, "employees.json");

	}

	private static void addProjectManagerEmployee() throws Exception {
		ProjectManager projectManager = new ProjectManager();
		System.out.println("Enter the Project Manager employee data");
		projectManager.addDetails();
		projectManager.writeJSONFileForProjectManagerEmployee(projectManager, "employees.json");
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
