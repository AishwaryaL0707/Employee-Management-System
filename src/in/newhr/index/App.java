package in.newhr.index;

import java.util.ArrayList;
import java.util.Scanner;

import in.newhr.dao.ApplyDAO;
import in.newhr.dao.ApplyDAOImpl;
import in.newhr.dao.EmployeeDAOImpl;
import in.newhr.dao.SalaryDAO;
import in.newhr.dao.SalaryDAOImpl;
import in.newhr.dto.Apply;
import in.newhr.dto.Employee;
import in.newhr.dto.Salary;

public class App {
	public static void options(Employee e) {
		Scanner sc=new Scanner(System.in);
		ApplyDAO adao=new ApplyDAOImpl();
		int i=0;
		do {
			System.out.println("Choose options");
			System.out.println("<1> View Data");
			System.out.println("<2> Apply for Leave");
			System.out.println("<3> View Leave Status");
			System.out.println("<4> View Tasks");
			System.out.println("<5> Download Payslip");
			System.out.println("<6> Raise a Concern");
			System.out.println("<7> View Raised Concerns");
			System.out.println("<8> Submit Resignation");
			System.out.println("<9> Logout");
			switch(i=sc.nextInt()) {
				case 1: System.out.println(e);
				break;
				case 2: Leave.applyLeave(e);
				break;
				case 3: System.out.println("Leave applied: ");
				ArrayList<Apply> leavesList=adao.getLeaveByEmployee(e.getEid());
				for(Apply a:leavesList) {
					System.out.println(a);
				}
				break;
				case 5: System.out.println("Enter month (MON_YYYY): ");
				String month=sc.next();
				SalaryDAO sdao=new SalaryDAOImpl();
				Salary sal=sdao.getSalary(e.getEid(), month);
				if(sal!=null) {
					String path=PayslipGenerator.generatePdf(e, sal);
					if(path!=null) {
						System.out.println("Payslip downloaded successfully: " +path);
					}
					else {
						System.out.println("Failed to generate payslip.");
					}
				}
				else {
					System.out.println("No salary record found for " +month);
				}
				break;
				case 6:Concern.raiseTicket(e);
				break;
			}
		}while(i!=9);
	}
}
