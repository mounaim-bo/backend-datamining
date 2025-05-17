package com.example.projetdatamining.model;

import java.util.List;

public class ClusterRequest {

    private List<String> strings;
    private DistanceType distanceType;

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public DistanceType getDistanceType() {
        return distanceType;
    }

    public void setDistanceType(DistanceType distanceType) {
        this.distanceType = distanceType;
    }
}
