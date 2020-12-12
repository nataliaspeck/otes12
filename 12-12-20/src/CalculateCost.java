import java.util.List;

/**
 * Template Method: um padrão de projeto comportamental que permite definir o esqueleto de um algoritmo em uma classe base
 * e permitir que as subclasses substituam as etapas sem alterar a estrutura geral do algoritmo:
 * é um meio simples de estender a funcionalidade padrão usando herança.
 *
 * Neste exemplo, o padrão Template Method define um algoritmo de custo genérico.
 * As subclasses que correspondem a uma custo específico, implementam essas etapas de acordo com seus cálculos específico.
 *
 * - Dependa de abstrações e não de implementações.
 * - Objetos ou entidades devem estar abertos para extensão, mas fechados para modificação.
 * - Classes não são forçadas a implementar métodos que não irão utilizar.
 *
 */
public class CalculateCost {
    public static final Double INITIAL_COST_VALUE = 0.0;
    public static final Double TAX = 1.05;

    public static void main(String[] args){

        Cost callingCost = new Call(INITIAL_COST_VALUE);
        Cost stayingCost = new Stay(INITIAL_COST_VALUE);
        Cost mealCost = new Meal(INITIAL_COST_VALUE);

        /**
         * Crie seus próprios mapas de custo
         * */
        callingCost.calc(List.of(new GeneralCost(1, 4.5), new GeneralCost(1, 4.50)));
        stayingCost.calc(List.of(new GeneralCost(1, 125.0)));
        mealCost.calc(List.of(new GeneralCost(1, 66.0)));

        double totalValue = new Calculate(INITIAL_COST_VALUE).totalCalc(List.of(callingCost, mealCost, stayingCost));

        System.out.println(totalValue * TAX);

    }

    public static class Calculate extends Cost {
        public Calculate(Double cost) {
            this.cost = cost;
        }

        public double calc(List<GeneralCost> costList) {
            return this.cost;
        }
    }

}