package in.newhr.index;

import java.util.ArrayList;
import java.util.Scanner;

import in.newhr.dao.ApplyDAO;
import in.newhr.dao.ApplyDAOImpl;
import in.newhr.dao.EmployeeDAO;
import in.newhr.dao.EmployeeDAOImpl;
import in.newhr.dto.Apply;
import in.newhr.dto.Employee;

public class ResignationApprove {
	public static void acceptResign(Employee e) {
		Scanner sc=new Scanner(System.in);
		ApplyDAO adao=new ApplyDAOImpl();
		EmployeeDAO edao=new EmployeeDAOImpl();
		ArrayList<Apply> resign=adao.resignByEmployee();
		for(Apply a:resign) {
			System.out.println(a);
		}
		System.out.println("Enter the Resignation ID to be approved:");
		boolean statusUpdate=false;
		Apply a=adao.getLeave(sc.nextInt());
		if(a.getStatus().equals("Pending") && a.getType().equals("Resign")) {
			System.out.println("<1> Approve");
			System.out.println("<2> Reject");
			switch(sc.nextInt()) {
			case 1: a.setStatus("Approved");
				System.out.println("Resignation approval in process..");
				Employee e1=edao.getEmployee(a.getEid());
				e1.setStatus("Inactive");
				statusUpdate=edao.updateEmployee(e1);
				break;
			case 2: a.setStatus("Rejected");
				System.out.println("Resignation rejecting...");
				break;
			}
			boolean res=adao.updateLeave(a);
			if(statusUpdate) {
				System.out.println("Resignation approved!");
			}
			else {
				System.out.println("Failed to update. Try again!");
			}
		}
		else {
			System.out.println("No resignations found!");
		}
	}
}
