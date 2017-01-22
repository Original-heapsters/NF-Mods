package com.example.nfulinarajr.ledcolorarray;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        String color_value;
        ImageButton customize = (ImageButton) findViewById(R.id.customize_btn);
        customize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ColorChooser.class);
                startActivity(intent);
            }
        });

        // Hardware entry point
        color_value = getIntent().getStringExtra("COLOR_VALUE");

        ImageButton morseCode = (ImageButton) findViewById(R.id.morsecode_btn);
        morseCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainMenu.this).create();

                final EditText input = new EditText(MainMenu.this);
                input.setGravity(Gravity.CENTER);

                alertDialog.setTitle("Morse Code");
                alertDialog.setMessage("What would you like to send?");
                alertDialog.setView(input);
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        ImageButton alert = (ImageButton) findViewById(R.id.alert_btn);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hardware entry point
            }
        });

        ImageButton cycle = (ImageButton) findViewById(R.id.cycle_btn);
        cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hardware entry point
            }
        });

        ImageButton flashlight = (ImageButton) findViewById(R.id.flashlight_btn);
        flashlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hardware entry point
            }
        });
    }
}
