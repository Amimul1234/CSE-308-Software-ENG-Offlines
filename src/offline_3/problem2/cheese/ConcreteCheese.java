package offline_3.problem2.cheese;

import offline_3.problem2.burger.Burger;

public class ConcreteCheese extends CheeseDecorator {

    private final double cheesePrice = 100.0;
    private final Burger burger;

    public ConcreteCheese( Burger burger ) {
        this.burger = burger;
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " , Cheese ( 100.0$)";
    }

    @Override
    public Double getPrice() {
        return burger.getPrice() + cheesePrice;
    }
}
