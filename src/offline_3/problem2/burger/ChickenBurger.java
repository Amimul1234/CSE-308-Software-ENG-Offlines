package offline_3.problem2.burger;

public class ChickenBurger implements Burger{

    private final String description;
    private final Double price;

    public ChickenBurger( String description, Double price ) {
        this.description = description;
        this.price = price;
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
