package com.vigneshgbe.juicymatch.ui.dialog;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.vigneshgbe.juicymatch.R;
import com.vigneshgbe.juicymatch.asset.Sounds;
import com.vigneshgbe.juicymatch.item.prize.Prize;
import com.nativegame.nattyengine.ui.GameActivity;
import com.nativegame.nattyengine.ui.GameButton;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public class NewPrizeDialog extends BaseDialog implements View.OnClickListener {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public NewPrizeDialog(GameActivity activity, Prize prize) {
        super(activity);
        setContentView(R.layout.dialog_new_prize);
        setContainerView(R.layout.dialog_container);

        // Init prize image
        ImageView imagePrize = (ImageView) findViewById(R.id.image_prize);
        imagePrize.setImageResource(prize.getDrawableId());

        // Init prize bg image
        ImageView imagePrizeBg = (ImageView) findViewById(R.id.image_prize_bg);
        Animation animation = AnimationUtils.loadAnimation(mParent, R.anim.logo_rotate);
        imagePrizeBg.startAnimation(animation);

        // Init button
        GameButton btnNext = (GameButton) findViewById(R.id.btn_next);
        btnNext.popUp(200, 300);
        btnNext.setOnClickListener(this);

        Sounds.GAME_WIN.play();
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void onClick(View view) {
        Sounds.BUTTON_CLICK.play();
        int id = view.getId();
        if (id == R.id.btn_next) {
            dismiss();
        }
    }
    //========================================================

}

