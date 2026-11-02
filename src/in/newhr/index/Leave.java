package in.newhr.index;

import java.util.Scanner;

import in.newhr.dao.ApplyDAO;
import in.newhr.dao.ApplyDAOImpl;
import in.newhr.dto.Apply;
import in.newhr.dto.Employee;

public class Leave {
	public static void applyLeave(Employee e) {
		Scanner sc=new Scanner(System.in);
		Apply a=new Apply();
		ApplyDAO adao=new ApplyDAOImpl();
		a.setEid(e.getEid());
		System.out.println("Enter the type of leave");
		System.out.println("<1> Casual Leave");
		System.out.println("<2> Sick Leave");
		System.out.println("<3> Resign");
		switch(sc.nextInt()) {
			case 1: a.setType("Casual Leave");
			break;
			case 2: a.setType("Sick Leave");
			break;
			case 3:a.setType("Resign");
			break;
		
		}
		if(a.getType()==null) {
			System.out.println("Leave application failed");
			App.options(e);
		}
		else {
			System.out.println("Enter the reason: ");
			sc.nextLine();
			a.setReason(sc.nextLine());
			System.out.println("Enter the Start date (YYYY-MM-DD): ");
			a.setStart_date(sc.next());
			int res1=adao.dateCheck(a.getStart_date());
			//System.out.println(res1);
			System.out.println("Enter the End date (YYYY-MM-DD): ");
			a.setEnd_date(sc.next());
			
			int res2=adao.dateCheck(a.getEnd_date());
			//System.out.println(res2);
			if(res2-res1>0) {
				boolean res=adao.insertLeave(a);
				if(res) {
					System.out.println("Leave applied successfully!");
				}
				else{
					System.out.println("Failed to apply leave! Try after sometime");
				}
			}
			else if(a.getType().equals("Resign")) {
				System.out.println("Are you sure, you want to resign?");
				System.out.println("<1> Yes");
				System.out.println("<2> No");
				if(sc.nextInt()==1) {
					boolean res=adao.insertLeave(a);
					if(res) {
						System.out.println("Resignation applied! Wait for Manager's approval!");
					}
					else {
						System.out.println("Resignation application failed");
					}
				}
				else {
					System.out.println("Have a good day!");
				}
			}
			else {
				System.out.println("Your application failed");
			}
		}
	}
}
