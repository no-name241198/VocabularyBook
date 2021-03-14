package com.example.joho_s10.vocabularybook;

import java.io.Serializable;

/**
 * Created by shind on 2017/10/6.
 */

public class Quiz implements Serializable {
    int q_num;
    String question;
    String q_string;
    String answer;

    private static Quiz[] quizzes = new Quiz[4];

    private Quiz(int q_num, String question, String q_string, String answer){
        this.q_num = q_num;
        this.question = question;
        this.q_string = q_string;
        this.answer = answer;
    }

    public static  void  init(){
        quizzes[0] = new Quiz(0,"第一問","謝罪","apology");
        quizzes[1] = new Quiz(1,"第二問","氷","ice");
        quizzes[2] = new Quiz(2,"第三問","めったにない","seldom");
        quizzes[3] = new Quiz(3,"第四問","in spite of~","");
        //quizzes[] = new Quiz(,"第問","","");
    }
    public static Quiz getQuiz(int num){
        if (num >= quizzes.length){
            return null;
        }
        return quizzes[num];
    }
}
