public class Arvore<T> extends NoArvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        setRaiz(raiz);
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

    public String subArvoreToString(T info) {
        NoArvore<T> newRaiz = buscar(raiz, info);
         
        if (newRaiz == null) {
            return "<>";
        }   
        return obterRepresentacaoTextual(newRaiz);
    }

    public NoArvore<T> buscar(T info) {
        return buscar(raiz, info);
    }

    private NoArvore<T> buscar(NoArvore<T> no, T info) {
        if (no == null) {
            return null;
        }
        if (no.getInfo().equals(info)) {
            return no;
        }
        NoArvore<T> result = buscar(no.getPrimeiro(), info);
        if (result != null) {
            return result;
        }
        return buscar(no.getProximo(), info);
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + contarNos(no.getPrimeiro()) + (contarNos(no.getProximo()));
        }
    }

    public Arvore<T> clonar() {
        Arvore<T> clone = new Arvore<T>();
        clone.setRaiz(clonar(this.raiz));
        return clone;
    }

    private NoArvore<T> clonar(NoArvore<T> no) {
        if (no == null) {
            return null;
        }

        NoArvore<T> cloneNo = new NoArvore<>();
        cloneNo.setInfo(no.getInfo());
        cloneNo.setPrimeiro(clonar(no.getPrimeiro()));
        cloneNo.setProximo(clonar(no.getProximo()));
        return cloneNo;
    }
}