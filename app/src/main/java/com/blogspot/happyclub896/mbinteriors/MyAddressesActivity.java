package com.blogspot.happyclub896.mbinteriors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.blogspot.happyclub896.mbinteriors.DeliveryActivity.SELECT_ADDRESS;

public class MyAddressesActivity extends AppCompatActivity {

    private RecyclerView myAddressesRecyclerView;
    private static AddressesAdapter addressesAdapter;
    private Button deliverHereBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("My Addresses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myAddressesRecyclerView=findViewById(R.id.addresses_reyclerview);
        deliverHereBtn=findViewById(R.id.deliver_here_btn);


        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);




        myAddressesRecyclerView.setLayoutManager(layoutManager);

        List<AddressesModel> addressesModelList=new ArrayList<>();
        addressesModelList.add(new AddressesModel("Binyameen","Gujrnwala Punjab Pakistan","123456",true));
        addressesModelList.add(new AddressesModel("Sohail","Gujrnwala Punjab Pakistan","123456",false));
        addressesModelList.add(new AddressesModel("Amir","Gujrnwala Punjab Pakistan","123456",false));
        addressesModelList.add(new AddressesModel("Touseeq","Gujrnwala Punjab Pakistan","123456",false));


        int mode=getIntent().getIntExtra("MODE",-1);
        if(mode==SELECT_ADDRESS){
            deliverHereBtn.setVisibility(View.VISIBLE);
        }else{
            deliverHereBtn.setVisibility(View.GONE);
        }

        addressesAdapter=new AddressesAdapter(addressesModelList,mode);
        myAddressesRecyclerView.setAdapter(addressesAdapter);
        ((SimpleItemAnimator)myAddressesRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        addressesAdapter.notifyDataSetChanged();
    }

    public static void refreshItem(int deselect,int select){
        addressesAdapter.notifyItemChanged(deselect);
        addressesAdapter.notifyItemChanged(select);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
