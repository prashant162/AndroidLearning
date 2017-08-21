package com.vemergetech.androidlearning;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentCommunicationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, new FragmentOne());
        fragmentTransaction.commit();
    }

//    @Override
//    public void setName(String name){
//        FragmentTwo f2 = (FragmentTwo) getFragmentManager().findFragmentById(R.id.fragment_two);
//        f2.updateInfo(name);
//    }
}
