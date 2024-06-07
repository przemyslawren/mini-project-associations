import java.util.ArrayList;
import java.util.List;

public abstract class Champion extends Player {
    private Gender gender;
    private List<Skill> skills;
    private List<Summoner> summoners;

    public Champion(String name) {
        super(name);
        this.skills = new ArrayList<>();
        this.summoners = new ArrayList<>();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getGender() {
        if (gender == null) {
            return "Not set";
        }
        return gender.getGender();
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
                .append("Gender: ").append(getGender()).append("\n")
                .append("Role: ").append(displayRole()).append("\n");
        for (Skill skill : skills) {
            info.append("  Skill: ").append(skill.getTitle()).append("  -");
            info.append("  Reference to: ").append(skill.getChampion().getName()).append("\n");
        }
        return info.toString();
    }
}
