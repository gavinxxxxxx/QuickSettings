package me.gavin.quicksettings;

import android.content.Intent;
import android.net.Uri;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.widget.Toast;

import static me.gavin.quicksettings.Utils.isAppInstalled;

/**
 * 支付宝扫码
 *
 * @author gavin.xiong 2017/10/9
 */
public class AlipayScanTileService extends TileService {

    @Override
    public void onStartListening() {
        getQsTile().setState(isAppInstalled(this, "com.eg.android.AlipayGphone")
                ? Tile.STATE_ACTIVE : Tile.STATE_UNAVAILABLE);
        getQsTile().updateTile();
    }

    @Override
    public void onClick() {
        try {
            Uri uri = Uri.parse("alipayqr://platformapi/startapp?saId=10000007");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivityAndCollapse(intent);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

}
