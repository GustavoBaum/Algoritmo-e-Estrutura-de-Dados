public class NoArvoreBinaria<T> {

    private Object info;

    public NoArvoreBinaria<T>(T info) {
        this.info = info;
        esquerda = null;
        direita = null;
    }

    public NoArvoreBinaria<T>(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
        this.info = info;
        esquerda = esq;
        direita = dir;
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