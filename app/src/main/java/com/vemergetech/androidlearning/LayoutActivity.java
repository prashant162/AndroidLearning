package com.vemergetech.androidlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LayoutActivity extends AppCompatActivity {

    Button myButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        myButton = (Button) findViewById(R.id.myButton);

        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myButton.setText("Clicked!");
            }
            });

    }
}
