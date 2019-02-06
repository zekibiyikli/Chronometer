package com.nikolayazilim.chronometer;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    int kademe=1;
    Button btn;
    long timeStopped=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Chronometer simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer);
        btn=(Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kademe==1){
                    simpleChronometer.setBase(SystemClock.elapsedRealtime()+timeStopped);
                    simpleChronometer.start();
                    kademe=2;
                    btn.setText("Durdur");
                }else if(kademe==2){
                    timeStopped=simpleChronometer.getBase()-SystemClock.elapsedRealtime();
                    simpleChronometer.stop();
                    kademe=3;
                    btn.setText("Resetle");
                }else if(kademe==3){
                    timeStopped=0;
                    simpleChronometer.stop();
                    simpleChronometer.setText("00:00");
                    kademe=1;
                    btn.setText("Başlat");
                }
            }
        });
    }
}
