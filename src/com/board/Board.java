package com.board;

import java.util.List;

import com.entities.Cell;
import com.entities.Color;
import com.entities.Piece;

public class Board {
	private Piece[][] grid=new Piece[8][8];
	private int whitesAlive;
	private int blacksAlive;
	public Board() {
		fillPieces(Color.WHITE,0);
		fillSoldiers(Color.WHITE,1);
		
		fillPieces(Color.BLACK,7);
		fillSoldiers(Color.BLACK,6);
		whitesAlive=16;
		blacksAlive=16;
	}
	
	private void fillPieces(Color color, int row) {
		grid[row][0]=new Piece("Rook",color);
		grid[row][7]=new Piece("Rook",color);
		
		grid[row][1]=new Piece("Horse",color);
		grid[row][6]=new Piece("Horse",color);
		
		grid[row][2]=new Piece("Bishop",color);
		grid[row][5]=new Piece("Bishop",color);
		
		grid[row][3]=new Piece("Queen",color);
		grid[row][4]=new Piece("King",color);
	}
	
	private void fillSoldiers(Color color, int row) {
		for(int i=0;i<8;i++) {
			grid[row][i]=new Piece("Soldiers",color);
		}
	}
	
	public void move(Cell c1, Cell c2) {
		if(isCellEmpty(c1)) {
			System.out.println("Invalid move Cell c1 is Empty");
			return;
		}
		if(!isValidCell(c2)) {
			System.out.println("Cell c2 is Out of board");
		}
		if(isCellEmpty(c2)) {
			updatePiece(c1,c2);
		}else {
			Piece p1=grid[c1.row()][c1.column()];
			Piece p2=grid[c2.row()][c2.column()];
			if(p1.getColor()==p2.getColor()) {
				System.out.println("Already Occupied with same color piece");
				return;
			}
			kill(p2.getColor());
			updatePiece(c1,c2);
		}	
	}
	private void updatePiece(Cell c1, Cell c2) {
		Piece p1=grid[c1.row()][c1.column()];
		System.out.println(p1.getColor()+" "+p1.getName()+" is moved from {"+c1.row()+","+c1.column()+"} to {"+c2.row()+","+c2.column()+"}");
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
}
