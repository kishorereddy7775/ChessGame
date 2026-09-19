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
	
	public void move(Cell c1, Cell c2) {
		if(state==GameState.COMPLETED) {
			System.out.println("Game Already Completed");
			return;
		}
		Player cur=turn.peek();
		if(!board.isPieceValidColor(c1, cur.getColor())) {
			System.out.println("Player is picking opposite color piece");
			return;
		}
		boolean success = board.move(c1, c2);
		
		if(success) {
			swapPlayers();
			if(board.isOneArmyDown()) {
				winner=cur;
				state=GameState.COMPLETED;
			}
		}
	}
	private void swapPlayers() {
		Player cur=turn.poll();
		turn.add(cur);
	}
}
