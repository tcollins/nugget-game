package net.tcollins.nugget.model;

import com.badlogic.gdx.math.Vector2;

/**
 * @author tcollins
 * 
 */
public class World {

	Nugget nugget;

	public World() {
		this.nugget = new Nugget(new Vector2(3, 3));
	}

	public Nugget getNugget() {
		return nugget;
	}

}
