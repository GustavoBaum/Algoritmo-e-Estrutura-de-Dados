public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar(T[] info) {
        int i, j;
        int n = info.length;
        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < i - 1; j++) {
                if ((info[i]).compareTo(info[j + 1]) > 0) {
                    trocar(info, j, j + 1);
                }
            }
        }
    }

    public void ordenarDecrescente() {
        boolean trocou = true;
        int n = info.length;

        // Continua passando enquanto houver trocas
        while (trocou) {
            trocou = false;

            for (int i = 0; i < n - 1; i++) {
                // Verifica se os elementos estão fora da ordem decrescente
                if ((info[i]).compareTo(info[i + 1]) < 0) { //info[i] < info[i + 1]
                    // Troca apenas uma vez por passagem
                    T temp = info[i];
                    info[i] = info[i + 1];
                    info[i + 1] = temp;

                    trocou = true;
                    break; // Faz só uma troca por passagem
                }
            }
        }
    }
}
