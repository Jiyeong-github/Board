package com.spring.first;

import com.koreait.spring.Speaker;

public class AppleSpeaker extends Speaker{
	
	public AppleSpeaker(int maxVolume) {
		super("애플", maxVolume);
		//부모가 가진 생성자 호출 필수
	}
	
}
