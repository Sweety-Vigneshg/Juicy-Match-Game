package com.vigneshgbe.juicymatch.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vigneshgbe.juicymatch.R;
import com.vigneshgbe.juicymatch.asset.Musics;
import com.vigneshgbe.juicymatch.asset.Sounds;
import com.vigneshgbe.juicymatch.game.JuicyMatch;
import com.nativegame.nattyengine.Game;
import com.nativegame.nattyengine.ui.GameButton;
import com.nativegame.nattyengine.ui.GameFragment;
import com.nativegame.nattyengine.ui.GameView;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public class MyGameFragment extends GameFragment implements View.OnClickListener {

    private Game mGame;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public MyGameFragment() {
        // Required empty public constructor
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Init button
        GameButton btnPause = (GameButton) view.findViewById(R.id.btn_pause);
        btnPause.setOnClickListener(this);

        // Update bg music
        Musics.BG_MUSIC.setCurrentStream(false);
        Musics.BG_MUSIC.stop();
        Musics.GAME_MUSIC.setCurrentStream(true);
        Musics.GAME_MUSIC.play();
    }

    @Override
    protected void onLayoutCreated(View view) {
        mGame = new JuicyMatch(getGameActivity(), (GameView) view.findViewById(R.id.game_view));
        mGame.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mGame.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mGame.stop();

        // Update bg music
        Musics.GAME_MUSIC.setCurrentStream(false);
        Musics.GAME_MUSIC.stop();
        Musics.BG_MUSIC.setCurrentStream(true);
        Musics.BG_MUSIC.play();
    }

    @Override
    public boolean onBackPressed() {
        mGame.pause();
        return true;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_pause) {
            mGame.pause();
            Sounds.BUTTON_CLICK.play();
        }
    }
    //========================================================

}
