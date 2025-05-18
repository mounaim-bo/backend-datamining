package com.example.projetdatamining.service;

import com.example.projetdatamining.model.DistanceType;
import com.example.projetdatamining.service.distance.Levenshtein;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    /**
     * Calcule la distance entre deux chaînes selon le type choisi.
     * Pour l’instant, seul Levenshtein est implémenté.
     */
    public int computeDistance(String s1, String s2, DistanceType distanceType) {
        if (s1 == null) s1 = "";
        if (s2 == null) s2 = "";

        switch (distanceType) {
            case LEVENSHTEIN:
                return Levenshtein.compute(s1, s2);

            // À compléter pour les autres distances
            // case JARO:
            //    return Jaro.compute(s1, s2);

            default:
                throw new IllegalArgumentException("Distance non supportée : " + distanceType);
        }
    }
}
