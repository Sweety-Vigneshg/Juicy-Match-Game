package com.vigneshgbe.juicymatch.ui.dialog;

import android.view.View;

import com.vigneshgbe.juicymatch.R;
import com.vigneshgbe.juicymatch.asset.Sounds;
import com.nativegame.nattyengine.ui.GameActivity;
import com.nativegame.nattyengine.ui.GameButton;
import com.nativegame.nattyengine.ui.GameImage;
import com.nativegame.nattyengine.ui.GameText;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public class MoreMoveDialog extends BaseDialog implements View.OnClickListener {

    private int mSelectedId = R.id.btn_cancel;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public MoreMoveDialog(GameActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_more_move);
        setContainerView(R.layout.dialog_container);
        setEnterAnimationId(R.anim.enter_from_center);
        setExitAnimationId(R.anim.exit_to_center);

        // Init image
        GameImage imageExtraMove = (GameImage) findViewById(R.id.image_extra_move);
        imageExtraMove.popUp(200, 300);

        // Init text
        GameText txtExtraMove = (GameText) findViewById(R.id.txt_extra_move);
        txtExtraMove.popUp(200, 500);

        // Init button
        GameButton btnWatchAd = (GameButton) findViewById(R.id.btn_watch_ad);
        btnWatchAd.popUp(200, 700);
        btnWatchAd.setOnClickListener(this);

        GameButton btnCancel = (GameButton) findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onHide() {
        if (mSelectedId == R.id.btn_watch_ad) {
            showAd();
        } else if (mSelectedId == R.id.btn_cancel) {
            quit();
        }
    }

    @Override
    public void onClick(View view) {
        Sounds.BUTTON_CLICK.play();
        int id = view.getId();
        if (id == R.id.btn_cancel) {
            mSelectedId = id;
            dismiss();
        } else if (id == R.id.btn_watch_ad) {
            mSelectedId = id;
            dismiss();
        }
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    public void showAd() {
    }

    public void quit() {
    }
    //========================================================

}
