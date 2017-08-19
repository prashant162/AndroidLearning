package com.vemergetech.androidlearning;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    String status = "";
    int order = 0;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        status = "Fragment Attached";
        displayStatus();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        status = "Fragment Created";
        displayStatus();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        status = "Fragment Create View";
        displayStatus();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        status = "Fragment View Created";
        displayStatus();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        status = "Fragment Activity Created";
        displayStatus();
    }

    @Override
    public void onStart() {
        super.onStart();
        status = "Fragment Started";
        displayStatus();
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        status = "Fragment State Restored";
        displayStatus();

    }

    @Override
    public void onResume() {
        super.onResume();
        status = "Fragment Resumed";
        displayStatus();
    }


    @Override
    public void onPause() {
        super.onPause();
        status = "Fragment Paused";
        displayStatus();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        status = "Fragment Saving State";
        displayStatus();
    }

    @Override
    public void onStop() {
        super.onStop();
        status = "Fragment Stopped";
        displayStatus();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        status = "Fragment View Destroyed";
        displayStatus();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        status = "Fragment Destroyed";
        displayStatus();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        status = "Fragment Detached";
        displayStatus();
    }

    public void displayStatus(){
        order++;
        String message = String.valueOf(order) + ": " + status;
        View v = getView();
        if(v != null){
            message = message + " [+View]";
        }
        //t.setText(status);
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
