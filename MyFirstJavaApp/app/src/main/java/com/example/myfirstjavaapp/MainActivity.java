package com.example.myfirstjavaapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d("app created successfully", "created working"); //runs message in logcat
        setTitle("Home");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void launchSettings(View v) {
        //launch a new activity
        Intent i = new Intent(this, SettingsActivity.class);
        String message = ((EditText) findViewById(R.id.source)).getText().toString();
        i.putExtra("COOL", message);
        startActivity(i);
    }



    public void handleText(View v) {
        EditText t = findViewById(R.id.source); //gets input field and assigns it to T
        String input = t.getText().toString(); //gets text; converts and assigns to string
        ((TextView)findViewById(R.id.output)).setText(input); //sets text to our input field

        Toast.makeText(this, input, Toast.LENGTH_LONG).show(); //gives us alert on phone
    }







    //button click event AKA event listener
    public void disable(View v) {
        findViewById(R.id.button1).setEnabled(false);
        ((Button) findViewById(R.id.button1)).setText("new new disabled");
       /* View myView = findViewById(R.id.button1); //find view by id instead of parameter
       Button button = (Button) myView; //cast view to button object
       button.setEnabled(false);
       button.setText("New disabled");
        */



        /* v.setEnabled(false); //button can only be clicked once; greyed out after
        //Log.d("Success!", "Button: disabled"); //prints to logcat
        Button button = (Button) v;
        button.setText("Disabled"); //changes button text to disabled
        */


    }

}