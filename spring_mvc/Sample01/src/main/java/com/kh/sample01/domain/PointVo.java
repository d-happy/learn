package com.kh.sample01.domain;

import java.sql.Timestamp;

public class PointVo {
	
	private int point_no;
	private String user_id;
	private String point_code;
	private String point_desc;
	private int point_score;
	private Timestamp point_date;
	
	public int getPoint_no() {
		return point_no;
	}
	public void setPoint_no(int point_no) {
		this.point_no = point_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPoint_code() {
		return point_code;
	}
	public void setPoint_code(String point_code) {
		this.point_code = point_code;
	}
	public String getPoint_desc() {
		return point_desc;
	}
	public void setPoint_desc(String point_desc) {
		this.point_desc = point_desc;
	}
	public int getPoint_score() {
		return point_score;
	}
	public void setPoint_score(int point_score) {
		this.point_score = point_score;
	}
	public Timestamp getPoint_date() {
		return point_date;
	}
	public void setPoint_date(Timestamp point_date) {
		this.point_date = point_date;
	}
	
	@Override
	public String toString() {
		return "PointVo [point_no=" + point_no + ", user_id=" + user_id + ", point_code=" + point_code + ", point_desc="
				+ point_desc + ", point_score=" + point_score + ", point_date=" + point_date + "]";
	}
	
}
