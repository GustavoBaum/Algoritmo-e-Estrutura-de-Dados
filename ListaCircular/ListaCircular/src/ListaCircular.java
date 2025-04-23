import javax.swing.JOptionPane;

public class ListaCircular<T> {

    private NoListaCircular<T> primeiro;

    public ListaCircular() {
        primeiro = null;
    }

    public NoListaCircular<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoListaCircular<T> novo = new NoListaCircular<T>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoListaCircular<T> buscar(T info) {
        NoListaCircular<T> p = primeiro;
        while (p != null) {
            if (p.getInfo() == info) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T info, T valor) {
        NoListaCircular<T> anterior = null;
        NoListaCircular<T> p = primeiro;
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

    public void exibirCircular() {
        NoListaCircular<T> p = primeiro;
        if (p != null) {
            do {
                JOptionPane.showMessageDialog(null, p.getInfo());
            } while (p != primeiro);
        }
    }
}