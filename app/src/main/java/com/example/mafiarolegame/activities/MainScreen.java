package com.example.mafiarolegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mafiarolegame.R;

public class MainScreen extends AppCompatActivity {

    private Button createGameButton;
    private Button joinGameButton;
    private Button quitGameButton;
    private Button instructionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        createGameButton = (Button) findViewById(R.id.create);
        joinGameButton = (Button) findViewById(R.id.join);
        quitGameButton = (Button) findViewById(R.id.quit);
        instructionsButton = (Button) findViewById(R.id.instructions);

        createGameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openSetUpRolesNumber();
            }
        });

        joinGameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openJoinExistingGame();
            }
        });

        quitGameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        instructionsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openInstructions();
            }
        });
    }

    public void openSetUpRolesNumber() {
        Intent intent = new Intent(this, setUpRolesNumber.class);
        startActivity(intent);
    }

    public void openJoinExistingGame() {
        Intent intent = new Intent(this, JoinExistingGame.class);
        startActivity(intent);
    }

    public void openInstructions() {
        Intent intent = new Intent(this, instructions.class);
        startActivity(intent);
    }
}
