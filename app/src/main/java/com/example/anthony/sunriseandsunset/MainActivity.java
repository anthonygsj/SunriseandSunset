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
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
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
    /** called when user clicks view times button
     * https://developer.android.com/training/basics/firstapp/starting-activity#CreateActivity*/
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText); //im not sure about this line
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}