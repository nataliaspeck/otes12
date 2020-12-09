/**
 * Classe para rede social Twitter que implementa nossa abstração
 */
public class Twitter extends RedeSocial {

    public Twitter(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public boolean logIn(String userName, String password) {
        System.out.println("\n Checando parâmetros de usuário...");
        System.out.println("Usuário: " + this.usuario);
        System.out.print("Senha: ");
        for (int i = 0; i < this.senha.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLogIn no Twitter realizado com sucesso");
        return true;
    }

    public boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted) {
            System.out.println("Mensagem: '" + new String(data) + "' foi postada no Twitter");
            return true;
        } else {
            return false;
        }
    }

    public void logOut() {
        System.out.println("Usuário: '" + usuario + "' foi desconectado do Twitter");
    }

    private void simulateNetworkLatency() {
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