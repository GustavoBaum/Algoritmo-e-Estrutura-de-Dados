public class TestesArvoreBinaria {
    
    public static void main(String[] args) {

    // Teste1:
    // Conferir se o método inserir() mantém os dados armazenados adequadamente, mantendo a árvore com a característica de ser uma árvore binária de busca.

    ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();
    arvore.inserir(50);
    arvore.inserir(30);
    arvore.inserir(70);
    arvore.inserir(40);
    arvore.inserir(25);
    arvore.inserir(75);
    arvore.inserir(65);
    arvore.inserir(35);
    arvore.inserir(60);

    System.out.println("\n" + arvore.toString() + "\n");

    // Teste2:
    // Conferir se a árvore consegue remover um nó folha
    
    ArvoreBinariaBusca<Integer> arvore1 = new ArvoreBinariaBusca<>();
    arvore1.inserir(50);
    arvore1.inserir(30);
    arvore1.inserir(25);
    arvore1.inserir(40);
    arvore1.retirar(40);

    System.out.println("\n" + arvore1.toString() + "\n");


    // Teste3:
    // Conferir se a árvore consegue remover nó com um filho

    ArvoreBinariaBusca<Integer> arvore2 = new ArvoreBinariaBusca<>();
    arvore2.inserir(80);
    arvore2.inserir(52);
    arvore2.inserir(90);
    arvore2.inserir(48);
    arvore2.inserir(71);
    arvore2.inserir(63);
    arvore2.inserir(67);
    arvore2.retirar(71);

    System.out.println("\n" + arvore2.toString() + "\n");

    // Teste4: 
    // Conferir se a árvore consegue remover um nó com dois filhos
   
    ArvoreBinariaBusca<Integer> arvore3 = new ArvoreBinariaBusca<>();
    arvore3.inserir(250);
    arvore3.inserir(38);
    arvore3.inserir(26);
    arvore3.inserir(72);
    arvore3.inserir(55);
    arvore3.inserir(90);
    arvore3.inserir(41);
    arvore3.inserir(60);
    arvore3.inserir(43);
    arvore3.inserir(78);
    arvore3.inserir(92);
    arvore3.inserir(74);
    arvore3.retirar(38);
    
    System.out.println("\n" + arvore3.toString() + "\n");
    }
}
