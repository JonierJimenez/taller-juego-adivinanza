package com.example.adivinanza;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity
                          implements View.OnClickListener,
                                     AdapterView.OnItemSelectedListener{

    Button startGameBtn;
    Spinner attemptsNumberSpn;
    String[] attempts = { "5", "7", "10"};
    int selectedAttempts = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attemptsNumberSpn = findViewById(R.id.attempts_number);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, attempts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attemptsNumberSpn.setAdapter(adapter);
        attemptsNumberSpn.setOnItemSelectedListener(this);

        startGameBtn = findViewById(R.id.start_game);
        startGameBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_game:
                Intent intent = new Intent( MainActivity.this, GameActivity.class);
                intent.putExtra("attempts", selectedAttempts);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedAttempts = Integer.parseInt(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}