package com.recallapplication.recallsurvivor.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.recallapplication.recallsurvivor.R;

public class SignUpActivity extends AppCompatActivity {
    EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    String firstName, lastName, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        this.firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        this.lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);
        this.emailEditText = (EditText) findViewById(R.id.emailEditText);
        this.passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        this.confirmPasswordEditText = (EditText) findViewById(R.id.confirmPasswordEditText);
    }

    public void signUp(View v)
    {
        setStringValues();
        if(validateSignUp()){
            finish();
            Intent signUpIntent = new Intent(this, LoginActivity.class);
            startActivity(signUpIntent);
        }

    }

    private boolean validateSignUp()
    {
        if(firstName.equals("")){
            firstNameEditText.setError("First Name is required");
            return false;
        }
        if(lastNameEditText.getText().toString().trim().equals("")){
            lastNameEditText.setError("Last Name is required");
            return false;
        }
        if(emailEditText.getText().toString().trim().equals("")){
            emailEditText.setError("Email is required");
            return false;
        }
        if(!password.equals(this.confirmPasswordEditText.getText().toString().trim())){
            passwordEditText.setError("Passwords do not match");
            return false;
        }
        if(!password.equals("")){
            passwordEditText.setError("Password is required");
            return false;
        }
        return true;
    }

    private void setStringValues()
    {
        firstName = this.firstNameEditText.getText().toString().trim();
        lastName = this.lastNameEditText.getText().toString().trim();
        email = this.emailEditText.getText().toString().trim();
        password = this.emailEditText.getText().toString().trim();
    }
}
