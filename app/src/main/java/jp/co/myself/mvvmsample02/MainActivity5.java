package jp.co.myself.mvvmsample02;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.bumptech.glide.Glide;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout cl = new ConstraintLayout(this);
        cl.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT));
        setContentView(cl);

        ImageView iv = new ImageView(this);
        iv.setId(View.generateViewId());
        cl.addView(iv);
        ConstraintSet ivCs = new ConstraintSet();
        ivCs.constrainWidth(
                iv.getId(),
                (int) Utils.convertDp2Px(100, this));
        ivCs.constrainHeight(
                iv.getId(),
                (int) Utils.convertDp2Px(100, this));
        ivCs.centerHorizontally(
                iv.getId(),
                ConstraintSet.PARENT_ID);
        ivCs.centerVertically(
                iv.getId(),
                ConstraintSet.PARENT_ID);
        ivCs.applyTo(cl);
        Glide
                .with(this)
                .load("https://item-shopping.c.yimg.jp/i/g/veds_315122-111-men")
                .into(iv);

    }
}