package quiz.aplicacao.swing;

import quiz.framework.Pergunta;
import quiz.framework.PerguntaFactory;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList ;
public class PerguntaFactoryProgramacao  implements PerguntaFactory {

    public List<Pergunta> criarPerguntas() {
        List<Pergunta> perguntas = new ArrayList<>();

        // Adiciona as perguntas usando a classe Pergunta do seu colega
        perguntas.add(new Pergunta(
                "O que é o Mito de Sísifo?",
                Arrays.asList(
                        "A) Mito de um homem destinado a carregar uma rocha contra uma montanha pela eternidade",
                        "B) Mito da Deusa do Amor e da Beleza",
                        "C) Mito do homem que perdeu sua mulher pelo seu orgulho."
                ),
                "A"
        ));

        perguntas.add(new Pergunta(
                "O que significa a sigla POO?",
                 Arrays.asList(
                        "A) Programação Orientada a Objetos.",
                        "B) Programação Orientada a AURA.",
                        "C) Padrão Orientado a Ordem."
                ),
                "A"
        ));

        return perguntas;
    }
}
