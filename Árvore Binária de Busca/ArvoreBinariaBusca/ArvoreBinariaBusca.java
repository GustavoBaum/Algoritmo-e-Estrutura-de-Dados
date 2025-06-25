public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbtract<T> {

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        NoArvoreBinaria<T> p = raiz;
        while (p != null && ((Comparable<T>) p.getInfo()).compareTo(info) < 0) {
            if (((Comparable<T>) info).compareTo(p.getInfo()) < 0) { // info < p.getInfo()
                p = p.getEsquerda();
            } else {
                p = p.getDireita();
            }
        }
        return p;
    }

    public void inserir(T info) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<T>(info);
        NoArvoreBinaria<T> p = raiz;
        NoArvoreBinaria<T> pai = null;

        if (raiz == null) {
            raiz = novo;
        } else {
            p = raiz;
            while (true) {
                pai = p;
                if (((Comparable<T>) info).compareTo(p.getInfo()) < 0) {
                    p = p.getEsquerda();
                    if (p == null) {
                        pai.setEsquerda(novo);
                        return;
                    }
                } else {
                    p = pai.getDireita();
                    if (p == null) {
                        pai.setDireita(novo);
                        return;
                    }
                }
            }
        }
    }

    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> excluir) {
        NoArvoreBinaria<T> atual = excluir.getDireita();
        NoArvoreBinaria<T> paiSucessor = excluir;
        NoArvoreBinaria<T> sucessor = excluir;

        while (atual != null) {
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda();
        }

        if (sucessor != excluir.getDireita()) {
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(excluir.getDireita());
        }

        return sucessor;
    }

    public void retirar(T info) {
        NoArvoreBinaria<T> p = raiz;
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;

        // Localizar o nó a ser removido:
        while (p != null && ((Comparable<T>) p.getInfo()).compareTo(info) != 0) {
            pai = p;
            if (((Comparable<T>) info).compareTo(p.getInfo()) < 0) {
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }

        if (p != null) {
            // Identifica que está removendo uma folha:
            if (p.getEsquerda() == null && p.getDireita() == null) {
                if (p == raiz) {
                    raiz = null;
                } else {
                    if (filhoEsquerda) {
                        pai.setEsquerda(null);
                    } else {
                        pai.setDireita(null);
                    }
                }
            }
            if (p.getDireita() == null) {
                if (p == raiz) {
                    raiz = p.getEsquerda();
                } else {
                    if (filhoEsquerda == true) {
                        pai.setEsquerda(p.getEsquerda());
                    } else {
                        pai.setDireita(p.getEsquerda());
                    }
                }
            } else {
                if (p.getEsquerda() == null) {
                    if (p == raiz) {
                        raiz = p.getDireita();
                    } else {
                        if (filhoEsquerda) {
                            pai.setEsquerda(p.getDireita());
                        } else {
                            pai.setDireita(p.getDireita());
                        }
                    }
                } else { // Nó com dois filhos
                    NoArvoreBinaria<T> sucessor = extrairSucessor(p);
                    if (p == raiz) {
                        raiz = sucessor;
                    } else {
                        if (filhoEsquerda) {
                            pai.setEsquerda(sucessor);
                        } else {
                            pai.setDireita(sucessor);
                        }
                    }
                    sucessor.setEsquerda(p.getEsquerda());
                }
            }
        }
    }
}
