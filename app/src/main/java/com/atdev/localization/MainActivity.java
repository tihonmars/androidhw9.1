package com.atdev.localization;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    Switch aSwitch;
    Spinner spinner;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
    }

    public void changeLanguage(String lang) {
        Locale locale = new Locale(lang);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

    public void switchLanguage(View view) {
        aSwitch = findViewById(R.id.switch_button);

        boolean switchState = aSwitch.isChecked();

        if (switchState) {
            changeLanguage("ru");
        } else {
            changeLanguage("en");
        }
    }

    public void applyColor(View view) {
        int spinnerValue = (int) spinner.getSelectedItemId();

        switch (spinnerValue){
            case 0:
                Utils.changeToTheme(this, Utils.THEME_GREEN);
                break;
            case 1:
                Utils.changeToTheme(this, Utils.THEME_BLUE);
                break;
            case 2:
                Utils.changeToTheme(this, Utils.THEME_YELLOW);
                break;
        }
    }
}

class Utils {
    private static int sTheme;

    final static int THEME_GREEN = 0;
    final static int THEME_BLUE = 1;
    final static int THEME_YELLOW = 2;


    static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_GREEN:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.AppTheme_Blue);
                break;
            case THEME_YELLOW:
                activity.setTheme(R.style.AppTheme_Yellow);
                break;
        }
    }
}