package com.atdev.localization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeLanguage(String lang){
        Locale locale = new Locale(lang);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

    public void switchLanguage(View view) {
        aSwitch = findViewById(R.id.switch_button);

        boolean switchState = aSwitch.isChecked();

        if (switchState){
            changeLanguage("ru");
        }else {
            changeLanguage("en");
        }
    }
}
