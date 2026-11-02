package in.newhr.index;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import in.newhr.dao.EmployeeDAO;
import in.newhr.dao.EmployeeDAOImpl;
import in.newhr.dto.Employee;

public class Admin {
	public static void admin(Employee e) {
		Scanner sc=new Scanner(System.in);
		EmployeeDAO edao=new EmployeeDAOImpl();
		int i=0;
		do {
			System.out.println("G'day " +e.getJob());
			System.out.println("Admin:" +e.getName());
			System.out.println("<1> Add an Employee");
			System.out.println("<2> View all Employees");
//			System.out.println("<3> Assign tasks to Employees");
			System.out.println("<3> Leave approval");
			System.out.println("<4> View Employees concerns");
			System.out.println("<5> Add salary to employee");
			System.out.println("<6> Fire Employee");
			System.out.println("<7> View Resignations");
			System.out.println("<8> My account");
			System.out.println("<9> Logout");
			
			switch(sc.nextInt()) {
			case 1: Signup.signup();
			break;
			case 2: ArrayList<Employee> empList=edao.getEmployee();
			Iterator<Employee> it=empList.iterator();
			while(it.hasNext()) {
				Employee e1=new Employee();
				System.out.println(e1);
			}
			break;
			case 3: LeaveUpdate.approve(e);
			break;
			case 4: Concerns.view(e);
			break;
			case 5: PaySlip.generatePayslip(e);
			break; 
			case 6: ArrayList<Employee> emps=edao.getEmployee();
				for(Employee e1: emps) {
					System.out.println(e1);
				}
				System.out.println("Enter the Employee ID:");
				Employee e1=edao.getEmployee(sc.nextInt());
				e1.setStatus("Inactive");
				boolean res=edao.updateEmployee(e1);
				if(res) {
					System.out.println("Employee fired!");
				}
				else {
					System.out.println("Failed to fire");
				}
			break;
			case 9: System.out.println("Going back to main menu");
			}
		}while(i!=9);
	}
}
