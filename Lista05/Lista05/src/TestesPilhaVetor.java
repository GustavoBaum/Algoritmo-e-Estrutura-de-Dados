public class TestesPilhaVetor {

    public void teste01() {
        PilhaVetor<Integer> pilha = new PilhaVetor<Integer>(10);
        assertEquals(pilha.estaVazia(), true);
    }

    public void teste02() {
        PilhaVetor<Integer> pilha = new PilhaVetor<Integer>(5);
        pilha.push(10);
        assertEquals(pilha.estaVazia(), false);
    }

    public void teste03() {
        PilhaVetor<Integer> pilha = new PilhaVetor<Integer>(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals(pilha.pop(), 30);
        assertEquals(pilha.pop(), 20);
        assertEquals(pilha.pop(), 10);
        assertEquals(pilha.estaVazia(), true);
    }

    public void teste04() {
        PilhaVetor<Integer> pilha = new PilhaVetor<Integer>(3);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertThrows(RuntimeException.class, ()->{pilha.push(40);});
    }

    public void teste05() {
        PilhaVetor<Integer> pilha = new PilhaVetor<Integer>(10);
        assertThrows(RuntimeException.class, ()->{pilha.pop()});
    }

    public void teste06() {
        PilhaVetor<Integer> pilha = new PilhaVetor<Integer>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals(pilha.peek(), 30);
        assertEquals(pilha.pop(), 30);
    }

    public void teste07() {
        PilhaVetor<Integer> pilha = new PilhaVetor<Integer>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.liberar();
        assertEquals(pilha.estaVazia(), true);
    }

    public void teste08() {
        PilhaVetor<Integer> pilha1 = new PilhaVetor<Integer>(10);
        pilha1.push(10);
        pilha1.push(20);
        pilha1.push(30);
        PilhaVetor<Integer> pilha2 = new PilhaVetor<Integer>(3);
        pilha1.concatenar(pilha2);
        assertEquals(pilha1.toString(), "50, 40, 30, 20, 10");
    }
}
