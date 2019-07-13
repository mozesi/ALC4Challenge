package com.kauzganga.moses.alc4challenge;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button aboutAlc;
    Button myProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the main page buttons
        aboutAlc  =(Button)findViewById(R.id.about_alc);
        myProfile =(Button)findViewById(R.id.my_profile);

        /*
        *listen to the click events of the buttons to move to another activity using the Intent clas
        *
         */
        aboutAlc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutAlcIntent = new Intent(MainActivity.this,AboutALC.class);
                startActivity(aboutAlcIntent);
            }
        });
        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutAlcIntent = new Intent(MainActivity.this,MyProfile.class);
                startActivity(aboutAlcIntent);
            }
        });
    }
}
