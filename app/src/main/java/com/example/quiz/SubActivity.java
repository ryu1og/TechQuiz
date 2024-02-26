package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;

public class SubActivity extends AppCompatActivity {

    private int point = 0;
    private int number = 0;

    private TextView questionView;
    private Button button1, button2, button3, button4;

    private String[] questions = {
            "int型は何型の変数か。",
            "無線LANの暗号化方式はどれか。",
            "技術を理解している者が企業経営を学び、技術革新をビジネスに結び付けようとする考え方はどれか。"
    };

    private String[][] choices = {
            {"整数型", "小数型", "文字型", "論理値型"},
            {"ESSID", "HTTPS", "POP3", "WPA2"},
            {"JIF", "MOT", "OJT", "TOM"}
    };

    private String[] answers = {"整数型", "WPA2", "MOT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        questionView = findViewById(R.id.question);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        setQuestion();
    }

    private void setQuestion() {
        questionView.setText(questions[number]);
        button1.setText(choices[number][0]);
        button2.setText(choices[number][1]);
        button3.setText(choices[number][2]);
        button4.setText(choices[number][3]);
    }

    public void answerClick(View view) {
        Button clickedButton = (Button) view;
        String buttonText = clickedButton.getText().toString();
        boolean isCorrect = buttonText.equals(answers[number]);

        // 正誤に応じたダイアログを表示
        showNextQuestionDialog(isCorrect);
    }

    private void showNextQuestionDialog(boolean isCorrect) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(isCorrect ? "正解！" : "不正解！");
        builder.setMessage(isCorrect ? "素晴らしい！次の問題に進みましょう。" : "残念でした。次の問題に進みましょう。");

        // 最終問題かどうかでボタンの挙動を変える
        if (number < questions.length - 1) {
            builder.setPositiveButton("次の問題へ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (isCorrect) {
                        point++;
                    }
                    number++;
                    setQuestion();
                }
            });
        } else {
            builder.setPositiveButton("結果を見る", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (isCorrect) {
                        point++;
                    }
                    showResult();
                }
            });
        }

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showResult() {
        Intent resultIntent = new Intent(SubActivity.this, ResultActivity.class);
        resultIntent.putExtra("SCORE", point);
        startActivity(resultIntent);
        finish(); // 現在のアクティビティを終了してスタックから削除
    }

}
