public class Teste {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Tiago");
        pessoa.adicionarAncestral();
        pessoa.adicionarAncestral();
        pessoa.adicionarAncestral();
        pessoa.removerAncestral("Nice");
        pessoa.imprimirArvore();
        
    }
}