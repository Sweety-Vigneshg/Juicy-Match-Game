package com.vigneshgbe.juicymatch.game.algorithm;

import com.vigneshgbe.juicymatch.game.algorithm.special.finder.SpecialTileFinderManager;
import com.vigneshgbe.juicymatch.game.layer.tile.Tile;
import com.vigneshgbe.juicymatch.game.layer.tile.TileSystem;
import com.nativegame.nattyengine.engine.Engine;
import com.nativegame.nattyengine.entity.Entity;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public abstract class BaseAlgorithm extends Entity implements Algorithm {

    protected final Tile[][] mTiles;
    protected final int mTotalRow;
    protected final int mTotalCol;

    protected final SpecialTileFinderManager mSpecialTileFinder;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    protected BaseAlgorithm(Engine engine, TileSystem tileSystem) {
        super(engine);
        mTiles = tileSystem.getChild();
        mTotalRow = tileSystem.getTotalRow();
        mTotalCol = tileSystem.getTotalColumn();
        mSpecialTileFinder = new SpecialTileFinderManager(engine);
    }
    //========================================================

}
