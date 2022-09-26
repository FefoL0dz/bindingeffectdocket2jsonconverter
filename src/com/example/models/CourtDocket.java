package com.loganima.models;

import java.util.List;

public class CourtDocket extends Docket {

    private Court court;

    public CourtDocket(int sv, String description, List<String> tags, Court court) {
        super(sv, description, tags);
        this.court = court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public Court getCourt() {
        return this.court;
    }
}
