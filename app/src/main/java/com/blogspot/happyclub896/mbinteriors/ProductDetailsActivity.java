package com.blogspot.happyclub896.mbinteriors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static com.blogspot.happyclub896.mbinteriors.MainActivity.*;

public class ProductDetailsActivity extends AppCompatActivity {

    private ViewPager productImagesViewPager;
    private TabLayout viewPagerIndicator;
    private FloatingActionButton addToWishListBtn;
    private static boolean ALREADY_ADDED_TO_WISHLIST=false;


    //////// rating layout
    private LinearLayout rateNowContainer;
    //////// rating ;ayout

    private Button buyNowBtn;
    private  Button viewAr;

    private ViewPager productDetailsViewPager;
    private TabLayout productDetailsTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ///title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productImagesViewPager=findViewById(R.id.product_images_viewpager);
        viewPagerIndicator=findViewById(R.id.viewpager_indicator);
        addToWishListBtn=findViewById(R.id.add_to_wishlist_btn);
        productDetailsViewPager=findViewById(R.id.product_details_viewpager);
        productDetailsTabLayout=findViewById(R.id.product_details_tablayout);


        buyNowBtn=findViewById(R.id.buy_now_btn);

        List<Integer> productImages=new ArrayList<>();
        productImages.add(R.mipmap.ic_launcher);
        productImages.add(R.mipmap.image);
        productImages.add(R.mipmap.banner);
        productImages.add(R.drawable.stripadd);

        ProductImagesAdapter productImagesAdapter=new ProductImagesAdapter(productImages);
        productImagesViewPager.setAdapter(productImagesAdapter);

        viewPagerIndicator.setupWithViewPager(productImagesViewPager,true);

        addToWishListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ALREADY_ADDED_TO_WISHLIST){
                    ALREADY_ADDED_TO_WISHLIST=false;
                    addToWishListBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                }else{
                    ALREADY_ADDED_TO_WISHLIST=true;
                    addToWishListBtn.setSupportImageTintList(getResources().getColorStateList(R.color.colorPrimary));
                }
            }
        });


        productDetailsViewPager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(),productDetailsTabLayout.getTabCount()));
        productDetailsViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTabLayout));
        productDetailsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        
        ////////rating layout
        rateNowContainer=findViewById(R.id.rate_now_container);
        for(int x=0;x<rateNowContainer.getChildCount();x++){
            final int starPosition=x;
            rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(starPosition);
                }
            });
        }
        ////////rating layout

        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent=new Intent(ProductDetailsActivity.this,DeliveryActivity.class);
                startActivity(deliveryIntent);
            }
        });

        ////////Download 3D MOdel using product name
        viewAr=findViewById(R.id.viewAr);
        viewAr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent arModelIntent=new Intent(ProductDetailsActivity.this,ProductArObject.class);
                startActivity(arModelIntent);
            }
        });


        ////////Download 3D MOdel using product name

    }

    private void setRating(int starPosition) {
        for(int x=0;x<rateNowContainer.getChildCount();x++){
            ImageView starBtn=(ImageView)rateNowContainer.getChildAt(x);
            starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if(x<=starPosition){
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();

        if (id==android.R.id.home){
            //todo:serach
            finish();
        }else if (id==R.id.main_search_icon){
            //todo: notfication
            return  true;
        }else if(id==R.id.main_cart_icon){
            //todo: cart
            Intent cartIntent=new Intent(ProductDetailsActivity.this,MainActivity.class);
            showCart=true;
            startActivity(cartIntent);
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }
}
