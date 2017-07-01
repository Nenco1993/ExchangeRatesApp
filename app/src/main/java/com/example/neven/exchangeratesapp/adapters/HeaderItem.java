package com.example.neven.exchangeratesapp.adapters;

/**
 * Created by Neven on 9.4.2017..
 */
public class HeaderItem extends Item {

    public HeaderItem(String medianRate, String buyingRate, String sellingRate, String currencyCode) {
        super(medianRate, buyingRate, sellingRate, currencyCode);
    }

    @Override
    public int getItemType() {
        return HEADER_ITEM_TYPE;
    }
}
