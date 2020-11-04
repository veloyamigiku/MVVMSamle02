package jp.co.myself.mvvmsample02;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class CustomView extends ConstraintLayout {

    public CustomView(Context context, String title) {
        super(context);

        TextView tv = new TextView(context);
        tv.setId(View.generateViewId());
        tv.setText(title);
        addView(tv);
        ConstraintSet tvCs = new ConstraintSet();
        tvCs.constrainWidth(
                tv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        tvCs.constrainHeight(
                tv.getId(),
                ConstraintSet.WRAP_CONTENT);
        tvCs.connect(
                tv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                20);
        tvCs.connect(
                tv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                20);
        tvCs.connect(
                tv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                20);
        tvCs.connect(
                tv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                20);
        tvCs.applyTo(this);

    }

}
