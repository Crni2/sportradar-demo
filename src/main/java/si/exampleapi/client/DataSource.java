package si.exampleapi.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
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

    @CacheEvict(value = {"sports", "tournaments"}, allEntries = true)
    @Scheduled(fixedRateString = "${caching.ttl}")
    public void clearCache() {
        System.out.println("Cache cleared");
    }

    @Cacheable(cacheNames = "sports")
    public Map<Integer, Sport> getAllSports() {
        HashMap<Integer, Sport> map = new HashMap<>();
        List<Sport> list = gson.fromJson(restTemplate.getForObject(sourceApiUrl + "sport/all", String.class),
                new TypeToken<ArrayList<Sport>>() {
                }.getType());
        for (Sport sport : list) {
            map.put(sport.getId(), sport);
        }
        return map;
    }

    @Cacheable(cacheNames = "tournaments")
    public Map<Integer, Tournament> getAllTournaments() {
        HashMap<Integer, Tournament> map = new HashMap<>();
        List<Tournament> list = gson.fromJson(restTemplate.getForObject(sourceApiUrl + "tournament/all", String.class),
                new TypeToken<ArrayList<Tournament>>() {
                }.getType());
        for (Tournament tournament : list) {
            map.put(tournament.getId(), tournament);
        }
        return map;
    }

    public List<Match> getAllMatches() {
        return gson.fromJson(restTemplate.getForObject(sourceApiUrl + "match/all", String.class),
                new TypeToken<ArrayList<Match>>() {
                }.getType());
    }
}
