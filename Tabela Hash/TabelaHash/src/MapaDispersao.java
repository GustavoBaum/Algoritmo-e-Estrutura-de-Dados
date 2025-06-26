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
            NoLista<noMapa<T>> atual = info[indice].getPrimeiro();
            while (atual != null) {
                noMapa<T> elemento = atual.getInfo();
                if (elemento.getChave() == chave) {
                    return elemento.getInfo(); // ou getInfo()
                }
                atual = atual.getProximo();
            }
        }
        return null;
    }

    // ---------------------------------------------------------------------------------------------

    public void incluirTodos(MapaDispersao<T> outroMapa) {

        // Percorre todas as posições da tabela hash do outro mapa
        for (int i = 0; i < outroMapa.info.length; i++) {
            // Recupera a lista encadeada na posição i do outro mapa
            ListaEncadeada<noMapa<T>> lista = outroMapa.info[i];

            if (lista != null) { // Verifica se existe uma lista nesta posição
                NoLista<noMapa<T>> atual = lista.getPrimeiro(); // Pega o início da lista encadeada

                // Percorre todos os nós da lista
                while (atual != null) {
                    noMapa<T> elemento = atual.getInfo(); // Recupera o objeto noMapa que contém a chave e o valor

                    // Insere o elemento no mapa atual
                    // Usa a chave e o valor obtidos do outro mapa
                    this.inserir(elemento.getChave(), elemento.getInfo());

                    atual = atual.getProximo(); // Avança para o próximo nó da lista
                }
            }
        }
    }
}