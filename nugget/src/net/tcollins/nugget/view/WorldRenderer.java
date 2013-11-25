/**
 * 
 */
package net.tcollins.nugget.view;

import net.tcollins.nugget.assets.Textures;
import net.tcollins.nugget.model.Nugget;
import net.tcollins.nugget.model.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

/**
 * @author tcollins
 * 
 */
public class WorldRenderer {

	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;

	private World world;
	private TextureRegion nuggetFrame;

	private OrthographicCamera camera;
	private SpriteBatch spriteBatch;

	private OrthogonalTiledMapRenderer tiledMapRenderer;
	ShapeRenderer shaperRenderer = new ShapeRenderer();

	private Textures textures;

	private int width;
	private int height;
	private float ppuX; // pixels per unit on the X axis
	private float ppuY; // pixels per unit on the Y axis

	public WorldRenderer(World world) {
		this.world = world;

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		// camera = new OrthographicCamera(1, h / w);
		camera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		camera.position.set(world.getNugget().getPosition().x, 1.0f, 0);
		camera.update();

		spriteBatch = new SpriteBatch();

		textures = new Textures();
		
		tiledMapRenderer = new OrthogonalTiledMapRenderer(textures.getTiledMap(), 1 / 64f);
	}

	public void setSize(int w, int h) {
		this.width = w;
		this.height = h;
		ppuX = (float) width / CAMERA_WIDTH;
		ppuY = (float) height / CAMERA_HEIGHT;
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

		// camera.position.set(world.getNugget().getPosition().x, 1.0f, 0);

		float lerp = 0.3f;
		Vector3 position = this.camera.position;
		position.x += (world.getNugget().getPosition().x - position.x) * lerp;

		camera.update();

		renderBackground();

		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		// sprite.draw(batch);
		renderNugget();
		spriteBatch.end();

	}

	public void renderBackground() {
		// shaperRenderer.setProjectionMatrix(camera.combined);
		// shaperRenderer.begin(ShapeType.FilledRectangle);
		// for (int i = 0; i < 40; i++) {
		// if (i % 2 == 0) {
		// shaperRenderer.setColor(new Color(1, 0, 0, 1));
		// } else {
		// shaperRenderer.setColor(new Color(1, 0, 1, 1));
		// }
		// shaperRenderer.filledRect(i - 14 + 2, -3.0f, 0.98f, 2);
		// }
		// shaperRenderer.end();

		shaperRenderer.setProjectionMatrix(camera.combined);
		shaperRenderer.begin(ShapeType.Filled);

		for (int i = 0; i < 40; i++) {
			if (i % 2 == 0) {
				shaperRenderer.setColor(new Color(1, 0, 0, 1));
			} else {
				shaperRenderer.setColor(new Color(1, 0, 1, 1));
			}
			shaperRenderer.rect(i - 14 + 2, -3.0f, 0.98f, 2);
		}
		shaperRenderer.end();
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

		Nugget nug = world.getNugget();

		switch (nug.getState()) {
		case IDLE:
			nuggetFrame = textures.getNuggetIdleLeft();
			break;
		case WALKING:
			nuggetFrame = textures.getNuggetWalkLeftAnimation().getKeyFrame(nug.getStateTime(), true);
			break;
		case JUMPING:
			nuggetFrame = textures.getNuggetIdleLeft();
			break;
		}

		if (nug.isFacingLeft()) {
			spriteBatch.draw(nuggetFrame, nug.getPosition().x, -1.0f, Nugget.WIDTH, Nugget.HEIGHT);

		} else {
			spriteBatch.draw(nuggetFrame, nug.getPosition().x + Nugget.WIDTH, -1.0f, -Nugget.WIDTH, Nugget.HEIGHT);
		}

	}

	public void dispose() {
		spriteBatch.dispose();
		// texture.dispose();
	}

}
