import java.util.List;

/**
 * Classe para manipular os custos de refeição que implementa nossa abstração
 */
public class Meal extends Cost {
    public Meal(Double cost) {
        this.cost = cost;
    }

    public double calc(List<GeneralCost> costList) {
        this.cost = costList.stream().map( elem -> elem.getQuantity() * elem.getValue() ).mapToDouble(Double::doubleValue).sum();
        return this.cost;
    }
}