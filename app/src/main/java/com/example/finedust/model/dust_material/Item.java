package com.example.finedust.model.dust_material;

public class Item {

    @Override
    public String toString() {
        return "Item{" +
                "so2Grade='" + so2Grade + '\'' +
                ", coFlag=" + coFlag +
                ", khaiValue='" + khaiValue + '\'' +
                ", so2Value='" + so2Value + '\'' +
                ", coValue='" + coValue + '\'' +
                ", pm25Flag=" + pm25Flag +
                ", pm10Flag=" + pm10Flag +
                ", o3Grade='" + o3Grade + '\'' +
                ", pm10Value='" + pm10Value + '\'' +
                ", khaiGrade='" + khaiGrade + '\'' +
                ", pm25Value='" + pm25Value + '\'' +
                ", sidoName='" + sidoName + '\'' +
                ", no2Flag=" + no2Flag +
                ", no2Grade='" + no2Grade + '\'' +
                ", o3Flag=" + o3Flag +
                ", pm25Grade='" + pm25Grade + '\'' +
                ", so2Flag=" + so2Flag +
                ", dataTime='" + dataTime + '\'' +
                ", coGrade='" + coGrade + '\'' +
                ", no2Value='" + no2Value + '\'' +
                ", stationName='" + stationName + '\'' +
                ", pm10Grade='" + pm10Grade + '\'' +
                ", o3Value='" + o3Value + '\'' +
                '}';
    }

    @com.squareup.moshi.Json(name = "so2Grade")
    private String so2Grade;
    @com.squareup.moshi.Json(name = "coFlag")
    private String coFlag;
    @com.squareup.moshi.Json(name = "khaiValue")
    private String khaiValue;
    @com.squareup.moshi.Json(name = "so2Value")
    private String so2Value;
    @com.squareup.moshi.Json(name = "coValue")
    private String coValue;
    @com.squareup.moshi.Json(name = "pm25Flag")
    private String pm25Flag;
    @com.squareup.moshi.Json(name = "pm10Flag")
    private String pm10Flag;
    @com.squareup.moshi.Json(name = "o3Grade")
    private String o3Grade;
    @com.squareup.moshi.Json(name = "pm10Value")
    private String pm10Value;
    @com.squareup.moshi.Json(name = "khaiGrade")
    private String khaiGrade;
    @com.squareup.moshi.Json(name = "pm25Value")
    private String pm25Value;
    @com.squareup.moshi.Json(name = "sidoName")
    private String sidoName;
    @com.squareup.moshi.Json(name = "no2Flag")
    private String no2Flag;
    @com.squareup.moshi.Json(name = "no2Grade")
    private String no2Grade;
    @com.squareup.moshi.Json(name = "o3Flag")
    private String o3Flag;
    @com.squareup.moshi.Json(name = "pm25Grade")
    private String pm25Grade;
    @com.squareup.moshi.Json(name = "so2Flag")
    private String so2Flag;
    @com.squareup.moshi.Json(name = "dataTime")
    private String dataTime;
    @com.squareup.moshi.Json(name = "coGrade")
    private String coGrade;
    @com.squareup.moshi.Json(name = "no2Value")
    private String no2Value;
    @com.squareup.moshi.Json(name = "stationName")
    private String stationName;
    @com.squareup.moshi.Json(name = "pm10Grade")
    private String pm10Grade;
    @com.squareup.moshi.Json(name = "o3Value")
    private String o3Value;

    public String getSo2Grade() {
        if (so2Grade == null) {
            return "";
        }
        return so2Grade;
    }

    public void setSo2Grade(String so2Grade) {
        this.so2Grade = so2Grade;
    }

    public String getCoFlag() {
        if (coFlag == null) {
            return "";
        }
        return coFlag;
    }

    public void setCoFlag(String coFlag) {
        this.coFlag = coFlag;
    }

    public String getKhaiValue() {
        if (khaiValue == null) {
            return "";
        }
        return khaiValue;
    }

