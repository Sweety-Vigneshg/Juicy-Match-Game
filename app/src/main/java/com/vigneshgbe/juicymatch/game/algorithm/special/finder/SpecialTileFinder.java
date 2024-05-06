package com.vigneshgbe.juicymatch.game.algorithm.special.finder;

import com.vigneshgbe.juicymatch.game.layer.tile.Tile;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public interface SpecialTileFinder {

    void findSpecialTile(Tile[][] tiles, int row, int col);

}
