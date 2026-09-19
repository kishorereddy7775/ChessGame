package com.piece;

import com.entities.Cell;
import com.entities.Color;
import com.entities.Movement;

public class Pawn extends Piece {

	public Pawn(Color color) {
		super(color);
	}

	public boolean isValidMove(Cell c1, Cell c2) {
		return Movement.isOneStepAway(c1, c2) || Movement.isTwoStepAway(c1, c2) || Movement.isCrossMove(c1, c2);
	}

}
