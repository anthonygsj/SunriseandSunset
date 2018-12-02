package com.example.anthony.sunriseandsunset;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import java.io.*;
import java.net.*;

public class MainActivity extends AppCompatActivity {

    public String request(String query) throws IOException{
        URL url = new URL("api.sunrise-sunset.org/json?");
        URLConnection urlc = url.openConnection();

        urlc.setDoOutput(true);
        urlc.setAllowUserInteraction(false);

        PrintStream ps = new PrintStream(urlc.getOutputStream());
        ps.print(query);
        ps.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
        String i = "";
        String l = null;
        while((l = br.readLine())!= null) {
            i += l + "\n";
        }
        br.close();
        return i;
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
                Log.i("My App", "Sunrise and Sunset info obtained");
                Toast toast = Toast.makeText(getApplicationContext(), "info obtained", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}