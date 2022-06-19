package offline_3.problem2.appetizer;

import offline_3.problem2.burger.Burger;

public class FrenchFries extends AppetizerDecorator {

    private final double price = 50.0;
    private final Burger burger;

    public FrenchFries( Burger burger ) {
        this.burger = burger;
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " FrenchFries(50.0$)";
    }

    @Override
    public Double getPrice() {
        return burger.getPrice() + price;
    }
}
