public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        setRaiz(raiz);
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

    // ---------------------------------------------------------------------------------------------------------------------
    // Método subArvoreToString
    public String subArvoreToString(T info) {
        NoArvoreBinaria<T> newraiz = buscar(raiz, info);

        if (newraiz == null) {
            return "<>";
        }

        return arvorePre(newraiz);
    }

    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(raiz, info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null || no.getInfo().equals(info)) {
            return no;
        }

        NoArvoreBinaria<T> result = buscar(no.getEsquerda(), info);
        if (result != null) {
            return result;
        }
        return buscar(no.getDireita(), info);
    }

    // ---------------------------------------------------------------------------------------------------------------------

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

    // ---------------------------------------------------------------------------------------------------------------------
    // Método posOrdem
    public String posOrdem() {
        return porOrdem(raiz);
    }

    private String porOrdem(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        String esquerdaStr = porOrdem(no.getEsquerda());
        String direitaStr = porOrdem(no.getDireita());
        return "<" + esquerdaStr + direitaStr + no.getInfo() + ">";
    }

    // ---------------------------------------------------------------------------------------------------------------------
    // Método ordemSimétrica
    public String ordemSimetrica() {
        return ordemSimetrica(raiz);
    }

    private String ordemSimetrica(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        String esquerdaStr = ordemSimetrica(no.getEsquerda());
        String direitaStr = ordemSimetrica(no.getDireita());
        return "<" + esquerdaStr + no.getInfo() + direitaStr + ">";
    }

    // ---------------------------------------------------------------------------------------------------------------------

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

    public ArvoreBinaria<T> clonar() {
        ArvoreBinaria<T> clone = new ArvoreBinaria<T>();
        clone.setRaiz(clonar(this.raiz));
        return clone;
    }

    private NoArvoreBinaria<T> clonar(NoArvoreBinaria<T> no) {
        if (no == null) {
            return null;
        }

        NoArvoreBinaria<T> cloneNo = new NoArvoreBinaria<T>(null);
        cloneNo.setInfo(no.getInfo());
        cloneNo.setEsquerda(clonar(no.getEsquerda()));
        cloneNo.setDireita(clonar(no.getDireita()));
        return cloneNo;
    }

    // ---------------------------------------------------------------------------------------------------------------------
    // Método retirar nó
    public boolean retirarNo(T info) {
        if (raiz == null) {
            return false;
        }
        if (raiz.getInfo().equals(info)) {
            raiz = null;
            return true;
        }

        return retirarNo(raiz, info);
    }

    private boolean retirarNo(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        }

        if (no.getEsquerda() != null && no.getEsquerda().getInfo().equals(info)) {
            no.setEsquerda(null);
            return true;
        }
        if (no.getDireita() != null && no.getDireita().getInfo().equals(info)) {
            no.setDireita(null);
            return true;
        }
        return retirarNo(no.getEsquerda(), info) || retirarNo(no.getDireita(), info);
    }

    // ---------------------------------------------------------------------------------------------------------------------
    // Método para calcular o nível da árvore

    public int contarNivel(T info) {
        return contarNivel(raiz, info, 0);
    }

    private int contarNivel(NoArvoreBinaria<T> no, T info, int nivel) {
        if (no == null) {
            return -1;
        }
        if (no.getInfo().equals(info)) {
            return nivel;
        }

        int nivelEsq = contarNivel(no.getEsquerda(), info, nivel + 1);
        if (nivelEsq != -1) {
            return nivelEsq;
        }
        int nivelDir = contarNivel(no.getDireita(), info, nivel + 1);
        return nivelDir;
    }

    // ---------------------------------------------------------------------------------------------------------------------
    // Método para calcular a altura da árvore

    public int getAltura() {
        return getAltura(raiz);
    }

    private int getAltura(NoArvoreBinaria<T> no) {
        if (no == null) {
            return -1;
        }

        int alturaEsq = getAltura(no.getEsquerda());
        int alturaDir = getAltura(no.getDireita());

        return Math.max(alturaEsq, alturaDir) + 1;
    }

    public int contarFolhas() {
        if (raiz == null) {
            return -1;
        }
        return contarFolhas(raiz);
    }

    // ---------------------------------------------------------------------------------------------
    // Método que visa contar a quantidade de nós filhos de uma árvore binária

    private int contarFolhas(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }

        if (no.getEsquerda() == null && no.getDireita() == null) {
            return +1;
        }

        return contarFolhas(no.getEsquerda()) + contarFolhas(no.getDireita());
    }
}