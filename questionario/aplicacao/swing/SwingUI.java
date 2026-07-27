package quiz.aplicacao.swing;



import quiz.framework.Pergunta;
import quiz.framework.QuizUI; // Lembre-se de importar a interface do framework
import javax.swing.JOptionPane;
import java.util.List;

public class SwingUI implements QuizUI {

    private String textoPerguntaAtual;
    private String ultimaResposta;

    @Override
    public void exibePergunta(Pergunta pergunta) {
        // Montamos o texto que vai aparecer na janelinha
        StringBuilder sb = new StringBuilder();
        sb.append(pergunta.getQuestao()).append("\n\n");

        List<String> opcoes = pergunta.getOpcoes();
        for (String opcao : opcoes) {
            sb.append(opcao).append("\n");
        }

        this.textoPerguntaAtual = sb.toString();
    }

    @Override
    public String usuarioResposta() {
        // Exibe a janela com a pergunta e o campo de texto para digitar a resposta
        this.ultimaResposta = JOptionPane.showInputDialog(
                null,
                textoPerguntaAtual + "\n\nDigite a sua resposta (Ex: A, B, C):",
                "Quiz de Programação",
                JOptionPane.QUESTION_MESSAGE
        );

        // Se o usuário clicar em "Cancelar", tratamos como vazio
        if (this.ultimaResposta == null) {
            this.ultimaResposta = "";
        }
        return this.ultimaResposta;
    }



    @Override
    public void feedback(Boolean acertou) {
        if (acertou) {
            JOptionPane.showMessageDialog(null, "Resposta Correta! Muito bem.", "Feedback", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Resposta Incorreta...", "Feedback", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void exibePontuacaoFinal(int acertos, int erros, int pontFinal) {
        String resultado = "Fim de Jogo!\n\n" +
                "Acertos: " + acertos + "\n" +
                "Erros: " + erros + "\n" +
                "Pontuação Final: " + pontFinal;

        JOptionPane.showMessageDialog(null, resultado, "Resultado Final", JOptionPane.INFORMATION_MESSAGE);
    }
 }