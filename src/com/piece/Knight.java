package com.piece;

import com.entities.Cell;
import com.entities.Color;
import com.entities.Movement;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
	}

	public boolean isValidMove(Cell source, Cell destination) {
		return Movement.isTwoRowAbove(source, destination) || Movement.isOneRowAbove(source, destination) || 
				Movement.isOneRowBelow(source, destination) || Movement.isTwoRowBelow(source, destination); 
	}
	
	
}
