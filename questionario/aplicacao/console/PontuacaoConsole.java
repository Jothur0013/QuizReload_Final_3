package quiz.aplicacao.console;

import quiz.framework.PontuacaoStrategy;
public class PontuacaoConsole implements PontuacaoStrategy{
    @Override
    public int calculaPontuacao(boolean acerto){
        if(acerto){return 3;}
         else {return -1;}
    }

}
