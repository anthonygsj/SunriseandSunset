package com.example.anthony.sunriseandsunset;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import java.net.*;
import java.io.*;

public class MainActivity extends AppCompatActivity {
    String url = "https://api.sunrise-sunset.org/json?lat=36.7201600&lng=-4.4203400";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textBox = findViewById(R.id.textBox);
        Button get = findViewById(R.id.get);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpURLConnection connection = null;
                BufferedReader reader = null;

                try {
                    URL url = new URL("https://api.sunrise-sunset.org/json?lat=36.7201600&lng=-4.4203400");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.connect();

                    InputStream stream = connection.getInputStream();

                    reader = new BufferedReader(new InputStreamReader(stream));

                    StringBuffer buffer = new StringBuffer();

                    String line = "";
                    while((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }

                    textBox.setText(buffer.toString());

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
                Toast toast = Toast.makeText(getApplicationContext(), "info obtained", Toast.LENGTH_LONG);
                toast.show();
                Log.i("My App", "Sunrise and Sunset info obtained");
            }
        });
    }
}