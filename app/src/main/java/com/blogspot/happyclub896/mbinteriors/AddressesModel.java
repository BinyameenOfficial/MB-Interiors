package com.blogspot.happyclub896.mbinteriors;

public class AddressesModel {
    private  String fullname;
    private  String addres;
    private  String pincode;

    public AddressesModel(String fullname, String addres, String pincode) {
        this.fullname = fullname;
        this.addres = addres;
        this.pincode = pincode;
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
