import interfaces.Support;

public class SupportChampion extends Champion implements Support {
    public SupportChampion(String name) {
        super(name);
    }

    @Override
    public void heal() {
        System.out.println(getName() + " is healing");
    }

    @Override
    public void buff() {
        System.out.println(getName() + " is buffing");
    }

    @Override
    public String displayRole() {
        return "Support";
    }
}
