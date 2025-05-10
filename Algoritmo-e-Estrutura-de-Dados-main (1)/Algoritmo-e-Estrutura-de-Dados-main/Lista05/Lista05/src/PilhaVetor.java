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
        String valores = "[";
        for (int i = tamanho-1; i >= 0; i--) {
            valores += info[i];
            if (i != 0) {
                valores += ", ";
            }
        }
        valores += "]";
        return valores;
    }

    public String toStringInvertido() {
        String valoresInvertidos = "[";
        for (int i = 0; i <= tamanho-1; i++) {
            valoresInvertidos += info[i];
            if (i != tamanho-1) {
                valoresInvertidos += ", ";
            }
        }
        valoresInvertidos += "]";
        return valoresInvertidos;
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
}