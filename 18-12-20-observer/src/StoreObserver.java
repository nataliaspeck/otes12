import java.util.ArrayList;
import java.util.List;

interface Subject {
    public void addSubscriber(Observer observer);
    public void removeSubscriber(Observer observer);
    public void notifySubscribers();
}

interface Observer {
    public void update(String message);
}

/**
 * Todos os observadores são notificados e tomam alguma ação dependendo de sua responsabilidade/interesse.
 */

class Loja implements Subject {
    private List<Observer> customers = new ArrayList<>();

    public void addSubscriber(Observer customer) {
        customers.add(customer);
    }
    public void removeSubscriber(Observer customer) {
        customers.remove(customer);
    }
    public void notifySubscribers() {
        System.out.println("Um novo livro está a venda: compre rapidamente antes que acabe!");
        for(Observer customer: customers) {
            customer.update("Vendido!");
        }
    }
}

class ClienteInteressado implements Observer {
    public void update(String message) {
        processMessage(message);
    }
    private void processMessage(String message) {
        System.out.println("Cliente está interessado em comprar o produto!");
    }
}

class ClienteComum implements Observer {
    public void update(String message) {
        System.out.println("Cliente foi notificado acerca da venda!");
    }
}

class StoreObserver {

    public static void main(String[] args) {
        Subject lojaDeLivros = new Loja();
        Observer passiveCustomer = new ClienteComum();
        Observer shopaholicCustomer = new ClienteInteressado();

        lojaDeLivros.addSubscriber(passiveCustomer);
        lojaDeLivros.addSubscriber(shopaholicCustomer);

        lojaDeLivros.notifySubscribers();

        lojaDeLivros.removeSubscriber(passiveCustomer);

        lojaDeLivros.addSubscriber(shopaholicCustomer);

        lojaDeLivros.notifySubscribers();
    }

}