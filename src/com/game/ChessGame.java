package com.game;

import java.util.ArrayDeque;
import java.util.Queue;

import com.board.Board;
import com.entities.Cell;
import com.entities.Color;
import com.entities.GameState;
import com.entities.Player;

public class ChessGame {

	private final Board board;
	private Queue<Player> turn;
	private Player winner;
	private GameState state;
	
	public ChessGame(Player p1, Player p2) {
		board=new Board();
		turn=new ArrayDeque<>();
		state=GameState.ACTIVE;
		turn.add(p1);
		turn.add(p2);
	}
	
	public void move(Cell source, Cell destination) {
		if(state==GameState.COMPLETED) {
			System.out.println("Game Already Completed");
			return;
		}
		Player cur=turn.peek();
		if(!validMove(source,destination,cur)) {
			return;
		}
		boolean success = board.move(source, destination);
		
		if(success) {
			swapPlayers();
			if(board.isOneArmyDown()) {
				winner=cur;
				state=GameState.COMPLETED;
			}
		}
	}
	private boolean validMove(Cell source, Cell destination, Player player) {
		return !board.isCellEmpty(source) && board.isValidCell(destination) && board.isPieceValidColor(source, player.getColor());
	}
	private void swapPlayers() {
		Player cur=turn.poll();
		turn.add(cur);
	}
}
