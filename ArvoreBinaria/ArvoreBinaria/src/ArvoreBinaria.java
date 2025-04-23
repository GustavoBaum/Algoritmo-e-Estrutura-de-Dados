public class ArvoreBinaria<T> implements NoArvoreBinaria<T> {

    public ArvoreBinaria() {

    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {

    }

    public boolean estaVazia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pertence() {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        } else {
            return (no.info == info) || pertence(no.esq, info) || pertence(no.dir, info);
        }
    }

    public String toString() {
        if (raiz == null) {
            return " ";
        } else {
            return obterRepresentacaoTextual(raiz);
        }
    }

    private String arvorePre(NoArvoreBinariaL<T> no) {

    }

    public int contarNos() {

    }

    private int contarNos(NoArvoreBinaria<T> no) {

    }
}