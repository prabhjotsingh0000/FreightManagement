package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The OrderLoader class is responsible for reading order data from a JSON file
 * located in the resources directory and loading it into a map.
 */
public class OrderLoader {
    /**
     * Loads orders from a JSON file and maps each order ID to its corresponding destination.
     *
     * @param fileName The name of the JSON file located in the resources directory.
     * @return A map where the key is the order ID and the value is the destination airport code.
     */
    public static Map<String, String> loadOrders(String fileName) {
        Map<String, String> orders = new LinkedHashMap<>();
        try (InputStream inputStream = OrderLoader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IOException("File not found: " + fileName);
            }
            String content = new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\A").next();
            JSONObject jsonObject = new JSONObject(content);
            for (String key : jsonObject.keySet()) {
                orders.put(key, jsonObject.getJSONObject(key).getString("destination"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }
}