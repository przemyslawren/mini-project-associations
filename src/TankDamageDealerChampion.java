import interfaces.DamageDealer;
import interfaces.Tank;

public class TankDamageDealerChampion extends Champion implements Tank, DamageDealer {
    public TankDamageDealerChampion(String name) {
        super(name);
    }

    @Override
    public void dealDamage() {
        System.out.println(getName() + " is dealing damage");
    }

    @Override
    public void burstDamage() {
        System.out.println(getName() + " is bursting damage");
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
        return "Tank | Damage Dealer";
    }
}
