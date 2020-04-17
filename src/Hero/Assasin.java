package Hero;

import java.util.ArrayList;
import java.util.Random;

public class Assasin extends Hero {

    int healthMin = 200;
    int addHeal = 0;
    int healthMax = 250;
    int damageMin = 50;
    int damageMax = 75;
    String[] nameArr = {"Pryorit", "Tomset", "Holland", "Syogeteriom", "Tereyakius", "Domstormios"};

    int criticalHit;
    Random random = new Random();

    public Assasin() {
        super.health = setHealth(healthMin, healthMax);
        setName();
        super.damage = setDamage(damageMin, damageMax);
        super.addHeal = setAddHeal(addHeal, addHeal);
        this.criticalHit = random.nextInt(20);
    }

    public Assasin(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
        this.criticalHit = random.nextInt(20);
    }

@Override
void hit(ArrayList <Hero> arHero) {
    ArrayList<Hero> list = arHero;
    for(int k = 0; k < arHero.size(); k++){
        for (int l = 0; l < arHero.size(); l++) {
            if (arHero.get(k).health < arHero.get(l).health) {
                Hero a = arHero.get(k);
                Hero b = arHero.get(l);
                arHero.set(l, a); 
                arHero.set(k, b);
            }
        }
    }

    for (int i = 0; i < arHero.size(); i++) {
        if (arHero.get(i) != this){
            if(health > 0) {
                arHero.get(i).causeDamage(damage + criticalHit);
                System.out.println(this.name + " нанес урон " + arHero.get(i).name + " -" + super.damage + "(" + arHero.get(i).health + ")");
                break;
            }
        }
    }
    arHero = list;
}

    @Override
    void healing(ArrayList<Hero> arHero) {
        System.out.println("Убийцы не умеют лечить!");
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