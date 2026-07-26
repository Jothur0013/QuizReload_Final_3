package quiz.aplicacao.swing;

import quiz.framework.AnnotationProcessor;
import quiz.framework.ConfiguracaoQuiz;

@ConfiguracaoQuiz(
        strategy = PontuacaoProgramacao.class,
        fabric = PerguntaFactoryProgramacao.class,
        ui = SwingUI.class
)
public class MainSwing {
    public static void main(String[] args) {
        AnnotationProcessor.iniciar(MainSwing.class);
    }
}