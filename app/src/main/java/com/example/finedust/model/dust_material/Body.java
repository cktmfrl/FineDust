package com.example.finedust.model.dust_material;

import java.util.List;

public class Body {

    @Override
    public String toString() {
        return "Body{" +
                "totalCount=" + totalCount +
                ", items=" + items +
                ", pageNo=" + pageNo +
                ", numOfRows=" + numOfRows +
                '}';
    }

    @com.squareup.moshi.Json(name = "totalCount")
    private int totalCount;
    @com.squareup.moshi.Json(name = "items")
    private List<Item> items = null;
    @com.squareup.moshi.Json(name = "pageNo")
    private int pageNo;
    @com.squareup.moshi.Json(name = "numOfRows")
    private int numOfRows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

}