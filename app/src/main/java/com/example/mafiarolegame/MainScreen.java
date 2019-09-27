package com.example.mafiarolegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    private Button createGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        createGameButton = (Button) findViewById(R.id.create);
        createGameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                testPrint();
            }
        });
    }

    public void testPrint() {
        //Log.e("magical treasure appears");
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
    }


}
