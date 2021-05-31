package com.koreait.spring;

public class Tv extends Object {
//abstract 추상 메소드가 없도라도 가능은 함!
//아예 안 주는 거나 public 가능 !! - 걍 public 줘라

	private Speaker speaker;
	private String brand;
	private int inch;
	private int maxChannel;
	private int maxVolume;
	private int currentChannel;
	private int currentVolume;

	public Tv() {
		super();
	}
	// super()는 부모 this는 나 자신! ()는 무조건 생성자 .은 멤버필드나 멤버메소드를 호출하거나 읽음!

	// 생성자 특징 : return 타입 X, 클래스명과 이름이 같음!
	// 생성자는 오버로딩 가능 - 똑같은 이름의 생성자 여러 개 만들기 가능
	// 기본 생성자는 컴파일러가 자동으로 만들어 줄 때가 있는데 생성자가 하나도 없을 때임

	public Tv(Speaker speaker, String brand, int inch, int maxChannel, int maxVolume) {
		this.speaker = speaker;
		this.brand = brand;
		this.inch = inch;
		this.maxChannel = maxChannel;
		this.maxVolume = maxVolume;
		this.currentChannel = 1;
	}
	// 한 번 값을 생성하면 값을 지정 안 해주기 위해 setter은 안 만듦(커렌트 제외)

	public int getCurrentChannel() {
		return currentChannel;
	}

	public int getInch() {
		return inch;
	}

	public int getMaxChannel() {
		return maxChannel;
	}

	public int getMaxVolume() {
		return maxVolume;
	}

	public void setCurrentChannel(int currentChannel) {
		this.currentChannel = currentChannel;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(int currentVolume) {
		this.currentVolume = currentVolume;
	}

	public String getBrand() {
		return brand;
	}

	// 1~40까지만 40 다음엔 1
	public void channelUp() {
		if (currentChannel == maxChannel) {
			currentChannel = 1;
		} else {
			currentChannel++;
		}

		currentChannel = currentChannel == maxChannel ? 1 : currentChannel + 1;
		System.out.println("currentChannel :" + currentChannel);
	}

	// 1 > 40
	public void channelDown() {
		if (currentChannel == 1) {
			currentChannel = maxChannel;
		} else {
			currentChannel--;
		}
		currentChannel = currentChannel == 1 ? maxChannel : currentChannel - 1;
		System.out.println("currentChannel :" + currentChannel);
	}

	public void volumeUp() {
		if (currentVolume < maxVolume) {
			currentVolume++;
		}
		System.out.printf("%s-speaker:%d\n", brand, currentVolume);
	}

	public void volumeDown() {
		if (currentVolume > 0) {
			currentVolume--;
		}
		System.out.printf("%s-speaker:%d\n", brand, currentVolume);
	}

	@Override
	public String toString() {
		return String.format("%s, %d인치, %d채널, %d 볼륨", brand, inch, maxChannel, maxVolume);
	}
}
