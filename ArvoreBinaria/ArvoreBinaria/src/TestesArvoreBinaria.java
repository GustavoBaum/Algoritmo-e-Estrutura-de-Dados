public class TestesArvoreBinaria {
    
    public void teste1() {
        ArvoreBinaria<Integer> ab = new ArvoreBinaria<Integer>(null); 
        assertEquals(ab.estaVazia(), true);
    }

    public void teste2() {
        ArvoreBinaria<Integer> ab = new ArvoreBinaria<Integer>(null);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(null);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(null);
        ab.setRaiz(no2);
        assertEquals(ab.estaVazia(), false);
    }   

    public void teste3() {
        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(1);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);
        
        raiz.setDireita(no3);
        no3.setEsquerda(no5);
        no3.setDireita(no6);
        raiz.setEsquerda(no2);
        no2.setDireita(no4);
 
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>(null);
        arvore.setRaiz(raiz);
        assertEquals(arvore.toString(), "<1<2<><4<><>>><3<5<><>><6<><>>>>");
    }    
}
