package com.koreait.spring;

public class TvTest {

	//메인 메소드
	public static void main(String[] args) {
		
		//Tv tv = new Tv(); - 에러 터지는 이유? 클래스명을 적어야 함. () <-기본 생성자 호출
		//기본 생성자가 없어서 에러가 터진 거였음!
	
	//	Tv tv = new Tv(1,1,1); -> 이거 보내주면 에러 안 터짐!! 
		
		Tv lgtv = new LgTv(new AppleSpeaker(40));
		//부모 객체는 자식 객체 가르키기 가능! 그 반대는 불가능!!
		
		Tv samtv = new SamsungTv(new SonySpeaker(30));
		
		// lgtv.equals(samtv);
		
		//object의 toString을 그냥 써버림..
		//부모 꺼를 안 쓰고 새로 정의해서 씀 - 오버라이딩 
		System.out.println(lgtv); //LgTv, 100인치, 40채널, 볼륨 50
		System.out.println(lgtv.toString()); //결과가 같음
		System.out.println(samtv.toString()); //SamsungTv, 90인치, 30채널, 볼륨 40
		
		for(int i=0;i<43;i++) {
		lgtv.channelDown();
		}
	}

}
