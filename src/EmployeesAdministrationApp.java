import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class EmployeesAdministrationApp {

	public static void main(String[] args) {
		int number = chooseAnOptionFromMainMenu();
		do {
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
					break;
			}
			number = chooseAnOptionFromMainMenu();
		} while (number != 7);
	}

	private static void addNewEmployee() {
		System.out.println("Please select the type of the new employee:" + "\n1. QA Employee" + "\n2. Developer Employee"
				+ "\n3. QA Team Lead Employee " + "\n4. Developer Team Lead Employee" + "\n5. Project Manager");
		Scanner scan = new Scanner(System.in);
		int typeOfTheEmployee = scan.nextInt();

		switch (typeOfTheEmployee) {
			case 1: {
				addEmployee(new QAEmployee(), "Enter the QA employee data");
				break;
			}
			case 2: {
				addEmployee(new DeveloperEmployee(), "Enter the Developer employee data");
				break;
			}
			case 3: {
				addEmployee(new QATeamLead(), "Enter the QA Team Lead employee data");
				break;
			}
			case 4: {
				addEmployee(new DeveloperTeamLead(), "Enter the Developer Team Lead employee data");
				break;
			}
			case 5: {
				addEmployee(new ProjectManager(), "Enter the Project Manager employee data");
				break;
			}
		}
	}

	private static void addEmployee(Object employee, String message) {
		System.out.println(message);
		try {
			Method addDetailsMethod = employee.getClass().getDeclaredMethod("addDetailsForEmployee");
			addDetailsMethod.invoke(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeJson(employee);
	}

	private static void writeJson(Object obj) {
		String employeesJsonFile = "employees.json";
		JSONArray allEmployeesList = new JSONArray();
		allEmployeesList = readFromFile(employeesJsonFile, allEmployeesList);
		Method[] methods = obj.getClass().getMethods();
		Map<String, Object> employeeDetails = new HashMap<String, Object>();
		for (Method method : methods) {
			if (method.getName().startsWith("get") && !method.getName().equals("getClass")) {
				try {
					employeeDetails.put(method.getName().replace("get", ""), method.invoke(obj));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Map<String, Object>> employeeDetailsJson = new HashMap<>();
		employeeDetailsJson.put("employee", employeeDetails);
		JSONObject employeeDetailsJsonObject = new JSONObject(employeeDetailsJson);
		allEmployeesList.add(employeeDetailsJsonObject);
		try {
			FileWriter file = new FileWriter(employeesJsonFile);
			file.write(allEmployeesList.toJSONString());
			file.flush();
		} catch (IOException e) {
			System.out.println("There was a problem in writing data to this file");
		}
		System.out.println("You have added a new " + obj.getClass().getName() + " with: " + obj + "\nin your "
				+ employeesJsonFile + " document");
	}

	private static JSONArray readFromFile(String employeesJsonFile, JSONArray allEmployeesList) {
		try {
			JSONParser parser = new JSONParser();
			File fileReader = new File(employeesJsonFile);
			if (fileReader.length() != 0) {
				allEmployeesList = (JSONArray) parser.parse(new FileReader(employeesJsonFile));
			} else {
				System.out.println("The file is empty!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allEmployeesList;
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

		System.out.println("\nPlease select an option:\n" + "1. Add a new employee\n" + "2. View all employees\n"
				+ "3. Search an employee\n" + "4. Delete an employee\n" + "5. Update existing employee\n"
				+ "6. Convert the type of an employee\n" + "7. Exit Application");
		Scanner scan = new Scanner(System.in);
		int numberSelected = scan.nextInt();

		System.out.println("You have selected " + numberSelected + options.get(numberSelected));
		return numberSelected;
	}

	private static void searchEmployee() {
		System.out.println("Please type in the id of the employee you want to search: ");
		Scanner scan = new Scanner(System.in);
		int idOfTheEmployee = scan.nextInt();
		String employeesJsonFile = "employees.json";
		JSONArray allEmployeesList = new JSONArray();
		allEmployeesList = readFromFile(employeesJsonFile, allEmployeesList);
		for (Object emp : allEmployeesList) {
			JSONObject employeeObject = (JSONObject) ((JSONObject) emp).get("employee");
			if (Integer.parseInt(String.valueOf(employeeObject.get("EmployeeId"))) == idOfTheEmployee) {
				System.out.println(employeeObject.toString().replaceAll("[{\"}]", "").replaceAll("[,]", "\n"));
			}
		}
	}

	private static void viewAllEmployees() {
		System.out.println("This is the list of all employees: ");
		String employeesJsonFile = "employees.json";
		JSONArray allEmployeesList = new JSONArray();
		allEmployeesList = readFromFile(employeesJsonFile, allEmployeesList);
		for (Object emp : allEmployeesList) {
			JSONObject employeeObject = (JSONObject) ((JSONObject) emp).get("employee");
			System.out.println();
			System.out.println(employeeObject.toString().replaceAll("[{\"}]", "").replaceAll("[,]", "\n"));
		}
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
}
