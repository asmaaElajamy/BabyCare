package com.example.babyinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Baby_information2 extends AppCompatActivity {

    String[] gender = {"Male","Female"};
    TextView cal;
    Calendar mCurrentdDate;
    int day, month ,year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_information);

        Spinner spinner = findViewById(R.id.gender);

        SpinAdapter adapter = new SpinAdapter(this,R.layout.customspinner,gender);

        spinner.setAdapter(adapter);

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
                                       DatePickerDialog datePickerDialog = new DatePickerDialog(Baby_information2.this, new DatePickerDialog.OnDateSetListener() {
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

    }
}
