

package com.aiimplementation.google.Service;

import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import org.json.JSONArray;

@Service
public class LLMService {

    private static final String GEMINI_URL =
            "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=";

    private static final String GEMINI_KEY = System.getenv("GEMINI_API_KEY");

    public String getStructuredOutput(String extractedText) throws Exception {
        if (GEMINI_KEY == null || GEMINI_KEY.isEmpty()) {
            throw new RuntimeException("GEMINI_API_KEY environment variable is not set");
        }

        HttpPost request = new HttpPost(GEMINI_URL + GEMINI_KEY);
        request.addHeader("Content-Type", "application/json");

        JSONObject textPart = new JSONObject()
                .put("text", "Extract structured JSON data (like name, DOB, ID number, address, etc.) from this OCR text:\n" + extractedText);

        JSONObject content = new JSONObject().put("parts", new JSONArray().put(textPart));

        JSONObject requestBody = new JSONObject().put("contents", new JSONArray().put(content));

        request.setEntity(new StringEntity(requestBody.toString(), "UTF-8"));

        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(request)) {

            return EntityUtils.toString(response.getEntity(), "UTF-8");
        }
    }
}




