package in.newhr.index;

import java.util.ArrayList;
import java.util.Scanner;

import in.newhr.dao.ApplyDAO;
import in.newhr.dao.ApplyDAOImpl;
import in.newhr.dto.Apply;
import in.newhr.dto.Employee;

public class LeaveUpdate {
	public static void approve(Employee e) {
		Scanner sc=new Scanner(System.in); 
		ApplyDAO adao=new ApplyDAOImpl();
		if(e!=null) {
			ArrayList<Apply> leavesList=adao.getLeave();
			for(Apply a: leavesList) {
				System.out.println(a);
			}
			System.out.println("Enter the Leave ID to be approved: ");
			Apply a=adao.getLeave(sc.nextInt());
			if(a.getStatus().equals("Pending") && !a.getType().equals("Resign")) {
				System.out.println("<1> Approve");
				System.out.println("<2> Reject");
				switch(sc.nextInt()) {
					case 1: a.setStatus("Approved");
					System.out.println("Leave approving...");
					break;
					case 2: a.setStatus("Rejected");
					System.out.println("Leave rejecting...");
					break;
					}
				boolean res=adao.updateLeave(a);
				if(res) {
					System.out.println("Leave updated");
				}
				else {
					System.out.println("Failed to update. Try again!");
				}
			}
			else {
				System.out.println("No leaves are pending");
			}
		}				
		else {
			System.out.println("No access found!");
		}
	}
}
