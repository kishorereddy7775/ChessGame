package com.piece;

import java.util.List;

import com.board.Board;
import com.entities.Cell;
import com.entities.Color;

public abstract class Piece {

	private Color color;
	public Piece(Color color) {
		this.color=color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public abstract boolean isValidMove(Board board, Cell source, Cell destination);
	
}
