package com.koreait.spring;

public class Speaker {

	private String brand;
	private int maxVolume;
	private int currentVolume;

	public Speaker(String brand, int maxVolume) {
		super();
		this.brand = brand;
		this.maxVolume = maxVolume;
		System.out.printf("--%s 스피커 생성 --", this.brand);
	}
	//부모가 가진 생성자 호출

	public void volumeUp() {
		if (currentVolume < maxVolume) {
			currentVolume++;
		}
	}

	public void volumeDown() {
		if (currentVolume > 0) {
			currentVolume--;
		}
	}

	public String getBrand() {
		return brand;
	}

}
