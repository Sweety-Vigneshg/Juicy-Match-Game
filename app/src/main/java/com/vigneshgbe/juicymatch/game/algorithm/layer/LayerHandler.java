package com.vigneshgbe.juicymatch.game.algorithm.layer;

import com.vigneshgbe.juicymatch.game.algorithm.target.TargetHandlerManager;
import com.vigneshgbe.juicymatch.game.layer.tile.Tile;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public interface LayerHandler {

    void initLayer(Tile[][] tiles, int row, int col);

    void updateLayer(TargetHandlerManager targetHandlerManager, Tile[][] tiles, int row, int col);

    void removeLayer(Tile[][] tiles, int row, int col);

}
