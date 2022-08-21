package com.example.assign_2_bscs_19011519_006;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);

        signin = findViewById(R.id.btnsignin);
        signup = findViewById(R.id.btnsignup);

        DB = new DBHelper(this);
    }

    public void onClickRegister(View view) {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        String repass = repassword.getText().toString();

        if(user.equals("")||pass.equals("")||repass.equals(""))
            Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        else {
            if (pass.equals(repass)){
                Boolean checkUser = DB.checkUsername(user);
                if (checkUser==false){
                    Boolean insert = DB.insertData(user, pass);
                    if (insert == true){
                        Toast.makeText(MainActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), SupervisorSelectionForm.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Registered failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "User already exists! Please login.", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(MainActivity.this, "Password not matching!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void onClickLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}