import enums.SummonerRole;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {

        DamageDealerChampion champion1 = new DamageDealerChampion("Ahri");
        DamageDealerChampion champion2 = new DamageDealerChampion("Zed");
        DamageDealerChampion champion3 = new DamageDealerChampion("Yasuo");
        TankChampion champion4 = new TankChampion("Leona");
        SupportChampion champion5 = new SupportChampion("Janna");
        TankDamageDealerChampion champion6 = new TankDamageDealerChampion("Kayn");


        Summoner summoner1 = new Summoner("Player1");
        Summoner summoner2 = new Summoner("Player2");

        summoner1.addRole(SummonerRole.PLAYER);
        summoner1.addRole(SummonerRole.ADMIN);

        summoner2.addRole(SummonerRole.PLAYER);
        summoner2.addRole(SummonerRole.MODERATOR);

        summoner1.addChampion(champion1);
        summoner1.addChampion(champion2);
        summoner1.addChampion(champion3);
        summoner1.addChampion(champion6);
        summoner2.addChampion(champion2);
        summoner2.addChampion(champion4);
        summoner2.addChampion(champion5);


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

        Skill.createSkill(champion4, "Sunlight");
        Skill.createSkill(champion4, "Shield of Daybreak");
        Skill.createSkill(champion4, "Eclipse");
        Skill.createSkill(champion4, "Zenith Blade");
        Skill.createSkill(champion4, "Solar Flare");

        Skill.createSkill(champion5, "Tailwind");
        Skill.createSkill(champion5, "Zephyr");
        Skill.createSkill(champion5, "Howling Gale");
        Skill.createSkill(champion5, "Eye of the Storm");
        Skill.createSkill(champion5, "Monsoon");

        Skill.createSkill(champion6, "Reaping Slash");
        Skill.createSkill(champion6, "Blade's Reach");
        Skill.createSkill(champion6, "Umbral Trespass");
        Skill.createSkill(champion6, "Darkin");
        Skill.createSkill(champion6, "The Darkin Scythe");


        System.out.println(champion1);
        System.out.println(champion2);
        System.out.println(champion3);
        System.out.println(champion4);
        System.out.println(champion5);

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

        for (int i = 1; i <= 10; i++) {
            Match match = new Match("Match" + i, new Date());
            summoner1.addMatchWithScore(champion6, match, i);
        }

        System.out.println('\n');
        System.out.println("Summoners after matches:\n");
        System.out.println(summoner1);
        System.out.println(summoner2);

//        System.out.println("Matches for champion Kayn played by summoner1:");
//        for (MatchWithScore match : summoner1.getMatchesForChampion(champion6)) {
//            System.out.println(match);
//        }
    }
}