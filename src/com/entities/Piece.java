package com.entities;

import java.util.List;

public class Piece {

	private String name;
	private Color color;
	public Piece(String name, Color color) {
		this.name=name;
		this.color=color;
	}
	public Color getColor() {
		return color;
	}
	public String getName() {
		return name;
	}
}
