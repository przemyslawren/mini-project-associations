import java.util.ArrayList;
import java.util.List;

public abstract class Champion extends Player {
    private List<Skill> skills;
    private List<Summoner> summoners;

    public Champion(String name) {
        super(name);
        this.skills = new ArrayList<>();
        this.summoners = new ArrayList<>();
    }

    public String getName() {
        return super.getName();
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkill(Skill skill) {
        if (!skills.contains(skill)) skills.add(skill);
    }

    public void removeSkill(Skill skill) throws Exception {
        if (skills.contains(skill)) {
            skills.remove(skill);
            skill.removeChampion();
        } else {
            throw new Exception("Skill not found");
        }
    }

    public void addSummoner(Summoner summoner) {
        if (!summoners.contains(summoner)) {
            summoners.add(summoner);
        }
    }

    public void removeSummoner(Summoner summoner) {
        summoners.remove(summoner);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Champion: " + getName() + "\n")
                .append("Role: ").append(displayRole()).append("\n");
        for (Skill skill : skills) {
            info.append("  Skill: ").append(skill.getTitle()).append("  -");
            info.append("  Reference to: ").append(skill.getChampion().getName()).append("\n");
        }
        return info.toString();
    }
}
