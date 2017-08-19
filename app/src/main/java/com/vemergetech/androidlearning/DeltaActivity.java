package com.vemergetech.androidlearning;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class DeltaActivity extends AppCompatActivity {

    private Button returnToSecondActivity = null;
    private Spinner mSpinner = null;
    private Button performImplicit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delta);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String detailValue = extras.getString("KeyForSending");
                if(detailValue != null){
                    Toast.makeText(this, detailValue, Toast.LENGTH_SHORT).show();
                }


        }

        mSpinner = (Spinner) findViewById(R.id.spinnerSelection);

        returnToSecondActivity = (Button)findViewById(R.id.returnToSecondActivity);

        returnToSecondActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent();
                String selectedItem = mSpinner.getSelectedItem().toString();
                i.putExtra("KeyForReturning", selectedItem);
                setResult(RESULT_OK, i);
                finish();
            }
        });

        performImplicit = (Button) findViewById(R.id.performImplicit);
        performImplicit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int selectedPosition = mSpinner.getSelectedItemPosition();
                Intent impliciteIntent = null;
                switch (selectedPosition){
                    case 0:
                        //nothing selected
                        break;
                    case 1:
                        impliciteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://deltaprogram.us"));
                        break;
                    case 2:
                        impliciteIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+91)9716091694"));
                        break;
                    case 3:
                        impliciteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:30.2715, -97.472"));
                        break;
                    case 4:
                        impliciteIntent = new Intent("android.media.action.IMAGE_CAOTURE");
                        break;
                    case 5:
                        impliciteIntent = new Intent(Intent.ACTION_EDIT, Uri.parse("content://contacts/people/1"));
                        break;
                }

                if(impliciteIntent != null){
                    if(isIntentAvailable(impliciteIntent)){
                        startActivity(impliciteIntent);
                    }
                    else {
                        Toast.makeText(v.getContext(), "No application available", Toast.LENGTH_SHORT);
                    }
                }
            }
        });
    }

    private boolean isIntentAvailable(Intent intent){
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        boolean isIntentSafe = activities.size() > 0;
        return  isIntentSafe;
    }
}
