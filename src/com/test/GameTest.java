package com.test;

import com.entities.Cell;
import com.entities.Color;
import com.entities.Player;
import com.game.ChessGame;

public class GameTest {
	
	public static void main(String[] Args) {
		Player p1=new Player(1,"Ramesh",Color.WHITE);
		Player p2=new Player(1,"Suresh",Color.BLACK);
		ChessGame game=new ChessGame(p1,p2);
		game.move(new Cell(1,2), new Cell(3,2));
		game.move(new Cell(7,1), new Cell(5,0));
		game.move(new Cell(0,0), new Cell(1,1));
	}

}
