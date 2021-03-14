package com.example.joho_s10.vocabularybook;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView tv_num;
    private TextView question;
    private TextView ans;

    private Quiz quiz;
    private TextView result;

    private SoundPool soundPool;
    private int good_se;
    private int bad_se;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_num = (TextView) findViewById(R.id.q_string);
        question = (TextView) findViewById(R.id.question);
        ans = (TextView)findViewById(R.id.ans);
        result = (TextView) findViewById(R.id.result);

        Intent intent = getIntent();
        if (intent != null) {
            quiz = (Quiz) intent.getSerializableExtra("Quiz");
            show();

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
            } else {

                AudioAttributes attr = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build();

                soundPool = new SoundPool.Builder()
                        .setAudioAttributes(attr)
                        .setMaxStreams(2)
                        .build();
            }
            good_se = soundPool.load(this, R.raw.good, 1);
            bad_se = soundPool.load(this, R.raw.bad, 1);
        }
    }

    private void setContentView(int activity_main2) {
    }

    void show() {
        if (quiz != null) {
            tv_num.setText(quiz.q_string);
            question.setText(quiz.question);
            ans.setText(quiz.answer);

            

            result.setText("");
        }
    }

    public void Jikkou(View view) {
        String str;
        EditText et = (EditText) findViewById(R.id.editText);
        str = et.getText().toString();
        String str2 = quiz.answer;
        if (str.equals(str2)) {
            result.setText("正解");
            soundPool.play(good_se, 1F, 1F, 0, 0, 1F);
            next();
            et.getText().clear();
        } else {
            result.setText("不正解");
            soundPool.play(bad_se, 1F, 1F, 0, 0, 1F);
            //次の問題を押した時と不正解になった時に問題の番号を記録する
        }
    }

    public void next() {
        quiz = Quiz.getQuiz(quiz.q_num + 1);
        if (quiz != null) {
            show();
        } else {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void next1(View view) {
        String str;
        EditText et = (EditText) findViewById(R.id.editText);
        str = et.getText().toString();
        et.getText().clear();
        Intent intent = getIntent();
        if (intent != null) {
            quiz = (Quiz) intent.getSerializableExtra("Quiz");
            ans.setText(quiz.answer);
            //next();
        }
    }

    public void finish(View v) {
        finish();
    }
}

