package com.blogspot.happyclub896.mbinteriors;

public class AddressesModel {
    private  String fullname;
    private  String addres;
    private  String pincode;
    private Boolean selected;

    public AddressesModel(String fullname, String addres, String pincode,Boolean selected) {
        this.fullname = fullname;
        this.addres = addres;
        this.pincode = pincode;
        this.selected=selected;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
