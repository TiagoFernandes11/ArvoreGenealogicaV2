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

    public void adicionarAncestral(String nome){
        Pessoa pessoa = this;
        while (pessoa.getMae() != null) {
            pessoa = pessoa.getMae();
        }
        pessoa.setMae(new Pessoa(nome, null, pessoa));
    }

    public Pessoa buscarAncestral(String nome) {
        Pessoa pessoa = this;
        while (pessoa != null) {
            if (pessoa.getNome().toLowerCase().equals(nome.toLowerCase())) {
                return pessoa;
            } else {
                pessoa = pessoa.getMae();
            }
        }
        return null;
    }

    public void inserirAncestral() {
        Pessoa pessoa = this;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do ancestral");
        Pessoa novaPessoa = new Pessoa(sc.nextLine());
        System.out.println("Qual o nome da mãe ?");
        String nomeDaMae = sc.nextLine().toLowerCase();

        while (pessoa != null) {
            if (pessoa.getMae().getNome().toLowerCase().equals(nomeDaMae)) {
                novaPessoa.setFilho(pessoa);
                novaPessoa.setMae(pessoa.getMae());
                pessoa.setMae(novaPessoa);
                return;
            }
            pessoa = pessoa.getMae();
        }
    }

    public void inserirAncestral(String nome, String nomeDaMae) {
        Pessoa pessoa = this;
        Pessoa novaPessoa = new Pessoa(nome);

        while (pessoa != null) {
            if (pessoa.getMae().getNome().toLowerCase().equals(nomeDaMae)) {
                novaPessoa.setFilho(pessoa);
                novaPessoa.setMae(pessoa.getMae());
                pessoa.setMae(novaPessoa);
                return;
            }
            pessoa = pessoa.getMae();
        }
    }

    public void removerAncestral(String nome) {
        Pessoa pessoa = this;
        while (pessoa.getMae() != null) {
            if (pessoa.getNome().toLowerCase().equals(nome.toLowerCase())) {
                if (pessoa.getFilho() != null) {
                    pessoa.getMae().setFilho(pessoa.getFilho());
                    pessoa.getFilho().setMae(pessoa.getMae());
                    return;
                } else {
                    setNome(pessoa.getMae().getNome());
                    setMae(this.getMae().getMae());
                    return;
                }
            }
            pessoa = pessoa.getMae();
        }
        pessoa.getFilho().setMae(null);
    }

    public void removerAncestral() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da pessoa a ser removida: ");
        String nome = sc.nextLine();
        Pessoa pessoa = this;
        while (pessoa.getMae() != null) {
            if (pessoa.getNome().toLowerCase().equals(nome.toLowerCase())) {
                if (pessoa.getFilho() != null) {
                    pessoa.getMae().setFilho(pessoa.getFilho());
                    pessoa.getFilho().setMae(pessoa.getMae());
                    return;
                } else {
                    setNome(pessoa.getMae().getNome());
                    setMae(this.getMae().getMae());
                    return;
                }
            }
            pessoa = pessoa.getMae();
        }
        pessoa.getFilho().setMae(null);
    }

    public void imprimirArvore() {
        String s = "\n ----- Arvore geneológica -----";
        Pessoa pessoa = this;
        while (pessoa != null) {
            s += pessoa.getNome() + "\n";
            pessoa = pessoa.getMae();
        }
        System.out.println(s);
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

    @Override
    public String toString() {
        String s = "\n ----- Arvore geneológica -----";
        Pessoa pessoa = this;
        while (pessoa != null) {
            s += pessoa.getNome() + "\n";
            pessoa = pessoa.getMae();
        }
        return s;
    }

    

}