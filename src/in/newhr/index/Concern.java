package in.newhr.index;

import java.util.Scanner;

import in.newhr.dao.TicketsDAO;
import in.newhr.dao.TicketsDAOImpl;
import in.newhr.dto.Employee;
import in.newhr.dto.Tickets;

public class Concern {
	public static void raiseTicket(Employee e) {
		Tickets t=new Tickets();
		TicketsDAO tdao=new TicketsDAOImpl();
		Scanner sc=new Scanner(System.in);
		t.setId(RandomNumber.generateRandomNumber());
		t.setEid(e.getEid());
		System.out.println("Enter the subject");
		t.setSubject(sc.nextLine());
		System.out.println("Description");
		t.setAbout(sc.nextLine());
		boolean res=tdao.insertTicket(t);
		if(res) {
			System.out.println("Ticket has been raised");
		}
		else {
			System.out.println("Failed to raise the ticket");
		}
	}

}

