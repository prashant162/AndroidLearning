package com.vemergetech.androidlearning;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MainFragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instantiate some stuff here like view components
        mFragment = new MainFragment();

        //Now you can set the fragment to be visible here
        setFragment(mFragment);
    }

    public void setFragment(Fragment frag)
    {
        //FragmentManager fm = getFragmentManager();
       // if (fm.findFragmentById(R.id.container) == null) {
        getSupportFragmentManager().beginTransaction().add(R.id.container, frag).commit();
        //}

    }
}
