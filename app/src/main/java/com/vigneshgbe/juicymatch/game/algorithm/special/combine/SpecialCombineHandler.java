package com.vigneshgbe.juicymatch.game.algorithm.special.combine;

import com.vigneshgbe.juicymatch.game.layer.tile.Tile;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public interface SpecialCombineHandler {

    long getStartDelay();

    boolean checkSpecialCombine(Tile[][] tiles, Tile tileA, Tile tileB, int row, int col);

}
