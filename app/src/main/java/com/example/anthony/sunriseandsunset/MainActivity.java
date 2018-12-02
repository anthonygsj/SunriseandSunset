package com.example.anthony.sunriseandsunset;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private String sendGet() throws Exception {
        String url = "https://api.sunrise-sunset.org/json?lat=36.7201600&lng=-4.4203400";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty(null, null);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return (response.toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textBox = findViewById(R.id.textBox);
        Button generate = findViewById(R.id.get);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    textBox.setText(sendGet());
                    Toast toast = Toast.makeText(getApplicationContext(), "info obtained", Toast.LENGTH_LONG);
                    toast.show();
                } catch (Exception e) {
                    textBox.setText("you fucked up");
                }
                Log.i("My App", "Sunrise and Sunset info obtained");
            }
        });
    }
}