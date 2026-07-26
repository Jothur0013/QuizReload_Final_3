package quiz.framework;

//Interface strategy para ser implementada nas diferentes possibilidades de calculo de pontuacao(precisamos saber se o usuário acertou)
public interface PontuacaoStrategy {
     public int calculaPontuacao(boolean acerto);
}
