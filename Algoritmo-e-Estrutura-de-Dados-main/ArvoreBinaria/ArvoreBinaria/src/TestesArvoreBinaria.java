public class TestesArvoreBinaria {

    public static void main(String[] args) {
        // Criar manualmente os nós
        NoArvoreBinaria<String> noA = new NoArvoreBinaria<>("A");
        NoArvoreBinaria<String> noB = new NoArvoreBinaria<>("B");
        NoArvoreBinaria<String> noC = new NoArvoreBinaria<>("C");
        NoArvoreBinaria<String> noD = new NoArvoreBinaria<>("D");
        NoArvoreBinaria<String> noE = new NoArvoreBinaria<>("E");

        // Montar a árvore:
        //       A
        //      / \
        //     B   C
        //    / \
        //   D   E

        noA.setEsquerda(noB);
        noA.setDireita(noC);
        noB.setEsquerda(noD);
        noB.setDireita(noE);

        // Criar a árvore com raiz
        ArvoreBinaria<String> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(noA);

        // Testar os métodos de exibição
        System.out.println("Pré-Ordem (toString):");
        System.out.println(arvore.toString());  // Esperado: <A<B<D<><>><E<><>>><C<><>>>

        System.out.println("\nPós-Ordem:");
        System.out.println(arvore.posOrdem());  // Esperado: <<<><>D><><>E>B><><>C>A>

        System.out.println("\nOrdem Simétrica:");
        System.out.println(arvore.ordemSimetrica());  // Esperado: <<<><>D>B<><>E>>A<><>C>>

        System.out.println("\nSubárvore a partir de 'B':");
        System.out.println(arvore.subArvoreToString("B"));  // Esperado: <B<D<><>><E<><>>>
    }
}