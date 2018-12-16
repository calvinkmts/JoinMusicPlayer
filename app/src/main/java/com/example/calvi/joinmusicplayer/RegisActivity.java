package com.example.calvi.joinmusicplayer;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisActivity extends AppCompatActivity {

    private EditText mNamaEditText;
    private EditText mNrpEditText;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mRegisterButton;
    private TextView mLoginTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        mNamaEditText = (EditText)findViewById(R.id.editText6);
        mNrpEditText = (EditText)findViewById(R.id.editText3);
        mEmailEditText = (EditText)findViewById(R.id.editText4);
        mPasswordEditText = (EditText)findViewById(R.id.editText5);
        mRegisterButton = (Button)findViewById(R.id.button2);
        mLoginTextView = (TextView)findViewById(R.id.textView2);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        mLoginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void register() {
        final String nama = mNamaEditText.getText().toString().trim();
        final String nrp = mNrpEditText.getText().toString().trim();
        final String email = mEmailEditText.getText().toString().trim();
        final String password = mPasswordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(nama)){
            mNamaEditText.setError("Tolong Masukkan Nama Dulu!!!");
            mNamaEditText.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(nrp)){
            mNrpEditText.setError("Tolong Masukkan Nrp Dulu!!!");
            mNrpEditText.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)){
            mEmailEditText.setError("Tolong Masukkan Email Dulu!!!");
            mEmailEditText.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            mPasswordEditText.setError("Tolong Masukkan Password Dulu!!!");
            mPasswordEditText.requestFocus();
            return;
        }


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);

                            if (!obj.getBoolean("error")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                JSONObject userJson = obj.getJSONObject("user");

                                User user = new User(
                                        userJson.getInt("id"),
                                        userJson.getString("nrp"),
                                        userJson.getString("nama"),
                                        userJson.getString("email")
                                );

                                finish();
                                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                            } else {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nrp", nrp);
                params.put("nama", nama);
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}
