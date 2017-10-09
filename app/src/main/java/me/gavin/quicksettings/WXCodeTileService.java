package me.gavin.quicksettings;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

/**
 * 微信付款码 todo
 *
 * @author gavin.xiong 2017/10/9
 */
public class WXCodeTileService extends TileService {

    @Override
    public void onStartListening() {
        getQsTile().setState(Tile.STATE_UNAVAILABLE);
        getQsTile().updateTile();
    }

    @Override
    public void onClick() {

    }

}
