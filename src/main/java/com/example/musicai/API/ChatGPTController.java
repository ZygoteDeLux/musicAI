package com.example.musicai.API;

import com.example.musicai.service.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
public class ChatGPTController {

    @Autowired
    private ChatGPTService chatGPTService;

    @CrossOrigin(origins = "*")
    @PostMapping("/recommendation")
    public String getRecommendation(@RequestBody String userInput) {
        return chatGPTService.getMusicRecommendation(userInput);
    }
}
