package com.example.adivinanza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WinnerActivity extends AppCompatActivity implements View.OnClickListener {

    Button retryGameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        retryGameBtn = findViewById(R.id.retry_game);
        retryGameBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.retry_game:
                Intent intent = new Intent(WinnerActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}