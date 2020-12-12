import java.util.List;

/**
 * Classe para manipular os custos de estadia que implementa nossa abstração
 */
public class Stay extends Cost {

    public Stay(Double cost) {
        this.cost = cost;
    }

    public double calc(List<GeneralCost> costList) {
        this.cost = costList.stream().map( elem -> elem.getQuantity() * elem.getValue() ).mapToDouble(Double::doubleValue).sum();
        return this.cost;
    }
}