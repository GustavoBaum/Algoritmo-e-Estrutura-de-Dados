public class ListaDupla<T> {
 
    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public NoListaDupla<T> getUltimo() {
        NoListaDupla<T> p = primeiro;
        while (p.getProximo() != null) {
            p = p.getProximo();
        }
        return p;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);
        if (primeiro != null) {
            this.primeiro.setAnterior(novo);
        }
        this.primeiro = novo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            if (p.getInfo() == valor) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> p = buscar(valor);
        if (p != null) {
            if (primeiro == p) {
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }
            if (p.getProximo() != null) {
                p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }

    public String exibirOrdemInversa() {
        /*
         * NoListaDupla<T> p = primeiro;
         * while (p != null && p.getProximo() != null) {
         * p = p.getProximo();
         * }
         * while (p != null) {
         * JOptionPane.showMessageDialog(null, p.getInfo());
         * p = p.getAnterior();
         * }
         */
        String ordem = "";
        NoListaDupla<T> p = getUltimo();
        while (p != null) {
            ordem += p.getInfo();
            if (p.getAnterior() != null) {
                ordem += ", ";
            }
            p = p.getAnterior();
        }
        return ordem;
    }

    public void liberar() {
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            NoListaDupla<T> a = p;
            p = p.getProximo();
            a.setAnterior(null);
            a.setProximo(null);
        }
        primeiro = null;
    }

    public String toString() {
        String numeros = "";
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            numeros += p.getInfo();
            if (p.getProximo() != null) {
                numeros += ", ";
            }
            p = p.getProximo();
        }
        return numeros;
    }

    public ListaDupla<T> clonar() {
        ListaDupla<T> clone = new ListaDupla<T>();
        NoListaDupla<T> p = primeiro;
        while (p.getProximo() != null) {
            p = p.getProximo();
        }
        while (p != null) {
            clone.inserir(p.getInfo());
            p = p.getAnterior();
        }   
        return clone;
    }
}