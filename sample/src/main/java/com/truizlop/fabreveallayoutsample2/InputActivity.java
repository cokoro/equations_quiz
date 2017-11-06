package com.truizlop.fabreveallayoutsample2;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import com.dd.processbutton.iml.ActionProcessButton;
import com.truizlop.fabreveallayoutsample2.utils.ProgressGenerator;

import java.sql.Array;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.HashMap;


import static java.lang.Double.parseDouble;
import static java.lang.StrictMath.sqrt;

public class InputActivity extends Activity implements ProgressGenerator.OnCompleteListener {

    MediaPlayer mediaPlayerF,mediaPlayerS;

    final int linear_num = 5;
    final int question_all = 10;
    Long timeA, timeB, Duration=0L;
    EditText txt_UserAnswer1, txt_UserAnswer2;
    int right,wrong;
    int answerd_l,answerd_q;
    Long linear_time,quadratic_time;
    public static final String EXTRAS_ENDLESS_MODE = "EXTRAS_ENDLESS_MODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        timeA = System.currentTimeMillis();

        Intent intent = this.getIntent();
        final int question_no = Integer.parseInt(intent.getStringExtra("question_no"));
        right = Integer.parseInt(intent.getStringExtra("right"));
        wrong = Integer.parseInt(intent.getStringExtra("wrong"));
        linear_time = Long.parseLong(intent.getStringExtra("linear_time"));
        quadratic_time = Long.parseLong(intent.getStringExtra("quadratic_time"));
        answerd_l = Integer.parseInt(intent.getStringExtra("answered_linear"));
        answerd_q = Integer.parseInt(intent.getStringExtra("answered_quadratic"));

        setContentView(R.layout.activity_input);

        Random random = new Random();
        int max = 199;
        int subtraction = 99;


        int A = random.nextInt(max) - subtraction;
        int B = random.nextInt(max) - subtraction;
        int C = random.nextInt(max) - subtraction;
        while ((question_no > linear_num  && ((B*B - 4 * A * C) < 0) ) || (A == 0)){
            A = random.nextInt(max) - subtraction;
            B = random.nextInt(max) - subtraction;
            C = random.nextInt(max) - subtraction;
        }
        System.out.println("&&&&&&&&&&A="+ A + "B = "+ B);

        String plus = "";
        String quadratic_x = "";
        final int res_num;
        final double res1,res2;
        if (question_no > linear_num) {
            plus += "^2";

            quadratic_x += "x";
            if (C >= 0) {
                if (C > 0){
                    quadratic_x += " +" + String.valueOf(C);
                }
            }else
                quadratic_x += " " + String.valueOf(C);
            if (B * B - 4 * A * C == 0){
                res1 = -((double)B) / (2*A);
                res_num = 1;
                res2 = 0;
            } else {
                res_num = 2;
                res1 = (-((double)B) + sqrt(B * B - 4 * A * C)) / (2 * A);
                res2 = (-((double)B) - sqrt(B * B - 4 * A * C)) / (2 * A);
                System.out.println("&&&&&&&&&&res="+ res1 + "res = "+ res2);
            }
        }else{
            res_num = 1;
            res2 = 0;
            res1 = -((double)B) / A;
            System.out.println("&&&&&&&&&&res="+ res1);
        }
        if (B >= 0)
            plus += "+";


        String resultStr = String.format( getResources( ).getString( R.string.Answer), "");
        final TextView resultTextView = (TextView) findViewById(R.id.answer);
        resultTextView.setText(resultStr);



        String todayStateStr = String.format( getResources( ).getString( R.string.Function), A, plus, B, quadratic_x);
        final TextView helloTextView = (TextView) findViewById(R.id.function);
        helloTextView.setText(todayStateStr);



        System.out.println("@@@@@@@@@@@@@@in the input quadratic_time = " + quadratic_time);
        final EditText answer_1 = (EditText) findViewById(R.id.answer_1);
        final EditText answer_2 = (EditText) findViewById(R.id.answer_2);

        if (res_num != 2)
            answer_2.setVisibility(View.INVISIBLE);

        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
        final ActionProcessButton btnSubmit = (ActionProcessButton) findViewById(R.id.btnSubmit);
        final ActionProcessButton btnNext = (ActionProcessButton) findViewById(R.id.btnNext);



