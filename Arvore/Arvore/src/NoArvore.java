public class NoArvore<T> {
    
    private T info;
    private NoArvore<T> primeiro;
    private NoArvore<T> proximo;

    public NoArvore(T info) {
        setInfo(info);
    }

    public void inserirFilho(NoArvore<T> sa) {
        sa.proximo = primeiro;
        primeiro = sa;
    }   

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return this.info;
    }

    public NoArvore<T> getPrimeiro() {
        return this.primeiro;
    }

    public void setPrimeiro(NoArvore<T> no) {
        
    }

    public NoArvore<T> getProximo() {
        return this.proximo;
    }

    public void setProximo(NoArvore<T> no) {
        
    }
}
