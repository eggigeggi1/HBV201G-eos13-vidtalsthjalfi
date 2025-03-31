package vinnsla;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class HuggingFaceClient {
    private static final String API_URL = "https://api-inference.huggingface.co/models/";
    private final OkHttpClient client = new OkHttpClient();
    private final String apiKey;

    public HuggingFaceClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String queryModel(String model, String input) throws IOException {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("inputs", input);

        RequestBody body = RequestBody.create(
                jsonBody.toString(),
                MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
                .url(API_URL + model)
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String responseBody = response.body().string();
            return parseResponse(responseBody);
        }
    }

    private String parseResponse(String jsonResponse) {
        try {
            JsonArray responses = JsonParser.parseString(jsonResponse).getAsJsonArray();
            JsonObject firstItem = responses.get(0).getAsJsonObject();
            String generatedText = firstItem.get("generated_text").getAsString();

            return formatForTextArea(generatedText);
        } catch (Exception e) {
            return "Error parsing response: " + e.getMessage();
        }
    }

    private String formatForTextArea(String rawText) {
        String [] trimmedRaw = rawText.split("(Feedback-below)");

        String unescaped = trimmedRaw[1]
                .replace("\\n", "\n")
                .replace("\\\"", "\"")
                .replace("\\t", "\t")
                .replace(")", "");

        unescaped = unescaped
                .replaceAll("\"\\s*\\+\\s*\"", "")
                .replaceAll("\"\\s*:\\s*\"", ": ");

        StringBuilder formatted = new StringBuilder();
        String[] lines = unescaped.split("\n");

        for (String line : lines) {
            if (line.matches("^\\d+\\.\\s.+") || line.matches("^-\\s.+")) {
                formatted.append("\n• ").append(line.replaceFirst("^\\d+\\.\\s", "").replaceFirst("^-\\s", ""));
            }
            else if (line.matches("^[A-Z][a-z]+:\\s.+")) {
                formatted.append("\n\n").append(line).append("\n");
            }
            else {
                formatted.append("\n").append(line);
            }
        }

        return formatted.toString()
                .replaceAll("\n{3,}", "\n\n")  // Max 2 newlines
                .trim();
    }
}