    public void setKhaiValue(String khaiValue) {
        this.khaiValue = khaiValue;
    }

    public String getSo2Value() {
        if (so2Value == null) {
            return "";
        }
        return so2Value;
    }

    public void setSo2Value(String so2Value) {
        this.so2Value = so2Value;
    }

    public String getCoValue() {
        if (coValue == null) {
            return "";
        }
        return coValue;
    }

    public void setCoValue(String coValue) {
        this.coValue = coValue;
    }

    public String getPm25Flag() {
        if (pm25Flag == null) {
            return "";
        }
        return pm25Flag;
    }

    public void setPm25Flag(String pm25Flag) {
        this.pm25Flag = pm25Flag;
    }

    public String getPm10Flag() {
        if (pm10Flag == null) {
            return "";
        }
        return pm10Flag;
    }

    public void setPm10Flag(String pm10Flag) {
        this.pm10Flag = pm10Flag;
    }

    public String getO3Grade() {
        if (o3Grade == null) {
            return "";
        }
        return o3Grade;
    }

    public void setO3Grade(String o3Grade) {
        this.o3Grade = o3Grade;
    }

    public String getPm10Value() {
        if (pm10Value == null) {
            return "";
        }
        return pm10Value;
    }

    public void setPm10Value(String pm10Value) {
        this.pm10Value = pm10Value;
    }

    public String getKhaiGrade() {
        if (khaiGrade == null) {
            return "";
        }
        return khaiGrade;
    }

    public void setKhaiGrade(String khaiGrade) {
        this.khaiGrade = khaiGrade;
    }

    public String getPm25Value() {
        if (pm25Value == null) {
            return "";
        }
        return pm25Value;
    }

    public void setPm25Value(String pm25Value) {
        this.pm25Value = pm25Value;
    }

    public String getSidoName() {
        if (sidoName == null) {
            return "";
        }
        return sidoName;
    }

    public void setSidoName(String sidoName) {
        this.sidoName = sidoName;
    }

    public String getNo2Flag() {
        if (no2Flag == null) {
            return "";
        }
        return no2Flag;
    }

    public void setNo2Flag(String no2Flag) {
        this.no2Flag = no2Flag;
    }

    public String getNo2Grade() {
        if (no2Grade == null) {
            return "";
        }
        return no2Grade;
    }

    public void setNo2Grade(String no2Grade) {
        this.no2Grade = no2Grade;
    }

    public String getO3Flag() {
        if (o3Flag == null) {
            return "";
        }
        return o3Flag;
    }

    public void setO3Flag(String o3Flag) {
        this.o3Flag = o3Flag;
    }

    public String getPm25Grade() {
        if (pm25Grade == null) {
            return "";
        }
        return pm25Grade;
    }

    public void setPm25Grade(String pm25Grade) {
        this.pm25Grade = pm25Grade;
    }

    public String getSo2Flag() {
        if (so2Flag == null) {
            return "";
        }
        return so2Flag;
    }

    public void setSo2Flag(String so2Flag) {
        this.so2Flag = so2Flag;
    }

    public String getDataTime() {
        if (dataTime == null) {
            return "";
        }
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getCoGrade() {
        if (coGrade == null) {
            return "";
        }
        return coGrade;
    }

    public void setCoGrade(String coGrade) {
        this.coGrade = coGrade;
    }

    public String getNo2Value() {
        if (no2Value == null) {
            return "";
        }
        return no2Value;
    }

    public void setNo2Value(String no2Value) {
        this.no2Value = no2Value;
    }

    public String getStationName() {
        if (stationName == null) {
            return "";
        }
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getPm10Grade() {
        if (pm10Grade == null) {
            return "";
        }
        return pm10Grade;
    }

    public void setPm10Grade(String pm10Grade) {
        this.pm10Grade = pm10Grade;
    }

    public String getO3Value() {
        if (o3Value == null) {
            return "";
        }
        return o3Value;
    }

    public void setO3Value(String o3Value) {
        this.o3Value = o3Value;
    }

}