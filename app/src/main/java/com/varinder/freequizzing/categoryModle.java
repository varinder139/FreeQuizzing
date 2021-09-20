package com.varinder.freequizzing;

import java.util.List;

public class categoryModle {

    private String name;
    private List<String> sets;
    private String url;
    String key;

    public categoryModle() {
        // for Firebase only
    }

    public categoryModle(String name, List<String> sets, String url, String key) {
        this.name = name;
        this.sets = sets;
        this.url = url;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSets() {
        return sets;
    }

    public void setSets(List<String> sets) {
        this.sets = sets;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}