        txt_UserAnswer1 = (EditText)findViewById(R.id.answer_1);
        txt_UserAnswer2 = (EditText)findViewById(R.id.answer_2);


        mediaPlayerF = MediaPlayer.create(this, R.raw.fail);
        mediaPlayerS = MediaPlayer.create(this, R.raw.success);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_answer1 = txt_UserAnswer1.getText().toString();
                String user_answer2 = txt_UserAnswer2.getText().toString();
                String result = "";

                if (is_invalid(user_answer1) || is_invalid(user_answer2))
                    return;


                btnSubmit.setEnabled(false);
                answer_1.setEnabled(false);
                answer_2.setEnabled(false);


                if ((equal_res(user_answer1, res1) && res_num == 1) ||
                        (equal_res(user_answer1, res1) && equal_res(user_answer2, res2)) ||
                        (equal_res(user_answer1, res2) && equal_res(user_answer2, res1))) {
                    result = "Correct! ";
                    right += 1;
                    if (!mediaPlayerS.isPlaying()) {
                        mediaPlayerS.start();
                    }
                }else {
                    result = "Wrong! ";
                    wrong += 1;
                    if (!mediaPlayerF.isPlaying()) {
                        mediaPlayerF.start();
                    }
                }
                if (res_num == 1)
                    result += "Answer is " + String.format("%.2f", res1);
                else
                    result += "Answers are " + String.format("%.2f", res1) + " and " + String.format("%.2f", res2);

                if (question_no <= linear_num)
                    answerd_l += 1;
                else
                    answerd_q += 1;
                String resultStr = String.format(getResources().getString(R.string.Answer), result);
                final TextView resultTextView = (TextView) findViewById(R.id.answer);
                resultTextView.setText(resultStr);
                timeB = System.currentTimeMillis();
                Duration = timeB - timeA;
            }

        });

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("in the Next button"+ Duration);
                Intent intent;

                System.out.println("**** q_no = " + (question_no));

                if (question_no < question_all) {
                    intent = new Intent(getBaseContext(), InputActivity.class);
                    intent.putExtra("question_no", String.valueOf(question_no + 1));
                    intent.putExtra("right", String.valueOf(right));
                    intent.putExtra("wrong",String.valueOf(wrong));
                    intent.putExtra("answered_linear",String.valueOf(answerd_l));
                    intent.putExtra("answered_quadratic",String.valueOf(answerd_q));
                    if (question_no <= linear_num) {
                        intent.putExtra("linear_time", String.valueOf(linear_time + Duration));
                        intent.putExtra("quadratic_time", String.valueOf(quadratic_time));
                    }else {
                        intent.putExtra("quadratic_time", String.valueOf(quadratic_time + Duration));
                        intent.putExtra("linear_time", String.valueOf(linear_time));
                    }

                    startActivity(intent);
                }else{
                    intent = new Intent(getBaseContext(), FinishActivity.class);
                    intent.putExtra("question_no", String.valueOf(question_no + 1));
                    intent.putExtra("right", String.valueOf(right));
                    intent.putExtra("wrong",String.valueOf(wrong));
                    intent.putExtra("answered_linear",String.valueOf(answerd_l));
                    intent.putExtra("answered_quadratic",String.valueOf(answerd_q));

                    intent.putExtra("quadratic_time", String.valueOf(quadratic_time + Duration));
                    intent.putExtra("linear_time", String.valueOf(linear_time));

                    startActivity(intent);
                }
            }

        });
    }
    @Override
    public void onComplete() {
        Toast.makeText(this, R.string.Loading_Complete, Toast.LENGTH_LONG).show();
    }

    public boolean equal_res(String user_answer, double res) {

        if (user_answer.equals(""))
            return false;

        DecimalFormat formatKeepOneZero = new DecimalFormat("#.##");
        double A = Double.parseDouble(user_answer);
        double B = Double.parseDouble(formatKeepOneZero.format(res));
        if (Math.abs(A - B) < 1e-6)
            return true;
        return false;

    }

    public boolean is_invalid(String user_answer) {
        if (user_answer.equals(""))
            return false;
        double user;
        try{
            user = parseDouble(user_answer);
        } catch (NumberFormatException e) { // display warning message

            new AlertDialog.Builder(this)
                    .setTitle("Please input interger.")
                    .setMessage("If the answers are not integers, please round the answers to 2 decimal places.")
                    .show();
            return true;

        }
        return false;
    }

}
