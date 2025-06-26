public class TestesMapaDispersao {

    public TestesMapaDispersao() {
        // Mapa 1: chave é número (como string), valor é T (neste caso, String)
        MapaDispersao<Integer> mapa1 = new MapaDispersao<>(10);
        MapaDispersao<Integer> mapa2 = new MapaDispersao<>(10);

        // Inserções no mapa1
        mapa1.inserir(1, 255);
        mapa1.inserir(2, 400);

        // Inserções no mapa2
        mapa2.inserir(3, 35);

        // Copia os dados de mapa1 para mapa2
        mapa2.incluirTodos(mapa1);

        // Impressão para verificar resultado
        System.out.println("1: " + mapa2.buscar(1)); // Esperado: abacate
        System.out.println("2: " + mapa2.buscar(2)); // Esperado: banana
        System.out.println("3: " + mapa2.buscar(3)); // Esperado: caju
    }

    public static void main(String[] args) {
        new TestesMapaDispersao();
    }
}
