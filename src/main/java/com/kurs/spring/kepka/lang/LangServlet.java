package com.kurs.spring.kepka.lang;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kurs.spring.kepka.hello.HelloServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
class LangServlet {
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    private LangService service;

    private LangServlet(LangService service, ObjectMapper mapper) {
        this.service = service;
    }

    @GetMapping("/langs")
    ResponseEntity<List<LangDTO>> findAllLangs() {
        logger.info("Got request");
        return ResponseEntity.ok(service.findAll());
    }
}
