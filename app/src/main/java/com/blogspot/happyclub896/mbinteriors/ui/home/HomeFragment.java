package com.blogspot.happyclub896.mbinteriors.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.blogspot.happyclub896.mbinteriors.CategoryAdapter;
import com.blogspot.happyclub896.mbinteriors.CategoryModel;
import com.blogspot.happyclub896.mbinteriors.GridProductLayoutAdapter;
import com.blogspot.happyclub896.mbinteriors.HomePageAdapter;
import com.blogspot.happyclub896.mbinteriors.HomePageModel;
import com.blogspot.happyclub896.mbinteriors.HorizontalProductScrollAdapter;
import com.blogspot.happyclub896.mbinteriors.HorizontalProductScrollModel;
import com.blogspot.happyclub896.mbinteriors.R;
import com.blogspot.happyclub896.mbinteriors.SliderAdapter;
import com.blogspot.happyclub896.mbinteriors.SliderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

   public HomeFragment(){
//constructor here
   }

   private RecyclerView categoryRecyclerView;
   private CategoryAdapter categoryAdapter;
   private RecyclerView testing;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

   View view=inflater.inflate(R.layout.fragment_home,container,false);

   categoryRecyclerView=view.findViewById(R.id.category_recyclerview);
   LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
   layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
   categoryRecyclerView.setLayoutManager(layoutManager);

        final List<CategoryModel> categoryModelList=new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Electronics"));
        categoryModelList.add(new CategoryModel("link","Appliances"));
        categoryModelList.add(new CategoryModel("link","Funiture"));
        categoryModelList.add(new CategoryModel("link","Fashion"));
        categoryModelList.add(new CategoryModel("link","Toys"));
        categoryModelList.add(new CategoryModel("link","Sports"));
        categoryModelList.add(new CategoryModel("link","Wall Arts"));


        categoryAdapter=new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

        //////////// Banner Slider
        List<SliderModel>sliderModelList=new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.mipmap.green_email,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_email,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.app_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.cart_black,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.profile_placeholder,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.home_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon,"#077AE4"));
        //////////// Banner Slider


        ///////////  Horizontal Product Layout

        List<HorizontalProductScrollModel> horizontalProductScrollModelList=new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.image,"Chair","MB Interiors","Rs. 5000-/"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.app_icon,"Chair","MB Interiors","Rs. 5000-/"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.app_round_icon,"Chair","MB Interiors","Rs. 5000-/"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cart_black,"Chair","MB Interiors","Rs. 5000-/"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.custom_error_icon,"Chair","MB Interiors","Rs. 5000-/"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.green_email,"Chair","MB Interiors","Rs. 5000-/"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.red_email,"Chair","MB Interiors","Rs. 5000-/"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.home_icon,"Chair","MB Interiors","Rs. 5000-/"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cart_black,"Chair","MB Interiors","Rs. 5000-/"));

        ///////////  Horizontal Product Layout

        //////////

        testing=view.findViewById(R.id.testing);
        LinearLayoutManager testingLayoutManagaer=new LinearLayoutManager(getContext());
        testingLayoutManagaer.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManagaer);


        List<HomePageModel> homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#ff0000"));
        homePageModelList.add(new HomePageModel(2,"Deals Of The Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals Of The Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#000000"));
        homePageModelList.add(new HomePageModel(3,"Deals Of The Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals Of The Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#ff0000"));
        homePageModelList.add(new HomePageModel(2,"Deals Of The Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals Of The Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#000000"));
        homePageModelList.add(new HomePageModel(3,"Deals Of The Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals Of The Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));




        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        ///////////


   return  view;
    }
}