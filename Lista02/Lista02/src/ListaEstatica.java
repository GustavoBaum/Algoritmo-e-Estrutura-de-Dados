import javax.swing.JOptionPane;

//IMPLEMENTAÇÃO DE UMA ARRAYLIST COM TIPO GENÉRICO T

public class ListaEstatica<T> {

    private T info[];
    private int tamanho;

    public ListaEstatica(int tamanho) {
        liberar();
    }   

    @SuppressWarnings("unchecked")
    private void redimencionar() {
        int novoTamanho;
        T[] novoInfo;

        novoTamanho = (info.length)+10;
        novoInfo = (T[]) new Object[novoTamanho];
        for (int i = 0; i < tamanho-1; i++) {
            novoInfo[i] = info[i]; 
        }
        info = novoInfo;
    }

    public void inserir(T valor) {
        if (tamanho == info.length) {
            redimencionar();
        }
        info[tamanho++] = valor; //Ok, primerio ele incrementa o valor e depois efetua a operação
        //info[++tamanho] = valor; //ERRADO, aqui ele primeiro realiza a operação e depois incrementa o novo valor

        //info[tamanho] = valor;
        //tamanho++;
    }

    public void exibir() {
        //System.out.println(toString());
        String numeros = "";
        for (int i = 0; i < tamanho; i++) {
            numeros += info[i] + " ";
        }
        JOptionPane.showMessageDialog(null, numeros);
    }

    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (valor == info[i]) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T valor) {
        int indiceValor = buscar(valor);
        if (indiceValor != 1) {
            for (int i = indiceValor; i < tamanho-1; i++) {
                info[i] = info[i+1]; 
            }
            tamanho--;
        }
    }

    @SuppressWarnings("unchecked")
    public void liberar() {
        tamanho = 0;
        info = (T[]) new Object[10];
    }

    public T obterElemento(int posicao) throws IndexOutOfBoundsException {
        if (posicao < tamanho) {
            return (T) info[posicao];
        }
        throw new IndexOutOfBoundsException();
    }   

    public boolean estaVazia() {
        return (tamanho == 0);
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public String toString() {
        String numeros = "";
        /*for (Object t : info) {
            numeros += t.toString() + "\n";
        }*/
        for (int i = 0; i < tamanho; i++) {
            numeros += info[i];
            if (i < tamanho-2) {
                numeros += ", ";
            }
        }
        return numeros;
    }

    public void inverter() {
        for (int i = 0; i < tamanho/2; i++) {
            T n = (T) info[i];
            info[i] = info[tamanho-i];
            info[tamanho-1-i] = n;
        }
        /*T aux;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < i; j++) {
                aux = info[i];
                info[i] = info[j];
                info[j] = aux;
            }
        }*/
    }
}
