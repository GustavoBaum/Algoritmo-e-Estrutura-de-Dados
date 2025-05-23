public class PilhaVetor<T> implements Pilha<T> {

    private Object info[];
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    public void push(T info) {
        if (limite == tamanho) {
            throw new RuntimeException("Capacidade da pilha esgotada");
        }
        this.info[tamanho++] = info;
        //this.tamanho++;
    }

    public T pop() {
        T valor = peek();
        info[tamanho] = null;
        tamanho--;
        return valor;
    }

    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha está vazia");
        }
        return (T) info[tamanho-1];
    }

    public boolean estaVazia() {
        return (tamanho == 0);
    }   

    public void liberar() {
        /*while (tamanho > 0) {
            info.equals(pop());
        }*/
        this.info = new Object[limite];
        this.tamanho = 0;
    }

    public String toString() {
        String valores = "";
        for (int i = tamanho-1; i >= 0; i--) {
            valores += info[i];
            if (i != 0) {
                valores += ", ";
            }
        }
        return valores;
    }

    public void concatenar(PilhaVetor<T> p) {
        PilhaVetor<T> pAux = new PilhaVetor<>(p.info.length);

        for (int i = p.tamanho-1; i >= 0; i--) {
            pAux.push((T)p.info[i]);
        }
        while (!pAux.estaVazia()) {
            this.push(pAux.pop());
        }
    }

    public PilhaVetor<T> subPilhaVetor(int inicio, int fim) {
        if (inicio < 0 || fim >= tamanho || inicio > fim) {
            throw new IndexOutOfBoundsException("Parâmetros informados apresentam erros");
        }
        PilhaVetor<T> subPilha = new PilhaVetor<>((fim-inicio)+1);
        for (int i = 0; i <= fim; i++) {
            subPilha.push((T) info[i]);
        }
        return subPilha;
    }
}