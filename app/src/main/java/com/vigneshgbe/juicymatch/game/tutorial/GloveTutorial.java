package com.vigneshgbe.juicymatch.game.tutorial;

import com.vigneshgbe.juicymatch.R;
import com.vigneshgbe.juicymatch.asset.Textures;
import com.vigneshgbe.juicymatch.game.effect.tutorial.TutorialFingerEffect;
import com.vigneshgbe.juicymatch.game.effect.tutorial.TutorialHintEffectSystem;
import com.vigneshgbe.juicymatch.level.Level;
import com.nativegame.nattyengine.engine.Engine;
import com.nativegame.nattyengine.ui.GameActivity;
import com.nativegame.nattyengine.ui.GameButton;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public class GloveTutorial implements Tutorial {

    private final TutorialHintEffectSystem mHintEffect;
    private final TutorialFingerEffect mFingerEffect;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public GloveTutorial(Engine engine) {
        mHintEffect = new TutorialHintEffectSystem(engine);
        mFingerEffect = new TutorialFingerEffect(engine, Textures.TUTORIAL_FINGER);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void show(GameActivity activity) {
        mHintEffect.activate(Level.LEVEL_DATA.getTutorialHint().toCharArray());
        mFingerEffect.activate(1200, 1200, 250, 550);

        // Click the booster button
        GameButton btnGlove = (GameButton) activity.findViewById(R.id.btn_glove);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btnGlove.performClick();
            }
        });
    }
    //========================================================

}
