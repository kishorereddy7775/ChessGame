package com.board;

import com.entities.Cell;
import com.entities.Color;
import com.entities.Move;
import com.piece.*;

public class Board {
	private Cell[][] grid;
	public Board() {
		grid = new Cell[8][8];
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				grid[i][j]=new Cell(i,j);
			}
		}
		fillPieces(Color.WHITE,0);
		fillPawns(Color.WHITE,1);
		
		fillPieces(Color.BLACK,7);
		fillPawns(Color.BLACK,6);
	}
	
	private void fillPieces(Color color, int row) {
		grid[row][0].setPiece(new Rook(color));
		grid[row][7].setPiece(new Rook(color));
		
		grid[row][1].setPiece(new Knight(color));
		grid[row][6].setPiece(new Knight(color));
		
		grid[row][2].setPiece(new Bishop(color));
		grid[row][5].setPiece(new Bishop(color));
		
		grid[row][3].setPiece(new Queen(color));
		grid[row][4].setPiece(new King(color));
	}
	
	private void fillPawns(Color color, int row) {
		for(int i=0;i<8;i++) {
			grid[row][i].setPiece(new Pawn(color));
		}
	}
	
	public boolean move(Move move) {
		Cell c1=move.getStart();
		Cell c2=move.getEnd();
		Piece source=grid[c1.row()][c1.column()].getPiece();
		if(source==null || !source.isValidMove(this, c1, c2))
			return false;
		c2.setPiece(source);
		c1.setPiece(null);	
		return true;
	}
	
	public Cell getCell(int row, int column) {
		return grid[row][column];
	}
	
	public Piece getPiece(int row, int col) {
		return grid[row][col].getPiece();
	}
	
	public void setPiece(int row, int col, Piece piece) {
		grid[row][col].setPiece(piece);
	}
	
	public boolean isCheckMate() {
		//To do
		return false;
	}
	public boolean isStaleMate() {
		//To do
		return false;
	}
	
}
