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
                "Qual conceito da POO permite que uma classe herde atributos e métodos de outra?",
                Arrays.asList(
                        "A)Encapsulamento",
                        "B)Herança ",
                        "C) Polimorfismo"
                ),
                "B"
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
