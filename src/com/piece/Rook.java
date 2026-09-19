package com.piece;

import com.entities.Cell;
import com.entities.Color;
import com.entities.Movement;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color);
	}

	public boolean isValidMove(Cell c1, Cell c2) {
		return Movement.isSameRow(c1, c2) || Movement.isSameColumn(c1, c2);
	}

}
