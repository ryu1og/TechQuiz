package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // ボタンがクリックされたときに呼び出されるメソッド
    public void startQuiz(View view) {
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
    }
}

