package com.zimincom.battlegroundstats.StatObjects;

import com.google.gson.annotations.SerializedName;
import com.zimincom.battlegroundstats.MatchMode;

/**
 * Created by Zimincom on 2017. 7. 16..
 */

public class History {
    @SerializedName("Region") private String region;
    @SerializedName("Season") private String season;
    @SerializedName("Match")  private MatchMode matchMode;
    @SerializedName("Stats")  private Stat[] stats;

    public Stat[] getStats() {
        return stats;
    }

    @Override
    public String toString() {
        return "History{" +
                "region='" + region + '\'' +
                ", season='" + season + '\'' +
                ", matchMode=" + matchMode +
                ", stats"  +
                '}';
    }
}
