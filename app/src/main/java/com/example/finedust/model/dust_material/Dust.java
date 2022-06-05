package com.example.finedust.model.dust_material;

public class Dust {

    private String name;
    private String value;
    private String unit;
    private String grade;
    private String flag;

    public Dust(String name, String value, String unit, String grade, String flag) {
        this.name = name;
        this.value = value;
        this.unit = unit;
        this.grade = grade;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Dust{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", unit='" + unit + '\'' +
                ", grade='" + grade + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}