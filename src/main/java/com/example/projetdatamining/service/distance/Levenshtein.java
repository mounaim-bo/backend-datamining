package com.example.projetdatamining.service.distance;

public class Levenshtein {
    /**
     * Calcule la distance de Levenshtein entre deux chaînes.
     * @param s1 Première chaîne
     * @param s2 Deuxième chaîne
     * @return distance (entier >= 0)
     */
    public static int compute(String s1, String s2) {
        if (s1 == null) s1 = "";
        if (s2 == null) s2 = "";

        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        // Initialisation des bords
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // Calcul dynamique
        for (int i = 1; i <= len1; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char c2 = s2.charAt(j - 1);

                int cost = (c1 == c2) ? 0 : 1;

                dp[i][j] = Math.min(
                        Math.min(
                                dp[i - 1][j] + 1,      // suppression
                                dp[i][j - 1] + 1),     // insertion
                        dp[i - 1][j - 1] + cost   // substitution
                );
            }
        }

        return dp[len1][len2];
    }
}
