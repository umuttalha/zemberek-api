package com.example.stemmer.service;

import org.springframework.stereotype.Service;
import zemberek.morphology.TurkishMorphology;
import zemberek.morphology.analysis.SingleAnalysis;
import zemberek.morphology.analysis.WordAnalysis;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class StemmerService {
    private TurkishMorphology morphology;

    @PostConstruct
    public void init() {
        morphology = TurkishMorphology.createWithDefaults();
    }

    public List<String> stemSentence(String sentence) {
        List<String> stems = new ArrayList<>();
        String[] words = sentence.split("\\s+");

        for (String word : words) {
            try {
                WordAnalysis analysis = morphology.analyze(word);
                if (!analysis.getAnalysisResults().isEmpty()) {
                    SingleAnalysis firstAnalysis = analysis.getAnalysisResults().get(0);
                    stems.add(firstAnalysis.getStem());
                } else {
                    stems.add(word); // If no analysis is found, add the original word
                }
            } catch (Exception e) {
                stems.add(word); // In case of any error, add the original word
            }
        }
        return stems;
    }
}