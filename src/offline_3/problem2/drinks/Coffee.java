package offline_3.problem2.drinks;

import offline_3.problem2.burger.Burger;

public class Coffee extends DrinksDecorator {

    private final double coffeePrice = 10.0;
    private final Burger burger;

    public Coffee( Burger burger ) {
        this.burger = burger;
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " Coffee(10.0$)";
    }

    @Override
    public Double getPrice() {
        return burger.getPrice() + coffeePrice;
    }
}
