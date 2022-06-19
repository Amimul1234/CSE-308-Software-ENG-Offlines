package offline_3.problem2.burger;

public class VeggiBurger implements Burger{

    private final String description;
    private final Double price;

    public VeggiBurger() {
        this.description = "Veggi burger(100$), ";
        this.price = 100.0;
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
