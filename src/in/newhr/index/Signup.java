package in.newhr.index;

import java.util.Scanner;

import in.newhr.dao.EmployeeDAO;
import in.newhr.dao.EmployeeDAOImpl;
import in.newhr.dto.Employee;

public class Signup {
	public static void signup() {
		Scanner sc=new Scanner(System.in);
		Employee e=new Employee();
		EmployeeDAO edao=new EmployeeDAOImpl();
		System.out.println("Enter the name: ");
		e.setName(sc.next());
		System.out.println("Enter the phone: ");
		e.setPhone(sc.nextLong());
		System.out.println("Enter the mail: ");
		e.setMail(sc.next());
		System.out.println("Choose the Job Role: ");
		System.out.println("<1> Operation Analyst");
		System.out.println("<2> Manager");
		System.out.println("<3> Business Analyst");
		System.out.println("<4> Developer");
		System.out.println("<5> Accountant");
		System.out.println("<6> Salesman");
		switch(sc.nextInt()) {
			case 1: e.setJob("Operation Analyst");
			break;
			case 2: e.setJob("Manager");
			break;
			case 3: e.setJob("Business Analyst");
			break;
			case 4: e.setJob("Developer");
			break;
			case 5: e.setJob("Accountant");
			break;
			case 6: e.setJob("Salesman");
			break;
		}
		System.out.println("Enter the DOB (YYYY-MM-DD): ");
		e.setDob(sc.next());
		System.out.println("Enter the DOJ (YYYY-MM-DD): ");
		e.setDoj(sc.next());
		System.out.println("Set a new password: ");
		String password=sc.next();
		System.out.println("Confirm the new password: ");
		String confirmPassword=sc.next();
		if(password.equals(confirmPassword)) {
			e.setPassword(confirmPassword);
			e.setStatus("active");
			boolean res=edao.insertEmployee(e);
			if(res) {
				System.out.println("Data added successfully");
			}
			else {
				System.out.println("Failed to save data");
			}
		}
		else {
			System.out.println("Password mismatch!");
		}
	}
}
