public class Skill {
    private String title;
    private Champion champion;

    private Skill(Champion champion, String title) {
        this.title = title;
        this.champion = champion;
    }

    public static void createSkill(Champion champion, String title) throws Exception {
        if (champion == null) {
            throw new Exception("The given champion does not exist!");
        }

        Skill skill = new Skill(champion, title);
        champion.addSkill(skill);

    }

    public String getTitle() {
        return title;
    }

    public Champion getChampion() {
        return champion;
    }

    public void removeChampion() {
        this.champion = null;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "title='" + title + '\'' +
                ", champion=" + champion.getName() +
                '}';
    }
}
