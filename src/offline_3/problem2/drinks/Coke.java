package offline_3.problem2.drinks;

import offline_3.problem2.burger.Burger;

public class Coke extends DrinksDecorator {

    private final double cokePrice = 30.0;
    private final Burger burger;

    public Coke( Burger burger ) {
        this.burger = burger;
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + "Coke(30.0$)";
    }

    @Override
    public Double getPrice() {
        return burger.getPrice() + cokePrice;
    }
}
