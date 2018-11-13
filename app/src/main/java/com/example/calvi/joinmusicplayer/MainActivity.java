package com.example.calvi.joinmusicplayer;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.editTextUsername);
        password = (EditText)findViewById(R.id.editTextPassword);
        loginButton = (Button)findViewById(R.id.button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginValidation(username.getText().toString(), password.getText().toString());
            }
        });


    }


    private void LoginValidation(String inputUsername, String inputPassword) {

        if (inputUsername.equals("admin") && inputPassword.equals("admin")) {

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            // 2. Chain together various setter methods to set the dialog characteristics
            builder.setMessage("Wrong username/password")
                    .setTitle("Login Unsuccessful")
                    .setCancelable(true);

            // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
            AlertDialog dialog = builder.create();
            dialog.show();

        }

    }
}
