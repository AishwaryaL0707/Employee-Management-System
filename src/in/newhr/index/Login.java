package in.newhr.index;

import java.util.Scanner;
import in.newhr.dao.EmployeeDAO;
import in.newhr.dao.EmployeeDAOImpl;
import in.newhr.dto.Employee;

public class Login {
	public static void login() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Mail ID: ");
		String mail=sc.next();
		System.out.println("Enter the password: ");
		String password=sc.next();
		
		EmployeeDAO edao=new EmployeeDAOImpl();
		Employee e=edao.getEmployee(mail, password);
		if(e!=null) {
			if(e.getEid()==1001) {
				System.out.println("Login successful! Welcome Admin: " +e.getName()+ ",");
				Admin.admin(e);
			}
			else {
				System.out.println("Login successful! Welcome " +e.getName()+ ",");
				App.options(e);
			}
		}
		else {
			System.out.println("Failed to login!");
		}
		
	}
}
