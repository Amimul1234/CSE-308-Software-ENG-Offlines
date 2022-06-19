package offline_3.problem2.drinks;

import offline_3.problem2.burger.Burger;

public abstract class DrinksDecorator implements Burger {
    @Override
    public String getDescription() {
        return "Drinks";
    }
}
