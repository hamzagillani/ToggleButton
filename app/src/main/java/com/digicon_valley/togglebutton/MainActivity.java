package com.digicon_valley.togglebutton;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Switch aSwitch;
    Vibrator vibrator;
    WifiManager wifiManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.result_text);
        textView.setVisibility(View.INVISIBLE);
        aSwitch=findViewById(R.id.toogle_button_2);
        vibrator=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        wifiManager=(WifiManager)this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    wifiManager.setWifiEnabled(isChecked);
                    textView.setText("Wifi On");

                    textView.setVisibility(View.VISIBLE);
                }else
                    wifiManager.setWifiEnabled(false);
                    textView.setText("Wifi Off");
            }
        });
    }

    public void changeVibrateState(View view) {

        boolean checked=((ToggleButton)view).isChecked();
        if (vibrator.hasVibrator()&&checked){
            vibrator.vibrate(600);
            textView.setText("Vibrate On");
            textView.setVisibility(View.VISIBLE);
        }else

            textView.setText("Vibrate Off");

    }
}
