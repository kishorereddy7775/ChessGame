package com.entities;

public class Player {
	private int id;
	private String name;
	private Color color;
	public Player(int id, String name) {
		this.id=id;
		this.name=name;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color=color;
	}
}
