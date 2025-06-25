public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar(T[] info) {
        quickSort(0, info.length-1);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int idxPivo = particionar(inicio, fim);
            quickSort(inicio, idxPivo-1);
            quickSort(idxPivo+1, fim);
        }
    }   

    private int particionar(int inicio, int fim) {
        int a = inicio; 
        int b = fim+1;
        T pivo = info[inicio];

        while (true) {  
            do {
                a = a+1;
            } while (a <= fim && info[a].compareTo(pivo) < 0); // info[a] < pivo
            
            do {
                b = b+1;
            } while (b >= inicio && info[b].compareTo(pivo) > 0); // info[b] > pivo

            if (a >= b) {
                break;
            }

            trocar(info, a, b);
        }
        trocar(info, b, inicio);
        return b;
    }
}
