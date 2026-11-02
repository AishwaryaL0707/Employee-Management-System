package in.newhr.index;

import java.util.ArrayList;
import java.util.Scanner;

import in.newhr.dao.EmployeeDAO;
import in.newhr.dao.EmployeeDAOImpl;
import in.newhr.dao.SalaryDAO;
import in.newhr.dao.SalaryDAOImpl;
import in.newhr.dto.Employee;
import in.newhr.dto.Salary;

public class PaySlip {
	public static void generatePayslip(Employee e) {
		Salary s=new Salary();
		Scanner sc=new Scanner(System.in);
		SalaryDAO sdao=new SalaryDAOImpl();
		EmployeeDAO edao=new EmployeeDAOImpl();
		ArrayList<Employee> eList=edao.getEmployee();
		for(Employee emp: eList) {
			System.out.println(emp);
		}
		s.setId(RandomNumber.generateRandomNumber());
		System.out.println("Enter the Employee ID:");
		s.setEid(sc.nextInt());
		System.out.println("Enter the month (MON-YYYY)");
		s.setMonth_year(sc.next());
		System.out.println("Enter the salary:");
		s.setSal(sc.nextDouble());
		s.setNetPay(s.getSal()-(s.getSal()*10/100));
		String path="C:\\JavaPrgmSalarySlipNewHr"+"\\"+s.getEid()+"_"+s.getMonth_year()+".pdf";
		System.out.println(path);
		s.setUrl(path);
		boolean res=sdao.insertSalary(s);
		if(res) {
			System.out.println("Salary credited to " +s.getEid());
		}
		else {
			System.out.println("Failed to credit the salary!");
		}
	}
}
