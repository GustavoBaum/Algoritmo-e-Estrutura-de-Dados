import java.beans.Transient;

public class ListaTestes {

    //@Test
    void teste1() {
        ListaEstatica lista = new ListaEstatica();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals("5, 10, 15, 20", lista.toString());
    }

    //@Test
    void teste2() {
        ListaEstatica lista = new ListaEstatica();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(4, lista.getTamanho());
    }

    //@Test
    void teste3() {
        ListaEstatica lista = new ListaEstatica();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(2, lista.buscar(15));

        //teste4
        assertEquals(-1, lista.buscar(30));

        //teste5
        lista.retirar(10);
        assertEquals("5, 15, 20", lista.toString());
        assertEquals(3, lista.getTamanho());
    }

    //@Test
    void teste6() {
        ListaEstatica lista = new ListaEstatica();
        for (int i = 0; i <= 15; i++) {
            lista.inserir(i);
        }
        assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15", lista.toString());
        assertEquals(lista.getTamanho(15));
    }
    
    //@Test
    void teste7() {
        ListaEstatica lista = new ListaEstatica();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(20, lista.obterElemento(3));
        //assertEquals(20, lista.obterElemento(5));
    }

    //@Test
    void teste8() {
        ListaEstatica lista = new ListaEstatica();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertTrue(lista.estaVazia());
    }
}
