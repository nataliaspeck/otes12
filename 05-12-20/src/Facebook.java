/**
 * Classe para rede social Facebook que implementa nossa abstração
 */
public class Facebook extends RedeSocial {
    public Facebook(String usuario, String senha) {
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
        System.out.println("\n\nLogIn success on Facebook");
        return true;
    }

    public boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted) {
            System.out.println("Mensagem: '" + new String(data) + "' foi postada no Facebook");
            return true;
        } else {
            return false;
        }
    }

    public void logOut() {
        System.out.println("Usuário: '" + usuario + "' foi desconectado do Facebook");
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