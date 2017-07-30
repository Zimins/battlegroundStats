package com.zimincom.battlegroundstats;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zimincom on 2017. 7. 21..
 */

public enum Category {
    Performance,
    @SerializedName("Skill Rating") Skill_Rating,
    @SerializedName("Per Game")Per_Game,
    Combat,
    Survival,
    Distance,
    Support
}
