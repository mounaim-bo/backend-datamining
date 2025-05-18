package com.example.projetdatamining.model;

import com.example.projetdatamining.service.DistanceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HACClusterer {
    private final DistanceService distanceService;

    public HACClusterer(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    public ClusterResult cluster(List<String> strings, DistanceType distanceType, int minClusters) {
        List<List<String>> clusters = new ArrayList<>();
        for (String s : strings) {
            List<String> singleCluster = new ArrayList<>();
            singleCluster.add(s);
            clusters.add(singleCluster);
        }

        while (clusters.size() > minClusters) {
            double minDistance = Double.MAX_VALUE;
            int clusterA = -1;
            int clusterB = -1;

            for (int i = 0; i < clusters.size(); i++) {
                for (int j = i + 1; j < clusters.size(); j++) {
                    double dist = clusterDistance(clusters.get(i), clusters.get(j), distanceType);
                    if (dist < minDistance) {
                        minDistance = dist;
                        clusterA = i;
                        clusterB = j;
                    }
                }
            }

            clusters.get(clusterA).addAll(clusters.get(clusterB));
            clusters.remove(clusterB);
        }

        return new ClusterResult(clusters);
    }

    /**
     * Distance minimale (single linkage) entre deux clusters
     */
    private double clusterDistance(List<String> c1, List<String> c2, DistanceType distanceType) {
        double minDist = Double.MAX_VALUE;

        for (String s1 : c1) {
            for (String s2 : c2) {
                int dist = distanceService.computeDistance(s1, s2, distanceType);
                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }

        return minDist;
    }
}
