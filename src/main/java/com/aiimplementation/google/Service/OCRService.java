
package com.aiimplementation.google.Service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OCRService {

    public String extractText(File imageFile) throws TesseractException {
        Tesseract tesseract = new Tesseract();

        // 🧭 Set the path to your Tesseract installation
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");



        // 🗣️ Set language to English (you can add others like "eng+hin")
        tesseract.setLanguage("eng");

        // 🧾 Perform OCR
        String text = tesseract.doOCR(imageFile);
        return text;
    }
}



