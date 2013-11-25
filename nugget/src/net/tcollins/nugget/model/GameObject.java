/**
 * 
 */
package net.tcollins.nugget.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * @author tcollins
 * 
 */
public class GameObject {

	Vector2 position = new Vector2();
	Vector2 acceleration = new Vector2();
	Vector2 velocity = new Vector2();
	Rectangle bounds = new Rectangle();

	public GameObject(Vector2 position, float height, float width) {
		this.setPosition(position);
		this.bounds.height = height;
		this.bounds.width = width;
	}

	public Vector2 getPosition() {
		return position;
	}

	public Vector2 getAcceleration() {
		return acceleration;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
		this.bounds.setX(position.x);
		this.bounds.setY(position.y);
	}

	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

}
