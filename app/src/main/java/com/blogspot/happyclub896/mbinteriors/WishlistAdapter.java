package com.blogspot.happyclub896.mbinteriors;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.Viewholder> {

    private List<WishlistModel> wishlistModelList;
    private Boolean wishlist;

    public WishlistAdapter(List<WishlistModel> wishlistModelList,Boolean wishlist) {
        this.wishlistModelList = wishlistModelList;
        this.wishlist=wishlist;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wishlist_item_layout,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder ViewHolder, int position) {
        int resource=wishlistModelList.get(position).getProductImage();
        String title=wishlistModelList.get(position).getProductTitle();
        int freeCoupans=wishlistModelList.get(position).getFreeCoupan();
        String rating=wishlistModelList.get(position).getRating();
        int totalRaings=wishlistModelList.get(position).getTotalRatings();
        String productPrice=wishlistModelList.get(position).getProductPrice();
        String cuttedPrice=wishlistModelList.get(position).getCuttedPrice();
        String paymentMethod=wishlistModelList.get(position).getPaymentMethod();
        ViewHolder.setData(resource,title,freeCoupans,rating,totalRaings,productPrice,cuttedPrice,paymentMethod);
    }

    @Override
    public int getItemCount() {
        return wishlistModelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private TextView productTitle;
        private TextView freeCoupans;
        private ImageView coupanIcon;
        private TextView rating;
        private TextView totalRating;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView paymentMethod;
        private View priceCut;
        private ImageButton deleteBtn;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            productImage=itemView.findViewById(R.id.product_image);
            productTitle=itemView.findViewById(R.id.product_title);
            freeCoupans=itemView.findViewById(R.id.free_coupan);
            coupanIcon=itemView.findViewById(R.id.coupan_icon);
            rating=itemView.findViewById(R.id.tv_product_rating_miniview);
            totalRating=itemView.findViewById(R.id.total_ratings);
            productPrice=itemView.findViewById(R.id.product_price);
            cuttedPrice=itemView.findViewById(R.id.cutted_price);
            paymentMethod=itemView.findViewById(R.id.payment_method);
            priceCut=itemView.findViewById(R.id.price_cut);
            deleteBtn=itemView.findViewById(R.id.delete_btn);
        }
        private void setData(int resource, String title, int freeCoupanNo, String averageRate, int totalRatingNo, String price, String cuttedPriceValue, String paytMethod){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if(freeCoupanNo!=0){
              coupanIcon.setVisibility(View.VISIBLE);
              if(freeCoupanNo==1){
                  freeCoupans.setText("free "+freeCoupanNo+"Coupan");
              }else{
                  freeCoupans.setText("free "+freeCoupanNo+"Coupans");
              }
            }else{
                coupanIcon.setVisibility(View.INVISIBLE);
                freeCoupans.setVisibility(View.INVISIBLE);
            }
            rating.setText(averageRate);
            totalRating.setText(totalRatingNo +"ratings");
            productPrice.setText(price);
            cuttedPrice.setText(cuttedPriceValue);
            paymentMethod.setText(paytMethod);


            if(wishlist){
                deleteBtn.setVisibility(View.VISIBLE);
            }else{
                deleteBtn.setVisibility(View.GONE);
            }
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"delete",Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent=new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });
        }
    }
}
