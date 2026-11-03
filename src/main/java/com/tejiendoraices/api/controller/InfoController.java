package com.tejiendoraices.api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/info")
@CrossOrigin(origins = "*")
public class InfoController {

    @GetMapping
    public Map<String, String> info() {
        return Map.of(
                "nombre", "Tejiendo Raíces",
                "eslogan", "Cada hilo cuenta una historia, ponte la tuya."
        );
    }
}