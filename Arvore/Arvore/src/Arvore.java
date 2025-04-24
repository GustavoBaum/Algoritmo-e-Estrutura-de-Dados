public class Arvore<T> extends NoArvore<T> {

    private NoArvore<T> raiz;

    public Arvore(T info) {
        super(info);
    }

    public NoArvore<T> getRaiz() {
        return this.raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public String toString() {
        if (raiz == null) {
            return "";
        } else {
            return obterRepresentacaoTextual(raiz);
        }
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String s = "<";
        s = s + no.getInfo();

        NoArvore p;
        p = no.getPrimeiro();
        while (p != null) {
            s = s + obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
        s = s + ">";
        return s;
    }

    public boolean pertence(T info) {
        if (raiz == null) {
            return false;
        } else {
            return pertence(raiz, info);
        }
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo() == info) {
            return true;
        }
        NoArvore p;
        p = no.getPrimeiro();
        while (p != null) {
            if (pertence(p, info)) {
                return true;
            }
            p.getProximo();
        }
        return false;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null) {
            throw new IndexOutOfBoundsException();
        }

        int qtNos = 0;
        if (no.getPrimeiro() != null) {
            qtNos++;
            if (no.getPrimeiro() != null) {
                qtNos++;
                contarNos(no.getProximo());
            }
            contarNos(no.getProximo());
        }
        return qtNos;
    }
    
}