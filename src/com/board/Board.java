package com.board;

import java.util.List;

import com.entities.Cell;
import com.entities.Color;
import com.piece.*;

public class Board {
	private Piece[][] grid=new Piece[8][8];
	private int whitesAlive;
	private int blacksAlive;
	public Board() {
		fillPieces(Color.WHITE,0);
		fillPawns(Color.WHITE,1);
		
		fillPieces(Color.BLACK,7);
		fillPawns(Color.BLACK,6);
		whitesAlive=16;
		blacksAlive=16;
	}
	
	private void fillPieces(Color color, int row) {
		grid[row][0]=new Rook(color);
		grid[row][7]=new Rook(color);
		
		grid[row][1]=new Knight(color);
		grid[row][6]=new Knight(color);
		
		grid[row][2]=new Bishop(color);
		grid[row][5]=new Bishop(color);
		
		grid[row][3]=new Queen(color);
		grid[row][4]=new King(color);
	}
	
	private void fillPawns(Color color, int row) {
		for(int i=0;i<8;i++) {
			grid[row][i]=new Pawn(color);
		}
	}
	
	public boolean move(Cell c1, Cell c2) {
		if(isCellEmpty(c1)) {
			System.out.println("Invalid move Cell c1 is Empty");
			return false;
		}
		Piece source=grid[c1.row()][c1.column()];
		if(!isValidCell(c2)) {
			System.out.println("Cell c2 is Out of board");
			return false;
		}
		if(!isMovePossible(source,c1,c2)) {
			System.out.println("Move is not possible");
			return false;
		}
		if(isCellEmpty(c2)) {
			updatePiece(c1,c2);
		}else {
			Piece p1=grid[c1.row()][c1.column()];
			Piece p2=grid[c2.row()][c2.column()];
			if(p1.getColor()==p2.getColor()) {
				System.out.println("Already Occupied with same color piece");
				return false;
			}
			kill(p2.getColor());
			updatePiece(c1,c2);
		}	
		return true;
	}
	private void updatePiece(Cell c1, Cell c2) {
		Piece p1=grid[c1.row()][c1.column()];
		grid[c2.row()][c2.column()]=p1;
		grid[c1.row()][c1.column()]=null;
	}
	private void kill(Color color) {
		if(color==Color.WHITE)
			whitesAlive--;
		else
			blacksAlive--;
	}
	
	private boolean isCellEmpty(Cell c) {
		return grid[c.row()][c.column()]==null;
	}
	
	private boolean isValidCell(Cell c) {
		return c.row()>=0 && c.row()<8 && c.column()>=0 && c.column()<8;
	}
	public boolean isOneArmyDown() {
		return whitesAlive==0 || blacksAlive==0;
	}
	public boolean isPieceValidColor(Cell c, Color color) {
		return grid[c.row()][c.column()].getColor()==color;
	}
	public boolean isMovePossible(Piece piece, Cell source, Cell destination) {
		return piece.isValidMove(source, destination);
	}
}
