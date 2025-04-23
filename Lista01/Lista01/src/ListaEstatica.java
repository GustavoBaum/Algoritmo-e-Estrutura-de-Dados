import javax.swing.JOptionPane;

//IMPLEMENTAÇÃO DE UMA ARRAYLIST

public class ListaEstatica {

    private int[] info;
    private int tamanho;

    public ListaEstatica(int[] info, int tamanho) {
        info = new int[tamanho];
        getTamanho(tamanho);
    }

    private void redimensionar() {
        int[] novoInfo;
        int novoTamanho;

        novoTamanho = (info.length)+10;
        novoInfo = new int[novoTamanho];
        for(int i = 0; i < tamanho-1; i++) {
            novoInfo[i] = info[i];
        }
        info = novoInfo;
    }

    public void inserir(int valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor; 
        tamanho++;
    }

    public void exibir() {
        String numeros = "";
        for (int i = 0; i < tamanho; i++) {   
            numeros += info[i] + " ";
        }
        JOptionPane.showMessageDialog(null, numeros);
    } 

    public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(int valor) {
        int indiceValor = buscar(valor);

        if (indiceValor != -1) {
            for (int i = indiceValor; i < tamanho-1; i++) {
                info[i] = info[i+1];
            }
            tamanho--;
        }
    }

    public void liberar() {
        tamanho = 0;
        info = new int[10];
    }   
        
    public int obterElemento(int posicao) {
        if (posicao < tamanho) 
            return info[posicao];
        throw new IndexOutOfBoundsException();
    }

    public boolean estaVazia() {
//      if (tamanho == 0) {
//          return false;
//      }
//      return true;
        return (tamanho == 0);
   }

    public int getTamanho(int tamanho) {
        return this.tamanho;
    }

    public String toString() {
        String numeros = "";
        for (int i = 0; i < tamanho; i++) {
            numeros += info[i];
            if (i < tamanho-2) {
                numeros += ", ";
            }
        }
        return numeros;
    }        
}