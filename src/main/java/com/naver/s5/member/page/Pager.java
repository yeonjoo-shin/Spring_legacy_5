package com.naver.s5.member.page;

public class Pager {
	//파라미터로 받아올 curPage 
	
	private Long curPage;//몇번째를 볼 것인가
	private Integer perPage;//한 페이지당 글 갯수
	
	private long startRow;
	private long lastRow;
	
	private long totalPage;
	private long totalBlock;
	private long curBlock;
	
	private long startNum;
	private long lastNum;
	
	private String kind;
	private String search;
	
	//-----------------------------
	
	public void makeRow() {
		System.out.println("curPage : " + this.getCurPage());
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
	
	public void makePage(long totalCount) {
		//1.totalCount : 전체 글의 갯수
		
		//2. totalCount -> totalPage 계산
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() !=0) {
			this.totalPage++;
		}
		
		//3.totalPage -> totalBlock 계산
		long perBlock = 5L;
		this.totalBlock = totalPage/perBlock;
		if(totalPage % perBlock !=0) {
			this.totalBlock++;
		}
		
		//4.curBlock starnum,lastnum
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;
		
		if(this.curBlock == this.totalBlock) {
			this.lastNum=this.totalPage;
		}
	}
	
	//---------getter/setter-------------
	
	public Long getCurPage() { //기본값//list에 처음들어왔을 때 curpage가 없어서 에러가 나니까 1로 바꿔서 들어올 수 있도록 
		if(this.curPage == null || this.curPage==0) {
			this.curPage=1L;
		}
		return curPage;
	}


	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}


	public Integer getPerPage() {//한 페이지에 몇개의 글이?
		if(this.perPage==null || this.perPage==0) {
			this.perPage=10;
		}
		return perPage;
	}


	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}


	public long getStartRow() {
		return startRow;
	}


	public long getLastRow() {
		return lastRow;
	}


	public long getTotalPage() {
		return totalPage;
	}

	public long getTotalBlock() {
		return totalBlock;
	}

	public long getCurBlock() {
		return curBlock;
	}

	public long getStartNum() {
		return startNum;
	}

	public long getLastNum() {
		return lastNum;
	}


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}


	
	
}
