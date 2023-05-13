package com.gdu.app01.xml_into_java;

public class Upload {

	// package를 upload와 attach 처럼 따로 만드는 이유는
	// DB 관점으로 보기 때문. (아마 테이블이라 생각하면 댈듯-내 생각)
	
	// field
	private String title;
	private Attach attach;
	
	// default constructor
	
	// getter setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Attach getAttach() {
		return attach;
	}
	public void setAttach(Attach attach) {
		this.attach = attach;
	}
	
}
