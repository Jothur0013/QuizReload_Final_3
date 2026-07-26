package quiz.framework;

public class Jogador implements JogadorObserver {
    private QuizUI quizUi;
    private int pontuacaoTotal = 0;
    private int acertos = 0;
    private int erros = 0;

    public Jogador(QuizUI quizUi) {
        if (quizUi != null) {
            this.quizUi = quizUi;
        }
    }

    @Override
    public void receberNovaPergunta(Pergunta perguntaAtual) {
        if (perguntaAtual != null && this.quizUi != null) {
            this.quizUi.exibePergunta(perguntaAtual);
        }
    }

    @Override
    public String enviarResposta() {
        if (this.quizUi != null) {
            return this.quizUi.usuarioResposta();
        }
        return null;
    }

    @Override
    public void atualizarPlacar(int pontosGanhos, boolean acertou) {
        this.pontuacaoTotal += pontosGanhos;
        if (acertou) {
            this.acertos++;
        } else {
            this.erros++;
        }
        if (this.quizUi != null) {
            this.quizUi.feedback(acertou);
        }
    }

    @Override
    public void receberResultadoFinal() {
        if (this.quizUi != null) {
            this.quizUi.exibePontuacaoFinal(this.acertos, this.erros, this.pontuacaoTotal);
        }
    }
}