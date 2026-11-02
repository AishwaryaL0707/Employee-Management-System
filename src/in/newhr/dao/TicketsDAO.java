package in.newhr.dao;

import java.util.ArrayList;

import in.newhr.dto.Tickets;

public interface TicketsDAO {
	public boolean insertTicket(Tickets t);
	public boolean updateTicket(Tickets t);
	public boolean deleteTicket(Tickets t);
	public Tickets getTicket(long ticketId);
	public ArrayList<Tickets> getTicket();
//	public Tickets getTicket(long ticketId, int eid);
	public ArrayList<Tickets> getTicketsByEmployee(int eid);
}
