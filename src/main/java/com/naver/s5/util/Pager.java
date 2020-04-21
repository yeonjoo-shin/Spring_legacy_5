package com.naver.s5.util;

public class Pager {
	//파라미터로 받아올 curpage 받기
	
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
	
	

	//--------------startrow/lastrow 계산---------------------------------------------
	public void makeRow() {
		System.out.println("curpage : "+this.getCurPage());
		this.startRow =  (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
	//----------------totalcount/ totalpage 계산--------------------------------------------

	public void makePage(long totalCount) {
		//1.totalCount : 전체 글의 갯수
		
		//2. totalCount로 totalPage 계산
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			this.totalPage++;
		}
		
		//3. totalPage - >totalBlock 계산
		long perBlock =5L;// block당 page 수
		
		this.totalBlock = totalPage /perBlock;
		if(totalPage % perBlock != 0) {
			this.totalBlock++;
		}
		
		//4. curPage -> curBlock 찾기(몇번째 블록인가)
		this.curBlock = this.curPage/perBlock;
		if(this.curPage % perBlock !=0) {
			this.curBlock++;
		}
		//5. curBlock startNum ,lastNum 계산
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;
		
		if(this.curBlock==this.totalBlock) {//5개씩 끊지만 글 갯수에 맞게하기(15까지 끊지만 14에서 글이 끝날수잇음)
			this.lastNum=this.totalPage;
		}
	}
	
	//--------------getter/setter----------------------------------------------
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

	public long getStartRow() {
		return startRow;
	}


	public long getLastRow() {
		return lastRow;
	}


	public Long getCurPage() { //defalt값 정해주기
		if(this.curPage == null || this.curPage == 0) {
			this.curPage=1L;
		}
		return curPage;
	}
	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}
	
	public Integer getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage=10;
		}
		
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	
	
	
	
	
	
	
	


}
