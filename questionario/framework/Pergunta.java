package quiz.framework;

//Classe pergunta e seu corpo
import java.util.List;
public class Pergunta {
    private String questoes;
    private List<String> opcoes;
    private String resposta;
    public Pergunta(String questoes, List<String> opcoes, String resposta){
        this.questoes = questoes;
        this.opcoes = opcoes;
        this.resposta = resposta;
    }
     public String getQuestao() {
        return this.questoes;
    }
    public String getResposta(){
        return this.resposta;
    }
    public List<String> getOpcoes(){
        return this.opcoes;
    }
}
