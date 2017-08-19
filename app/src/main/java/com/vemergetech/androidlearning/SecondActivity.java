package com.vemergetech.androidlearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button goToFirstActivityButton = null;
    private Button goToDetailActivityButton = null;
    public static final int DETAIL_REQUEST = 1;
    private TextView userSelectionText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        goToFirstActivityButton = (Button) findViewById(R.id.goFirstActivity);

        goToFirstActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent firstActivityIntent = new Intent(v.getContext(), FirstActivity.class);
                startActivity(firstActivityIntent);
            }
        });

        goToDetailActivityButton = (Button) findViewById(R.id.goDetailActivity);
        goToDetailActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent detailIntent = new Intent(v.getContext(), DeltaActivity.class);
                detailIntent.putExtra("KeyForSending", "Some data from second activity");
                startActivityForResult(detailIntent,DETAIL_REQUEST); //This will start the activity and wait for callback from that activity.. that activity will give it the data by using method 'setResult' this handles the call back in the method 'onActivityResult' as shown below
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == DETAIL_REQUEST){
            if(data.hasExtra("KeyForReturning")) {
                String myValue = data.getExtras().getString("KeyForReturning");
                userSelectionText = (TextView) findViewById(R.id.userSelection);
                userSelectionText.setText(myValue);
            }
            }

        }
    }


