package offline_3.problem2.meal;

import offline_3.problem2.appetizer.FrenchFries;
import offline_3.problem2.appetizer.OnionRings;
import offline_3.problem2.burger.BeefBurger;
import offline_3.problem2.burger.Burger;
import offline_3.problem2.burger.VeggiBurger;
import offline_3.problem2.cheese.ConcreteCheese;
import offline_3.problem2.drinks.Coffee;
import offline_3.problem2.drinks.Coke;
import offline_3.problem2.drinks.Water;

public class Main {


    public static void main( String[] args ) {

        //Beef burger with French fry and cheese
        Burger burger = new ConcreteCheese(new FrenchFries(new BeefBurger()));
        printBurger(burger);

        //Veggi Pizza with onion rings and Bottle of Water
        Burger burger1 = new OnionRings(new Water(new VeggiBurger()));
        printBurger(burger1);

        //A combo meal with Veggi burger, French Fry and Coke
        Burger burger2 = new FrenchFries(new Coke(new VeggiBurger()));
        printBurger(burger2);

        //A combo meal with Veggi burger, Onion Rings, Coffee and Water
        Burger burger3 = new OnionRings(new Coffee(new Water(new VeggiBurger())));
        printBurger(burger3);

        //A Beef burger only
        Burger burger4 = new BeefBurger();
        printBurger(burger4);
    }

    private static void printBurger( Burger burger ) {
        System.out.println("Burger name: " + burger.getDescription() + " ||| Total Price: " + burger.getPrice() + "$");
    }
}
