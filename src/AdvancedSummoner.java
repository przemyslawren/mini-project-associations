import enums.SummonerRole;

public class AdvancedSummoner extends Summoner {
    public AdvancedSummoner(Summoner originalSummoner) {
        super(originalSummoner.getName());
        this.getChampions().addAll(originalSummoner.getChampions());
        this.getChampionMatches().putAll(originalSummoner.getChampionMatches());

        for (SummonerRole role : originalSummoner.getRoles()) {
            this.addRole(role);
        }
    }

    @Override
    public String displayRole() {
        return "Advanced Summoner: " + getName() + " (Can Play Ranked)";
    }

    @Override
    public String toString() {
        return "Advanced " + super.toString();
    }
}
