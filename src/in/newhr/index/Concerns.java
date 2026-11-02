package in.newhr.index;

import java.util.ArrayList;
import java.util.Scanner;

import in.newhr.dao.TicketsDAO;
import in.newhr.dao.TicketsDAOImpl;
import in.newhr.dto.Employee;
import in.newhr.dto.Tickets;

public class Concerns {
	public static void view(Employee e) {
		Scanner sc=new Scanner(System.in);
		TicketsDAO tdao=new TicketsDAOImpl();
		ArrayList<Tickets> tickets=tdao.getTicket();
		for(Tickets t: tickets) {
			System.out.println(t);
		}
		System.out.println("Enter the ticket ID: ");
		Tickets t=tdao.getTicket(sc.nextLong());
		System.out.println(t);
		System.out.println("<1> In progress");
		System.out.println("<2> Resolved");
		System.out.println("<3> Closed");
		switch(sc.nextInt()) {
		case 1: t.setStatus("In progress");
		break;			
		case 2: t.setStatus("Resolved");
		break;
		case 3: t.setStatus("Closed");
		break;
		default: System.out.println("Sorry! Ticket is still open.");
		}
		boolean res=tdao.updateTicket(t);
		if(res) {
			System.out.println("New Ticket status:" +t.getStatus());
		}
		else {
			System.out.println("Failed to update the status");
		}
	}
}
