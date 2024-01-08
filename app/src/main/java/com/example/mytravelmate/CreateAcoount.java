package com.example.mytravelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class CreateAcoount extends AppCompatActivity {

    private EditText nameEditText, usernameEditText, passwordEditText, confirmPasswordEditText;
    private Button createAccountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acoount);

        nameEditText = findViewById(R.id.Name);
        usernameEditText = findViewById(R.id.UserName);
        passwordEditText = findViewById(R.id.Setpassword);
        confirmPasswordEditText = findViewById(R.id.Confirmpassword);
        createAccountButton = findViewById(R.id.createAccountButton);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString().trim();
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    nameEditText.setError("Name is required!");
                    return;
                }

                if (TextUtils.isEmpty(username)) {
                    usernameEditText.setError("Username is required!");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    passwordEditText.setError("Password is required!");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    confirmPasswordEditText.setError("Passwords do not match!");
                    return;
                }

                // Check if user already exists
                for (User user : MainActivity.userList) {
                    if (user.getUsername().equals(username)) {
                        usernameEditText.setError("Username already taken!");
                        return;
                    }
                }

                // Create new user and add to the list
                User newUser = new User(name, username, password);
                MainActivity.userList.add(newUser);

                Gson gson = new Gson();
                String userListJson = gson.toJson(MainActivity.userList);
                getSharedPreferences("MyPrefs", MODE_PRIVATE).edit().putString("userList", userListJson).apply();


                Intent intent3=new Intent(CreateAcoount.this,Welcome.class);
                startActivity(intent3);
            }
        });


    }
}