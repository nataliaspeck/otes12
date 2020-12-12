interface Pessoa {
    void register(String nome);
}

class Aluno implements Pessoa {

    String nome;

    public void register(String nome) {
        this.nome = nome;
        this.saveOnRepository();
        System.out.println("\nAluno(a) "+ this.nome + " cadastrado com sucesso!");
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

class Professor implements Pessoa {

    String nome;

    public void register(String nome) {
        this.nome = nome;
        this.saveOnRepository();
        System.out.println("\nProfessor(a) "+ this.nome + " cadastrado com sucesso!");
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

class School {

    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.register("Natália Speck");

        Professor professor = new Professor();
        professor.register("William Alberto");
    }

}