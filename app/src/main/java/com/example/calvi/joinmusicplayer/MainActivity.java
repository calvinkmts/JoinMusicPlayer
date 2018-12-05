package com.example.calvi.joinmusicplayer;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mNrpEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private Button mRegisButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNrpEditText = (EditText)findViewById(R.id.editText);
        mPasswordEditText = (EditText)findViewById(R.id.editText2);
        mLoginButton = (Button)findViewById(R.id.button);
        mRegisButton = (Button)findViewById(R.id.button3);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginValidation(mNrpEditText.getText().toString(), mPasswordEditText.getText().toString());
            }
        });

        mRegisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
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

    private void register() {
        final String nrp = mNrpEditText.getText().toString().trim();
        final String password = mPasswordEditText.getText().toString().trim();
        //final String email =
    }
}
