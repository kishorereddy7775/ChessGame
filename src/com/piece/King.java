package com.piece;

import com.entities.Cell;
import com.entities.Color;
import com.entities.Movement;

public class King extends Piece {

	public King(Color color) {
		super(color);
	}

	public boolean isValidMove(Cell c1, Cell c2) {
		return Movement.isOneStepAwayInAnyDirection(c1, c2);
	}
	
}
