package com.koreait.spring;

import com.koreait.java.AppleSpeaker;

//상속받을 땐 extends
public class LgTv extends Tv {

	/*
	 * public LgTv(int inch, int maxChannel, int maxVolume) { super(inch,
	 * maxChannel, maxVolume); 이거 없을 때 에러 터진 이유? 기본 생성자가 없었으니까! super()도 줬어야 함 ㅎㅋ
	 */
	public LgTv(Speaker speaker) {
		super(new AppleSpeaker(40),"LgTv", 100, 40, 50);
	}


}
