/**
 * 
 */
package net.tcollins.nugget.model;

import com.badlogic.gdx.math.Vector2;

/**
 * @author tcollins
 * 
 */
public class Nugget extends GameObject {

	public enum State {
		IDLE, WALKING, JUMPING, DYING
	}

	public static final float SIZE = 1.5f;

	State state = State.IDLE;
	boolean facingLeft = true;
	float stateTime = 0;

	public Nugget(Vector2 position) {
		super(position, SIZE, SIZE);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean isFacingLeft() {
		return facingLeft;
	}

	public void setFacingLeft(boolean facingLeft) {
		this.facingLeft = facingLeft;
	}

	public float getStateTime() {
		return stateTime;
	}

	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;
	}

	public void updateStateTime(float delta) {
		stateTime += delta;
	}

}
