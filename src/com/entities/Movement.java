package com.entities;

public class Movement {

	public static boolean isOneStepAway(Cell c1, Cell c2) {
		return c1.column()==c2.column() && c1.row()+1==c2.row();
	}
	
	public static boolean isTwoStepAway(Cell c1, Cell c2) {
		return c1.column()==c2.column() && c1.row()+2==c2.row();
	}
	
	public static boolean isCrossMove(Cell c1, Cell c2) {
		return (c1.row()+1==c2.row() && (c1.column()+1==c2.column() || c1.column()-1==c2.column()));
	}
	
	public static boolean isSameRow(Cell c1, Cell c2) {
		return c1.row()==c2.row();
	}
	
	public static boolean isSameColumn(Cell c1, Cell c2) {
		return c1.column()==c2.column();
	}
	
	public static boolean isKnightMove(Cell c1, Cell c2) {
		int dr=Math.abs(c1.row()-c2.row());
		int dc=Math.abs(c1.column()-c2.column());
		return (dr==2 && dc==1) || (dr==1 || dc==2);
	}
	
	public static boolean isDiagonal(Cell source, Cell destination) {
		return Math.abs(source.row()-destination.row())==Math.abs(source.column()-destination.column());
	}
	
	public static boolean isOneStepAwayInAnyDirection(Cell source, Cell destination) {
		return Math.max(Math.abs(source.row()-destination.row()),Math.abs(source.column()-destination.column()))==1;
	}
}
