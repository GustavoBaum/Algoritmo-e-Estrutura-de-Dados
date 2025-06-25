public class ArvoreBinaria<T extends Comparable<T>> extends ArvoreBinariaAbtract<T> {

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        NoArvoreBinaria<T> p = raiz;
        while (p != null && ((Comparable<T>) p.getInfo()).compareTo(info) < 0) {
            if (((Comparable<T>) info).compareTo(p.getInfo()) < 0) { // info < p.getInfo()
                p = p.getEsquerda();
            } else {
                p = p.getDireita();
            }
        }
        return p;
    }       

    @SuppressWarnings("unused")
    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }

        if (((Comparable<T>) info).compareTo(no.getInfo()) < 0) {
            return no;
        } else {
            if (((Comparable<T>) info).compareTo(no.getInfo()) > 0) {
                return buscar(no.getEsquerda(), info);
            } else {
                return buscar(no.getDireita(), info);
            }
        }
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }
}
