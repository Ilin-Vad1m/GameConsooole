package Hero;

import java.util.ArrayList;
import java.util.Random;

public class CreateGame {
    int quantity_heroes_in_team = 3;

    int round = 1;
    Random rand = new Random();
    ArrayList <Hero> listHero = new ArrayList<>();
    ArrayList <Hero> team1 = new ArrayList<>();
    ArrayList <Hero> team2 = new ArrayList<>();
    ArrayList <Hero> team1Kill = new ArrayList<>();
    ArrayList <Hero> team2Kill = new ArrayList<>();

    public void start() {

        addHeroList();
        addHeroRandom(listHero, team1);
        addHeroRandom(listHero, team2);

        while(true){
            if(kill(team1, team1Kill) || kill(team2, team2Kill)){
                break;
            }

            System.out.println(round + " раунд начался");
            if (rand.nextInt(2) == 0) {
                changeCommand(team1, team2);
            } else {
                changeCommand(team2, team1);
            }
            System.out.println(round + " раунд закончился");
            round++;
        }
        System.out.println();
        System.out.println("_______________________");
        if(team1.size() >= 1 ){
            System.out.println("Победила команда 1");
            for(Hero t1 : team1) {
                t1.info();
            }
        }else {
            System.out.println("Победила команда 2");
            for(Hero t2:team2) {
                t2.info();
            }
        }
    }


    public void addHeroRandom(ArrayList <Hero> givenList, ArrayList <Hero> heroList) {
        int randomElement = rand.nextInt(givenList.size() - 1);
        for (int i = 0; i < quantity_heroes_in_team; i++) {
            heroList.add(givenList.get(randomElement));
            givenList.remove(randomElement);
        }
    }

    private void addHeroList(){
        listHero.add(new Warrior());
        listHero.add(new Doctor());
        listHero.add(new Assasin());
        listHero.add(new Warrior());
        listHero.add(new Doctor());
        listHero.add(new Assasin());
        listHero.add(new Warrior());
        listHero.add(new Doctor());
        listHero.add(new Assasin());
        listHero.add(new Warrior());
        listHero.add(new Doctor());
        listHero.add(new Assasin());
    }

    private void changeCommand(ArrayList<Hero> team1, ArrayList<Hero> team2){
        for (int i = 0; i < team1.size(); i++) {
            if (team1.get(i) instanceof Doctor){
                team1.get(i).healing(team1);
                team1.get(i).hit(team2);
            } else {
                team1.get(i).hit(team2);
            }
        }
    }

    private boolean kill(ArrayList <Hero> list, ArrayList <Hero> killList) {
        boolean result = false;
        int remove = -1;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).name + " (" +list.get(i).health + ") " + " (" +list.get(i).damage + ")");
            if(list.get(i).health < 0){
                killList.add(list.get(i));
                System.out.println(list.get(i).name + " герой добавлен в список мертвых");
                remove = i;
            }
        }
        System.out.println("_______________________");

        if(remove != -1){
            list.remove(remove);
        }

        if(killList.size() == 3){
            System.out.println("Список мертвых ");
            for (int i = 0; i < killList.size(); i++) {
                System.out.print(killList.get(i).name + " ");
            }
            result = true;
        }
        return result;
    }
}
