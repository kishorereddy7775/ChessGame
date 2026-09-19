package com.piece;

import com.entities.Cell;
import com.entities.Color;
import com.entities.Movement;

public class Queen extends Piece {

	public Queen(Color color) {
		super(color);
	}

	public boolean isValidMove(Cell c1, Cell c2) {
		return Movement.isDiagonal(c1, c2) || Movement.isSameRow(c1, c2) || Movement.isSameColumn(c1, c2);
	}

}
