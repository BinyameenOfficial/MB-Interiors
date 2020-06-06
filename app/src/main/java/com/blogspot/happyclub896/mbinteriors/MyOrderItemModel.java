package com.blogspot.happyclub896.mbinteriors;

public class MyOrderItemModel {

    private int productImage;
    private String producttitle;
    private String deliveryStatus;
    private  int rating;

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public MyOrderItemModel(int productImage, int rating, String producttitle, String deliveryStatus) {
        this.productImage = productImage;
        this.rating=rating;
        this.producttitle = producttitle;
        this.deliveryStatus = deliveryStatus;
    }
}
