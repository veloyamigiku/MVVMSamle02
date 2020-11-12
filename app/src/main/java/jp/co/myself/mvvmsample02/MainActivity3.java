package jp.co.myself.mvvmsample02;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView sc = new ScrollView(this);
        sc.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        ViewGroup.MarginLayoutParams mlp3 = (ViewGroup.MarginLayoutParams) sc.getLayoutParams();
        mlp3.setMargins(10, 10, 10, 10);
        sc.setBackgroundColor(Color.BLUE);
        setContentView(sc);

        LinearLayout verticalLl = new LinearLayout(this);
        verticalLl.setBackgroundColor(Color.YELLOW);
        verticalLl.setOrientation(LinearLayout.VERTICAL);
        verticalLl.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        ViewGroup.MarginLayoutParams mlp2 = (ViewGroup.MarginLayoutParams)verticalLl.getLayoutParams();
        mlp2.setMargins(10, 10, 10, 10);
        verticalLl.setLayoutParams(mlp2);
        sc.addView(verticalLl);


        RecyclerView rv = new RecyclerView(this);
        rv.setBackgroundColor(Color.RED);
        rv.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        LinearLayoutManager llmForRv = new LinearLayoutManager(this);
        llmForRv.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(llmForRv);
        ItemRecyclerViewAdapter adapter = new ItemRecyclerViewAdapter(createDataset());
        rv.setAdapter(adapter);
        verticalLl.addView(rv);


        TextView tv = new TextView(this);
        tv.setText("MVVMSample02");
        tv.setBackgroundColor(Color.RED);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        tv.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams)tv.getLayoutParams();
        mlp.setMargins(50, 50, 50, 50);
        verticalLl.addView(tv);

        CustomView2 cv = new CustomView2(this, 5, 2, "BTN");
        cv.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        cv.setListener(new CustomView2.CustomeView2Listener() {
            @Override
            public void click(String title, int rowIdx, int colIdx) {
                Snackbar.make(cv, title + ":" + rowIdx + ":" + colIdx, Snackbar.LENGTH_LONG).show();
            }
        });
        verticalLl.addView(cv);

        CustomView2 cv2 = new CustomView2(this, 5, 3, "btn");
        cv2.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        cv2.setListener(new CustomView2.CustomeView2Listener() {
            @Override
            public void click(String title, int rowIdx, int colIdx) {
                Snackbar.make(cv2, title + ":" + rowIdx + ":" + colIdx, Snackbar.LENGTH_LONG).show();
            }
        });
        verticalLl.addView(cv2);

        CustomView2 cv3 = new CustomView2(this, 5, 2, "Btn");
        cv3.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        cv3.setListener(new CustomView2.CustomeView2Listener() {
            @Override
            public void click(String title, int rowIdx, int colIdx) {
                Snackbar.make(cv3, title + ":" + rowIdx + ":" + colIdx, Snackbar.LENGTH_LONG).show();
            }
        });
        verticalLl.addView(cv3);

    }

    private List<ItemData> createDataset() {
        List<ItemData> dataset = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemData data = new ItemData("商品_" + i, "メーカー_" + i);
            dataset.add(data);
        }
        return dataset;
    }
}