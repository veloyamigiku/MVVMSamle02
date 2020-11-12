package jp.co.myself.mvvmsample02;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout cl = new ConstraintLayout(this);
        cl.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT));
        cl.setBackgroundColor(Color.GREEN);
        setContentView(cl);

        CustomView2 cv = new CustomView2(this, 5, 2, "BTN");
        cv.setId(View.generateViewId());
        cv.setListener(new CustomView2.CustomeView2Listener() {
            @Override
            public void click(String buttonTitle, int buttonRowIdx, int buttonColIdx) {
                Snackbar.make(cv, buttonTitle + ":" + buttonRowIdx + ":" + buttonColIdx, Snackbar.LENGTH_LONG).show();
            }
        });
        cl.addView(cv);
        ConstraintSet cvCs = new ConstraintSet();
        cvCs.constrainWidth(
                cv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        cvCs.constrainHeight(
                cv.getId(),
                ConstraintSet.WRAP_CONTENT);
        cvCs.connect(
                cv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                0);
        cvCs.connect(
                cv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        cvCs.connect(
                cv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        cvCs.applyTo(cl);


    }
}