package com.entities;

import com.piece.Piece;

public class Cell{
	private final int row;
	private final int column;
	private Piece piece;
	public Cell(int row, int column) {
		this.row=row;
		this.column=column;
	}
	
	public int row() {
		return row;
	}
	public int column() {
		return column;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece=piece;
	}
	
}
