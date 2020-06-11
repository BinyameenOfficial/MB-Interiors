package com.blogspot.happyclub896.mbinteriors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRewardsAdapter extends RecyclerView.Adapter<MyRewardsAdapter.Viewholder> {

    private List<RewardsModel> rewardsModelList;

    public MyRewardsAdapter(List<RewardsModel> rewardsModelList) {
        this.rewardsModelList = rewardsModelList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rewards_item_layout,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        String title= rewardsModelList.get(position).getTitle();
        String date= rewardsModelList.get(position).getExpiryDate();
        String body= rewardsModelList.get(position).getCoupanBody();
        viewholder.setData(title,date,body);
    }

    @Override
    public int getItemCount() {
        return rewardsModelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        private TextView coupanTitle;
        private TextView coupanexpiryDate;
        private TextView coupanBody;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            coupanTitle=itemView.findViewById(R.id.coupan_title);
            coupanexpiryDate=itemView.findViewById(R.id.coupan_validity);
            coupanBody=itemView.findViewById(R.id.coupan_body);
        }
        private void setData(String title, String date, String body){
            coupanTitle.setText(title);
            coupanexpiryDate.setText(date);
            coupanBody.setText(body);
        }
    }
}
