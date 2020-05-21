import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class EmployeesAdministrationApp {
	public static Map<String, String> listOfEmployees = new HashMap<String, String>();

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
				case 7:
					saveFile();
					break;
				case 8:
					loadFile();
					break;
			}
			number = chooseAnOptionFromMainMenu();
		} while (number != 9);
	}

	private static void loadFile() {
		System.out.println("Please write the name of the file you want to load: ");
		Scanner scan = new Scanner(System.in);
		String jsonFile = scan.nextLine();
		if (!jsonFile.endsWith(".json")) {
			jsonFile = jsonFile + ".json";
		}
		try {
			JSONParser parser = new JSONParser();
			File fileReader = new File(jsonFile);
			if (fileReader.exists()) {
				if (fileReader.length() != 0) {
					listOfEmployees.clear();
					JSONArray arrayFromJsonFile = (JSONArray) parser.parse(new FileReader(jsonFile));
					for (Object emp : arrayFromJsonFile) {
						Map<String, String> map = ((HashMap<String, String>) emp);
						Iterator<Entry<String, String>> it = map.entrySet().iterator();
						while (it.hasNext()) {
							Map.Entry<String, String> pair = it.next();
							listOfEmployees.put(pair.getKey(), pair.getValue());
						}
					}
					System.out.println("The data from the " + jsonFile + " file was loaded");
				} else {
					System.out.println("The file is empty!");
				}
			} else {
				System.out.println("The file does not exist!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void saveFile() {
		if (listOfEmployees.size() != 0) {
			System.out.println("Please type in the file you want to save the data in: ");
			Scanner scan = new Scanner(System.in);
			String employeesJsonFile = scan.nextLine();
			if (!employeesJsonFile.endsWith(".json")) {
				employeesJsonFile = employeesJsonFile + ".json";
			}
			try {
				FileWriter file = new FileWriter(employeesJsonFile);
				JSONArray array = new JSONArray();
				// array.add(listOfEmployees);
				Iterator<Entry<String, String>> it = listOfEmployees.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, String> pair = it.next();
					JSONObject obj = new JSONObject();
					obj.put(pair.getKey(), pair.getValue());
					array.add(obj);
				}
				file.write(array.toJSONString());
				file.flush();
			} catch (IOException e) {
				System.out.println("There was a problem in writing data to this file");
			}
			System.out.println("The data was succesfully saved in your " + employeesJsonFile + " document");
		} else {
			System.out.println("There is nothing to save.");
		}
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
		Scanner scan = new Scanner(System.in);
		try {
			int idOfTheEmployee = getValidEmployeeId(employee);
			Class<?> c = employee.getClass();
			Method method1 = c.getMethod("setEmployeeId", int.class);
			method1.invoke(employee, idOfTheEmployee);
			Method addDetailsMethod = employee.getClass().getDeclaredMethod("addDetailsForEmployee");
			addDetailsMethod.invoke(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String employeeDetailsStr = "";
		Method[] methods = employee.getClass().getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().startsWith("get") && !method.getName().equals("getClass")) {
					employeeDetailsStr = employeeDetailsStr + method.getName().replace("get", "") + ":" + method.invoke(employee)
							+ " ";
				}
			}
			listOfEmployees.put(String.valueOf(employee.getClass().getMethod("getEmployeeId").invoke(employee)), employeeDetailsStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The employee was added to your list.");
	}

	private static int getValidEmployeeId(Object employee) {
		System.out.println("Please type in the employeeId of the new employee: ");
		Scanner scan = new Scanner(System.in);
		int idOfTheEmployee = scan.nextInt();
		for (String key : listOfEmployees.keySet()) {
			if (Integer.parseInt(key) == idOfTheEmployee) {
				System.out.println("The id is not unique!");
				idOfTheEmployee = getValidEmployeeId(employee);
			}
		}
		return idOfTheEmployee;
	}

	private static int chooseAnOptionFromMainMenu() {
		Map<Integer, String> options = new HashMap<>();
		options.put(1, ". Add a new employee");
		options.put(2, ". View all employees");
		options.put(3, ". Search an employee");
		options.put(4, ". Delete an employee");
		options.put(5, ". Update existing employee");
		options.put(6, ". Convert the type of an employee");
		options.put(7, ". Save file");
		options.put(8, ". Load file");
		options.put(9, ". Exit Application");
		System.out.println("\nPlease select an option:\n" + "1. Add a new employee\n" + "2. View all employees\n"
				+ "3. Search an employee\n" + "4. Delete an employee\n" + "5. Update existing employee\n"
				+ "6. Convert the type of an employee\n" + "7. Save file\n" + "8. Load file\n" + "9. Exit Application");
		Scanner scan = new Scanner(System.in);
		int numberSelected = scan.nextInt();
		scan.nextLine();
		System.out.println("You have selected " + numberSelected + options.get(numberSelected));
		return numberSelected;
	}

	private static void searchEmployee() {
		if (listOfEmployees.size() != 0) {
			System.out.println("Please type in the id of the employee you want to search: ");
			Scanner scan = new Scanner(System.in);
			int idOfTheEmployee = scan.nextInt();
			Iterator<Entry<String, String>> it = listOfEmployees.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> pair = it.next();
				if (Integer.parseInt(pair.getKey()) == idOfTheEmployee) {
					System.out.println(pair.getValue());
				}
			}
		} else {
			System.out.println("The list is empty!");
		}
	}

	private static void viewAllEmployees() {
		if (listOfEmployees.size() != 0) {
			System.out.println("This is the list of all employees: \n");
			Iterator<Entry<String, String>> it = listOfEmployees.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> pair = it.next();
				System.out.println(pair.getValue());
			}
		} else {
			System.out.println("The list is empty!");
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
