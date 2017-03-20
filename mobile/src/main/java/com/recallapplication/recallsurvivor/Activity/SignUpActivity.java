package com.recallapplication.recallsurvivor.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.recallapplication.recallsurvivor.R;
import com.recallapplication.recallsurvivor.lib.requestManagement.SignUpRequestManager;
import com.recallapplication.recallsurvivor.model.Survivor;

public class SignUpActivity extends AppCompatActivity {
    EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    Spinner memoryRatingSpinner;
    Survivor survivor;
    int memoryRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        this.firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        this.lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);
        this.emailEditText = (EditText) findViewById(R.id.emailEditText);
        this.passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        this.confirmPasswordEditText = (EditText) findViewById(R.id.confirmPasswordEditText);
        this.memoryRatingSpinner = (Spinner) findViewById(R.id.memoryRatingSpinner);
        ArrayAdapter<CharSequence> memoryRatingAdapter = ArrayAdapter.createFromResource(this,
                R.array.memory_score_scale_array,
                android.R.layout.simple_spinner_item);
        memoryRatingSpinner.setAdapter(memoryRatingAdapter);

        survivor = new Survivor();


    }

    public void signUp(View v)
    {
        setStringValues();
        if(validateSignUp()){
            SignUpRequestManager requestManager = new SignUpRequestManager(this, this.survivor);
            requestManager.signUp();
            finish();
            Intent signUpIntent = new Intent(this, LoginActivity.class);
            startActivity(signUpIntent);
        }

    }

    private boolean validateSignUp()
    {
        if(survivor.getFirstName().equals("")){
            firstNameEditText.setError("First Name is required");
            return false;
        }
        if(survivor.getLastName().equals("")){
            lastNameEditText.setError("Last Name is required");
            return false;
        }
        if(survivor.getEmail().equals("")){
            emailEditText.setError("Email is required");
            return false;
        }
        if(!survivor.getPassword().equals(this.confirmPasswordEditText.getText().toString().trim())){
            passwordEditText.setError("Passwords do not match");
            return false;
        }
        if(!survivor.getPassword().equals("")){
            passwordEditText.setError("Password is required");
            return false;
        }
        return true;
    }

    private void setStringValues()
    {
        survivor.setFirstName(this.firstNameEditText.getText().toString().trim());
        survivor.setLastName(this.lastNameEditText.getText().toString().trim());
        survivor.setEmail(this.emailEditText.getText().toString().trim());
        survivor.setPassword(this.emailEditText.getText().toString().trim());
        survivor.setMemoryRating(Integer.valueOf(this.memoryRatingSpinner.getSelectedItem().toString()));
    }
}
