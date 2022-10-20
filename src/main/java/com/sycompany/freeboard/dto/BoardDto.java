package com.sycompany.freeboard.dto;

public class BoardDto {
	private int bid;
	private String bname;  // 게시글 번호
	private String btitle; // 글쓴이 이름
	private String bcontent; // 게시글 내용
	private String bdate; // 글 게시 시간
	private int bhit; // 조회수
	public int getBid() {
		return bid;
	}
	
	public BoardDto() {  //기본생성자
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDto(int bid, String bname, String btitle, String bcontent, String bdate, int bhit) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bhit = bhit;

	}

	
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	
	

}
