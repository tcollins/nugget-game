/**
 * 
 */
package net.tcollins.nugget.screen;

import net.tcollins.nugget.controller.NuggetController;
import net.tcollins.nugget.model.World;
import net.tcollins.nugget.view.WorldRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

/**
 * @author tcollins
 * 
 */
public class GameScreen implements Screen, InputProcessor {

	private World world;
	private WorldRenderer renderer;
	private NuggetController nuggetController;

	private int width, height;
	
	/************************************
	 * Screen methods
	 */

	@Override
	public void show() {
		world = new World();
		renderer = new WorldRenderer(world);
		nuggetController = new NuggetController(world);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		nuggetController.update(delta);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		renderer.setSize(width, height);
		this.width = width;
		this.height = height;
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		renderer.dispose();
		Gdx.input.setInputProcessor(null);
	}

	/************************************
	 * InputProcessor methods
	 */

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.LEFT) {
			nuggetController.leftDown();
		}
		if (keycode == Keys.RIGHT) {
			nuggetController.rightDown();
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT) {
			nuggetController.leftUp();
		}
		if (keycode == Keys.RIGHT) {
			nuggetController.rightUp();
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
