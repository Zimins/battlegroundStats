package com.zimincom.battlegroundstats.StatObjects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zimincom on 2017. 7. 21..
 */

public class LiveTracking {

    @SerializedName("Match")        private int Match;
    @SerializedName("MatchDisplay") private String MatchDisPlay;
    @SerializedName("Season")       private int Season;
    @SerializedName("RegionId")     private int RegionId;
    @SerializedName("Region")       private String Region;
    @SerializedName("Date")         private String Date;
    @SerializedName("Delta")        private float Delta;
    @SerializedName("Value")        private float Value;
    @SerializedName("message")      private String message;

    @Override
    public String toString() {
        return "LiveTracking{" +
                "Match=" + Match +
                ", MatchDisPlay='" + MatchDisPlay + '\'' +
                ", Season=" + Season +
                ", RegionId=" + RegionId +
                ", Region='" + Region + '\'' +
                ", Date='" + Date + '\'' +
                ", Delta=" + Delta +
                ", Value=" + Value +
                ", message='" + message + '\'' +
                '}';
    }
}
