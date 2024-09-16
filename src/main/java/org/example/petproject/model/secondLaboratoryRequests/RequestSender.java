package org.example.petproject.model.secondLaboratoryRequests;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestSender {
    public static String sendRequest(String typeOfRequest) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request;
        HttpResponse<String> response;

        if (typeOfRequest.equals("GET")) {
            request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/third-task-request"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
        } else {
            request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/third-task-request"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"key\":\"value\"}"))
                    .build();
        }
        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
