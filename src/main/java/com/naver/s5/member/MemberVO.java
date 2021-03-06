package com.naver.s5.member;

import com.naver.s5.member.memberFile.MemberFileVO;

public class MemberVO {
	private String id;
	private String upw;
	private String uname;
	private int age;
	private String email;
	private String phone;
	private MemberFileVO memberFileVO;
	
	public MemberFileVO getMemberFileVO() {
		return memberFileVO;
	}
	public void setMemberFileVO(MemberFileVO memberFileVO) {
		this.memberFileVO = memberFileVO;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
