public class ListaEncadeada<T> {
 
    private NoLista<T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoLista<T> novo = new NoLista<T>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    public boolean estaVazia() {
        return (primeiro == null);
    }

    public NoLista<T> buscar(T info) {
        NoLista<T> p = primeiro;
        while (p != null) {
            if (p.getInfo() == info) {
                return p;   
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T info, T valor) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;
        while (p != null && p.getInfo() != valor) {
            anterior = p;
            p = p.getProximo();
        }
        if (p != null) {
            if (p != primeiro) {
                this.primeiro = p.getProximo();
            }
            anterior.setProximo(p.getProximo());
        }
    }

    public int obterComprimento() {
        int comprimento = 0;
        NoLista<T> p = primeiro;
        while (p != null) {
            comprimento++;
            p = p.getProximo();
        }
        return comprimento;
    }

    public NoLista<T> obterNo(int idx) {
        int indiceNo = 0;
        NoLista<T> p = primeiro;
        while (p != null) { 
            if (idx == indiceNo) {
                return p;
            }
            indiceNo++;
            p = p.getProximo();
        }
        throw new IndexOutOfBoundsException("Indice fora dos limites: " + idx);
    }

    public String toString() {
        String numeros = "";
        NoLista<T> p = primeiro;
        while (p != null) {
            numeros += p.getInfo();
            if (p.getProximo() != null) {
                numeros += (", ");
            }
            p = p.getProximo();
        }
        return numeros;
    }

    public ListaEncadeada<T> criarSubLista(int inicio, int fim) {
        ListaEncadeada<T> subLista = new ListaEncadeada<T>();
        NoLista<T> p = primeiro;
        if (inicio > 0 && inicio <= p.obterComprimento() && fim > 0 && fim <= p.obterComprimento()) {
            while (p != null) {
                if (p.getInfo() == inicio) {
                    while (p != buscar(fim).proximo.getInfo()) {
                        subLista.inserir(p.setInfo());
                        p = p.getProximo();
                    }
                    p = p.getProximo();
                }
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return subLista;
    }
}