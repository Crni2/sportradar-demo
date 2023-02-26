package si.exampleapi.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import si.exampleapi.object.Match;
import si.exampleapi.object.Sport;
import si.exampleapi.object.Tournament;

public class DataSource {
    @Value("${source.api.url}")
    private String sourceApiUrl;
    private Gson gson;
    private RestTemplate restTemplate;

    public DataSource() {
        gson = new Gson();
        restTemplate = new RestTemplate();
    }

    public List<Sport> getAllSports() {
        return gson.fromJson(restTemplate.getForObject(sourceApiUrl + "sport/all", String.class),
                new TypeToken<ArrayList<Sport>>() {
                }.getType());
    }

    public List<Tournament> getAllTournaments() {
        return gson.fromJson(restTemplate.getForObject(sourceApiUrl + "tournament/all", String.class),
                new TypeToken<ArrayList<Tournament>>() {
                }.getType());
    }

    public List<Match> getAllMatches() {
        return gson.fromJson(restTemplate.getForObject(sourceApiUrl + "match/all", String.class),
                new TypeToken<ArrayList<Match>>() {
                }.getType());
    }
}
