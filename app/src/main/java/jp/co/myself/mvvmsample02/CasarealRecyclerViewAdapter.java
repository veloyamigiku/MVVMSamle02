package jp.co.myself.mvvmsample02;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CasarealRecyclerViewAdapter extends RecyclerView.Adapter<CasarealViewHolder> {

    private List<RowData> list;

    public CasarealRecyclerViewAdapter(List<RowData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CasarealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ConstraintLayout cs = new ConstraintLayout(parent.getContext());
        cs.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT));

        TextView titleTv = new TextView(parent.getContext());
        titleTv.setId(CasarealConstant.VIEW_ID_TITLE);
        titleTv.setTextSize(20);
        titleTv.setTextColor(parent.getResources().getColor(R.color.black));
        cs.addView(titleTv);
        ConstraintSet titleTvCs = new ConstraintSet();
        titleTvCs.constrainWidth(
                titleTv.getId(),
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        titleTvCs.constrainHeight(
                titleTv.getId(),
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        titleTvCs.connect(
                titleTv.getId(),
                ConstraintLayout.LayoutParams.TOP,
                ConstraintLayout.LayoutParams.PARENT_ID,
                ConstraintLayout.LayoutParams.TOP,
                20);
        titleTvCs.connect(
                titleTv.getId(),
                ConstraintLayout.LayoutParams.BOTTOM,
                ConstraintLayout.LayoutParams.PARENT_ID,
                ConstraintLayout.LayoutParams.BOTTOM,
                20);
        titleTvCs.connect(
                titleTv.getId(),
                ConstraintLayout.LayoutParams.LEFT,
                ConstraintLayout.LayoutParams.PARENT_ID,
                ConstraintLayout.LayoutParams.LEFT,
                20);
        titleTvCs.applyTo(cs);

        //parent.addView(cs);

        CasarealViewHolder cvh = new CasarealViewHolder(cs);

        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CasarealViewHolder holder, int position) {
        holder.titleView.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
