public class TestesBuscaLinearOrdenada {
    public static void main(String[] args) {
        // Cria a lista encadeada ordenada
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserir(30);
        lista.inserir(20);
        lista.inserir(10); // Lista: 10 -> 20 -> 30

        // Instancia o buscador
        BuscaLinearListaOrdenada<Integer> busca = new BuscaLinearListaOrdenada<>();

        // Testa valor existente
        NoLista<Integer> achado = busca.buscar(lista, 20);
        System.out.println("\n");
        System.out.println(achado != null ? achado.getInfo() : "Não encontrado"); // Esperado: 20

        // Testa valor inexistente
        NoLista<Integer> naoAchado = busca.buscar(lista, 25);
        System.out.println(naoAchado != null ? naoAchado.getInfo() : "Não encontrado"); // Esperado: Não encontrado
    }
}
