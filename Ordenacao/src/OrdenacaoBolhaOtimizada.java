public class OrdenacaoBolhaOtimizada<T extends Comparable<T>> extends OrdenacaoAbstract<T>{

    @Override
    public void ordenar(T[] info) {
        int i, j;
        int n = info.length;
        boolean trocou;
        for (i = 0; i < n-1; i++) {
            trocou = false;
            for (j = 0; j < i-1; j++) {
                if (((Comparable<T>) info[i]).compareTo(info[j+1]) > 0) {
                    trocar(info, j, j+1);
                    trocou = true;
                }
            }
            if (!trocou) {
                return;
            }
        }
    }
}
