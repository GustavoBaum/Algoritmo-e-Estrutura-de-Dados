public class FilaLista<T> implements Fila<T> {

    public ListaEncadeada<T> lista;

    public FilaLista() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserirFinalFila((int) valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");   
        }
        return (T) lista.getPrimeiro();
    }

    @Override
    public T retirar() {
        T valor = peek();
        lista.retirar(valor, valor);
        return valor;
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<>();
    }

    public String toString() {
        return lista.toString();
    }
}