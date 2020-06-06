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
public class MyOrdersFragment extends Fragment {


    public MyOrdersFragment() {
        // Required empty public constructor
    }

    private RecyclerView myOrderRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_orders, container, false);
        myOrderRecyclerView=view.findViewById(R.id.my_orders_recyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myOrderRecyclerView.setLayoutManager(layoutManager);

        List<MyOrderItemModel> myOrderItemModelList=new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.mipmap.image,2,"Pixel 2XL (Black)","Delivered on 15th,May 2020"));
        myOrderItemModelList.add(new MyOrderItemModel(R.mipmap.image,0,"Pixel 2XL (Blue 2ndImge)","Delivered on 15th,May 2020"));
        myOrderItemModelList.add(new MyOrderItemModel(R.mipmap.image,1,"Pixel 2XL (Black 3rdimage)","Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.mipmap.image,4,"Pixel 2XL (Black 4rthimage)","Delivered on 15th,May 2020"));

        MyOrderAdapter myOrderAdapter=new MyOrderAdapter(myOrderItemModelList);
        myOrderRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();

        return  view;
    }

}
