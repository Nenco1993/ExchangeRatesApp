package com.example.neven.exchangeratesapp.adapters;

/**
 * Created by Neven on 9.4.2017..
 */
public abstract class Item {

    static final int HEADER_ITEM_TYPE = 0;
    static final int CHILD_ITEM_TYPE = 1;
    final String medianRate;
    final String buyingRate;
    final String sellingRate;
    final String currencyCode;

    Item(String medianRate, String buyingRate, String sellingRate, String currencyCode) {
        this.medianRate = medianRate;
        this.buyingRate = buyingRate;
        this.sellingRate = sellingRate;
        this.currencyCode = currencyCode;
    }

    public abstract int getItemType();


}
