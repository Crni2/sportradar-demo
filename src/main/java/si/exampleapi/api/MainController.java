package si.exampleapi.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import si.exampleapi.client.DataSource;
import si.exampleapi.enums.MatchStatus;
import si.exampleapi.object.Match;

@RestController
public class MainController {

    @Autowired
    private DataSource dataSource;

    @Operation(summary = "Return all matches", description = "Returns all avaliable matches, regardless of status")
    @GetMapping("/all")
    public List<Match> getAllMatches() {
        return dataSource.getAllMatches();
    }

    @Operation(summary = "Return completed matches", description = "Returns all completed matches")
    @GetMapping("/completed")
    public List<Match> getCompletedMatches() {
        return dataSource.getAllMatches().stream().filter(match -> match.getStatus().equals(MatchStatus.COMPLETED))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Return live matches", description = "Returns all live matches")
    @GetMapping("/live")
    public List<Match> getLiveMatches() {
        return dataSource.getAllMatches().stream().filter(match -> match.getStatus().equals(MatchStatus.Live))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Returns matches by team name", description = "Returns all matches according to filter fully or partially matching either home or away team name.")
    @GetMapping("/filter")
    public List<Match> getMatchesByTeamName(@RequestParam("teamName") String teamName) {
        return dataSource.getAllMatches().stream()
                .filter(match -> match.getAway_team().contains(teamName) || match.getHome_team().contains(teamName))
                .collect(Collectors.toList());
    }
}
