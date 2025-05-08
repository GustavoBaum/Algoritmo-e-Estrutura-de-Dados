public class FilaVetor<T> implements Fila<T> {

    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }
        int posicaoInserir = (inicio + tamanho)  % limite;
        info[posicaoInserir] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return (T) info[inicio];
    }

    @Override
    public T retirar() {
        T valor = peek();   
        inicio = (inicio + 1) % limite;
        tamanho--;
        return valor;
    }
    
    @Override
    public void liberar() {
        this.info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<T>(this.limite + f2.getLimite());

        for (int i = 0; i < this.tamanho; i++) {
            int elementos = (inicio+i) % info.length;
            f3.inserir((T)this.info[elementos]);
        }
        for (int a = 0; a < f2.tamanho; a++) {
            int elementos = (f2.inicio+a) % f2.info.length;
            f3.inserir((T)f2.info[elementos]);
        }
        return f3;
    }

    public String toString() {
        String valores = "";

        if (tamanho == limite) {
            throw new FilaVaziaException();
        }

        for (int i = 0; i < tamanho; i++) {
            int indice = (inicio+1) % limite;
            valores += "[" + info[indice] + "]";
        }
        return valores;
    }

    public int getLimite() {
        return limite;
    }
}
