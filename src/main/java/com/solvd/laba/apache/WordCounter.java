package com.solvd.laba.apache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WordCounter {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(WordCounter.class);

    public static void main(String[] args) {
        try {
            String content = FileUtils.readFileToString(new File("input.txt"));
            String[] words = StringUtils.split(content);

            Set<String> uniqueWords = new HashSet<>();
            for (String word : words) {
                uniqueWords.add(word.toLowerCase());
            }

            FileUtils.write(new File("output.txt"), "Number of unique words: " + uniqueWords.size());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

}