package com.loganima.models;

import java.util.ArrayList;
import java.util.List;

public class Docket {

    private int sv;

    private String description;

    private List<String> tags;

    public int getSv() {
        return sv;
    }

    public void setSv(int sv) {
        this.sv = sv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Docket(int sv, String description, List<String> tags) {
        this.sv = sv;
        this.description = description;
        this.tags = (tags == null) ? new ArrayList<>() : tags;
    }
}
