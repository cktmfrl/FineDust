package com.example.finedust.view;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finedust.R;
import com.example.finedust.model.dust_material.Dust;

import java.util.List;


public class FineDustRecyclerAdapter extends RecyclerView.Adapter<FineDustRecyclerAdapter.ViewHolder> {

    private final List<Dust> mList;

    public FineDustRecyclerAdapter(List<Dust> mList) {
        this.mList = mList;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_finedust, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dust item = mList.get(position);
        holder.item.setText(item.getName());
        holder.value.setText(item.getValue() + " " + item.getUnit());

        int grade = Integer.parseInt(item.getGrade()); // (1 : 좋음, 2: 보통, 3: 나쁨, 4: 매우나쁨)
        String gradeStr = "좋음";
        switch (grade) {
            case 1:
                holder.grade_img.setImageResource(R.drawable.ic_grade_very_good_24);
                holder.grade.setTextColor(Color.BLUE);
                gradeStr = "좋음";
                break;
            case 2:
                holder.grade_img.setImageResource(R.drawable.ic_grade_good_24);
                holder.grade.setTextColor(Color.parseColor("#24AE5F"));
                gradeStr = "보통";
                break;
            case 3:
                holder.grade_img.setImageResource(R.drawable.ic_grade_bad_24);
                holder.grade.setTextColor(Color.YELLOW);
                gradeStr = "나쁨";
                break;
            case 4:
                holder.grade_img.setImageResource(R.drawable.ic_grade_very_bad_24);
                holder.grade.setTextColor(Color.RED);
                gradeStr = "매우나쁨";
                break;
        }

        holder.grade.setText(gradeStr);
    }

    // 뷰 홀더 패턴
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView grade_img;
        TextView item;
        TextView value;
        TextView grade;

        public ViewHolder(View itemView) {
            super(itemView);
            grade_img = itemView.findViewById(R.id.result_grade_img);
            item = itemView.findViewById(R.id.result_item_text);
            value = itemView.findViewById(R.id.result_value_text);
            grade = itemView.findViewById(R.id.result_grade_text);
        }
    }

}
