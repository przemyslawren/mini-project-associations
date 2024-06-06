
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Summoner {
    private String name;
    private List<Champion> champions;
    private Map<String, List<Match>> matchesQualif;
    private Map<Champion, List<MatchWithScore>> championMatches;

    public Summoner(String name) {
        this.name = name;
        this.champions = new ArrayList<>();
        this.matchesQualif = new TreeMap<>();
        this.championMatches = new HashMap<>();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Summoner{name='").append(name).append("'}\n");
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
