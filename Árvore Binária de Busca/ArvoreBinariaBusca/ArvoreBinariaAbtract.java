public abstract class ArvoreBinariaAbtract<T> {

    protected NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbtract() {
        setRaiz(raiz);
    }

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return this.raiz;
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

    public abstract NoArvoreBinaria<T> buscar(T info);

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
