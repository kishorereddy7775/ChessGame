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
	
	public static boolean isTwoRowAbove(Cell source, Cell destination) {
		return source.row()+2==destination.row() && isOneColumnsAway(source, destination);
	}
	
	public static boolean isOneRowAbove(Cell source, Cell destination) {
		return source.row()+1==destination.row() && isTwoColumnsAway(source, destination);
	}
	
	public static boolean isOneRowBelow(Cell source, Cell destination) {
		return source.row()-1==destination.row() && isTwoColumnsAway(source, destination);
	}
	
	public static boolean isTwoRowBelow(Cell source, Cell destination) {
		return source.row()-2==destination.row() && isOneColumnsAway(source, destination);
	}

	private static boolean isOneColumnsAway(Cell source, Cell destination) {
		return source.column()+1==destination.column() || source.column()-1==destination.column();
	}
	
	private static boolean isTwoColumnsAway(Cell source, Cell destination) {
		return source.column()+2==destination.column() || source.column()-2==destination.column();
	}
	
	public static boolean isDiagonal(Cell source, Cell destination) {
		return Math.abs(source.row()-destination.row())==Math.abs(source.column()-destination.column());
	}
	
	public static boolean isOneStepAwayInAnyDirection(Cell source, Cell destination) {
		return Math.abs(source.row()-destination.row())<=1 && Math.abs(source.column()-destination.column())<=1;
	}
}
