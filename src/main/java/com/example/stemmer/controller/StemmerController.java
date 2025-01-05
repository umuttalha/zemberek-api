package com.example.stemmer.controller;

import com.example.stemmer.service.StemmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StemmerController {

    @Autowired
    private StemmerService stemmerService;

    @PostMapping("/stem")
    public List<String> stemSentence(@RequestBody String sentence) {
        return stemmerService.stemSentence(sentence);
    }
}