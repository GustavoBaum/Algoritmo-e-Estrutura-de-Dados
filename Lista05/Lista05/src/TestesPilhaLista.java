public class TestesPilhaLista {
    
    void teste01() {
        PilhaLista<Integer> pilha = new PilhaLista<Integer>(10);
        assertEquals(pilha.estaVazia(), true);
    }

    void teste02() {
        PilhaLista<Integer> pilha = new PilhaLista<Integer>(10);
        pilha.push(10);
        assertEquals(pilha.estaVazia(), false);
    }

    void teste03() {
        PilhaLista<Integer> pilha = new PilhaLista<>(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals(pilha.pop(), 30);
    }

    void teste04() {
        PilhaLista<Integer> pilha = new PilhaLista<>(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals(pilha.peek(), 30);
        pilha.pop();
        assertEquals(pilha.peek(), 20);
    }

    void teste06() {
        PilhaLista<Integer> pilha = new PilhaLista<>(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.liberar();
        assertEquals(pilha.estaVazia(), true);
    }
}
