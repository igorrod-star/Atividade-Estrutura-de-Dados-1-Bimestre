import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Aluno[] alunos = new Aluno[100];
    static int quantidade = 0;

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println();
            System.out.println("===============================");
            System.out.println("       SISTEMA DE ALUNOS");
            System.out.println("===============================");
            System.out.println("1 - Cadastrar alunos");
            System.out.println("2 - Relatorio por nome");
            System.out.println("3 - Relatorio por RA");
            System.out.println("4 - Relatorio de aprovados");
            System.out.println("0 - Sair");
            System.out.println("===============================");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarAlunos();
                    break;

                case 2:
                    relatorioPorNome();
                    break;

                case 3:
                    relatorioPorRa();
                    break;

                case 4:
                    relatorioAprovados();
                    break;

                case 0:
                    System.out.println();
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println();
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void cadastrarAlunos() {

        if (quantidade == alunos.length) {
            System.out.println();
            System.out.println("Limite de alunos atingido.");
            return;
        }

        System.out.println();
        System.out.println("===============================");
        System.out.println("       CADASTRO DE ALUNOS");
        System.out.println("===============================");

        System.out.print("Quantos alunos deseja cadastrar? ");
        int total = scanner.nextInt();
        scanner.nextLine();

        if (total <= 0) {
            System.out.println("Quantidade invalida.");
            return;
        }

        if (total > alunos.length - quantidade) {
            System.out.println("Nao ha espaco suficiente.");
            return;
        }

        for (int i = 0; i < total; i++) {

            System.out.println();
            System.out.println("Aluno " + (i + 1));

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("RA: ");
            int ra = scanner.nextInt();

            System.out.print("Idade: ");
            int idade = scanner.nextInt();

            System.out.print("Sexo (M/F): ");
            char sexo = scanner.next().charAt(0);

            System.out.print("Media: ");
            double media = scanner.nextDouble();
            scanner.nextLine();

            alunos[quantidade] = new Aluno(nome, ra, idade, sexo, media);
            quantidade++;

            System.out.println("Aluno cadastrado com sucesso.");
        }
    }

    public static void relatorioPorNome() {

        if (quantidade == 0) {
            System.out.println();
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        Aluno[] copia = copiarAlunos();

        for (int i = 0; i < copia.length - 1; i++) {

            for (int j = 0; j < copia.length - 1 - i; j++) {

                if (copia[j].getNome().compareToIgnoreCase(
                        copia[j + 1].getNome()) > 0) {

                    Aluno aux = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = aux;
                }
            }
        }

        System.out.println();
        System.out.println("===============================");
        System.out.println("       ALUNOS POR NOME");
        System.out.println("===============================");

        mostrarAlunos(copia);
    }

    public static void relatorioPorRa() {

        if (quantidade == 0) {
            System.out.println();
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        Aluno[] copia = copiarAlunos();

        for (int i = 0; i < copia.length - 1; i++) {

            int maior = i;

            for (int j = i + 1; j < copia.length; j++) {

                if (copia[j].getRa() > copia[maior].getRa()) {
                    maior = j;
                }
            }

            Aluno aux = copia[i];
            copia[i] = copia[maior];
            copia[maior] = aux;
        }

        System.out.println();
        System.out.println("===============================");
        System.out.println("        ALUNOS POR RA");
        System.out.println("===============================");

        mostrarAlunos(copia);
    }

    public static void relatorioAprovados() {

        if (quantidade == 0) {
            System.out.println();
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        int totalAprovados = 0;

        for (int i = 0; i < quantidade; i++) {

            if (alunos[i].getResultado().equals("Aprovado")) {
                totalAprovados++;
            }
        }

        if (totalAprovados == 0) {
            System.out.println();
            System.out.println("Nenhum aluno aprovado.");
            return;
        }

        Aluno[] aprovados = new Aluno[totalAprovados];

        int posicao = 0;

        for (int i = 0; i < quantidade; i++) {

            if (alunos[i].getResultado().equals("Aprovado")) {
                aprovados[posicao] = alunos[i];
                posicao++;
            }
        }

        for (int i = 0; i < aprovados.length - 1; i++) {

            for (int j = 0; j < aprovados.length - 1 - i; j++) {

                if (aprovados[j].getNome().compareToIgnoreCase(
                        aprovados[j + 1].getNome()) > 0) {

                    Aluno aux = aprovados[j];
                    aprovados[j] = aprovados[j + 1];
                    aprovados[j + 1] = aux;
                }
            }
        }

        System.out.println();
        System.out.println("===============================");
        System.out.println("       ALUNOS APROVADOS");
        System.out.println("===============================");

        mostrarAlunos(aprovados);
    }

    public static void mostrarAlunos(Aluno[] lista) {

        for (Aluno aluno : lista) {

            System.out.println();
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("RA: " + aluno.getRa());
            System.out.println("Idade: " + aluno.getIdade());
            System.out.println("Sexo: " + aluno.getSexo());
            System.out.printf("Media: %.2f%n", aluno.getMedia());
            System.out.println("Resultado: " + aluno.getResultado());
            System.out.println("-------------------------------");
        }
    }

    public static Aluno[] copiarAlunos() {

        Aluno[] copia = new Aluno[quantidade];

        for (int i = 0; i < quantidade; i++) {
            copia[i] = alunos[i];
        }

        return copia;
    }
}