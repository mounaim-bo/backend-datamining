package com.example.projetdatamining.model;

import java.util.List;

public class ClusterResult {
    private List<List<String>> clusters;

    public ClusterResult(List<List<String>> clusters) {
        this.clusters = clusters;
    }

    public List<List<String>> getClusters() {
        return clusters;
    }
}
