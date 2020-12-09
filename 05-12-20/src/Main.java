import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Template Method: um padrão de projeto comportamental que permite definir o esqueleto de um algoritmo em uma classe base
 * e permitir que as subclasses substituam as etapas sem alterar a estrutura geral do algoritmo:
 * é um meio simples de estender a funcionalidade padrão usando herança.
 *
 * Neste exemplo, o padrão Template Method define um algoritmo de trabalho com uma rede social.
 * As subclasses que correspondem a uma rede social específica, implementam essas etapas de acordo com a API fornecida pela rede social.
 *
 * - Dependa de abstrações e não de implementações.
 * - Objetos ou entidades devem estar abertos para extensão, mas fechados para modificação.
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        RedeSocial redeSocial = null;
        System.out.print("Informe seu usuário: ");
        String userName = reader.readLine();
        System.out.print("Informe sua senha: ");
        String password = reader.readLine();

        System.out.print("Informe a mensagem que deseja postar: ");
        String message = reader.readLine();

        System.out.println("\nEscolha uma rede social para postar a mensagem.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choice = Integer.parseInt(reader.readLine());

        if (choice == 1) {
            redeSocial = new Facebook(userName, password);
        } else if (choice == 2) {
            redeSocial = new Twitter(userName, password);
        }

        redeSocial.post(message);
    }
}