package jp.co.myself.mvvmsample02;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class CustomView2 extends LinearLayout {
    
    public interface CustomeView2Listener {
        void click(String buttonTitle, int buttonRowIdx, int buttonColIdx);
    }
    
    private CustomeView2Listener listener = null;
    
    public void setListener(CustomeView2Listener listener) {
         this.listener = listener;
    }
    
    public CustomView2(Context context, int row, int col, String labelPrefix) {
        super(context);

        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(Color.BLUE);
        setPadding(0, 0, 0, 0);

        for (Integer i = 0; i < row; i++) {
            LinearLayout horizontalLl = new LinearLayout(context);
            horizontalLl.setLayoutParams(new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));
            horizontalLl.setOrientation(LinearLayout.HORIZONTAL);
            horizontalLl.setBackgroundColor(Color.RED);
            MarginLayoutParams mp2 = (MarginLayoutParams)horizontalLl.getLayoutParams();
            mp2.setMargins(10, 0, 10, 0);
            horizontalLl.setLayoutParams(mp2);
            addView(horizontalLl);
            for (Integer j = 0; j < col; j++) {
                // TODO TextViewに切り替える。
                Button button = new Button(context);
                button.setAllCaps(false);
                button.setText(labelPrefix + i + "_" + j);
                button.setLayoutParams(new LinearLayout.LayoutParams(
                        0,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        1));
                MarginLayoutParams mlp = (MarginLayoutParams)button.getLayoutParams();
                mlp.setMargins(10, 10, 10, 10);
                button.setLayoutParams(mlp);
                button.setTextColor(Color.BLACK);
                //button.setBackgroundColor(Color.YELLOW);
                Integer finalI = i;
                Integer finalJ = j;
                button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (listener != null) {
                            listener.click(button.getText().toString(), finalI, finalJ);
                        }
                    }
                });
                horizontalLl.addView(button);
                /*TextView tv = new TextView(context);
                tv.setText(labelPrefix + i + "_" + j);
                tv.setLayoutParams(new LinearLayout.LayoutParams(
                        500,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                MarginLayoutParams mlp2 = (MarginLayoutParams)tv.getLayoutParams();
                mlp.setMargins(10, 0, 10, 0);
                tv.setLayoutParams(mlp2);
                tv.setBackgroundColor(Color.GRAY);
                horizontalLl.addView(tv);*/
            }
            //LayoutParams lp = (LayoutParams) horizontalLl.getLayoutParams();
        }

    }

}
