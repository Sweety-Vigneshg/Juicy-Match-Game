package com.vigneshgbe.juicymatch.game.tutorial;

import com.vigneshgbe.juicymatch.asset.Colors;
import com.vigneshgbe.juicymatch.asset.Textures;
import com.vigneshgbe.juicymatch.game.effect.tutorial.TutorialFingerEffect;
import com.vigneshgbe.juicymatch.game.effect.tutorial.TutorialHintEffectSystem;
import com.vigneshgbe.juicymatch.game.effect.tutorial.TutorialShadowEffect;
import com.vigneshgbe.juicymatch.level.Level;
import com.nativegame.nattyengine.engine.Engine;
import com.nativegame.nattyengine.ui.GameActivity;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public class Match3Tutorial implements Tutorial {

    private final TutorialShadowEffect mShadowBg;
    private final TutorialHintEffectSystem mHintEffect;
    private final TutorialFingerEffect mFingerEffect;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public Match3Tutorial(Engine engine) {
        mShadowBg = new TutorialShadowEffect(engine, Colors.BLACK_80);
        mHintEffect = new TutorialHintEffectSystem(engine);
        mFingerEffect = new TutorialFingerEffect(engine, Textures.TUTORIAL_FINGER);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void show(GameActivity activity) {
        mShadowBg.addToGame();
        mHintEffect.activate(Level.LEVEL_DATA.getTutorialHint().toCharArray());
        mFingerEffect.activate(1200, 1200, 400, 700);
    }
    //========================================================

}
