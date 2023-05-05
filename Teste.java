public class Teste {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("tiago");
        pessoa.adicionarAncestral();
        pessoa.adicionarAncestral();
        System.out.println(pessoa.buscarAncestral("Maria").getFilho().getNome());
        
    }
}
