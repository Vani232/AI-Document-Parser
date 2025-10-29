package com.aiimplementation.google.controller;
import com.aiimplementation.google.Service.OCRService;

import com.aiimplementation.google.Service.LLMService;

import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api")
public class OCRController {

    @Autowired
    private OCRService ocrService;

    @Autowired
    private LLMService llmService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
        try {
            // Save uploaded file temporarily
            File temp = File.createTempFile("upload_", file.getOriginalFilename());
            file.transferTo(temp);

            // Extract text using OCR
            String rawText = ocrService.extractText(temp);

            // Convert raw text to structured output using LLM (dummy for now)
            String structuredJson = llmService.getStructuredOutput(rawText);

            return ResponseEntity.ok(structuredJson);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
}
