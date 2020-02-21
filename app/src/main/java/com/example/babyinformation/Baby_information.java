package com.example.babyinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Baby_information extends AppCompatActivity {

    private Button newbaby;
    String name;
    int weight, length;
    String[] gender = {"Male","Female"};
    TextView cal;
    Calendar mCurrentdDate;
    int day, month ,year;

    EditText namebaby;
    EditText lengthbaby;
    EditText weightbaby;
    Button submitbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_information);

        //////////////////////////////////////////////// start Babyname /////////////////////////////////////////////////

        namebaby = (EditText) findViewById(R.id.namebaby);
        lengthbaby = (EditText) findViewById(R.id.length);
        weightbaby = (EditText) findViewById(R.id.weight);


        //////////////// Intialization validation /////////////////////

        submitbutton = (Button) findViewById(R.id.submitbutton);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = namebaby.getText().toString();
                weight = Integer.valueOf(weightbaby.getText().toString());
                length = Integer.valueOf(lengthbaby.getText().toString());
            }
        });


        //////////////////////////////////////////////// End Baby name //////////////////////////////////////////////////



        //////////////////////////////////////////////// start spinner /////////////////////////////////////////////////
        Spinner spinner = findViewById(R.id.gender);

        SpinAdapter adapter = new SpinAdapter(this,R.layout.customspinner,gender);

        spinner.setAdapter(adapter);
        //////////////////////////////////////////////// End spinner /////////////////////////////////////////////////


        //////////////////////////////////////////////// start Date /////////////////////////////////////////////////

        cal = (TextView) findViewById(R.id.Date);
        mCurrentdDate = Calendar.getInstance();

        day = mCurrentdDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrentdDate.get(Calendar.MONTH);
        year = mCurrentdDate.get(Calendar.YEAR);

        month = month+1;

        cal.setText(day+"/"+month+"/"+year);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Baby_information.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;
                        cal.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                    }
                }, year , month , day);
                datePickerDialog.show();
            }
        }

        );
        //////////////////////////////////////////////// End Date /////////////////////////////////////////////////

        /////////////////////////////////////// This is move to new page //////////////////////////////////////////
        newbaby = (Button) findViewById(R.id.newbaby);
        newbaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBaby_information2();
            }
        });
    }

    


    public void openBaby_information2(){
        Intent intent = new Intent(this, Baby_information2.class);
        startActivity(intent);
    }




}
