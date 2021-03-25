package com.example.adivinanza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LooserActivity extends AppCompatActivity implements View.OnClickListener {

    int correctNumber;
    TextView correctNumberTxt;
    Button retryGameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looser);

        correctNumber = getIntent().getIntExtra("correct_number", 5);

        correctNumberTxt = findViewById(R.id.correct_number);
        correctNumberTxt.setText(getString(R.string.correct_number, correctNumber));

        retryGameBtn = findViewById(R.id.retry_game);
        retryGameBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.retry_game:
                Intent intent = new Intent(LooserActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}