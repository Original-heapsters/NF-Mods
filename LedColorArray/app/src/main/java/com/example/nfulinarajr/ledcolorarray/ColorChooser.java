package com.example.nfulinarajr.ledcolorarray;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

public class ColorChooser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_chooser);

        final TextView color_value = (TextView) findViewById(R.id.command);
        final ColorWheel colorwheel = (ColorWheel) findViewById(R.id.wheel);
        final TextView submit_button = (TextView) findViewById(R.id.cmd_submit_btn);

        colorwheel.getColor();

        getColorValue(colorwheel, color_value);

        colorwheel.setOnColorChangedListener(new ColorWheel.OnColorChangedListener() {
            @Override
            public void onColorChanged(int color) {
                getColorValue(colorwheel, color_value);
            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ColorChooser.this, MainMenu.class);
                String hexColor = String.format("#%06X", (0xFFFFFF & colorwheel.getColor()));
                intent.putExtra("COLOR_VALUE", hexColor);
                startActivity(intent);

            }
        });

        colorwheel.setShowOldCenterColor(false);
    }

    public void getColorValue (ColorWheel in_color, TextView cv) {
        String hexColor = String.format("#%06X", (0xFFFFFF & in_color.getColor()));
        cv.setText(hexColor);
        cv.setTextColor(in_color.getColor());
    }
}
