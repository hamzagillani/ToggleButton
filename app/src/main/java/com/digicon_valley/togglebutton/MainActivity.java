package com.digicon_valley.togglebutton;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.result_text);
        textView.setVisibility(View.INVISIBLE);
        aSwitch=findViewById(R.id.toogle_button_2);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    textView.setText("Wifi On");
                    textView.setVisibility(View.VISIBLE);
                }else textView.setText("Wifi Off");
            }
        });
    }

    public void changeVibrateState(View view) {

        boolean checked=((ToggleButton)view).isChecked();
        if (checked){
            textView.setText("Vibrate On");
            textView.setVisibility(View.VISIBLE);
        }else
            textView.setText("Vibrate Off");

    }
}
