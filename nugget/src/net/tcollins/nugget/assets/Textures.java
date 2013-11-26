/**
 * 
 */
package net.tcollins.nugget.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * @author tcollins
 * 
 */
public class Textures {

	private static final float RUNNING_FRAME_DURATION = 0.16f;

	/** Textures **/
	private TextureRegion nuggetIdleLeft;
	// private TextureRegion nuggetIdleRight;

	/** Animations **/
	private Animation nuggetWalkLeftAnimation;

	// private Animation nuggetWalkRightAnimation;

	/** TiledMaps **/
	private TiledMap tiledMap;

	public Textures() {
		load();
	}

	private void load() {
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("images/textures/textures.pack"));
		nuggetIdleLeft = atlas.findRegion("nugget-dude01");
		// nuggetIdleRight = new TextureRegion(nuggetIdleLeft);
		// nuggetIdleLeft.flip(true, false);

		// nuggetWalkRightAnimation = buildNuggetWalkAnimation(atlas, false);
		nuggetWalkLeftAnimation = buildNuggetWalkAnimation(atlas, true);

		// load the map
		tiledMap = new TmxMapLoader().load("levels/level-01.tmx");
		//tiledMap = new TmxMapLoader().load("super-koalio/level1.tmx");

	}

	private Animation buildNuggetWalkAnimation(TextureAtlas atlas, boolean flip) {
		TextureRegion[] frames = new TextureRegion[2];
		for (int i = 0; i < frames.length; i++) {
			frames[i] = atlas.findRegion("nugget-dude0" + (i + 1));
			if (flip) {
				frames[i].flip(true, false);
			}
		}
		Animation walkAnimation = new Animation(RUNNING_FRAME_DURATION, frames);
		return walkAnimation;
	}

	public TextureRegion getNuggetIdleLeft() {
		return nuggetIdleLeft;
	}

	// public TextureRegion getNuggetIdleRight() {
	// return nuggetIdleRight;
	// }

	public Animation getNuggetWalkLeftAnimation() {
		return nuggetWalkLeftAnimation;
	}

	// public Animation getNuggetWalkRightAnimation() {
	// return nuggetWalkRightAnimation;
	// }

	public TiledMap getTiledMap() {
		return tiledMap;
	}

}
