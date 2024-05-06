package com.vigneshgbe.juicymatch.game.algorithm.special.combine;

import com.vigneshgbe.juicymatch.algorithm.TileState;
import com.vigneshgbe.juicymatch.asset.Textures;
import com.vigneshgbe.juicymatch.game.GameEvent;
import com.vigneshgbe.juicymatch.game.effect.flash.ExplosionBeamEffectSystem;
import com.vigneshgbe.juicymatch.game.effect.flash.ExplosionFlashEffectSystem;
import com.vigneshgbe.juicymatch.game.layer.Layer;
import com.vigneshgbe.juicymatch.game.layer.tile.SpecialType;
import com.vigneshgbe.juicymatch.game.layer.tile.Tile;
import com.nativegame.nattyengine.engine.Engine;
import com.nativegame.nattyengine.entity.particles.ParticleSystem;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public class DoubleExplosiveTileCombineHandler extends BaseSpecialCombineHandler {

    private static final int GLITTER_NUM = 12;

    private final ExplosionFlashEffectSystem mFlashEffectSystem;
    private final ExplosionBeamEffectSystem mBeamEffectSystem;
    private final ParticleSystem mGlitterParticleSystem;
    private final ParticleSystem mRingLightParticleSystem;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public DoubleExplosiveTileCombineHandler(Engine engine) {
        super(engine);
        mFlashEffectSystem = new ExplosionFlashEffectSystem(engine, 1);
        mBeamEffectSystem = new ExplosionBeamEffectSystem(engine, 8);
        mGlitterParticleSystem = new ParticleSystem(engine, Textures.GLITTER, GLITTER_NUM)
                .setDuration(600)
                .setSpeedWithAngle(1500, 2500)
                .setInitialRotation(0, 360)
                .setRotationSpeed(-360, 360)
                .setAlpha(255, 0, 200)
                .setScale(1.2f, 0.5f, 200)
                .setLayer(Layer.EFFECT_LAYER);
        mRingLightParticleSystem = new ParticleSystem(engine, Textures.FLASH_RING, 1)
                .setDuration(500)
                .setScale(0, 10)
                .setAlpha(255, 55)
                .setLayer(Layer.EFFECT_LAYER);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public long getStartDelay() {
        return 0;
    }

    @Override
    public boolean checkSpecialCombine(Tile[][] tiles, Tile tileA, Tile tileB, int row, int col) {
        // Check are both tiles explosion special tile
        if (tileA.getSpecialType() == SpecialType.EXPLOSIVE
                && tileB.getSpecialType() == SpecialType.EXPLOSIVE) {
            // We make sure the origin special tiles not being detected
            tileA.setTileState(TileState.MATCH);
            tileB.setTileState(TileState.MATCH);
            handleSpecialCombine(tiles, tileA, tileB, row, col);
            return true;
        }

        return false;
    }

    @Override
    protected void playTileEffect(Tile tileA, Tile tileB) {
        super.playTileEffect(tileA, tileB);
        mGlitterParticleSystem.oneShot(tileA.getCenterX(), tileA.getCenterY(), GLITTER_NUM);
        mFlashEffectSystem.activate(tileA.getCenterX(), tileA.getCenterY());
        mBeamEffectSystem.activate(tileA.getCenterX(), tileA.getCenterY());
        mRingLightParticleSystem.oneShot(tileA.getCenterX(), tileA.getCenterY(), 1);
        mEngine.dispatchEvent(GameEvent.PULSE_GAME);
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    private void handleSpecialCombine(Tile[][] tiles, Tile tileA, Tile tileB, int row, int col) {
        int targetRow = tileA.getRow();
        int targetCol = tileA.getColumn();

        // Pop 5 X 5 tiles around
        for (int i = targetRow - 2; i <= targetRow + 2; i++) {
            for (int j = targetCol - 2; j <= targetCol + 2; j++) {
                // We make sure the index not out of bound
                if (i < 0 || i > row - 1 || j < 0 || j > col - 1) {
                    continue;
                }
                Tile t = tiles[i][j];
                // We make sure not pop the tile multiple time
                if (t.getTileState() == TileState.IDLE) {
                    t.popTile();
                }
            }
        }

        playTileEffect(tileA, tileB);
    }
    //========================================================

}
