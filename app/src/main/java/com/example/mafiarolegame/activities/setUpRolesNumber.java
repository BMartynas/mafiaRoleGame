package com.example.mafiarolegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mafiarolegame.R;
import com.example.mafiarolegame.gameElements.DBManager;
import com.example.mafiarolegame.gameElements.GameSession;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class setUpRolesNumber extends AppCompatActivity {

    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference rootRef = database.getReference("Session ID");
    private DatabaseReference gameRef;
    private static GameSession game;
//    private DatabaseReference playersRef;
//    private DatabaseReference pnRef;
//    private DatabaseReference snRef;
    private DBManager DBM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_roles_number);

//        final EditText numberOfRoles = (EditText) findViewById(R.id.numberOfRoles);
        final EditText numberOfCitizens = (EditText) findViewById(R.id.numberOfCitizens);
        final EditText numberOfMafia = (EditText) findViewById(R.id.numberOfMafia);

        final EditText sessionName = (EditText) findViewById(R.id.session_name_text);
        final EditText sessionPin = (EditText) findViewById(R.id.session_pin_text);

//        Button incNumberOfRoles = (Button) findViewById(R.id.incNumerOfRoles);
        Button incNumberOfCitizens = (Button) findViewById(R.id.incNumerOfCitizens);
        Button incNumberOfMafia = (Button) findViewById(R.id.incNumerOfMafia);

//        Button decNumberOfRoles = (Button) findViewById(R.id.decNumerOfRoles);
        Button decNumberOfCitizens = (Button) findViewById(R.id.decNumerOfCitizens);
        Button decNumberOfMafia = (Button) findViewById(R.id.decNumerOfMafia);

        Button confirm = (Button) findViewById(R.id.confirmButton);

//        incNumberOfRoles.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int nOfRoles = Integer.parseInt(numberOfRoles.getText().toString()) + 1;
//                numberOfRoles.setText(nOfRoles + "");
//            }
//        });

        incNumberOfCitizens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nOfCitizens = Integer.parseInt(numberOfCitizens.getText().toString()) + 1;
                numberOfCitizens.setText(nOfCitizens + "");
            }
        });

        incNumberOfMafia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nOfMafia = Integer.parseInt(numberOfMafia.getText().toString()) + 1;
                numberOfMafia.setText(nOfMafia + "");
            }
        });

//        decNumberOfRoles.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int nOfRoles = Integer.parseInt(numberOfRoles.getText().toString()) - 1;
//                numberOfRoles.setText(nOfRoles + "");
//            }
//        });

        decNumberOfCitizens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nOfCitizens = Integer.parseInt(numberOfCitizens.getText().toString()) - 1;
                numberOfCitizens.setText(nOfCitizens + "");
            }
        });

        decNumberOfMafia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nOfMafia = Integer.parseInt(numberOfMafia.getText().toString()) - 1;
                numberOfMafia.setText(nOfMafia + "");
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewGameLobby();
//                createNewSession();

                game = new GameSession(sessionPin.getText().toString(), sessionName.getText().toString());
                DBM = new DBManager(game.getPin());
                DBM.createNewGame(game);

//                game.setPin();
//                game.setName();

//                gameRef = rootRef.child(game.getPin());
//                gameRef.setValue(game);

//                for (int i = 0; i < numberOfMafia; i++) {
                    //game.addPlayer();
//                }


//                snRef = pinRef.child("session name");
//                snRef.setValue(sessionName.getText().toString());
//                playersRef = pinRef.child("Players");
//                pnRef = playersRef.child("1");
//                pnRef.setValue("John");

            }
        });

    }

    public void openNewGameLobby() {
        Intent intent = new Intent(this, NewGameLobby.class);
        startActivity(intent);
    }

//    private void createNewSession() {
//
//    }

    public static GameSession getGame() {
        return game;
    }

    public static FirebaseDatabase getDatabase() {
        return database;
    }
}
