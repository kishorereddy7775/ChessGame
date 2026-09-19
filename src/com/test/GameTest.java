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
		game.start();
	}

}
