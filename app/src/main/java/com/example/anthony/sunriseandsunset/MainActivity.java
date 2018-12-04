package com.example.anthony.sunriseandsunset;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button generate = findViewById(R.id.get);
        final TextView textBox =findViewById(R.id.textBox);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    textBox.setText(API_Call.call_me());
                } catch (Exception e) {
                    textBox.setText("An error has occured.");
                    e.printStackTrace();
                }
                Log.i("My App", "Info Obtained");
                Toast toast = Toast.makeText(getApplicationContext(), "Info Obtained", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}