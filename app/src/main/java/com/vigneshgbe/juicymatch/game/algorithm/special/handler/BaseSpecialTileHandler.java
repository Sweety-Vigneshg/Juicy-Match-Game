package com.vigneshgbe.juicymatch.game.algorithm.special.handler;

import com.vigneshgbe.juicymatch.asset.Textures;
import com.vigneshgbe.juicymatch.game.layer.Layer;
import com.vigneshgbe.juicymatch.game.layer.tile.Tile;
import com.nativegame.nattyengine.engine.Engine;
import com.nativegame.nattyengine.entity.particles.ParticleSystem;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public abstract class BaseSpecialTileHandler implements SpecialTileHandler {

    protected final Engine mEngine;
    private final ParticleSystem mLightBgParticleSystem;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    protected BaseSpecialTileHandler(Engine engine) {
        mEngine = engine;
        mLightBgParticleSystem = new ParticleSystem(engine, Textures.LIGHT_BG, 1)
                .setDuration(750)
                .setAlpha(255, 0)
                .setScale(4, 4)
                .setLayer(Layer.EFFECT_BG_LAYER);
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    protected void playTileEffect(Tile tile) {
        // Add light bg
        mLightBgParticleSystem.oneShot(tile.getCenterX(), tile.getCenterY(), 1);
    }
    //========================================================

}
