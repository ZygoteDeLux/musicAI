package com.example.musicai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatGPTService {

    private static final String CHATGPT_URL = "https://api.openai.com/v1/engines/davinci/completions";

    @Autowired
    private RestTemplate restTemplate;

    public String getMusicRecommendation(String userInput) {

        String prompt = "List 3 " + userInput +  "music artists or bands:";

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("prompt", prompt);
        requestBody.put("max_tokens", 45);
        requestBody.put("n", 1);
        requestBody.put("temperature", 0.5);
        //requestBody.put("stop", Arrays.asList("\n\n"));


        Map<String, Object> response = restTemplate.postForObject(CHATGPT_URL, requestBody, Map.class);

        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
        Map<String, Object> choice = choices.get(0);
        return (String) choice.get("text");
    }

}




