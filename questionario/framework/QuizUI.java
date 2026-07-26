package quiz.framework;

//São os métodos básicos necessários para a exibição da pergunta e seu corpo, da resposta final e tambem do resltado final
public interface QuizUI {
    public void exibePergunta(Pergunta pergunta);
    public String usuarioResposta();
    public boolean analisePergunta(Pergunta pergunta);
    public void feedback(Boolean acertou);
    public void exibePontuacaoFinal(int acertos, int erros, int pontuacaoFinal);
 }
