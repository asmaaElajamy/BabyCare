package com.example.babyinformation;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class userinfo extends AppCompatActivity {
    //initialize variable
    EditText nameuser, emailuser, passuser;
    CheckBox checkBox, checkBox2 ,checkBox3;
    String[] gender = {"Male","Female"};
    Button button;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

        //assign variable
        nameuser = (EditText) findViewById(R.id.nameuser);
        emailuser = (EditText) findViewById(R.id.emailuser);
        passuser = (EditText) findViewById(R.id.passuser);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        button = (Button) findViewById(R.id.button);
        Spinner spinner = findViewById(R.id.gender);
        SpinAdapter adapter = new SpinAdapter(this,R.layout.customspinner,gender);
        spinner.setAdapter(adapter);

//initialize validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
//add validation for name
        awesomeValidation.addValidation(this,R.id.nameuser, RegexTemplate.NOT_EMPTY,R.string.invalide_name);
//add validation for emali
        awesomeValidation.addValidation(this,R.id.emailuser, Patterns.EMAIL_ADDRESS,R.string.invalide_email);
//add validation for password
        awesomeValidation.addValidation(this,R.id.passuser,".{6,}",R.string.invalide_password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check validation
                if(awesomeValidation.validate()& (checkBox.isChecked() || checkBox2.isChecked() || checkBox3.isChecked())){
                    Toast.makeText(getApplicationContext() , "Form Validation Succefully...",Toast.LENGTH_SHORT).show();
                    openActivity2();
                }
                else {
                    Toast.makeText(getApplicationContext() , "Please choose any checkbox",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void openActivity2() {
        Intent intent = new Intent(this, Baby_information.class);
        startActivity(intent);
    }


}
