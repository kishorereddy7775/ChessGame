package com.piece;

import com.board.Board;
import com.entities.Cell;
import com.entities.Color;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color);
	}
	
	@Override
	public boolean isValidMove(Board board, Cell source, Cell destination) {
		return source.row()==destination.row() || source.column()==destination.column();
	}

}
