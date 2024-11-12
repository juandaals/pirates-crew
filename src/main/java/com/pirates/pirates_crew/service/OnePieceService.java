package com.pirates.pirates_crew.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OnePieceService {

    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${url.api}")
    public String api;

    public Object getCharacters() {
        String url = api+"characters/en";
        return restTemplate.getForObject(url, Object.class);
    }

    public Object getCrews() {
        String url = api+"crews/en";
        return restTemplate.getForObject(url, Object.class);
    }

    public Object getBoats() {
        String url = api+"boats/en";
        return restTemplate.getForObject(url, Object.class);
    }
}
