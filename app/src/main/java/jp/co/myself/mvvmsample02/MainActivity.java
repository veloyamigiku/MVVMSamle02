package jp.co.myself.mvvmsample02;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private static final int VIEW_ID_TOOLBAR = 1;
    private static final int VIEW_ID_RECYCLERVIEW = 2;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // レイアウトを作成する。
        ConstraintLayout cl = new ConstraintLayout(this);
        cl.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT));
        //cl.setBackgroundColor(Color.BLUE);
        setContentView(cl);

        Toolbar tb = new Toolbar(this);
        tb.setId(VIEW_ID_TOOLBAR);
        tb.setTitle("MVVMSample1234");
        TypedValue colorPrimaryTv = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, colorPrimaryTv, true);
        tb.setBackgroundColor(colorPrimaryTv.data);
        TypedValue colorOnPrimaryTv = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorOnPrimary, colorOnPrimaryTv, true);
        tb.setTitleTextColor(colorOnPrimaryTv.data);
        tb.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_name));
        cl.addView(tb);
        ConstraintSet tbCs = new ConstraintSet();
        tbCs.clone(cl);
        tbCs.constrainWidth(
                tb.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        tbCs.constrainHeight(
                tb.getId(),
                ConstraintSet.WRAP_CONTENT);
        tbCs.connect(
                tb.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                0);
        tbCs.connect(
                tb.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        tbCs.connect(
                tb.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        tbCs.applyTo(cl);

        setSupportActionBar(tb);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                tb.getId(),
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