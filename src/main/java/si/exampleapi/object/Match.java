package si.exampleapi.object;

import java.util.Date;

import si.exampleapi.enums.MatchStatus;

public class Match {
    private Integer id;
    private Integer tournamentId;
    private Date start_time;
    private MatchStatus status;
    private String home_team;
    private String away_team;
    private Integer home_score;
    private Integer away_score;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTournamentId() {
        return this.tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Date getStart_time() {
        return this.start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public MatchStatus getStatus() {
        return this.status;
    }

    public void setStatus(MatchStatus status) {
        this.status = status;
    }

    public String getHome_team() {
        return this.home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getAway_team() {
        return this.away_team;
    }

    public void setAway_team(String away_team) {
        this.away_team = away_team;
    }

    public Integer getHome_score() {
        return this.home_score;
    }

    public void setHome_score(Integer home_score) {
        this.home_score = home_score;
    }

    public Integer getAway_score() {
        return this.away_score;
    }

    public void setAway_score(Integer away_score) {
        this.away_score = away_score;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", tournamentId='" + getTournamentId() + "'" +
                ", start_time='" + getStart_time() + "'" +
                ", status='" + getStatus().name() + "'" +
                ", home_team='" + getHome_team() + "'" +
                ", away_team='" + getAway_team() + "'" +
                ", home_score='" + getHome_score() + "'" +
                ", away_score='" + getAway_score() + "'" +
                "}";
    }

}
