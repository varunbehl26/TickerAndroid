package com.lifeapps.tickerapi.adapter;
/**
 * Created by varunbehl on 02/04/16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lifeapps.myhealth.model.Currency;
import com.lifeapps.myhealth.model.KoinexResponse;
import com.lifeapps.tickerapi.R;

import java.util.Map;


public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolder> {

    private final KoinexResponse mkoinexResponse;

    public CoinAdapter(KoinexResponse objects) {
        this.mkoinexResponse = objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.coin_layout, null);
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        Currency crypt = getElementByIndex(mkoinexResponse.getStats(), position);


        holder.valueCurr.setText(((mkoinexResponse.getStats().keySet().toArray())[position]).toString());

        holder.lastTradedTx.setText(crypt.getLastTradedPrice());
        holder.lowestAskTx.setText(crypt.getLowestAsk());
        holder.HighestBidTx.setText(crypt.getHighestBid());
        holder.min24Tx.setText(crypt.getMin24hrs());
        holder.max24Tx.setText(crypt.getMax24hrs());
        holder.volume24.setText(crypt.getVol24hrs());


    }

    public Currency getElementByIndex(Map<String, Currency> map, int index) {
        return map.get((map.keySet().toArray())[index]);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (mkoinexResponse != null) {
            return mkoinexResponse.getStats().size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView lastTradedTx, lowestAskTx, HighestBidTx, min24Tx, max24Tx, volume24, valueCurr;

        public ViewHolder(View itemView) {
            super(itemView);

            valueCurr = itemView.findViewById(R.id.value_curr);
            lastTradedTx = itemView.findViewById(R.id.value_last_traded);
            lowestAskTx = itemView.findViewById(R.id.value_lowest_ask);
            HighestBidTx = itemView.findViewById(R.id.value_highest_bid);
            min24Tx = itemView.findViewById(R.id.value_min_24);
            max24Tx = itemView.findViewById(R.id.value_max_24);
            volume24 = itemView.findViewById(R.id.value_vol_24);

        }
    }


}