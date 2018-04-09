package com.linkedin.android;

import android.annotation.TargetApi;
import android.app.assist.AssistStructure;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.widget.AbsSpinner;
import android.widget.Button;
import android.widget.SpinnerAdapter;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AutofillManager a = getApplicationContext().getSystemService(AutofillManager.class);
//        a.hasEnabledAutofillServices();
//        boolean d = a.isEnabled();
        View f = new View(this);
//        int g = f.getAutofillType();
//        Log.e("TIPO->",String.valueOf(g));

//        AutofillId u = f.getAutofillId();
//        Log.e("id->",String.valueOf(u));

        //String gi[] = f.getAutofillHints();// risulta nullo


        //AutofillValue j = f.getAutofillValue(); // FORZA l'AUTOFILL
        //autofill(j);
        //f.autofill(j);






        Button loadNewActivity = (Button) findViewById(R.id.loadNewActivityButton);
        loadNewActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.linkedin.android.NewActivity.class);
                startActivity(intent);
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void autofill(AutofillValue value) {


        CharSequence text = value.getTextValue();
        Log.e("UU",text.toString());
    }



}