package quiz.aplicacao.console;

import quiz.framework.AnnotationProcessor;
import quiz.framework.ConfiguracaoQuiz;

@ConfiguracaoQuiz(
        strategy = PontuacaoConsole.class,
        fabric = PerguntaFactoryConsole.class,
        ui = ConsoleUI.class
)
public class MainConsole {
    public static void main(String[] args) {
        AnnotationProcessor.iniciar(MainConsole.class);
    }
}