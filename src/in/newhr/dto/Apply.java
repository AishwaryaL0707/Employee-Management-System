package in.newhr.dto;

public class Apply {
	private int id;
	private int eid;
	private String type;
	private String start_date;
	private String end_date;
	private String reason;
	private String status;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Apply [id=" + id + ", eid=" + eid + ", type=" + type + ", start_date=" + start_date + ", end_date="
				+ end_date + ", reason=" + reason + ", status=" + status + ", date=" + date + "]";
	}
	
	
}
