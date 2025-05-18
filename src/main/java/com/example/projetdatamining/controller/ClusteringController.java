package com.example.projetdatamining.controller;

import com.example.projetdatamining.model.ClusterRequest;
import com.example.projetdatamining.model.ClusterResult;
import com.example.projetdatamining.model.HACClusterer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClusteringController {
    @Autowired
    private HACClusterer hacClusterer;

    @PostMapping("/cluster")
    public ClusterResult clusterStrings(
            @RequestBody ClusterRequest request) {
        return hacClusterer.cluster(request.getStrings(), request.getDistanceType(), request.getMinClusters());
    }

}
