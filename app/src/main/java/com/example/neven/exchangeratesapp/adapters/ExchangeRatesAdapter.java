package com.example.neven.exchangeratesapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.example.neven.exchangeratesapp.R;

import java.util.List;

/**
 * Created by Neven on 14.6.2017..
 */
public class ExchangeRatesAdapter extends RecyclerView.Adapter<ExchangeRatesAdapter.MyViewHolder> {

    private final List<Item> listItems;
    private final Context context;

    public ExchangeRatesAdapter(List<Item> listRates, Context context) {
        this.listItems = listRates;
        this.context = context;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivLogo)
        ImageView ivLogo;

        @BindView(R.id.tvCurrencyName)
        TextView tvCurrencyName;

        @BindView(R.id.tvSellingRate)
        TextView tvSellingRate;

        @BindView(R.id.tvBuyingRate)
        TextView tvBuyingRate;

        @BindView(R.id.tvMedianRate)
        TextView tvMedianRate;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_exchange_rates_header, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_exchange_rates_child, parent, false);

        }

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if (!isHeaderType(position)) {
            bindChildItem(holder, position);
        }


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public int getItemViewType(int position) {

        return listItems.get(position).getItemType() == Item.HEADER_ITEM_TYPE ? 0 : 1;

    }


    private void bindChildItem(MyViewHolder holder, int position) {

        Item singleRate = listItems.get(position);
        String currencyCode = singleRate.currencyCode.toLowerCase();
        String flagURL = "http://s.xe.com/themes/xe/images/flags/big/" + currencyCode + ".png";

        Glide
                .with(context)
                .load(flagURL)
                .crossFade()
                .into(holder.ivLogo);

        holder.tvBuyingRate.setText(singleRate.buyingRate);
        holder.tvSellingRate.setText(singleRate.sellingRate);
        holder.tvCurrencyName.setText(singleRate.currencyCode);
        holder.tvMedianRate.setText(singleRate.medianRate);


    }

    private boolean isHeaderType(int position) {

        boolean value;

        if (listItems.get(position).getItemType() == Item.HEADER_ITEM_TYPE) {
            value = true;
        } else {
            value = false;
        }

        return value;


    }


}
