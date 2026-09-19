package com.entities;

public class Player {
	private int id;
	private String name;
	private Color color;
	public Player(int id, String name, Color color) {
		this.id=id;
		this.name=name;
		this.color=color;
	}
	public Color getColor() {
		return color;
	}
}
