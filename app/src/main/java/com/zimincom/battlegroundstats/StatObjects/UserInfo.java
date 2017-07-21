package com.zimincom.battlegroundstats.StatObjects;

import java.util.Arrays;

/**
 * Created by Zimincom on 2017. 7. 16..
 */

public class UserInfo {
    private Integer platformId;
    private String AccountId;
    //link of avatar
    private String Avatar;
    private String selectedRegion;
    private String defaultSeason;
    private String seasonDisplay;
    private String LastUpdated;
    private LiveTracking[] LiveTracking;
    private String Playername;
    private int PubgTrackerId;
    private History[] histories;


    @Override
    public String toString() {
        return "UserInfo{" +
                "platformId=" + platformId +
                ", AccountId='" + AccountId + '\'' +
                ", Avatar='" + Avatar + '\'' +
                ", selectedRegion='" + selectedRegion + '\'' +
                ", defaultSeason='" + defaultSeason + '\'' +
                ", seasonDisplay='" + seasonDisplay + '\'' +
                ", LastUpdated='" + LastUpdated + '\'' +
                ", LiveTracking=" + Arrays.toString(LiveTracking) +
                ", Playername='" + Playername + '\'' +
                ", PubgTrackerId=" + PubgTrackerId +
                ", histories=" + Arrays.toString(histories) +
                '}';
    }
}
