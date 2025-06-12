public abstract class OrdenacaoAbstract<T> {

    protected T info[];

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    public void trocar(T info[], int a, int b) {
        T temp = info[a];
        info[a] = info[b];
        info[b] = temp;
    }

    abstract void ordenar(T info[]);
}