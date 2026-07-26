package quiz.framework;

import java.util.ArrayList;
import java.util.List;

public class QuizTemplate {
    private PontuacaoStrategy pontuacaoStrategy;
    private List<JogadorObserver> listaJogadores;
    private List<Pergunta> listaPerguntas;

    public QuizTemplate(PontuacaoStrategy pontuacaoStrategy, List<Pergunta> listaPerguntas) {
        if (pontuacaoStrategy != null) {
            this.pontuacaoStrategy = pontuacaoStrategy;
        }
        if (listaPerguntas != null) {
            this.listaPerguntas = listaPerguntas;
        }
        this.listaJogadores = new ArrayList<>();
    }

    public void registrarJogador(JogadorObserver jogadorAtual) {
        if (jogadorAtual != null) {
            this.listaJogadores.add(jogadorAtual);
        }
    }

    public void iniciarQuiz() {
        if (listaPerguntas != null && !listaPerguntas.isEmpty() && listaJogadores != null && !listaJogadores.isEmpty()) {
            for (Pergunta perguntaAtual : listaPerguntas) {
                for (JogadorObserver jogadorAtual : listaJogadores) {
                    if (jogadorAtual != null) {
                        jogadorAtual.receberNovaPergunta(perguntaAtual);
                        String respostaCapturada = jogadorAtual.enviarResposta();

                        if (respostaCapturada != null) {
                            processarResposta(perguntaAtual, respostaCapturada, jogadorAtual);
                        }
                    }
                }
            }

            for (JogadorObserver jogadorAtual : listaJogadores) {
                if (jogadorAtual != null) {
                    jogadorAtual.receberResultadoFinal();
                }
            }
        }
    }

    private void processarResposta(Pergunta perguntaAtual, String respostaCapturada, JogadorObserver jogadorAtual) {
        if (perguntaAtual != null && respostaCapturada != null && jogadorAtual != null) {
            boolean acertou = respostaCapturada.trim().equalsIgnoreCase(perguntaAtual.getResposta().trim());
            int pontos = pontuacaoStrategy.calculaPontuacao(acertou);

            jogadorAtual.atualizarPlacar(pontos, acertou);
        }
    }
}