package com.example.anthony.sunriseandsunset;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button generate = findViewById(R.id.get);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("My App", "Account has been generated");
                Toast toast = Toast.makeText(getApplicationContext(), "Account Generated", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}