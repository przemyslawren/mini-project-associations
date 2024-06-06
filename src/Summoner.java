import enums.SummonerRole;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Summoner extends Player {
    private List<Champion> champions;
    private Map<String, List<Match>> matchesQualif;
    private Map<Champion, List<MatchWithScore>> championMatches;
    private EnumSet<SummonerRole> roles;

    public Map<Champion, List<MatchWithScore>> getChampionMatches() {
        return championMatches;
    }

    public Summoner(String name) {
        super(name);
        this.champions = new ArrayList<>();
        this.matchesQualif = new TreeMap<>();
        this.championMatches = new HashMap<>();
        this.roles = EnumSet.noneOf(SummonerRole.class);
    }

    public EnumSet<SummonerRole> getRoles() {
        return roles;
    }

    public void addRole(SummonerRole role) {
        roles.add(role);
    }

    public void removeRole(SummonerRole role) {
        roles.remove(role);
    }

    public boolean hasRole(SummonerRole role) {
        return roles.contains(role);
    }

    @Override
    public String displayRole() {
        return "Summoner: " + getName() + " - Roles: " + roles;
    }

    public void addChampion(Champion champion) {
        if (!champions.contains(champion)) {
            champions.add(champion);
            champion.addSummoner(this);
        }
    }

    public void removeChampion(Champion champion) {
        if (champions.contains(champion)) {
            champions.remove(champion);
            champion.removeSummoner(this);
        }
    }

    public void addMatch(Champion champion, Match match) {
        if (!matchesQualif.containsKey(champion.getName())) {
            matchesQualif.put(champion.getName(), new ArrayList<>());
        }
        matchesQualif.get(champion.getName()).add(match);
    }

    public List<Match> findMatchesQualif(String championName) throws Exception {
        if (!matchesQualif.containsKey(championName)) {
            throw new Exception("Unable to find matches for champion: " + championName);
        }
        return matchesQualif.get(championName);
    }

    public void addMatchWithScore(Champion champion, Match match, int score) {
        if (!championMatches.containsKey(champion)) {
            championMatches.put(champion, new ArrayList<>());
        }
        championMatches.get(champion).add(new MatchWithScore(match, score));
    }

    public List<MatchWithScore> getMatchesForChampion(Champion champion) {
        return championMatches.getOrDefault(champion, new ArrayList<>());
    }

    public List<Champion> getChampions() {
        return champions;
    }

    public int getTotalMatches() {
        int totalMatches = 0;
        for (List<MatchWithScore> matches : championMatches.values()) {
            totalMatches += matches.size();
        }
        return totalMatches;
    }

    public Summoner upgradeIfEligible() {
        if (getTotalMatches() >= 10) {
            AdvancedSummoner advancedSummoner = new AdvancedSummoner(this);
            for (Champion champion : champions) {
                champion.removeSummoner(this);
                champion.addSummoner(advancedSummoner);
            }
            return advancedSummoner;
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); sb.append("Summoner{name='").append(getName())
                .append("', roles=").append(roles).append("}\n");
        sb.append("Champions owned:\n");
        for (Champion champion : champions) {
            sb.append("  ").append(champion.getName()).append("\n");
        }
        sb.append("Matches with scores:\n");
        for (Map.Entry<Champion, List<MatchWithScore>> entry : championMatches.entrySet()) {
            sb.append("  Champion '").append(entry.getKey().getName()).append("':\n");
            for (MatchWithScore matchWithScore : entry.getValue()) {
                sb.append("    ").append(matchWithScore).append("\n");
            }
        }
        return sb.toString();
    }
}
