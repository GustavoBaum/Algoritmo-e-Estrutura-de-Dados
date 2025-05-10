public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada lista;

    public PilhaLista(T info) {
        lista = new ListaEncadeada<>();
        lista.inserir(info);
    }

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    public T peek() {
        if (lista.estaVazia()) {
            throw new RuntimeException("Pilha está vazia");
        }
        return (T) lista.getPrimeiro().getInfo();
    }

    public T pop() {
        T valor = peek();
        lista.retirar(valor, lista);

        return valor;
    }

    public String toString() {
        return lista.toString();
    }

    @Override
    public boolean estaVazia() {
        return (lista.getPrimeiro() == null);
    }

    @Override
    public void liberar() {
       lista = new ListaEncadeada<>();
    }
}
