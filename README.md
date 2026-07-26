# Trabalho Final - Princípios e Padrões de Projetos

**Disciplina:** Princípios e Padrões de Projetos  
**Instituição:** BCC FACOM UFU  
**Professora:** Fabíola S. F. Pereira  
**Integrantes do Grupo:** Davi Cabeceira ,João Arthur e Leonardo Guimarães. 

---

## 1. Arquitetura do Sistema
O projeto foi desenvolvido com o objetivo de projetar e implementar um framework orientado a objetos para o desenvolvimento de aplicações do tipo Quiz. O foco principal foi garantir extensibilidade, reutilização, baixo acoplamento e alta coesão.

A arquitetura foi rigidamente dividida em dois pacotes principais:
* **Framework (`quiz.framework`):** Responsável por fornecer a infraestrutura genérica. Ele gerencia o fluxo do quiz, o controle de pontuação e as regras de negócio. Este núcleo interage com as camadas de exibição apenas por meio de abstrações, garantindo que não dependa diretamente de classes gráficas como Swing.
* **Aplicações Cliente (`quiz.aplicacao.programacao` e `quiz.aplicacao.console`):** Consomem o framework genérico para criar jogos específicos. São responsáveis por definir as perguntas, escolher a estratégia de pontuação e implementar a interface de exibição. Foram construídas duas aplicações diferentes (Swing e Console) sobre o mesmo núcleo de código-fonte.

## 2. Padrões de Projeto Obrigatórios Utilizados
Para prover a flexibilidade necessária ao framework, foram implementados os seguintes padrões de projeto:

* **Template Method:** 
  Aplicado no núcleo do framework para ditar o fluxo de execução do quiz (exibir pergunta, registrar resposta, validar e avançar). Ele fornece a estrutura básica do jogo, garantindo que a ordem das operações não seja alterada, enquanto as aplicações concretas preenchem as particularidades.

* **Strategy:** 
  Utilizado para abstrair as diferentes políticas de pontuação. Como o sistema precisa suportar regras variadas (ex: +10 pontos por acerto, +5 pontos, ou penalização por erro), o Strategy permite que cada aplicação cliente injete sua própria lógica de cálculo sem modificar o motor do framework.

* **Factory Method:** 
  Empregado para delegar a criação de conteúdo e interfaces. O framework não conhece as perguntas específicas de Matemática ou Programação; ele delega a instanciação desses objetos para fábricas concretas implementadas na camada da aplicação cliente, promovendo o encapsulamento e a alta coesão.

## 3. Desacoplamento da Interface de Exibição
O projeto cumpre o requisito de permitir a construção de interfaces gráficas variadas (como Java Swing e console). O pacote do framework interage exclusivamente com a abstração `QuizUI`. As classes responsáveis por renderizar a tela com `JOptionPane` (Swing) ou `Scanner` (Console) foram mantidas estritamente nos pacotes das aplicações clientes, configurando o quiz sem violar a arquitetura.

## 4. Implementações Opcionais e Funcionalidades Extras
Para estender as capacidades do framework e buscar a pontuação extra prevista nas instruções, a arquitetura previu a inclusão de:

* **Padrão Observer:** Implementado para permitir o suporte a múltiplos jogadores simultâneos, notificando os participantes sobre atualizações no estado do jogo e no placar de pontuação.
* **Annotations:** A infraestrutura do framework foi adaptada para ser baseada em anotações (processador de anotações Java), facilitando a configuração das perguntas e a injeção de dependências pela aplicação cliente de forma declarativa.
