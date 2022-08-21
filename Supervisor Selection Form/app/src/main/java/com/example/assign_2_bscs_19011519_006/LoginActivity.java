package com.example.assign_2_bscs_19011519_006;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);

        btnLogin = findViewById(R.id.btnsignin1);
        DB = new DBHelper(this);
    }

    public void onClickLogin(View view) {
        String user = username.getText().toString();
        String pass = password.getText().toString();

        if (user.equals("")||pass.equals("")){
            Toast.makeText(LoginActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean checkUserPass = DB.checkUsernamePassword(user, pass);
            if (checkUserPass==true){
                Toast.makeText(LoginActivity.this, "Login Successfully!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SupervisorSelectionForm.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(LoginActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
            }
            }

        }
    }
