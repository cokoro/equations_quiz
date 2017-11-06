package com.truizlop.fabreveallayoutsample2;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.truizlop.fabreveallayout.FABRevealLayout;
import com.truizlop.fabreveallayout.OnRevealChangeListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FABRevealLayout fabRevealLayout = (FABRevealLayout) findViewById(R.id.fab_reveal_layout);
        configureFABReveal(fabRevealLayout);
    }

    private void configureFABReveal(FABRevealLayout fabRevealLayout) {
        fabRevealLayout.setOnRevealChangeListener(new OnRevealChangeListener() {
            @Override
            public void onMainViewAppeared(FABRevealLayout fabRevealLayout, View mainView) {
                System.out.println("in the loop\n");
                Intent intent;
                intent = new Intent(getBaseContext(), InputActivity.class);
                intent.putExtra("question_no","1");
                intent.putExtra("right","0");
                intent.putExtra("wrong","0");
                intent.putExtra("linear_time","0");
                intent.putExtra("quadratic_time","0");
                intent.putExtra("answered_linear","0");
                intent.putExtra("answered_quadratic","0");
                startActivity(intent);

            }

            @Override
            public void onSecondaryViewAppeared(final FABRevealLayout fabRevealLayout, View secondaryView) {
                prepareBackTransition(fabRevealLayout);

            }
        });
    }

    private void prepareBackTransition(final FABRevealLayout fabRevealLayout) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fabRevealLayout.revealMainView();
            }
        }, 100);
    }

}
