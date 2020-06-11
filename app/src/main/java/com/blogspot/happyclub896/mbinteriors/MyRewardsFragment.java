package com.blogspot.happyclub896.mbinteriors;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyRewardsFragment extends Fragment {


    public MyRewardsFragment() {
        // Required empty public constructor
    }

    private RecyclerView rewardsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_rewards, container, false);
        rewardsRecyclerView=view.findViewById(R.id.my_rewards_recyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rewardsRecyclerView.setLayoutManager(layoutManager);

        List<RewardsModel> rewardsModelList=new ArrayList<>();
        rewardsModelList.add(new RewardsModel("Cashback","till 20th, june 2020","Get 20% cashback on any product above Rs.200/- and below Rs.300/-."));
        rewardsModelList.add(new RewardsModel("Discount","till 20th, june 2020","Get 20% cashback on any product above Rs.200/- and below Rs.300/-."));
        rewardsModelList.add(new RewardsModel("Buy 1 get 1 free","till 20th, june 2020","Get 20% cashback on any product above Rs.200/- and below Rs.300/-."));
        rewardsModelList.add(new RewardsModel("Cashback","till 20th, june 2020","Get 20% cashback on any product above Rs.200/- and below Rs.300/-."));
        rewardsModelList.add(new RewardsModel("Discount","till 20th, june 2020","Get 20% cashback on any product above Rs.200/- and below Rs.300/-."));
        rewardsModelList.add(new RewardsModel("Buy 1 get 1 free","till 20th, june 2020","Get 20% cashback on any product above Rs.200/- and below Rs.300/-."));        rewardsModelList.add(new RewardsModel("Cashback","till 20th, june 2020","Get 20% cashback on any product above Rs.200/- and below Rs.300/-."));
        rewardsModelList.add(new RewardsModel("Discount","till 20th, june 2020","Get 20% cashback on any product above Rs.200/- and below Rs.300/-."));
        rewardsModelList.add(new RewardsModel("Buy 1 get 1 free","till 20th, june 2020","Get 20% cashback on any product above Rs.200/- and below Rs.300/-."));


        MyRewardsAdapter myRewardsAdapter=new MyRewardsAdapter(rewardsModelList);
        rewardsRecyclerView.setAdapter(myRewardsAdapter);
        myRewardsAdapter.notifyDataSetChanged();

        return view;
    }

}
