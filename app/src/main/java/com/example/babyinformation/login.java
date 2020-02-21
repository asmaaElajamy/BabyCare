package com.example.babyinformation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");
    private EditText Email;
    private EditText Password;
    private Button Login;
    private Button Info;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText) findViewById(R.id.etEmail);
        Password = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.loginbtn);

    }
    private boolean validateEmail() {
        String emailInput = Email.getText().toString().trim();

        if (emailInput.isEmpty()) {
            Email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Email.setError("Please enter a valid email address");
            return false;
        } else {
            Email.setError(null);
            return true;
        }
    }


    private boolean validatePassword() {
        String passwordInput = Password.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            Password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            Password.setError("Password too weak");
            return false;
        } else {
            Password.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateEmail() |!validatePassword()) {
            return;
        }

        String input = "Email: " + Email.getText().toString();
        input += "\n";
        input += "Password: " + Password.getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }

}
