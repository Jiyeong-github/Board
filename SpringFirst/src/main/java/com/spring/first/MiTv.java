package com.spring.first;

public class MiTv {
	private Speaker speaker;
	//speaker는 null 값 - 호출x
	public MiTv() {
		System.out.println("MiTv 기본 생성자");
	}
	
	public MiTv(Speaker speaker) {
		System.out.println("MiTv speaker 생성자");
		this.speaker = speaker;
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
}
