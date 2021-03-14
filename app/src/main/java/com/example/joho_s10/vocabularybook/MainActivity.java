package com.example.joho_s10.vocabularybook;
import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Quiz.init();

    }
    public void  hajimeru(View view) {
        Intent intent = new Intent(getApplication(), Main2Activity.class);
        intent.putExtra("Quiz", Quiz.getQuiz(0));
        startActivity(intent);
        finish();
    }
}