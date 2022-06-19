package offline_3.problem2.burger;

public class BeefBurger implements Burger {

    private final String description;
    private final Double price;

    public BeefBurger() {
        this.description = "Beef burger(200.0$), ";
        this.price = 200.0;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
