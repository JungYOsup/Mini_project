package min.edu.dto;

import java.sql.Date;


public class Dto {
	
	private int rank;
	private int seq;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String email;
	private String user_record;
	private	Date regdate;
	private String grade;
	private String enabled;
	private String sregdate;
	
	//기본생성자를 무조건 써줘야한다, 안그러면 mapping이 안됨
	public Dto() {
		
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_record() {
		return user_record;
	}

	public void setUser_record(String user_record) {
		this.user_record = user_record;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getSregdate() {
		return sregdate;
	}

	public void setSregdate(String sregdate) {
		this.sregdate = sregdate;
	}

	@Override
	public String toString() {
		return "Dto [rank=" + rank + ", seq=" + seq + ", user_id=" + user_id + ", user_pw=" + user_pw + ", user_name="
				+ user_name + ", email=" + email + ", user_record=" + user_record + ", regdate=" + regdate + ", grade="
				+ grade + ", enabled=" + enabled + ", sregdate=" + sregdate + "]";
	}

	
	
	
	
	
}
