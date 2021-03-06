package com.vemergetech.androidlearning;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by prashant on 20-Aug-17.
 */

public class FragmentOne extends Fragment {
    EditText editText;
    Button button;
    OnNameSetListener onNameSetListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_layout, container, false);
        editText = (EditText) view.findViewById(R.id.name);
        button = (Button) view.findViewById(R.id.submit_id);
        button.setOnClickListener(new View.OnClickListener(){
                @Override
            public void onClick(View v){
                  String name = editText.getText().toString();
                    //onNameSetListener.setName(name);
                    Bundle bundle = new Bundle();
                    bundle.putString("EditText", name);

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    FragmentTwo fragmentTwo = new FragmentTwo();
                    fragmentTwo.setArguments(bundle);

                    fragmentTransaction.replace(R.id.second_frame_container, fragmentTwo);
                    fragmentTransaction.commit();
                }

        });

        return view;

    }

    public interface OnNameSetListener  {
        public void setName(String name);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            onNameSetListener = (OnNameSetListener) context;
        }
        catch (Exception ex){
            Log.e("TextView", ex.getMessage().toString());
        }
    }
}
