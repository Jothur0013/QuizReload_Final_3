package quiz.aplicacao.swing;

import quiz.framework.PontuacaoStrategy;

public class PontuacaoProgramacao implements PontuacaoStrategy {
    @Override
    public int calculaPontuacao(boolean acerto) {
        if (acerto) {
            return (67);
        } else {
            return -1000;
        }
    }
 }