package in.newhr.dto;

public class Salary {
	private long id;
	private int eid;
	private String month_year;
	private double sal;
	private double netPay;
	private String url;
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
	public String getMonth_year() {
		return month_year;
	}
	public void setMonth_year(String month_year) {
		this.month_year = month_year;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getNetPay() {
		return netPay;
	}
	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
