package quiz.aplicacao.console;

import quiz.framework.QuizUI;
import quiz.framework.Pergunta;
import java.util.Scanner;

public class ConsoleUI implements QuizUI{
    Scanner sc = new Scanner(System.in);
    String respostaAtual;

    @Override
    public void exibePergunta(Pergunta pergunta){

        System.out.println("**************************************************************************");
        System.out.println(pergunta.getQuestao());
        System.out.println("**************************************************************************");
        int count = 0;
        for (String opcao : pergunta.getOpcoes()){
            count++;
            System.out.println(count + ")" + opcao + "\n");
        }

    }
    @Override
    public String usuarioResposta(){
        System.out.println("\n¬¬¬¬¬¬¬ Resposta do Usuário(+3 pontos para acerto, -1 ponto para erro): ");
        respostaAtual = sc.nextLine();
        return respostaAtual;
    }
    @Override
    public void feedback(Boolean acertou){
        if (acertou){System.out.println("BOA RESPOSTA!");}
        else{System.out.println("RESPOSTA HORROROSA!");}
    }
    @Override
    public boolean analisePergunta(Pergunta pergunta){
        if (pergunta.getOpcoes().stream().anyMatch(opcao -> opcao.equalsIgnoreCase(respostaAtual))){
            return true;
        }
        else{
            System.out.println("RESPOSTA FORA DAS OPCOES, TENTE NOVAMENTE!");
            return false;}}

     @Override
    public void exibePontuacaoFinal(int acertos, int erros, int pontFinal){
        System.out.println("\n*******************************************\n ENCERRANDO O QUIZ \n*******************************************");
        System.out.println("\nESTATÍSTICAS:");
        System.out.println("\n");
        System.out.println("Acertos: " + acertos);
        System.out.println("Erros: " + erros);
        System.out.println("Pontuacao Final: " + pontFinal);

    }
}
