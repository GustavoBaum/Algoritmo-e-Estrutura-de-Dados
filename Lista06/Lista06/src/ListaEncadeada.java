public class ListaEncadeada<T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;

    public ListaEncadeada() {
        primeiro = null;
        ultimo = null;
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

    public void inserirFinalFila(int valor) {
        NoLista novo = new NoLista();
        novo.info = valor;
        novo.proximo = null;
        
        if (estaVazia()) {
            primeiro = novo;
        } else {
            ultimo.proximo = novo;
        }
        ultimo = novo;
    }

    public void setUltimo() {
        this.ultimo = ultimo;
    }

    public NoLista<T> getUltimo() {
        return ultimo;
    }
}