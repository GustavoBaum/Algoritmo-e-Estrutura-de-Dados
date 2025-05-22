public class NoListaExtremos<T> {
    private T info;
    private NoListaExtremos<T> proximo;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoListaExtremos<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoListaExtremos<T> proximo) {
        this.proximo = proximo;
    }
}
