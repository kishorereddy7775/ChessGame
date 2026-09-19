package com.piece;

import com.board.Board;
import com.entities.Cell;
import com.entities.Color;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
	}

	@Override
	public boolean isValidMove(Board board, Cell source, Cell destination) {
		int rowDiff=Math.abs(source.row()-destination.row());
		int columnDiff=Math.abs(source.column()-destination.column());
		return (rowDiff==1 && columnDiff==2) || (rowDiff==2 || columnDiff==1);
	}
}
