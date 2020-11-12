package jp.co.myself.mvvmsample02;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomView2 extends LinearLayout {
    
    public interface CustomeView2Listener {
        void click(String title, int rowIdx, int colIdx);
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
                TextView tv = new TextView(context);
                // タップ時のエフェクトを設定する。
                tv.setClickable(true);
                TypedValue selectableItemBackgroundTypedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, selectableItemBackgroundTypedValue, true);
                tv.setBackgroundResource(selectableItemBackgroundTypedValue.resourceId);
                tv.setText(labelPrefix + i + "_" + j);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
                tv.setPadding(20, 20, 20, 20);
                tv.setLayoutParams(new LinearLayout.LayoutParams(
                        0,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        1));
                //MarginLayoutParams tvForMlp = (MarginLayoutParams)tv.getLayoutParams();
                //tvForMlp.setMargins(20, 20, 20, 20);
                //tv.setLayoutParams(tvForMlp);
                //tv.setBackgroundColor(Color.GRAY);
                Integer finalI = i;
                Integer finalJ = j;
                tv.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (listener != null) {
                            listener.click(tv.getText().toString(), finalI, finalJ);
                        }
                    }
                });
                horizontalLl.addView(tv);
            }
        }

    }

}
