import interfaces.Tank;

public class TankChampion extends Champion implements Tank {
    public TankChampion(String name) {
        super(name);
    }

    @Override
    public void absorbDamage() {
        System.out.println(getName() + " is absorbing damage");
    }

    @Override
    public void taunt() {
        System.out.println(getName() + " is taunting");
    }

    @Override
    public String displayRole() {
        return "Tank";
    }
}
