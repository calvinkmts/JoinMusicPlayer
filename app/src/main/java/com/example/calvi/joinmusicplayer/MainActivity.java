package com.example.calvi.joinmusicplayer;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText mNrpEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private TextView mRegisTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNrpEditText = (EditText)findViewById(R.id.editText);
        mPasswordEditText = (EditText)findViewById(R.id.editText2);
        mLoginButton = (Button)findViewById(R.id.button);
        mRegisTextView = (TextView)findViewById(R.id.textView);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });


        mRegisTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisActivity.class);
                startActivity(intent);
            }
        });

    }


    private void Login() {



    }


}
