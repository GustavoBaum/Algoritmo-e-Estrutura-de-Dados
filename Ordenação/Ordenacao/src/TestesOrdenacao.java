import java.util.Arrays;

public class TestesOrdenacao {

    public TestesOrdenacao() {

        // @Teste1:
        Integer[] vetor = new Integer[] { 70, 2, 88, 15, 90, 30 };
        OrdenacaoBolha<Integer> ob = new OrdenacaoBolha<>();
        ob.ordenar(vetor);

        System.out.println("\nTeste com método Ordenação Bolha: " + Arrays.toString(vetor) + ";");

        // @Teste2:
        OrdenacaoBolhaOtimizada<Integer> obp = new OrdenacaoBolhaOtimizada<>();
        obp.ordenar(vetor);

        System.out.println("\nTeste com método Ordenação Bolha Otimizado: " + Arrays.toString(vetor) + ";");

        // @Teste3: 
        OrdenacaoBolha<Integer> ordenacao = new OrdenacaoBolha<>();
        ordenacao.setInfo(new Integer[] { 70, 2, 88, 15, 90, 30 });

        ordenacao.ordenarDecrescente();

        System.out.println(Arrays.toString(ordenacao.getInfo()));

        // @Teste4:
        OrdenacaoQuickSort<Integer> oq = new OrdenacaoQuickSort<>();
        oq.ordenar(vetor);

        System.out.println("\n este com método QuickSort: " + Arrays.toString(vetor) + ";");

        // @Teste5:
        OrdenacaoMergeSort<Integer> om = new OrdenacaoMergeSort<>();
        om.ordenar(vetor);

        System.out.println("\nTeste com método MergeSort: " + Arrays.toString(vetor) + ";");
    }

    public static void main(String[] args) {
        new TestesOrdenacao();
    }
}
