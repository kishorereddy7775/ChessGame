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
		int rowDiff=destination.row()-source.row();
		int columnDiff=Math.abs(source.column()-destination.column());
		
		if(getColor()==Color.WHITE) {
			return (((rowDiff==1 && columnDiff==0) || (rowDiff==2 && source.row()==1 )) && board.getPiece(destination.row(), destination.column())==null) ||
					(rowDiff==1 && columnDiff==1 && board.getPiece(destination.row(),destination.column())!=null);
		}else {
			return (((rowDiff==-1 && columnDiff==0) || (rowDiff==-2 && source.row()==6))  && board.getPiece(destination.row(), destination.column())==null) ||
					(rowDiff==-1 && columnDiff==1 && board.getPiece(destination.row(),destination.column())!=null);
		}
	}

}
