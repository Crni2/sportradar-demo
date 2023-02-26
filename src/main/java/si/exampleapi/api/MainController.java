package si.exampleapi.api;

import java.util.ArrayList;
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
import si.exampleapi.object.MatchRet;
import si.exampleapi.object.Sport;
import si.exampleapi.object.Tournament;

@RestController
public class MainController {

    @Autowired
    private DataSource dataSource;

    @Operation(summary = "Return all matches", description = "Returns all avaliable matches, regardless of status")
    @GetMapping("/all")
    public List<MatchRet> getAllMatches() {
        return getMatchRetList(dataSource.getAllMatches());
    }

    @Operation(summary = "Return completed matches", description = "Returns all completed matches")
    @GetMapping("/completed")
    public List<MatchRet> getCompletedMatches() {
        return getMatchRetList(
                dataSource.getAllMatches().stream().filter(match -> match.getStatus().equals(MatchStatus.COMPLETED))
                        .collect(Collectors.toList()));
    }

    @Operation(summary = "Return live matches", description = "Returns all live matches")
    @GetMapping("/live")
    public List<MatchRet> getLiveMatches() {
        return getMatchRetList(
                dataSource.getAllMatches().stream().filter(match -> match.getStatus().equals(MatchStatus.Live))
                        .collect(Collectors.toList()));
    }

    @Operation(summary = "Returns matches by team name", description = "Returns all matches according to filter fully or partially matching either home or away team name.")
    @GetMapping("/filter")
    public List<MatchRet> getMatchesByTeamName(@RequestParam("teamName") String teamName) {
        return getMatchRetList(dataSource.getAllMatches().stream()
                .filter(match -> match.getAway_team().toUpperCase().contains(teamName.toUpperCase())
                        || match.getHome_team().toUpperCase().contains(teamName.toUpperCase()))
                .collect(Collectors.toList()));
    }

    private List<MatchRet> getMatchRetList(List<Match> matchList) {
        List<MatchRet> list = new ArrayList<>();
        for (Match match : matchList) {
            Tournament tournament = dataSource.getAllTournaments().get(match.getTournamentId());
            Sport sport = dataSource.getAllSports().get(tournament.getSportId());
            list.add(new MatchRet(match, tournament, sport));
        }
        return list;
    }
}
