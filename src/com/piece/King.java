package com.piece;

import com.board.Board;
import com.entities.Cell;
import com.entities.Color;

public class King extends Piece {

	public King(Color color) {
		super(color);
	}

	@Override
	public boolean isValidMove(Board board, Cell source, Cell destination) {
		int rowDiff=Math.abs(source.row()-destination.row());
		int columnDiff=Math.abs(source.column()-destination.column());
		return Math.max(rowDiff, columnDiff)==1;
	}
	
}
