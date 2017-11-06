package com.truizlop.fabreveallayoutsample2;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.dd.processbutton.iml.ActionProcessButton;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Intent intent = this.getIntent();
        int question_no = Integer.parseInt(intent.getStringExtra("question_no")) - 1;
        int right = Integer.parseInt(intent.getStringExtra("right"));
        int wrong = Integer.parseInt(intent.getStringExtra("wrong"));
        int answered_linear = Integer.parseInt(intent.getStringExtra("answered_linear"));
        int answered_quadratic = Integer.parseInt(intent.getStringExtra("answered_quadratic"));

        String rightStateStr = String.format( getResources( ).getString( R.string.right_num), right);
        final TextView rightTextView = (TextView) findViewById(R.id.right_num);
        rightTextView.setText(rightStateStr);

        String wrongStateStr = String.format( getResources( ).getString( R.string.wrong_num), wrong);
        final TextView wrongTextView = (TextView) findViewById(R.id.wrong_num);
        wrongTextView.setText(wrongStateStr);

        int skip = question_no - right - wrong;
        String skipStateStr = String.format( getResources( ).getString( R.string.skip_num), skip);
        final TextView skipTextView = (TextView) findViewById(R.id.skip_num);
        skipTextView.setText(skipStateStr);

        System.out.println("@@@@@@!!!!" + intent.getStringExtra("linear_time"));
        System.out.println("@@@@@@!!!!" + Long.parseLong(intent.getStringExtra("linear_time")));
        System.out.println("in the finish @@@@@@!!!!" + intent.getStringExtra("quadratic_time"));
        System.out.println("@@@@@@!!!!" + Long.parseLong(intent.getStringExtra("quadratic_time")));

        Long linear = Long.parseLong(intent.getStringExtra("linear_time"));
        Long quadratic = Long.parseLong(intent.getStringExtra("quadratic_time"));


        double average_linear = 0;
        if (answered_linear != 0)
            average_linear = ((double)linear)/answered_linear;
        String linearTimeStr = String.format( getResources( ).getString( R.string.linear_time), String.format("%.2f", average_linear));
        final TextView linearTimeView = (TextView) findViewById(R.id.linear_time);
        linearTimeView.setText(linearTimeStr);

        double average_quadratic = 0;
        if (answered_quadratic != 0)
            average_quadratic = ((double)quadratic)/answered_quadratic;
        String quadraticTimeStr = String.format( getResources( ).getString( R.string.quadratic_time), String.format("%.2f", average_quadratic));
        final TextView quadraticTimeView = (TextView) findViewById(R.id.quadratic_time);
        quadraticTimeView.setText(quadraticTimeStr);

        final ActionProcessButton btnSubmit = (ActionProcessButton) findViewById(R.id.btnHome);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
