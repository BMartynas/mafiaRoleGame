package com.example.mafiarolegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mafiarolegame.R;
import com.example.mafiarolegame.gameElements.GameSession;

public class NewGameLobby extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_lobby);

        TextView gamePin = (TextView) findViewById(R.id.game_pin_text);

//        gamePin.setText(game.get);
    }
}
