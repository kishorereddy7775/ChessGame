package com.test;

import com.entities.Cell;
import com.entities.Player;
import com.game.ChessGame;

public class GameTest {
	
	public static void main(String[] Args) {
		Player p1=new Player(1,"Ramesh");
		Player p2=new Player(1,"Suresh");
		ChessGame game=new ChessGame(p1,p2);
		game.move(new Cell(1,2), new Cell(3,2));
		game.move(new Cell(7,1), new Cell(5,0));
	}

}
