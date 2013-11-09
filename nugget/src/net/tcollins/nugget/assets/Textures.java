/**
 * 
 */
package net.tcollins.nugget.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author tcollins
 * 
 */
public class Textures {

	private static final float RUNNING_FRAME_DURATION = 0.06f;

	/** Textures **/
	private TextureRegion nuggetIdleLeft;
	private TextureRegion nuggetIdleRight;

	/** Animations **/
	private Animation nuggetWalkLeftAnimation;
	private Animation nuggetWalkRightAnimation;

	public Textures() {
		load();
	}

	private void load() {
		TextureAtlas atlas = new TextureAtlas(
				Gdx.files.internal("images/textures/textures.pack"));
		nuggetIdleRight = atlas.findRegion("nugget-dude01");
		nuggetIdleLeft = new TextureRegion(nuggetIdleRight);
		//nuggetIdleLeft.flip(true, false);

		nuggetWalkRightAnimation = buildNuggetWalkAnimation(atlas, false);
		nuggetWalkLeftAnimation = buildNuggetWalkAnimation(atlas, true);
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

	public TextureRegion getNuggetIdleRight() {
		return nuggetIdleRight;
	}

	public Animation getNuggetWalkLeftAnimation() {
		return nuggetWalkLeftAnimation;
	}

	public Animation getNuggetWalkRightAnimation() {
		return nuggetWalkRightAnimation;
	}

}
