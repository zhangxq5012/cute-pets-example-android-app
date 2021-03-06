package com.example.cutepets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

/**
 * The main application activity. The automatic activity tracking is enabled in {@link
 * MyApp#onCreate()}. Most of the class is boilerplate template generated by Android Studio. The
 * Google Analytics code is added to onOptionsItemSelected handler to log an event when settings are
 * selected from the menu.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void begin(View view) {
        // Set custom dimensions to track gender, age group, and pets owned for the current user.
        // Custom dimensions must first be configured using the Google Analytics web interface.

        String gender = null;
        if (((RadioButton) findViewById(R.id.male)).isChecked()) {
            gender = "Male";
        } else if (((RadioButton) findViewById(R.id.female)).isChecked()) {
            gender = "Female";
        } else if (((RadioButton) findViewById(R.id.other)).isChecked()) {
            gender = "Other";
        }
        MyApp.tracker().set("&cd1", gender);

        String age = null;
        if (((RadioButton) findViewById(R.id.young)).isChecked()) {
            age = "Young";
        } else if (((RadioButton) findViewById(R.id.middle)).isChecked()) {
            age = "Middle";
        } else if (((RadioButton) findViewById(R.id.old)).isChecked()) {
            age = "Old";
        }
        MyApp.tracker().set("&cd2", age);

        if (((CheckBox) findViewById(R.id.cats)).isChecked()) {
            MyApp.tracker().set("&cd3", "Yes");
        } else {
            MyApp.tracker().set("&cd3", "No");
        }
        if (((CheckBox) findViewById(R.id.dogs)).isChecked()) {
            MyApp.tracker().set("&cd4", "Yes");
        } else {
            MyApp.tracker().set("&cd4", "No");
        }

        startActivity(new Intent(this, Instructions.class));
    }
}
