import java.util.Scanner;

/**
 * This class implements a simple employee
 * 
 * @author geanina.finaru
 * @version 1.0
 */
public abstract class Employee {

	private String name;
	private int employeeId;
	private String gender;
	private String CNP;

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
		this.name = name;
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
	 * This sets the employeeId of this employee
	 * 
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	 * This sets the gender of this employee
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * This sets the CNP for the employee
	 * 
	 * @param cNP
	 */
	public void setCNP(String cNP) {
		CNP = cNP;
	}

	@Override
	public String toString() {
		return String.format("\nName: %s \nGender: %s \nEmployeeId: %d \nCNP: %s", name, gender, employeeId, CNP);
	}


	public void addDetails() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Please type in the name of the new employee:");
		this.name = scan.nextLine();
		System.out.println("Please type in the employeeId of the new employee: ");
		this.employeeId = scan.nextInt();
		scan.nextLine();
		System.out.println("Please type in the CNP of the new employee: ");
		this.CNP = scan.nextLine();
		System.out.println("Please type in the gender of the new employee: ");
		this.gender = scan.nextLine();



	};
}
