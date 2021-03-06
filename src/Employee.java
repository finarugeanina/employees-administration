import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * This class implements a simple employee
 * 
 * @author geanina.finaru
 * @version 1.0
 */
public class Employee {

	private String name;
	private int employeeId;
	private String gender;
	private String CNP;
	Scanner scan = new Scanner(System.in);

	/**
	 * This returns the current name of this employee
	 * 
	 * @return this employee's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This sets a given name for this employee
	 * 
	 * @param name
	 */
	public void setName(String name) {
		if (name.length() == 0 || name.equals(" ")) {
			System.out.println("Name length must be greater than 0! Please re-enter the name: ");
			setName(scan.nextLine());
		} else if (!name.matches("[a-zA-Z ,]+")) {
			System.out.println("The name must contain only letters! Please re-enter the name: ");
			setName(scan.nextLine());
		} else {
			this.name = name.toUpperCase();
		}
	}

	/**
	 * This sets the employeeId of this employee
	 * 
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * This returns the employeeId of this employee
	 * 
	 * @return
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * This returns the gender of this employee
	 * 
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * This sets the gender of this employee only if it is in the right format (M/F)
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		gender = gender.toUpperCase();
		if (!(gender.equals("M") || gender.equals("F"))) {
			System.out.println("The gender is not in the right format! Please re-enter the gender (M/F): ");
			setGender(scan.nextLine());
		} else if (gender.equals("M")) {
			this.gender = "MALE";
		} else if (gender.equals("F")) {
			this.gender = "FEMALE";
		}
	}

	/**
	 * This returns the CNP for this employee
	 * 
	 * @return
	 */
	public String getCNP() {
		return CNP;
	}

	/**
	 * This sets the CNP for the employee only if it is in the right format
	 * 
	 * @param CNP
	 */
	public void setCNP(String CNP) {
		if (CNP.length() != 13) {
			System.out.println("The length of the CNP should be 13 numbers! Please re-enter the CNP:");
			setCNP(scan.nextLine());
		} else if (!CNP.substring(0, 1).equals("1") && !CNP.substring(0, 1).equals("2")) {
			System.out.println("The CNP should start only with 1 or 2! Please re-enter the CNP:");
			setCNP(scan.nextLine());
		} else if (!isValidDateFormat(CNP.substring(1, 7))) {
			System.out.println("The entered CNP is not in the right date format! Please re-enter the CNP:)");
			setCNP(scan.nextLine());
		} else {
			this.CNP = CNP;
		}
	}

	/**
	 * This returns true if the substring of the CNP is in a valid date format
	 * 
	 * @return
	 */
	public static boolean isValidDateFormat(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date);
		} catch (ParseException ex) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("\nName: %s \nGender: %s \nEmployeeId: %d \nCNP: %s", name, gender, employeeId, CNP);
	}

	/**
	 * This sets basic details for the employee: name, employeeId, gender and CNP
	 */
	public void addDetailsForEmployee() {
		System.out.println("Please type in the name of the new employee:");
		setName(scan.nextLine());
		System.out.println("Please type in the CNP of the new employee: ");
		setCNP(scan.nextLine());
		System.out.println("Please type in the gender of the new employee (M/F): ");
		setGender(scan.nextLine());
	}

}
