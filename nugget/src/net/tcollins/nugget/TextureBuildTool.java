package net.tcollins.nugget;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

public class TextureBuildTool {

	public static void main(String[] args) {
		String src = "/home/tcollins/dev/game-dev/nugget-game/nugget-android/assets/images";
		String dest = "/home/tcollins/dev/game-dev/nugget-game/nugget-android/assets/images/textures";

		TexturePacker2.process(src, dest, "textures.pack");
	}
}
