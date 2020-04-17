package Hero;

import java.util.ArrayList;
import java.util.Random;

public abstract class Hero {

    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;

    Random random = new Random();

    public Hero(){
        this.health = 0;
        this.name = "name";
        this.damage = 0;
        this.addHeal = 0;
    }


    public Hero(int health, String name, int damage, int addHeal) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    public int getHealth() {
        return health;
    }

    abstract int setHealth(int min, int max);
    abstract int setDamage(int min, int max);
    abstract int setAddHeal(int min, int max);
    abstract String setName();

    int random(int min, int max){
        int num;
        return num = min + random.nextInt(max - min) ;
    }

    abstract void hit(ArrayList <Hero> arHero);

    abstract void healing(ArrayList <Hero> arHero);

    void causeDamage(int damage) {
        health -= damage;
    }

    public void addHealth(int health) {
        this.health += health;
    }

    public void info() {

        System.out.println(name + " " + (health < 0 ? "Герой мертвый" : health) + " " + damage);
    }
}
