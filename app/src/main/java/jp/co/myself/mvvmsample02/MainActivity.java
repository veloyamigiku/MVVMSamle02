package jp.co.myself.mvvmsample02;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private static final int VIEW_ID_RECYCLERVIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // レイアウトを作成する。
        ConstraintLayout cl = new ConstraintLayout(this);
        cl.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT));
        cl.setBackgroundColor(Color.BLUE);
        setContentView(cl);

        // コンポーネントを作成＆配置する。
        RecyclerView rv = new RecyclerView(this);
        rv.setId(VIEW_ID_RECYCLERVIEW);
        rv.setLayoutManager(new LinearLayoutManager(this));
        cl.addView(rv);
        ConstraintSet rvCs = new ConstraintSet();
        rvCs.clone(cl);
        rvCs.constrainWidth(
                rv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        rvCs.constrainDefaultHeight(
                rv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                0);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                0);
        rvCs.applyTo(cl);

    }
}