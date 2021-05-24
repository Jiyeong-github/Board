package com.koreait.board7.board;

public class BoardDomain extends BoardEntity {//도메인이 엔티티보다 크다
	private String writerNm;

	public String getWriterNm() {
		return writerNm;
	}

	public void setWriterNm(String writerNm) {
		this.writerNm = writerNm;
	}

}
