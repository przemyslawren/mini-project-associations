import interfaces.DamageDealer;

public class DamageDealerChampion extends Champion implements DamageDealer {
    public DamageDealerChampion(String name) {
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
    public String displayRole() {
        return "Damage Dealer";
    }
}
