package com.lifeapps.myhealth.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class KoinexResponse {
    var stats: Map<String, Currency>? = null
}


class Currency {


    @SerializedName("last_traded_price")
    @Expose
    var lastTradedPrice: String? = null

    @SerializedName("lowest_ask")
    @Expose
    var lowestAsk: String? = null

    @SerializedName("highest_bid")
    @Expose
    var highestBid: String? = null

    @SerializedName("min_24hrs")
    @Expose
    var min24hrs: String? = null

    @SerializedName("max_24hrs")
    @Expose
    var max24hrs: String? = null

    @SerializedName("vol_24hrs")
    @Expose
    var vol24hrs: String? = null

}