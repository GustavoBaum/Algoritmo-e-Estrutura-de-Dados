public class FilaLista<T> implements Fila<T> {

    public ListaEncadeada<T> lista;
    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaLista(int limite) {
        info = (Object[]) new Object();
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T valor) {
        lista.inserirFinalFila((int) valor);
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");   
        }
        return (T) info[inicio];
    }

    @Override
    public T retirar() {
        T valor = peek();
        lista.retirar(valor, valor);
        return valor;
    }

    @Override
    public void liberar() {
        this.info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    public String toString() {
        String valores = "";
        for (int i = 0; i < tamanho; i++) {
            valores += info[i];
            if (i != 0) {
                valores += ", ";
            }
        }
        return valores;
    }
    
}