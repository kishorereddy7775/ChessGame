package com.piece;

import com.board.Board;
import com.entities.Cell;
import com.entities.Color;

public class Pawn extends Piece {

	public Pawn(Color color) {
		super(color);
	}

	@Override
	public boolean isValidMove(Board board, Cell source, Cell destination) {
		int rowDiff=Math.abs(source.row()-destination.row());
		int columnDiff=Math.abs(source.column()-destination.column());
		
		return (rowDiff==1 && columnDiff==0) || (rowDiff==2 && (source.row()==1 || source.row()==6)) ||
				(rowDiff==1 && columnDiff==1 && board.getPiece(destination.row(),destination.column())!=null);
		
	}

}
