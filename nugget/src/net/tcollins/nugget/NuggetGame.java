package net.tcollins.nugget;

import net.tcollins.nugget.screen.GameScreen;

import com.badlogic.gdx.Game;

public class NuggetGame extends Game {
	@Override
	public void create() {
		setScreen(new GameScreen());
		
		//setScreen(new SuperKoalio());
	}
}
