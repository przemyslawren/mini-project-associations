public class MatchWithScore extends Match {
    private Match match;
    private int score;

    public MatchWithScore(Match match, int score) {
        super(match.getId(), match.getStartDate());
        this.match = match;
        this.score = score;
    }

    public Match getMatch() {
        return match;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "MatchWithScore{match=" + match + ", score=" + score + '}';
    }
}
