package com.example.itzpulu.prime;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView Text;
    private int RandomNumber = (int)(Math.random()*1000 + 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Text = (TextView) findViewById(R.id.Text);
        assert Text != null;
        if (savedInstanceState == null) {
            String RandomString = String.format(Locale.US, "%d", RandomNumber);
            Text.setText("Is " + RandomString + " a prime Number ?");
            Text.setTextColor(Color.parseColor("#FF000000"));
        }
        else
        {
            RandomNumber = savedInstanceState.getInt("RandomNumber");
            String RandomString = String.format(Locale.US, "%d", RandomNumber);
            Text.setText("Is " + RandomString + " a prime Number ?");
            Text.setTextColor(Color.parseColor("#FF000000"));
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt("RandomNumber", RandomNumber);
        super.onSaveInstanceState(savedInstanceState);
    }
    private int check_Prime() {
        for (int NumberToDivide = 2; NumberToDivide < RandomNumber; NumberToDivide++) {
            if (RandomNumber % NumberToDivide == 0) {
                return 0;
            }
        }
        return 1;
    }

    public void ChangeText(View view) {
        RandomNumber = (int)(Math.random()*1000 + 1);
        String RandomString = String.format(Locale.US, "%d", RandomNumber);
        Text.setText("Is " + RandomString + " a prime Number ?");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.Quit:
                finish();
                break;
            default:
                break;
        }

        return true;
    }
    public void check_incorrectness(View view) {
        if(check_Prime()==1)
        {
            Toast.makeText(this, "Your answer is wrong! ", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Your answer is right!", Toast.LENGTH_LONG).show();
        }
    }

    public void check_Correctness(View view) {
        if(check_Prime()==1)
        {
            Toast.makeText(this, "Your answer is correct! ", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Your answer is wrong!", Toast.LENGTH_LONG).show();
        }
    }
}
