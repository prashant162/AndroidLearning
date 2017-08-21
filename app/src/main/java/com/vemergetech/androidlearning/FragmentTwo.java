package com.vemergetech.androidlearning;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by prashant on 20-Aug-17.
 */

public class FragmentTwo extends Fragment {
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_layout, container, false);

        Bundle bundle = getArguments();
        String editText = bundle.getString("EditText");

        textView = (TextView)view.findViewById(R.id.display_name);
        textView.setText(editText);
        //textView.setVisibility(View.GONE);
        return view;
    }

    public void updateInfo(String name){
        textView.setText("Welcome " + name);
        textView.setVisibility(View.VISIBLE);
    }
}
