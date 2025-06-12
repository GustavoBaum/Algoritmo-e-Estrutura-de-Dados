public class NoArvoreBinaria<T> {

    private T info;
    private NoArvoreBinaria<T> esquerda;
    private NoArvoreBinaria<T> direita;

    public NoArvoreBinaria(T info) {
        setInfo(info);
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
        setInfo(info);
        setEsquerda(esq);
        setDireita(dir);
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return this.info;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return this.esquerda;
    }

    public NoArvoreBinaria<T> getDireita() {
        return this.direita;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(NoArvoreBinaria<T> direita) {
        this.direita = direita;
    }
}
