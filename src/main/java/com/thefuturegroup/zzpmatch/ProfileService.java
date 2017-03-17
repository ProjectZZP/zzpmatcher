package com.thefuturegroup.zzpmatch;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {

    @Autowired
    @Value("#{systemProperties['PROFILE_API_URL'] ?: 'http://profile.zzp-matcher-api.entreact.com:8001/api/profile'}")
    private String apiLocation;

    public List<String> findAll() {
        List<String> result = new ArrayList<>();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiLocation);
        try (CloseableHttpResponse response = client.execute(httpGet);
             BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
        ) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            JsonParser jsonParser = JsonParserFactory.getJsonParser();
            for (Object item : jsonParser.parseList(builder.toString())) {
                result.add(String.valueOf(item));
            }
        } catch (IOException exception) {
            throw ExceptionWrapper.wrap(exception);
        }
        return result;
    }
}
