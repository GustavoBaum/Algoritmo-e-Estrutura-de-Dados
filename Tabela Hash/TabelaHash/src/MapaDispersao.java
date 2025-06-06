public class MapaDispersao<T> {
    
    private ListaEncadeada<noMapa<T>> info[];

    public MapaDispersao(int tamanho) {
        info = new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave) {
        int tamanho = info.length;   
        return (chave % tamanho);
        // return (chave % info.length);
    }

    public void inserir(int chave, T dado) {
        int indice = calcularHash(chave);
        
        if (info[indice] == null) {
            info[indice] = new ListaEncadeada<>();
        }
        noMapa no = new noMapa();
        no.setChave(chave);
        no.setInfo(dado); 

        info[indice].inserir(no);
    }

    public void remover(int chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            noMapa<T> noMapa = new noMapa();
            noMapa.setChave(chave);
            info[indice].retirar(noMapa);
        }
    }

    public T buscar(int chave) {
        int indice = calcularHash(chave);
        
        if (info[indice] != null) {
            noMapa<T> noMapa = new noMapa<>();
            noMapa.setChave(chave);

            NoLista<noMapa<T>> no = info[indice].buscar(noMapa);
            if (no != null) {
                return no.getInfo().getInfo();
            }
        }
        return null;
    }
}