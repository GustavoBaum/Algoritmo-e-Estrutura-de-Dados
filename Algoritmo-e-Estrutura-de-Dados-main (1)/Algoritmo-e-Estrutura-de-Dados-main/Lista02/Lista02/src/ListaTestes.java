public class ListaTestes {

    //@Test
    public void teste01() {
        ListaEstatica<Integer> lista = new ListaEstatica<Integer>(10);
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inverter();
        String valores = "20\n15\n10\n5";
        assertEquals(valores, lista.toString());
    }

    //@Test
    public void teste02() {
        ListaEstatica<Integer> lista = new ListaEstatica<Integer>(10);
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);
        lista.inverter();
        String valores = "25\n20\n15\n10\n5";
        assertEquals(valores, lista.toString());
    }

    //@Test
    public void teste03() {
        ListaEstatica<Pessoa> pessoas = new ListaEstatica<Pessoa>(10);
        pessoas.inserir(new Pessoa("P1", 10));
        
        Pessoa p = new Pessoa("P2", 20);
        pessoas.inserir(p);

        pessoas.inserir(new Pessoa("P3", 30));  
        assertEquals(pessoas.getTamanho(), 3);

        String dados = "Pessoa [nome=P1, idade=10]\n" + "Pessoa [nome=P2, idade=20]\n" + "Pessoa [nome=P3, idade=30]\n";
        assertEquals(pessoas.toString(), dados);

        pessoas.retirar(p);
        dados = "Pessoa [nome=P1, idade=10]\n" + "Pessoa [nome=P3, idade=30]\n";
        assertEquals(pessoas.toString(), dados);
    }

}
