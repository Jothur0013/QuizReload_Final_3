package quiz.aplicacao.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import quiz.framework.Pergunta;
import quiz.framework.PerguntaFactory;

public class PerguntaFactoryConsole  implements PerguntaFactory {

    @Override
    public List<Pergunta> criarPerguntas() {
        List<Pergunta> perguntasJ = new ArrayList<>();

        perguntasJ.add(new Pergunta("Orcas são?", Arrays.asList("Baleias", "Peixes", "Golfinhos", "Tubaroes" ), "Golfinhos"));
        perguntasJ.add(new Pergunta("Qual o maior time brasileiro na libertadores?", Arrays.asList("Flamengo", "Fluminense", "Palmeiras", "Sao Paulo"), "Flamengo"));
        perguntasJ.add(new Pergunta("Qual a campeã da copa do mundo 2026?", Arrays.asList("Espanha", "Brasil", "Franca", "Cabo Verde"), "Espanha"));

         return perguntasJ;
    }
}
