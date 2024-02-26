package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // インテントからスコアを取得
        Intent intent = getIntent();
        int score = intent.getIntExtra("SCORE", 0);

        // スコアを表示するTextViewを取得し、スコアを設定
        TextView scoreView = findViewById(R.id.score);
        scoreView.setText(String.format("Your Score: %d", score));
    }
}
