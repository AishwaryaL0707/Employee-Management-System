package in.newhr.dto;

public class Tickets {
	private long id;
	private int eid;
	private String subject;
	private String about;
	private String status;
	private String resolved_date;
	private String date;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResolved_date() {
		return resolved_date;
	}
	public void setResolved_date(String resolved_date) {
		this.resolved_date = resolved_date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Tickets [id=" + id + ", subject=" + subject + ", about=" + about + ", status=" + status
				+ ", resolved_date=" + resolved_date + ", date=" + date + "]";
	}
	
	
}
