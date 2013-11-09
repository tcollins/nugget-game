/**
 * 
 */
package net.tcollins.nugget.view;

import net.tcollins.nugget.assets.Textures;
import net.tcollins.nugget.model.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author tcollins
 * 
 */
public class WorldRenderer {
	private World world;

	private OrthographicCamera camera;
	private SpriteBatch spriteBatch;

	private Textures textures;

	// private Texture texture;
	// private Sprite sprite;

	public WorldRenderer(World world) {
		this.world = world;

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(1, h / w);
		spriteBatch = new SpriteBatch();

		textures = new Textures();

		// texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		// texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//
		// TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		//
		// sprite = new Sprite(region);
		// sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		// sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
		// sprite.setPosition(-sprite.getWidth() / 2, -sprite.getHeight() / 2);

	}

	public void render() {
		// spriteBatch.setProjectionMatrix(cam.combined);
		// spriteBatch.begin();
		// drawBlocks();
		// drawBob();
		// spriteBatch.end();
		// drawCollisionBlocks();
		// if (debug)
		// drawDebug();

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		// sprite.draw(batch);
		renderNugget();
		spriteBatch.end();

	}

	public void renderNugget() {
		// Bob bob = world.getBob();
		// bobFrame = bob.isFacingLeft() ? bobIdleLeft : bobIdleRight;
		// if(bob.getState().equals(State.WALKING)) {
		// bobFrame = bob.isFacingLeft() ?
		// walkLeftAnimation.getKeyFrame(bob.getStateTime(), true) :
		// walkRightAnimation.getKeyFrame(bob.getStateTime(), true);
		// } else if (bob.getState().equals(State.JUMPING)) {
		// if (bob.getVelocity().y > 0) {
		// bobFrame = bob.isFacingLeft() ? bobJumpLeft : bobJumpRight;
		// } else {
		// bobFrame = bob.isFacingLeft() ? bobFallLeft : bobFallRight;
		// }
		// }
		// spriteBatch.draw(bobFrame, bob.getPosition().x, bob.getPosition().y,
		// Bob.SIZE, Bob.SIZE);

		TextureRegion nuggetFrame = textures.getNuggetIdleLeft();
		TextureRegion nuggetFrame2 = textures.getNuggetIdleRight();

		
		spriteBatch.draw(nuggetFrame, -0.2f, 0.01f, 0.16f, 0.16f);
		spriteBatch.draw(nuggetFrame2, -0.4f, -0.2f, 0.16f, 0.16f);
		
	}

	public void dispose() {
		spriteBatch.dispose();
		// texture.dispose();
	}

}
