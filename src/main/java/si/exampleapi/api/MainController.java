package si.exampleapi.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import si.exampleapi.client.DataSource;
import si.exampleapi.enums.MatchStatus;
import si.exampleapi.object.Match;

@RestController
public class MainController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/match/all")
    public List<Match> getAllMatches() {
        return dataSource.getAllMatches();
    }

    @GetMapping("/match/completed")
    public List<Match> getCompletedMatches() {
        return dataSource.getAllMatches().stream().filter(match -> match.getStatus().equals(MatchStatus.COMPLETED))
                .collect(Collectors.toList());
    }

    @GetMapping("/match/live")
    public List<Match> getLiveMatches() {
        return dataSource.getAllMatches().stream().filter(match -> match.getStatus().equals(MatchStatus.Live))
                .collect(Collectors.toList());
    }

    @GetMapping("/match/filter")
    public List<Match> getMatchesByTeamName(@RequestParam("teamName") String teamName) {
        return dataSource.getAllMatches().stream()
                .filter(match -> match.getAway_team().equals(teamName) || match.getHome_team().equals(teamName))
                .collect(Collectors.toList());
    }
}
