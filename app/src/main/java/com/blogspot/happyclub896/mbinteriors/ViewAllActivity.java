package com.blogspot.happyclub896.mbinteriors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals Of The Day! ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView=findViewById(R.id.gridview);
        recyclerView=findViewById(R.id.recyclerview);

        int layout_code=getIntent().getIntExtra("layout_code",-1);
        if(layout_code==0){

            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager=new LinearLayoutManager(this);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

            List<WishlistModel> wishlistModelList=new ArrayList<>();
            wishlistModelList.add(new WishlistModel(R.mipmap.image,"Pixel 2",1,"3",145,"Rs.49999/-","Rs.59999/-","Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.mipmap.image,"Pixel 2",0,"3",145,"Rs.49999/-","Rs.59999/-","Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.mipmap.image,"Pixel 2",2,"3",145,"Rs.49999/-","Rs.59999/-","Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.mipmap.image,"Pixel 2",4,"3",145,"Rs.49999/-","Rs.59999/-","Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.mipmap.image,"Pixel 2",1,"3",145,"Rs.49999/-","Rs.59999/-","Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.mipmap.image,"Pixel 2",1,"3",145,"Rs.49999/-","Rs.59999/-","Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.mipmap.image,"Pixel 2",0,"3",145,"Rs.49999/-","Rs.59999/-","Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.mipmap.image,"Pixel 2",2,"3",145,"Rs.49999/-","Rs.59999/-","Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.mipmap.image,"Pixel 2",4,"3",145,"Rs.49999/-","Rs.59999/-","Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.mipmap.image,"Pixel 2",1,"3",145,"Rs.49999/-","Rs.59999/-","Cash on Delivery"));



            WishlistAdapter adapter=new WishlistAdapter(wishlistModelList,true);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }else if(layout_code==1){


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

            gridView.setVisibility(View.VISIBLE);
            GridProductLayoutAdapter gridProductLayoutAdapter=new GridProductLayoutAdapter(horizontalProductScrollModelList);
            gridView.setAdapter(gridProductLayoutAdapter);

        }



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }
}
