
package com.example.neven.exchangeratesapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ExchangeRate implements Serializable {

    @SerializedName("median_rate")
    @Expose
    public String medianRate;
    @SerializedName("unit_value")
    @Expose
    public Integer unitValue;
    @SerializedName("selling_rate")
    @Expose
    public String sellingRate;
    @SerializedName("currency_code")
    @Expose
    public String currencyCode;
    @SerializedName("buying_rate")
    @Expose
    public String buyingRate;


}
