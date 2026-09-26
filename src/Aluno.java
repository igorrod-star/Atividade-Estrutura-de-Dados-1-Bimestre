public class Aluno {

    private String nome;
    private int ra;
    private int idade;
    private char sexo;
    private double media;
    private String resultado;

    public Aluno(String nome, int ra, int idade, char sexo, double media) {
        this.nome = nome;
        this.ra = ra;
        this.idade = idade;
        this.sexo = sexo;
        this.media = media;

        if (media >= 6.0) {
            this.resultado = "Aprovado";
        } else {
            this.resultado = "Reprovado";
        }
    }

    public String getNome() {
        return nome;
    }

    public int getRa() {
        return ra;
    }

    public int getIdade() {
        return idade;
    }

    public char getSexo() {
        return sexo;
    }

    public double getMedia() {
        return media;
    }

    public String getResultado() {
        return resultado;
    }
}
