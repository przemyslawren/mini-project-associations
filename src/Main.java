import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {

        Champion champion1 = new Champion("Ahri");
        Champion champion2 = new Champion("Zed");
        Champion champion3 = new Champion("Yasuo");
        Summoner summoner1 = new Summoner("Player1");
        Summoner summoner2 = new Summoner("Player2");

        summoner1.addChampion(champion1);
        summoner1.addChampion(champion2);
        summoner2.addChampion(champion2);

        Skill.createSkill(champion1, "Essence Theft");
        Skill.createSkill(champion1, "Orb of Deception");
        Skill.createSkill(champion1, "Fox Fire");
        Skill.createSkill(champion1, "Charm");
        Skill.createSkill(champion1, "Spirit Rush");

        Skill.createSkill(champion2, "Contempt for the Weak");
        Skill.createSkill(champion2, "Razor Shuriken");
        Skill.createSkill(champion2, "Living Shadow");
        Skill.createSkill(champion2, "Shadow Slash");
        Skill.createSkill(champion2, "Death Mark");

        Skill.createSkill(champion3, "Way of the Wanderer");
        Skill.createSkill(champion3, "Wind Wall");
        Skill.createSkill(champion3, "Steel Tempest");
        Skill.createSkill(champion3, "Sweeping Blade");
        Skill.createSkill(champion3, "Last Breath");

        System.out.println(champion1);
        System.out.println(champion2);
        System.out.println(champion3);

        champion1.removeSkill(champion1.getSkills().get(4));

        System.out.println("After removing the last skill of Ahri: ");
        System.out.println(champion1);

        System.out.println("Summoners before matches:\n");
        System.out.println(summoner1);
        System.out.println(summoner2);

        Match match1 = new Match("Match1", new Date());
        Match match2 = new Match("Match2", new Date());

        summoner1.addMatch(champion1, match1);
        summoner1.addMatch(champion2, match1);
        summoner1.addMatch(champion1, match2);
        summoner2.addMatch(champion2, match2);

        summoner1.addMatchWithScore(champion1, match1, 10);
        summoner1.addMatchWithScore(champion2, match1, 5);
        summoner1.addMatchWithScore(champion1, match2, 8);

        summoner2.addMatchWithScore(champion2, match2, 4);
        summoner2.addMatchWithScore(champion2, match2, 0);


        System.out.println("Matches for champion Ahri played by summoner1:");
        for (Match match : summoner1.findMatchesQualif("Ahri")) {
            System.out.println(match);
        }
        System.out.println('\n');
        System.out.println("Matches for champion Zed played by summoner1:");
        for (Match match : summoner1.findMatchesQualif("Zed")) {
            System.out.println(match);
        }
        System.out.println('\n');
        System.out.println("Matches for champion Zed played by summoner2:");
        for (Match match : summoner2.findMatchesQualif("Zed")) {
            System.out.println(match);
        }
        System.out.println('\n');
        System.out.println("Summoners after matches:\n");
        System.out.println(summoner1);
        System.out.println(summoner2);

        System.out.println("Matches with scores for summoner1:");
        summoner1.getMatchesForChampion(champion1).forEach(System.out::println);
    }
}