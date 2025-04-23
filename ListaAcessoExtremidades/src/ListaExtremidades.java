public class ListaExtremidades<T> {

    private NoListaExtremos<T> primeiro;
    private NoListaExtremos<T> ultimo;

    public ListaExtremidades() {
        primeiro = null;
        ultimo = null;
    }

    public NoListaExtremos getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoListaDupla primeiro) {
        this.primeiro = primeiro;
    }

    private NoListaDupla<T> getUltimo() {
        NoListaDupla<T> no = primeiro;
        while (no.getProximo() != ultimo) {
            no = no.getProximo();
        }
        return no;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla();
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(ultimo);
        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> no = primeiro;

        while (no.getProximo() != primeiro) {
            if (no.getInfo().equals(valor)) {
                return no;
            }
            no = no.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> no = buscar(valor);

        if (no != null) {
            if (primeiro == no) {
                this.primeiro = no.getProximo();
                
            } else {
               no.getAnterior().setProximo(no.getProximo());
            }
        }
        if (no.getProximo() != primeiro) {
            no.getProximo().setAnterior(no.getAnterior());
            no.getAnterior().setProximo(no.getProximo());
        }
    }

    public String exibirOrdemInversa() {
        String s = "";

        NoListaDupla<T> no = getUltimo();
        while (no != ultimo) {
            s += no.getInfo();
            if (no.getAnterior()!= ultimo) {
                s += (", ");
            }
            no = no.getAnterior();
        }
        return s;
    }

    public void liberar() {
        NoListaDupla<T> no = ultimo;
        while (no != primeiro) {
            no = no.getAnterior();
            no.setProximo(null);
        }
        primeiro = null;
    }

    @Override
    public String toString() {
        String s = "";

        NoListaDupla<T> no = getPrimeiro();
        while (no != ultimo) {
            s += no.getInfo();
            if (no.getProximo() != ultimo) {
                s += (", ");
            }
            no = no.getProximo();
        }
        return s;
    }
}
