package com.quado.seekbarex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text_view);
        seekBar = findViewById(R.id.seekBar);

        text.setText(seekBar.getProgress() + " / " + seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value = progress;
                text.setText(progress + " / " + seekBar.getMax());
                Toast.makeText(MainActivity.this, "Seekbar On Progress Changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Seekbar On Progress Start", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                text.setText(value + " / " + seekBar.getMax());
                Toast.makeText(MainActivity.this, "Seekbar On Progress Stop", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
