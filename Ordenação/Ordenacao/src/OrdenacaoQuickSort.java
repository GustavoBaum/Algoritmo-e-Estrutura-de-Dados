public class OrdenacaoQuickSort<T> {
    
    public void ordenar() {
        
    }

    public void quickSort() {
        int n = info.length-1;
        quickSort(0, n);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int idxPivo = participar(inicio, fim);
            quickSort(inicio, idxPivo-1);
            quickSort(idxPivo+1, fim);
        }
    }

    private int participar(int inicio, int fim) {
        int a = inicio;
        int b = fim+1;
        int pivo = info[inicio];

        while (true) {
            do {
                a = a + 1;
            } while (a <= fim && info[a] < pivo);

            do {
                b = b - 1;
            } while (b >= inicio && info[b] > pivo);

            if (a >= b) {
                break;
            }
            trocar(a, b);
        }
        trocar(b, inicio);
        return b;
    }   
}   