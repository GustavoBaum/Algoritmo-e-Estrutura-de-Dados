public class ArvoreBinaria<T> extends NoArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria(T info) {
        super(info);
        raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        } else {
            return (no.getInfo() == info || pertence(no.getEsquerda(), info) || pertence(no.getDireita(), info)); 
        }
    }

    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        String esquerdaStr = arvorePre(no.getEsquerda());
        String direitaStr = arvorePre(no.getDireita());
        return "<" + no.getInfo() + esquerdaStr + direitaStr + ">";
    }
 
    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
        }
    }
}