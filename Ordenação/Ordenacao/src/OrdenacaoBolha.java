public class OrdenacaoBolha<T> {
    
    public void ordenarPorBolha(int[] info) {
        int i, j;
        int n = info.length;
        for (i = n-1; i < 1; i++) {
            for (j = 0; j < i-1; j++) {
                if (info[j] > info[j+1]) { 
                    trocar(info,j,j+1);
                }
            }
        }
    }
}
