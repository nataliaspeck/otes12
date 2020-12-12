import java.util.List;

/**
 * Superclasse abstrata para representar a interface da generalização de um custo:
 * sua subclasse irá implementar as etapas abstratas e sobrescrever algumas das opcionais se necessário.
 */
public abstract class Cost {
    Double cost;

    Cost() {}

    public double totalCalc(List<Cost> costList){
        return costList.stream().map(elem -> elem.cost).mapToDouble(Double::doubleValue).sum();
    }

    /**
     * Realiza o cálculo de qualquer tipo de gasto
     */
    abstract double calc(List<GeneralCost> costList);

}