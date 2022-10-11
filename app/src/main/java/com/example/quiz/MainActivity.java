package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    private Button truebutton;
    private Button falsebutton;
    private Button nextbutton;
    private TextView questionTextView;

    private void setNextQuestion() {
        questionTextView.setText(questions[currentIndex].getQuestionID());
    }

    private Question[] questions = new Question[]
            {
                    new Question(R.string.q_one, true),
                    new Question(R.string.q_two, true),
                    new Question(R.string.q_three, false),
                    new Question(R.string.q_four, false),
                    new Question(R.string.q_five, false)
            };
    private int currentIndex = 0;

    private void checkAnswerCorrectness(boolean userAnswer) {
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessegeID = 0;
        if(userAnswer == correctAnswer)
        {
            resultMessegeID = R.string.correct_answer;
        }
        else
        {
            resultMessegeID = R.string.false_answer;
        }
        Toast.makeText(this,resultMessegeID, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        truebutton = findViewById(R.id.button_true);
        falsebutton = findViewById(R.id.button_false);
        nextbutton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);

        truebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswerCorrectness(true);
            }
        });
        falsebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswerCorrectness(false);
            }
        });
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1)%questions.length;
                setNextQuestion();
            }
        });
        setNextQuestion();
    }
}
