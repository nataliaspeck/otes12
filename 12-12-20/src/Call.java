import java.util.List;

/**
 * Classe para manipular os custos de ligação que implementam nossa abstração
 */
public class Call extends Cost {
    public Call(Double cost) {
        this.cost = cost;
    }

    public double calc(List<GeneralCost> costList) {
        this.cost = costList.stream().map( elem -> elem.getQuantity() * elem.getValue() ).mapToDouble(Double::doubleValue).sum();
        return this.cost;
    }
}