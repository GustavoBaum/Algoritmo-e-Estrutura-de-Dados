public class ListaPrincipal {
    public static void main(String[] args) {
        ListasGenericasExp lista = new ListasGenericasExp<String>();
        lista.setInfo("Oi");
        System.out.println(lista.getInfo());

        lista = new ListasGenericasExp<Integer>();
        lista.setInfo(2);
        System.out.println(lista.getInfo());
    }
}