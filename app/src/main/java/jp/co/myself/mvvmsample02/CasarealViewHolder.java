package jp.co.myself.mvvmsample02;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CasarealViewHolder extends RecyclerView.ViewHolder {

    public TextView titleView;

    public CasarealViewHolder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(CasarealConstant.VIEW_ID_TITLE);
    }
}
