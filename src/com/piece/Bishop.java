package com.piece;

import com.entities.Cell;
import com.entities.Color;
import com.entities.Movement;

public class Bishop extends Piece{

	public Bishop(Color color) {
		super(color);
	}

	public boolean isValidMove(Cell c1, Cell c2) {
		return Movement.isDiagonal(c1, c2);
	}
	
	
	
}
