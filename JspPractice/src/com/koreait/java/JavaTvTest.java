package com.koreait.java;

import com.koreait.spring.LgTv;
import com.koreait.spring.SamsungTv;
import com.koreait.spring.Speaker;
import com.koreait.spring.SpeakerFactory;
import com.koreait.spring.Tv;

public class JavaTvTest {
	public static void main(String[] args) {
		//외부 파일 읽음
		Speaker s1= SpeakerFactory.choiceSpeaker(args[0]);
		Speaker s2= SpeakerFactory.choiceSpeaker(args[1]);
		
		Tv lgtv = new LgTv(s1);
		Tv samtv = new SamsungTv(s2);
		
		for(int i=0; i<50; i++) {
			lgtv.volumeUp();
			samtv.volumeUp();
		}
	}
}
