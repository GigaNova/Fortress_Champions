package com.fortress.helpers;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class TextureManager {

	private static HashMap<String, Texture> textures = new HashMap<String, Texture>();
	
	public static Sprite loadSprite(String spritename) {
		if(textures.containsKey(spritename)) {
			return new Sprite(textures.get(spritename));
		}
		else {
			Texture newTexture = new Texture(Gdx.files.internal(spritename));
			textures.put(spritename, newTexture);
			return new Sprite(newTexture);
		}
	}
	
}
