/**
 * Superclasse abstrata para representar a interface da generalização de uma rede social:
 * sua subclasse irá implementar as etapas abstratas e sobrescrever algumas das opcionais se necessário.
 */
public abstract class RedeSocial {
    String usuario;
    String senha;

    RedeSocial() {}

    /**
     * Publica a postagem em qualquer rede social.
     */
    public boolean post(String message) {
        if (logIn(this.usuario, this.senha)) {
            boolean result =  sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String usuario, String senha);
    abstract boolean sendData(byte[] data);
    abstract void logOut();

}