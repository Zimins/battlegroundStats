package com.zimincom.battlegroundstats.StatObjects;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Zimincom on 2017. 7. 16..
 */

public class UserInfo {

    @SerializedName("platformId")       private Integer platformId;
    @SerializedName("AccountId")        private String accountId;
    @SerializedName("Avatar")           private String avatarImageUrl;
    @SerializedName("selectedRegion")   private String selectedRegion;
    @SerializedName("defaultSeason")    private String defaultSeason;
    @SerializedName("seasonDisplay")    private String seasonDisplay;
    @SerializedName("LastUpdated")      private String lastUpdated;
    @SerializedName("LiveTracking")     private LiveTracking[] liveTracking;
    @SerializedName("PlayerName")       private String playerName;
    @SerializedName("PubgTrackerId")    private int pubgTrackerId;
    @SerializedName("Stats")            private History[] histories;

    @Override
    public String toString() {
        return "{" +
                "platformId=" + platformId +
                ", accountId='" + accountId + '\'' +
                ", avatarImageUrl='" + avatarImageUrl + '\'' +
                ", selectedRegion='" + selectedRegion + '\'' +
                ", defaultSeason='" + defaultSeason + '\'' +
                ", seasonDisplay='" + seasonDisplay + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", liveTracking=" + Arrays.toString(liveTracking) +
                ", playername='" + playerName + '\'' +
                ", pubgTrackerId=" + pubgTrackerId +
                ", histories=" + Arrays.toString(histories) +
                '}';
    }

    public LiveTracking[] getLiveTracking() {
        return liveTracking;
    }

    public History[] getHistories() {
        return histories;
    }

    public String getAvatarImageUrl() {
        return avatarImageUrl;
    }

    public String getPlayerName() {
        return playerName;
    }
}
