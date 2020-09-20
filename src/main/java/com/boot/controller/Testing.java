package com.boot.controller;

import com.boot.model.AddressInfo;
import com.boot.utils.Utilities;

public class Testing {

    public static void main(String[] args) {

        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAddressLine1("123");
        addressInfo.setAddressLine2("456");

        AddressInfo addressInfo2 = new AddressInfo();
        addressInfo2.setAddressLine1("kevin");
        addressInfo2.setCity("here");
        addressInfo2.setId(4);

       Utilities.merge(addressInfo, addressInfo2, "id");
    }


}

