package jp.co.myself.mvvmsample02;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<ItemData> list;

    public ItemRecyclerViewAdapter(List<ItemData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ConstraintLayout cs = new ConstraintLayout(parent.getContext());
        cs.setBackgroundColor(Color.CYAN);
        cs.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT));
        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) cs.getLayoutParams();
        mlp.setMargins(10, 10, 10, 10);

        TextView nameTv = new TextView(parent.getContext());
        nameTv.setId(ItemConstant.VIEW_ID_NAME);
        nameTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        nameTv.setTextColor(parent.getResources().getColor(R.color.black));
        nameTv.setBackgroundColor(Color.GREEN);
        cs.addView(nameTv);
        ConstraintSet nameTvCs = new ConstraintSet();
        nameTvCs.constrainWidth(
                nameTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        nameTvCs.constrainHeight(
                nameTv.getId(),
                ConstraintSet.WRAP_CONTENT
        );
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                10);
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                10);
        nameTvCs.connect(
                nameTv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                10);
        nameTvCs.applyTo(cs);

        TextView makerTv = new TextView(parent.getContext());
        makerTv.setId(ItemConstant.VIEW_ID_MAKER);
        makerTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        makerTv.setTextColor(parent.getResources().getColor(R.color.black));
        makerTv.setBackgroundColor(Color.MAGENTA);
        cs.addView(makerTv);
        ConstraintSet makerTvCs = new ConstraintSet();
        makerTvCs.constrainWidth(
                makerTv.getId(),
                ConstraintSet.WRAP_CONTENT);
        makerTvCs.constrainHeight(
                makerTv.getId(),
                ConstraintSet.WRAP_CONTENT
        );
        makerTvCs.connect(
                makerTv.getId(),
                ConstraintSet.TOP,
                nameTv.getId(),
                ConstraintSet.BOTTOM,
                10);
        makerTvCs.connect(
                makerTv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                10);
        makerTvCs.connect(
                makerTv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                10);
        makerTvCs.connect(
                makerTv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                10);
        makerTvCs.applyTo(cs);

        ItemViewHolder ivh = new ItemViewHolder(cs);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.nameTv.setText(list.get(position).getName());
        holder.makerTv.setText(list.get(position).getMaker());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
