public class noMapa<T> {
    
    private int chave;
    private T info;

    public int getChave() {
        return this.chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        /*NoMapa<?> noMapa = new NoMapa<?> o;
         * return chave == noMapa.chave;*/
        noMapa other = (noMapa) obj;
        if (chave != other.chave) {
            return false;
        }
        return true;
    }
}
