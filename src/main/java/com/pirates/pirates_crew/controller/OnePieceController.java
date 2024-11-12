package com.pirates.pirates_crew.controller;

import com.pirates.pirates_crew.service.OnePieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("total")

public class OnePieceController {

    @Autowired
    private OnePieceService onePieceService;



    @GetMapping("characters")
    public ResponseEntity<Object> getCharacters() {
        return ResponseEntity.ok(onePieceService.getCharacters());
    }

    @GetMapping("crews")
    public ResponseEntity<Object> getCrews() {
        return ResponseEntity.ok(onePieceService.getCrews());
    }

    @GetMapping("boats")
    public ResponseEntity<Object> getBoats() {
        return ResponseEntity.ok(onePieceService.getBoats());
    }
}
