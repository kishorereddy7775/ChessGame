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
	
	public void start() {
		while(!isGameOver()) {
			Move move;
			try {
				move=getPlayerMove();
			} catch (InvalidMoveException e) {
				System.out.println(e.getMessage());
				continue;
			}
			if(board.move(move)) {
				swapPlayers();
			}
		}
	}
	
	private void swapPlayers() {
		currentPlayer = (currentPlayer==whitePlayer)?blackPlayer:whitePlayer;
	}
	private Move getPlayerMove() throws InvalidMoveException {
		Scanner scanner=new Scanner(System.in);
		
		int sourceRow=scanner.nextInt();
		int sourceColumn=scanner.nextInt();
		
		int destinationRow=scanner.nextInt();
		int destinationColumn=scanner.nextInt();
		
		Piece piece = board.getPiece(sourceRow, sourceColumn);
		if(piece==null || piece.getColor()!=currentPlayer.getColor()) {
			throw new InvalidMoveException("Invalid Move");
		}
				
		return new Move(board.getCell(sourceRow, sourceColumn),board.getCell(destinationRow, destinationColumn));
	}
	
	public boolean isGameOver() {
		return board.isCheckMate() || board.isStaleMate();
	}
}
