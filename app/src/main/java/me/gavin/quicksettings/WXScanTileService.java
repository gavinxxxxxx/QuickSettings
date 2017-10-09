package me.gavin.quicksettings;

import android.content.Intent;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.widget.Toast;

import static me.gavin.quicksettings.Utils.isAppInstalled;

/**
 * 微信扫码
 *
 * @author gavin.xiong 2017/10/9
 */
public class WXScanTileService extends TileService {

    @Override
    public void onStartListening() {
        getQsTile().setState(isAppInstalled(this, "com.tencent.mm")
                ? Tile.STATE_ACTIVE : Tile.STATE_UNAVAILABLE);
        getQsTile().updateTile();
    }

    @Override
    public void onClick() {
        try {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            startActivityAndCollapse(intent);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
