import java.util.Random;

interface Register {
    void register(String nome);
}

class RegisterEmergencyCall implements Register {

    String description;

    public void register(String nome) {
        this.description = nome;
        this.saveOnRepository();
        System.out.println("\nChamada de emergência "+ this.description + " registrada com sucesso!");
    }

    private void saveOnRepository() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

interface Search {
    void search(String cep, Register register);
}

class SearchVehicle implements Search {

    public void search(String cep, Register register) {
        int vehicle = this.searchOnRepository();
        System.out.println("\nPara o CEP "+ cep + " encontramos o veículo: " + vehicle);
    }

    private int searchOnRepository() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return new Random().nextInt();
    }
}

class Emergency {

    public static void main(String[] args) {
        RegisterEmergencyCall registerEmergencyCall = new RegisterEmergencyCall();
        registerEmergencyCall.register("Incêndio na rua Beira Rio");

        SearchVehicle searchVehicle = new SearchVehicle();
        searchVehicle.search("89224-041", registerEmergencyCall);
    }

}