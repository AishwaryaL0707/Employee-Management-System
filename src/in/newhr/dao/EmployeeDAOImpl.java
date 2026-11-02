package in.newhr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.newhr.connection.Connector;
import in.newhr.dto.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	private Connection con;
	
	public EmployeeDAOImpl() {
		this.con=Connector.requestConnection();
	}
	
	@Override
	public boolean insertEmployee(Employee e) {
		// TODO Auto-generated method stub
		String query="INSERT INTO EMPLOYEE VALUES(0,?,?,?,?,?,?,?,?,SYSDATE())";
		PreparedStatement ps=null;
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, e.getName());
			ps.setLong(2, e.getPhone());
			ps.setString(3, e.getMail());
			ps.setString(4, e.getJob());
			ps.setString(5, e.getDob());
			ps.setString(6, e.getDoj());
			ps.setString(7, e.getPassword());
			ps.setString(8, e.getStatus());
			i=ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		String query="UPDATE EMPLOYEE SET NAME=?, PHONE=?, MAIL=?, DOB=?, DOJ=?, JOB=?, STATUS=? WHERE ID=?";
		PreparedStatement ps=null;
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, e.getName());
			ps.setLong(2, e.getPhone());
			ps.setString(3, e.getMail());
			ps.setString(4, e.getDob());
			ps.setString(5, e.getDob());
			ps.setString(6, e.getJob());
			ps.setString(7, e.getStatus());
			ps.setInt(8, i);
			i=ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean deleteEmployee(Employee e) {
		// TODO Auto-generated method stub
		String query="DELETE FROM EMPLOYEE WHERE ID=?";
		PreparedStatement ps=null;
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, e.getEid());
			i=ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public Employee getEmployee(String mail, String password) {
		// TODO Auto-generated method stub
		Employee emp=null;
		String query="SELECT * FROM EMPLOYEE WHERE MAIL=? AND PASSWORD=?";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, mail);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				emp=new Employee();
				emp.setEid(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPhone(rs.getLong("phone"));
				emp.setMail(rs.getString("mail"));
				emp.setJob(rs.getString("job"));
				emp.setDob(rs.getString("dob"));
				emp.setDoj(rs.getString("doj"));
				emp.setPassword(rs.getString("password"));
				emp.setStatus(rs.getString("status"));
				emp.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		}
	
		@Override
		public ArrayList<Employee> getEmployee() {
			// TODO Auto-generated method stub
			ArrayList<Employee> employees=new ArrayList<>();
			String query="SELECT * FROM EMPLOYEE WHERE STATUS='active'";
			PreparedStatement ps=null;
			ResultSet rs=null;
			Employee emp=null;
			try {
				ps=con.prepareStatement(query);
				rs=ps.executeQuery();
				while(rs.next()) {
					emp=new Employee();
					emp.setEid(rs.getInt("id"));
					emp.setName(rs.getString("name"));
					emp.setPhone(rs.getLong("phone"));
					emp.setMail(rs.getString("mail"));
					emp.setJob(rs.getString("job"));
					emp.setDob(rs.getString("dob"));
					emp.setDoj(rs.getString("doj"));
					emp.setPassword(rs.getString("password"));
					emp.setStatus(rs.getString("status"));
					emp.setDate(rs.getString("date"));
					employees.add(emp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return employees;
		}	
		@Override
		public Employee getEmployee(int id) {
			Employee emp=null;
			String query="SELECT * FROM EMPLOYEE WHERE ID=?";
			PreparedStatement ps=null;
			try {
				ps=con.prepareStatement(query);
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					emp=new Employee();
					emp.setEid(rs.getInt("id"));
					emp.setName(rs.getString("name"));
					emp.setPhone(rs.getLong("phone"));
					emp.setMail(rs.getString("mail"));
					emp.setJob(rs.getString("job"));
					emp.setDob(rs.getString("dob"));
					emp.setDoj(rs.getString("doj"));
					emp.setPassword(rs.getString("password"));
					emp.setStatus(rs.getString("status"));
					emp.setDate(rs.getString("date"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return emp;
		}
}
