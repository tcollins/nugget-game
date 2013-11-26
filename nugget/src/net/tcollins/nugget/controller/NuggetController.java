/**
 * 
 */
package net.tcollins.nugget.controller;

import net.tcollins.nugget.model.Nugget;
import net.tcollins.nugget.model.World;

/**
 * @author tcollins
 * 
 */
public class NuggetController {

	private static final float ACCELERATION = 1.2f;
	private static final float GRAVITY = -20f;
	private static final float DAMP = 0.81f;
	private static final float MAX_VEL = 0.12f;

	private World world;
	private Nugget nug;

	// keys
	boolean keySpace = false;
	boolean keyLeft = false;
	boolean keyRight = false;

	public NuggetController(World world) {
		this.world = world;
		this.nug = world.getNugget();
	}

	public void update(float delta) {
		// System.out.println("NuggetController.update - " + delta + " -L: " +
		// keyLeft + " -R: " + keyRight);

		processInput();

		// Setting initial vertical acceleration
		nug.getAcceleration().y = GRAVITY;

		// Convert acceleration to frame time
		nug.getAcceleration().mul(delta);

		// apply acceleration to change velocity
		nug.getVelocity().add(nug.getAcceleration().x, nug.getAcceleration().y);

		// checking collisions with the surrounding blocks depending on Bob's
		// velocity
		// checkCollisionWithBlocks(delta);

		// apply damping to halt Bob nicely
		nug.getVelocity().x *= DAMP;

		// ensure terminal velocity is not exceeded
		if (nug.getVelocity().x > MAX_VEL) {
			nug.getVelocity().x = MAX_VEL;
		}
		if (nug.getVelocity().x < -MAX_VEL) {
			nug.getVelocity().x = -MAX_VEL;
		}

		
		System.out.println(nug.getVelocity().x);
		
		
		// simply updates the state time
		nug.updateStateTime(delta);

		// update Nug's position
		nug.getPosition().add(nug.getVelocity());
		nug.getBounds().x = nug.getPosition().x;
		nug.getBounds().y = nug.getPosition().y;

	}

	/** Change Bob's state and parameters based on input controls **/
	private boolean processInput() {
		// if (keys.get(Keys.JUMP)) {
		// if (!bob.getState().equals(State.JUMPING)) {
		// jumpingPressed = true;
		// jumpPressedTime = System.currentTimeMillis();
		// bob.setState(State.JUMPING);
		// bob.getVelocity().y = MAX_JUMP_SPEED;
		// grounded = false;
		// } else {
		// if (jumpingPressed && ((System.currentTimeMillis() - jumpPressedTime)
		// >= LONG_JUMP_PRESS)) {
		// jumpingPressed = false;
		// } else {
		// if (jumpingPressed) {
		// bob.getVelocity().y = MAX_JUMP_SPEED;
		// }
		// }
		// }
		// }

		if(keySpace){
			// todo  handle jumping
			System.out.println("TODO... handle jump");
		}
		
		if (!nug.getState().equals(Nugget.State.JUMPING)) {
			if (keyLeft) {
				nug.setFacingLeft(true);
				nug.setState(Nugget.State.WALKING);
				nug.getAcceleration().x = -ACCELERATION;
			} else if (keyRight) {
				nug.setFacingLeft(false);
				nug.setState(Nugget.State.WALKING);
				nug.getAcceleration().x = ACCELERATION;
			} else {
				nug.setState(Nugget.State.IDLE);
				nug.getAcceleration().x = 0;
			}
		}

		return false;
	}

	public void leftDown() {
		keyLeft = true;
	}

	public void leftUp() {
		keyLeft = false;
	}

	public void rightDown() {
		keyRight = true;
	}

	public void rightUp() {
		keyRight = false;
	}
	
	public void spaceDown() {
		keySpace = true;
	}
	
	public void spaceUp() {
		keySpace = false;
	}
	
	
}
