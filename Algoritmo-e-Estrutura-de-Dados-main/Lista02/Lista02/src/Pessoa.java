public class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        setNome(nome);
        setIdade(idade);
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    } 

    public String getNome() {
        return this.nome;
    }

    public String toString() {
        return ("Nome = " + nome + "\nIdade = " + idade + ".\n");
    }
}
