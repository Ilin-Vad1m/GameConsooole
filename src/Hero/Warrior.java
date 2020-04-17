package Hero;

import java.util.ArrayList;

public class Warrior extends Hero {

    int healthMin = 250;
    int healthMax = 300;
    int damageMin = 50;
    int damageMax = 75;
    int addHeal = 0;
    String[] nameArr = {"Actek", "Billoen", "Mardobius", "Malbek", "Draxler", "Townjhon"};


    public Warrior(int health, String type, int damage, int addHeal) {
        super(health, type, damage, addHeal);
    }

    public Warrior() {
        super.health = setHealth(healthMin, healthMax);
        setName();
        super.damage = setDamage(damageMin, damageMax);
        super.addHeal = setAddHeal(addHeal, addHeal);
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
        System.out.println("Воины не умеют лечить!");
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
        return addHeal;
    }

    @Override
    String setName() {
        super.name = nameArr[random(0,nameArr.length)];
        return nameArr[random(0,nameArr.length)];
    }
}
