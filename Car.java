package com.shir.hw.io;

public class Car {

	private int idNum;
	private String color;
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getIdNum() {
		return idNum;
	}

	@Override
	public String toString() {
		return "Car [idNum=" + idNum + ", color=" + color + ", speed=" + speed + "]";
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public Car(int idNum, String color, int speed) {
		super();
		this.idNum = idNum;
		this.color = color;
		this.speed = speed;
	}

}
