import java.util.Scanner;

public class Pessoa {
    private String nome;
    private Pessoa mae;
    private Pessoa filho;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, Pessoa mae, Pessoa filho) {
        this.nome = nome;
        this.mae = mae;
        this.filho = filho;
    }

    public void adicionarAncestral() {
        Scanner sc = new Scanner(System.in);
        Pessoa pessoa = this;
        while (pessoa.getMae() != null) {
            pessoa = pessoa.getMae();
        }
        System.out.println("Digite o nome do ancestral");
        pessoa.setMae(new Pessoa(sc.nextLine(), null, pessoa));
    }

    public void imprimirArvore(){
        String s = "";
        Pessoa pessoa = this;
        while(pessoa != null){
            s += pessoa.getNome() + "\n";
            pessoa = pessoa.getMae();
        }
        System.out.println(s);
    }

    public Pessoa buscarAncestral(String nome){
        Pessoa pessoa = this;
        while(pessoa !=null){
            if(pessoa.getNome().toLowerCase().equals(nome.toLowerCase())){
                return pessoa;
            }else{
                pessoa = pessoa.getMae();
            }
        }
        return null;
    }

    public void removerAncestral(){
        System.out.println("todo");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getMae() {
        return mae;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }

    public Pessoa getFilho() {
        return filho;
    }

    public void setFilho(Pessoa filho) {
        this.filho = filho;
    }

}