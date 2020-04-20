package com.blogspot.happyclub896.mbinteriors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ///title
        String title=getIntent().getStringExtra("categoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        categoryRecyclerView=findViewById(R.id.category_recyclerview);


        //////////// Banner Slider
        List<SliderModel>sliderModelList=new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.mipmap.home_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_email,"#077AE4"));


        sliderModelList.add(new SliderModel(R.mipmap.red_email,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.app_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.cart_black,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.profile_placeholder,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.home_icon,"#077AE4"));


        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_email,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_email,"#077AE4"));
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

        LinearLayoutManager testingLayoutManagaer=new LinearLayoutManager(this);
        testingLayoutManagaer.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManagaer);


        List<HomePageModel> homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#ff0000"));
        homePageModelList.add(new HomePageModel(2,"Deals Of The Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals Of The Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#000000"));
        homePageModelList.add(new HomePageModel(3,"Deals Of The Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals Of The Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));




        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();

        if (id==R.id.main_search_icon){
            //todo:serach
            return true;
        }else if (id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
