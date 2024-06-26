package com.vigneshgbe.juicymatch.game.algorithm.target;

import com.vigneshgbe.juicymatch.game.layer.tile.Tile;
import com.vigneshgbe.juicymatch.game.layer.tile.type.CookieTile;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public class CookieTargetHandler implements TargetHandler {

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public boolean checkTarget(Tile tile) {
        if (tile instanceof CookieTile) {
            CookieTile cookie = ((CookieTile) tile);
            return cookie.isObstacle();
        }
        return false;
    }
    //========================================================

}
