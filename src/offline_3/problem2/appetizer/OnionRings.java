package offline_3.problem2.appetizer;

import offline_3.problem2.burger.Burger;

public class OnionRings extends AppetizerDecorator {

    private final double price = 40.0;
    private final Burger burger;

    public OnionRings( Burger burger ) {
        this.burger = burger;
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Onion Rings (40$)";
    }

    @Override
    public Double getPrice() {
        return burger.getPrice() + price;
    }
}
