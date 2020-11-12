package jp.co.myself.mvvmsample02;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView nameTv;
    public TextView makerTv;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        nameTv = itemView.findViewById(ItemConstant.VIEW_ID_NAME);
        makerTv = itemView.findViewById(ItemConstant.VIEW_ID_MAKER);
    }

}

