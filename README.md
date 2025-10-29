AI Document Parser– OCR and AI-based Text Understanding Engine

Transforming Images into Meaningful Structured Data

Image2Insight or AI Document Parser is an intelligent OCR + LLM-based system that extracts text from images (like scanned documents, IDs, or forms) 
using Tesseract (Tess4J) and then converts that unstructured text into structured JSON insights using Google Gemini API.  

 Features

- 🖼️ OCR Extraction – Detects and extracts text from image files using Tess4J.  
- 🤖 AI Text Structuring – Uses Google Gemini (Generative AI) to transform plain text into structured, machine-readable data.  
- 📄 JSON Output – Outputs information such as name, date of birth, ID number, and address in a clean JSON format.  
- ⚙️ Spring Boot Backend – Provides RESTful APIs for processing uploaded documents.  
- 🔐 Environment-based Key Management – API keys are securely loaded from environment variables.

Tech Stack

| Technology | Purpose |
|-------------|----------|
| Java  | Core backend language |
| Spring Boot | Application framework |
| Maven | Build & dependency management |
| Tess4J (Tesseract OCR) | Image text extraction |
| Google Gemini API | AI-based text understanding |
| JSON (org.json) | Data formatting |
| HTTPClient | API communication |

⚙️ How It Works

1. Upload an Image → The image is processed using Tesseract OCR via Tess4J to extract raw text.  
2. Text Sent to LLM → The extracted text is passed to Google Gemini API, prompting it to output structured JSON.  
3. Return JSON → The structured data (like name, DOB, ID number, address) is sent back as a clean response.



