package in.newhr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.newhr.connection.Connector;
import in.newhr.dto.Employee;
import in.newhr.dto.Tickets;

public class TicketsDAOImpl implements TicketsDAO{
	private Connection con;
	
	public TicketsDAOImpl() {
		this.con=Connector.requestConnection();
	}

	@Override
	public boolean insertTicket(Tickets t) {
		// TODO Auto-generated method stub
		String query="INSERT INTO TICKET VALUES(?,?,?,?,'Open',sysdate(),sysdate())";
		PreparedStatement ps=null;
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, t.getId());
			ps.setInt(2, t.getEid());
			ps.setString(3, t.getSubject());
			ps.setString(4, t.getAbout());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {			
			return false;
		}
	}

	@Override
	public boolean updateTicket(Tickets t) {
		// TODO Auto-generated method stub
		String query="UPDATE TICKET SET SUBJECT=?, ABOUT=?, STATUS=? WHERE ID=?";
		PreparedStatement ps=null;
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, t.getSubject());
			ps.setString(2, t.getAbout());
			ps.setString(3, t.getStatus());
			ps.setLong(4, t.getId());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;			
		}
	}

	@Override
	public boolean deleteTicket(Tickets t) {
		// TODO Auto-generated method stub
		String query="DELETE FROM TICKET WHERE ID=?";
		PreparedStatement ps=null;
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, t.getId());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;			
		}
	}

	@Override
	public Tickets getTicket(long ticketId) {
		// TODO Auto-generated method stub
		String query="SELECT * FROM TICKET WHERE ID=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		Tickets t=new Tickets();
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, t.getId());
			rs=ps.executeQuery();
			while(rs.next()) {
				t.setId(rs.getLong("id"));
				t.setEid(rs.getInt("eid"));
				t.setSubject(rs.getString("subject"));
				t.setAbout(rs.getString("about"));
				t.setStatus(rs.getString("status"));
				t.setResolved_date(rs.getString("resolved_date"));
				t.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public ArrayList<Tickets> getTicketsByEmployee(int eid) {
		// TODO Auto-generated method stub
		ArrayList<Tickets> ticketList=new ArrayList<>();
		String query="SELECT * FROM TICKET WHERE ID=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		Tickets t=null;
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, eid);
			rs=ps.executeQuery();
			while(rs.next()) {
				t.setId(rs.getLong("id"));
				t.setEid(rs.getInt("eid"));
				t.setSubject(rs.getString("subject"));
				t.setAbout(rs.getString("about"));
				t.setStatus(rs.getString("status"));
				t.setResolved_date(rs.getString("resolved_date"));
				t.setDate(rs.getString("date"));
				ticketList.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticketList;
	}
	public ArrayList<Tickets> getTicket() {
		// TODO Auto-generated method stub
		ArrayList<Tickets> tickets=new ArrayList<>();
		String query="SELECT * FROM TICKET ORDER BY DATE DESC";
		PreparedStatement ps=null;
		ResultSet rs=null;
		Tickets t=null;
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				t=new Tickets();
				t.setId(rs.getLong("id"));
				t.setEid(rs.getInt("eid"));
				t.setSubject(rs.getString("subject"));
				t.setAbout(rs.getString("about"));
				t.setStatus(rs.getString("status"));
				t.setResolved_date(rs.getString("resolved_date"));
				t.setDate(rs.getString("date"));
				tickets.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tickets;
	}		
	
}
