package si.exampleapi.object;

import java.util.Date;
import java.util.Objects;

public class MatchRet {
    private String tournamentName;
    private String sportName;
    private Date startTime;
    private String status;
    private String homeTeam;
    private String awayTeam;
    private Integer homeScore;
    private Integer awayScore;

    public MatchRet() {
        super();
    }

    public MatchRet(Match match, Tournament tournament, Sport sport) {
        this.tournamentName = tournament.getName();
        this.sportName = sport.getName();
        this.startTime = match.getStart_time();
        if (match.getStatus() != null) {
            this.status = match.getStatus().name();
        }
        this.homeTeam = match.getHome_team();
        this.awayTeam = match.getAway_team();
        this.homeScore = match.getHome_score();
        this.awayScore = match.getAway_score();
    }

    public String getTournamentName() {
        return this.tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getSportName() {
        return this.sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHomeTeam() {
        return this.homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return this.awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getHomeScore() {
        return this.homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return this.awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    @Override
    public String toString() {
        return "{" +
                " tournamentName='" + getTournamentName() + "'" +
                ", sportName='" + getSportName() + "'" +
                ", startTime='" + getStartTime() + "'" +
                ", status='" + getStatus() + "'" +
                ", homeTeam='" + getHomeTeam() + "'" +
                ", awayTeam='" + getAwayTeam() + "'" +
                ", homeScore='" + getHomeScore() + "'" +
                ", awayScore='" + getAwayScore() + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MatchRet)) {
            return false;
        }
        MatchRet matchRet = (MatchRet) o;
        return Objects.equals(tournamentName, matchRet.tournamentName) && Objects.equals(sportName, matchRet.sportName)
                && Objects.equals(startTime, matchRet.startTime) && Objects.equals(status, matchRet.status)
                && Objects.equals(homeTeam, matchRet.homeTeam) && Objects.equals(awayTeam, matchRet.awayTeam)
                && Objects.equals(homeScore, matchRet.homeScore) && Objects.equals(awayScore, matchRet.awayScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tournamentName, sportName, startTime, status, homeTeam, awayTeam, homeScore, awayScore);
    }

}
