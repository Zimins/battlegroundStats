package com.zimincom.battlegroundstats.StatObjects;

import com.google.gson.annotations.SerializedName;
import com.zimincom.battlegroundstats.Category;

/**
 * Created by Zimincom on 2017. 7. 21..
 */

public class Stat {

    @SerializedName("partition")        private String partition;
    @SerializedName("label")            private String label;
    @SerializedName("subLabel")         private Object subLabel;
    @SerializedName("field")            private String field;
    @SerializedName("category")         private Category category;
    @SerializedName("ValueInt")         private int valueInt;
    @SerializedName("ValueDec")         private float valueDec;
    @SerializedName("value")            private String value;
    @SerializedName("rank")             private Integer rank;
    @SerializedName("percentile")       private float percentile;
    @SerializedName("displayValue")     private String displayValue;


    @Override
    public String toString() {
        return "Stat{" +
                "partition='" + partition + '\'' +
                ", label='" + label + '\'' +
                ", subLabel=" + subLabel +
                ", field='" + field + '\'' +
                ", category='" + category + '\'' +
                ", valueInt=" + valueInt +
                ", valueDec=" + valueDec +
                ", value='" + value + '\'' +
                ", rank=" + rank +
                ", percentile=" + percentile +
                ", displayValue='" + displayValue + '\'' +
                '}';
    }
}
