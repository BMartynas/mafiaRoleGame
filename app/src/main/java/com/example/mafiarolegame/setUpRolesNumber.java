package com.example.mafiarolegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class setUpRolesNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_roles_number);

        final EditText numberOfRoles = (EditText) findViewById(R.id.numberOfRoles);
        final EditText numberOfCitizens = (EditText) findViewById(R.id.numberOfCitizens);
        final EditText numberOfMafia = (EditText) findViewById(R.id.numberOfMafia);

        Button incNumberOfRoles = (Button) findViewById(R.id.incNumerOfRoles);
        Button incNumberOfCitizens = (Button) findViewById(R.id.incNumerOfCitizens);
        Button incNumberOfMafia = (Button) findViewById(R.id.incNumerOfMafia);

        Button decNumberOfRoles = (Button) findViewById(R.id.decNumerOfRoles);
        Button decNumberOfCitizens = (Button) findViewById(R.id.decNumerOfCitizens);
        Button decNumberOfMafia = (Button) findViewById(R.id.decNumerOfMafia);

        Button confirm = (Button) findViewById(R.id.confirmButton);

        incNumberOfRoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nOfRoles = Integer.parseInt(numberOfRoles.getText().toString()) + 1;
                numberOfRoles.setText(nOfRoles + "");
            }
        });

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

        decNumberOfRoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nOfRoles = Integer.parseInt(numberOfRoles.getText().toString()) - 1;
                numberOfRoles.setText(nOfRoles + "");
            }
        });

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
            }
        });

    }

    public void openNewGameLobby() {
        Intent intent = new Intent(this, NewGameLobby.class);
        startActivity(intent);
    }
}
