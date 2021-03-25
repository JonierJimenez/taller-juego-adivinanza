package com.example.adivinanza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    EditText numberInput;
    TextView attemptCountdownTxt;
    Button validateBtn;
    int correctNumber;
    int attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        attempts = getIntent().getIntExtra("attempts", 5);

        Random rand = new Random();
        correctNumber = rand.nextInt(101);

        Log.i("magic_number", "" + correctNumber);

        numberInput = findViewById(R.id.number_input);
        attemptCountdownTxt = findViewById(R.id.attempts_countdown);

        attemptCountdownTxt.setText(getString(R.string.attempts_countdown, attempts));

        validateBtn = findViewById(R.id.validate_number);
        validateBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.validate_number:
                String value = numberInput.getText().toString();

                if(TextUtils.isEmpty(value)){
                    Toast.makeText(this, R.string.empty_input, Toast.LENGTH_SHORT).show();
                    return;
                }

                if(Integer.parseInt(value) > 100){
                    Toast.makeText(this, R.string.invalid_range, Toast.LENGTH_SHORT).show();
                }else {
                    if(Integer.parseInt(value) == correctNumber){
                        Intent intent = new Intent(GameActivity.this, WinnerActivity.class);
                        startActivity(intent);
                        finish();
                    }else if(Integer.parseInt(value) > correctNumber){
                        Toast.makeText(this, R.string.greater_number, Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, R.string.smaller_number, Toast.LENGTH_SHORT).show();
                    }

                    attempts--;
                    attemptCountdownTxt.setText(getString(R.string.attempts_countdown, attempts));

                    if(attempts == 0){
                        Intent intent = new Intent( GameActivity.this, LooserActivity.class);
                        intent.putExtra("correct_number", correctNumber);
                        startActivity(intent);
                        finish();
                    }
                }

                break;
        }
    }
}