package com.example.mytravelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;
    Button loginButton, createAccountButton;
    public static ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.PasswordEditText);
        loginButton = findViewById(R.id.button);
        createAccountButton = findViewById(R.id.button2);

        String userListJson = getSharedPreferences("MyPrefs", MODE_PRIVATE).getString("userList", "");
        if (!userListJson.isEmpty()) {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<User>>(){}.getType();
            userList = gson.fromJson(userListJson, type);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();



                // Checking if username and password are valid
                if (getUser(username, password) != null) {
                    // Login successful, start next activity
                    Intent intent = new Intent(MainActivity.this, Discover.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });


        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,CreateAcoount.class);
                startActivity(intent2);
            }
        });


    }

    // helper method to get user from user list
    private User getUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}

class User {

    private final String username;
    private final String name;
    private final String password;


    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
    public User(String username, String password) {
        this("", username, password);
    }

    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
