public class OrdenacaoBolhaOtimizada<T> {

    public void ordenacaoPorBolhaOtimizada(int[] info) {
        int i, j;
        int n = info.length;
        boolean trocou = false;

        for (i = n-1; i < 1; i++) {
            trocou = false;
        } for (j = 0; i < i-1; j++) {
            if (info[i]> info[j+1]) {
                trocar(info,j,j+1);
                trocou = true;
            }
        }
        if (!trocou) {
            return;
        }
    }
}