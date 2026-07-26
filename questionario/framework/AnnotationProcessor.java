package quiz.framework;

import java.lang.reflect.Method;
import java.util.List;

public class AnnotationProcessor {

    public static void iniciar(Class<?> classePrincipal) {
        if (classePrincipal != null) {
            if (classePrincipal.isAnnotationPresent(ConfiguracaoQuiz.class)) {
                try {
                    ConfiguracaoQuiz configuracaoAtual = classePrincipal.getAnnotation(ConfiguracaoQuiz.class);

                    if (configuracaoAtual != null) {
                        PontuacaoStrategy estrategiaInjetada = configuracaoAtual.strategy().getDeclaredConstructor().newInstance();
                        QuizUI interfaceInjetada = configuracaoAtual.ui().getDeclaredConstructor().newInstance();

                        Object fabricaInjetada = configuracaoAtual.fabric().getDeclaredConstructor().newInstance();
                        Method metodoCriarPerguntas = configuracaoAtual.fabric().getMethod("criarPerguntas");

                        @SuppressWarnings("unchecked")
                        List<Pergunta> perguntasInjetadas = (List<Pergunta>) metodoCriarPerguntas.invoke(fabricaInjetada);

                        if (estrategiaInjetada != null && interfaceInjetada != null && perguntasInjetadas != null) {
                            QuizTemplate motorQuiz = new QuizTemplate(estrategiaInjetada, perguntasInjetadas);
                            Jogador jogadorPrincipal = new Jogador(interfaceInjetada);

                            motorQuiz.registrarJogador(jogadorPrincipal);
                            motorQuiz.iniciarQuiz();
                        }
                    }
                } catch (Exception excecaoGerada) {
                    System.err.println("Erro ao processar anotações: " + excecaoGerada.getMessage());
                }
            }
        }
    }
}