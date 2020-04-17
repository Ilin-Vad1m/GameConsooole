package Hero;


import java.util.ArrayList;

public class Doctor extends Hero {

    int healthMin = 150;
    int healthMax = 200;
    int damageMin = 10;
    int damageMax = 25;
    int addHealMin= 25;
    int addHealMax = 100;
    String[] nameArr = {"Dr.Brain", "Dr.Monsh ", "ClerenseDoctor", "Dr.Train", "Dr.Borsh ", "SurevadorDoctor" };

    public Doctor(){
        super.health = setHealth(healthMin, healthMax);
        setName();
        super.damage = setDamage(damageMin, damageMax);
        super.addHeal = setAddHeal(addHealMin, addHealMax);
    }

    public Doctor(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
    }

    @Override
    void hit(ArrayList <Hero> arHero) {
        ArrayList<Hero> list = arHero;
        for(int k = 0; k < arHero.size(); k++){
            for (int l = 0; l < arHero.size(); l++) {
                if (arHero.get(k).health < arHero.get(l).health) {
                    Hero a = arHero.get(k);
                    Hero b = arHero.get(l);
                    arHero.set(l, a); // проверить работу
                    arHero.set(k, b);
                }
            }
        }

        for (int i = 0; i < arHero.size(); i++) {
            if (arHero.get(i) != this){
                if(arHero.get(i).health > 0) {
                    arHero.get(i).causeDamage(damage);
                    System.out.println(this.name + " нанес урон "
                            + arHero.get(i).name + " -" + super.damage + "(" + arHero.get(i).health + ")");
                    break;
                }
            }
        }
        arHero = list;
    }


    @Override
    void healing(ArrayList <Hero> arHero) {
        ArrayList<Hero> list = arHero;
        for(int k = 0; k < arHero.size(); k++){
            for (int l = 0; l < arHero.size(); l++) {
                if (arHero.get(k).health < arHero.get(l).health) {
                    Hero a = arHero.get(k);
                    Hero b = arHero.get(l);
                    arHero.set(l, a); // проверить работу
                    arHero.set(k, b);
                }
            }
        }

        for (int i = 0; i < arHero.size(); i++) {
            if (arHero.get(i) != this){
                if(arHero.get(i).health > 0){
                    arHero.get(i).addHealth(addHeal);
                    System.out.println(super.name + " похилил " + arHero.get(i).name + " +" + super.addHeal + "(" + arHero.get(i).health + ")");
                    break;
                }
            }
        }
        arHero = list;
    }

    @Override
    public int setHealth(int min, int max) {
        return random(min, max);
    }

    @Override
    int setDamage(int min, int max) {
        return random(min, max);
    }

    @Override
    int setAddHeal(int min, int max) {
        return random(min, max);
    }

    @Override
    String setName() {
        super.name = nameArr[random(0,nameArr.length)];
        return nameArr[random(0,nameArr.length)];
    }
}
