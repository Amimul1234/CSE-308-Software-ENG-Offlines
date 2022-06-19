package offline_3.problem2.drinks;

import offline_3.problem2.burger.Burger;

public class Water extends DrinksDecorator {

    private final double waterPrice = 20.0;
    private final Burger burger;

    public Water( Burger burger ) {
        this.burger = burger;
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " Water(20$)";
    }

    @Override
    public Double getPrice() {
        return burger.getPrice() + waterPrice;
    }
}
