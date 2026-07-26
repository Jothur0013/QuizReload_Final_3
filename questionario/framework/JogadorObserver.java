package quiz.framework;

public interface JogadorObserver {
    void receberNovaPergunta(Pergunta perguntaAtual);
    String enviarResposta();
    void atualizarPlacar(int pontosGanhos, boolean acertou);
    void receberResultadoFinal();
}