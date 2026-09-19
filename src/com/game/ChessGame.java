package com.game;

import java.util.Scanner;

import com.board.Board;
import com.entities.Cell;
import com.entities.Color;
import com.entities.Move;
import com.entities.Player;
import com.exception.InvalidMoveException;
import com.piece.Piece;

public class ChessGame {

	private final Board board;
	private final Player whitePlayer, blackPlayer;
	private Player currentPlayer;
	
	public ChessGame(Player p1, Player p2) {
		board=new Board();
		whitePlayer=p1;
		blackPlayer=p2;
		currentPlayer=whitePlayer;
	}
	//To test
	public boolean makeMove(int r1,int c1,int r2, int c2) {
		return makeMove(new Move(board.getCell(r1, c1),board.getCell(r2, c2)));
	}
	
	private boolean makeMove(Move move) {
		Piece piece = move.getStart().getPiece();
		if(piece==null || piece.getColor()!=currentPlayer.getColor())
			return false;
		if(!board.move(move)) {
			return false;
		}
		swapPlayers();
		return true;
	}
	
	private void swapPlayers() {
		currentPlayer = (currentPlayer==whitePlayer)?blackPlayer:whitePlayer;
	}
	
	public boolean isGameOver() {
		return board.isCheckMate() || board.isStaleMate();
	}
}
