package com.example.anthony.sunriseandsunset;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.net.*;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button get = findViewById(R.id.get);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Request Sent", Toast.LENGTH_LONG);
                toast.show();
                Log.i("My App", "Request Sent");
                new JSONTask().execute();
            }
        });
    }

    public class JSONTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "Invalid input, please try again";
            EditText latitude = findViewById(R.id.editLatitude);
            EditText longitude = findViewById(R.id.editLongitude);
            EditText date = findViewById(R.id.editDate);
            String lat = latitude.getText().toString();
            String lng = longitude.getText().toString();
            String d = date.getText().toString();
            try {
                result = API_Call.call_me(lat,lng,d);
                if (result == null) {
                    result = "Latitude cannot exceed +-90, Longitude cannot exceed +=180.";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            final TextView textBox = findViewById(R.id.textBox);
            super.onPostExecute(result);
            textBox.setText(result);
        }
    }
}