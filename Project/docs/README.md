# LPOO_700 Tetris

> Este projeto foi desenvolvido no âmbito da unidade curricular de LPOO. O projeto consiste numa versão text-based de um jogo de Tetris. O desenvolvimento deste projeto tem como principal objetivo colocar em prática os conceitos lecionados. De entre estes conceitos, destacam-se a identificação de Code Smells e a aplicação de Design Patterns na sua resolução. O projeto foi desenvolvido em Java o que nos permitiu também aplicar novos conceitos relacionados com esta linguagem de programação. 

## Funcionalidades Implementadas
> Foram implementadas as seguintes funcionalidades:
>- <strong>Movimento das peças através do teclado</strong>: As peças do jogo podem ser movimentadas através das teclas w,s,d e a. As teclas a,d e s deslocam as peças para a esquerda, direita e baixo, respetivamente. Já a tecla w é usada para rodar a peça no sentido horário.
>- <strong>Movimento das peças com a passagem do tempo</strong>: Para além da movimentação provocada pelo jogador, as peças movimentam-se para baixo uma posição a uma velocidade constante (a cada 300ms, ou seja, aproximadamente três vezes por segundo).
>- <strong>Eliminação das Linhas Preenchidas</strong>: Sempre que uma linha do jogo fica completamente preenchida com peças do jogo, esta linha é eliminada e o número de linhas removidas é aumentado.
>- <strong>Modo de Pausa</strong>: O jogador pode fazer uma pausa no jogo premindo a tecla 'P'. Para retomar o jogo, basta premir novamente a mesma.
>- <strong>Fim do Jogo</strong>: Quando alguma peça, após estar colocada, atingir o limite superior da área de jogo, este termina e o jogador perde.
>- <strong>Peça em Espera e Peças Seguintes</strong>: No ecrã de jogo, para além da área de jogo, pretendemos adicionar uma área com a pontuação do jogador, o número de linhas removidas, o tempo restante até ao fim do jogo, a peça em espera e as peças seguintes. A área correspondente às peças seguintes irá mostrar as próximas peças a surgir na área de jogo. Já a peça em espera, corresponde a uma peça que o jogador pode decidir não usar num determinado momento do jogo e guardar para usar mais tarde. O jogador apenas pode manter uma peça em espera, caso o jogador já tenha uma peça guardada e peça para guardar outra, a anterior será descartada.
>- <strong>Modo de 2 jogadores</strong>: Este modo permite que dois jogadores joguem localmente simultaneamente. Neste modo a eliminação de linhas por parte de um jogador faz com que o numero de linhas do outro jogador aumente complicando o seu jogo. O vencedor deste modo será o jogador que eliminar mais linhas no final do tempo ou se o jogador adversário chegar ao fim do jogo (topo da área de jogo).
![Multiplayer](images/Multiplayer.png?raw=true "Multiplayer")
>- <strong>Menus</strong>: Foram implementados vários menus, que permitirão a seleção dos modos de jogo, entre outras funcionalidades.
![Menu](images/Menus.png?raw=true "Menu")
>- <strong>Lanterna & Swing</strong>: O jogo foi implementado para duas interfaces gráficas diferentes: Lanterna e Swing.
![Swing](images/Multiplayer2.png?raw=true "Swing")

## Funcionalidades Planeadas
> Para além das funcionalidades referidas anteriormente, planeamos ainda implementar as seguintes funcionalidades:
>- <strong>Modo Personalizado</strong>: Este modo irá fazer com que a área de jogo no seu arranque não esteja vazia. O objetivo neste modo será carregar as diferentes opções possíveis a partir de ficheiros.
>- <strong>Highscores</strong>: As melhores pontuações deverão ser guardadas num ficheiro próprio e depois carregadas no programa de forma a poderem ser visualizadas.

> Estas funcionalidades não foram implementadas devido à falta de tempo para tal.

## Design

#### State
  >**Problem in Context**: Como fazer a passagem entre os vários ecrãs/estados possíveis (Jogo *Singleplayer* e *Multiplayer*, Menu principal, Menu "Game Over" e Menu de Instruções)?<br>
  >**The Pattern**: O padrão State permite que um determinado objeto efetue ações diferentes de acordo com o seu estado atual (contexto). Deste modo, os vários "ecrãs" são representados por estados, sendo que cada estado, no final, altera o contexto consoante a forma como correu.<br>
  >**Implementation**: ![UML - State](images/State.png?raw=true "State Design Pattern")<br>
  >**Consequences**: A utilização deste padrão permitiu uma maior simplificação da função run() da classe Handler, assim como a sua abstração dos vários estados e da passagem entre eles.<br>

#### Adapter
  >**Problem in Context**: Como implementar o mesmo jogo tendo como base duas interfaces gráficas diferentes, tentando simplificar ao máximo o código, através de um alto nível de abstração?<br>
  >**The Pattern**: O padrão Adapter pressupõe a existência de uma classe que permite obter um estrutura base/geral que, através da composição (neste caso específico), adapta duas (ou mais) estruturas que têm o mesmo propósito mas modos de funcionamento diferentes. <br>
  >**Implementation**: ![UML - Adapter](images/Adapter.png?raw=true "Adapter Design Pattern")<br>
  >**Consequences**: A utilização deste padrão permitiu a facilitação da utilização das duas interfaces gráficas (Lanterna e Swing) de uma forma fácil, rápida e intuitiva.<br>

#### MVC
  >**Problem in Context**: Como estruturar um projeto de forma a que a alteração de uma das suas partes (interface, processamento e dados) não implique a renovação de todo o projeto?<br>
  >**The Pattern**: A arquitetura MVC (Model - View - Controller) propõe a utilização da divisão do projeto em três partes diferentes: uma responsável por manter os dados (Model), uma responsável por fazer todo o processamento dos dados consoante inputs (Controller) e uma última responsável por receber inputs e fazer output dos dados. <br>
  >**Implementation**: ![UML - MVC](images/MVC.png?raw=true "MVC Architectural Pattern")<br>
  >**Consequences**: A utilização desta arquitetura permitiu uma melhor estruturação e segmentação do projeto. Durante a implementação do gui Swing permitiu apenas ter que alterar a "View", tornando a adição desta nova *feature* muito mais fácil.

## Code Smells conhecidos e sugestões de Refactoring

#### Code Smell 1 - Switch Statements
> A implementação da função "void processKey(T model, KeyEvent key, Q view)" nas classes MenuController e GameController baseia-se na existência de um *switch statement*. A existência de este tipo estrutura condicional é sempre algo que nos deve levar à análise do código para perceber se não há uma melhor alternativa.<br>
> Neste caso, não existe um melhor opção (pelo menos conhecida por nós) para resolver este code smell.

#### Code Smell 2 - Long Method & Duplicate Code
> O método correctRotation(GameArea area) é um método extremamente longo que efetua imensos cálculos. Uma solução para este problema passaria por subdividir este método em diversos métodos mais pequenos. O motivo pelo qual não o fizemos prende-se pelo facto de este código apenas ser utilizado no caso específico da chamada a correctRotation. Assim, optamos por fazer comentários ao código para melhor mostrar o cada secção faz, apesar de sabermos que esta não é a melhor solução.<br>
> Este método é também bastante repetitivo em termos de código. Apresenta, por 2 vezes, 4 secções de código que em muito pouco variam. Este code smell poderia ser facilmente resolvido, criando uma função auxiliar para estas secções semelhantes, que receberia como argumentos as poucas variáveis/funções que variavam de secção para secção. Esta solução por si só resolveria não só o code smell "Duplicate Code" mas também o "Long Method".

#### Code Smell 3 - Empty Interface
> A interface Model é uma interface completamente vazia. Isto chama-nos imediatamente à atenção para o facto de que algo pode estar errado. No entanto, esta interface é bastante útil na implementação da classe State, que sabemos que, à partida, terá de ter um atributo do tipo Model. Na instanciação de objetos que implementam State (como é o exemplo da classe Game e MenuGeneralization), o objeto model (do tipo M extends Model) já é declarado como sendo do tipo GameModel ou MenuModel.

#### Code Smell 4 - Message Chains
> Na classe GameController vemos muito a utilização de message chains (normalmente de tamanho 3), sendo que a maior parte delas iniciam-se por "area.getActivePiece()". Este code smell poderia ser facilmente resolvido se no início dos métodos se declara-se uma variável Piece=area.getActivePiece().

#### Code Smell 5 - Data Class
> As classes GameModel e MenuModel são classes que apenas possuem construtor e *getters*, sendo, claramente, classes de dados. No entanto, este *code smell* não chama a atenção para um problema efetivo, visto que este é precisamente o propósito destas classes, segundo o modelo MVC.

#### Code Smell 6 - Temporary Fields
> As classes GameViewAdapter e MenuViewAdapter possuem os atributos "vs" e "vl", que representam as suas views para as interfaces Swing e Lanterna, respetivamente. No entanto apenas uma das variáveis poderá ser usada (e inicializada), de facto, durante a execução do programa. Apesar de ser um code smell, foi a única solução encontrada para desenvolver os Adapter de forma eficaz e simples.

#### Code Smell 7 - Duplicate Code
> As classes GameViewAdapter e MenuViewAdapter são muito semelhantes em termos de código. Uma solução para este code smell passaria por criar uma classe abstrata "View Adapter" que seria constituída por estas funções semelhantes. Esta solução não foi levada adiante visto que a sua implementação poderia implicar a criação de mais duas classes abstratas/interfaces "GameView" e "MenuView", o que provocaria outros code smells: Lazy Class e exagero no número de classes abstratas/interfaces para resolver um problema simples.

## Resultados dos testes 
> Foram realizados diversos testes para as diferentes classes implementadas. Como é visível nos resultados dos testes não temos uma cobertura de linhas de código de 100% uma vez que existem algumas funções bastante básicas que consideramos não fazer sentido serem testadas. Existem, no entanto, bastantes mutações no nosso código que os testes não conseguem identificar fazendo com que apenas 341 das 901 geradas sejam, de facto, eliminadas. Consideramos que este resultado se deve, sobretudo, à dificuldade encontrada em realizar testes eficientes às funções de desenho implementadas. A primeira abordagem realizada nesse tipo de testes foi criar mocks de um Screen ou JFrame e utilizar a função verify do Mockito para verificar que as funções corretas eram chamadas o número certo de vezes. Porém, esta abordagem não funcionou devido a não termos encontrado uma forma de, não podendo inicializar o Screen ou JFrame respetivos, evitar que fossem lançadas exceções por apontadores nulos. As imagens mais representativas da qualidade dos nossos testes encontram-se abaixo. Para um relatório mais detalhado consultar a pasta "Reports" na pasta "docs".

![TestCoverage](images/TestCoverage.png?raw=true "Test Coverage")
![TestReport](images/TestReport.png?raw=true "Test Report")
![MutationCoverage](images/MutationCoverage.png?raw=true "Mutation and Line Coverage")

## Autoavaliação
> Este projeto foi desenvolvido de forma bastante linear e, ao contrário do que é normal, não modular. Deste modo, cada um dos elementos do grupo ia desenvolvendo o projeto, avaliando a fase em que se encontrava e trabalhando nele a partir daí. As aulas práticas foram essenciais para podermos discutir determinados detalhes, sendo que estas eram a única altura em que fazíamos uma divisão mais concreta de tarefas (para a aula).<br>
> De chamar a atenção que as estatísticas do git relativas a percentagem de commits e linhas de código não é, de todo, reveladora da percentagem de trabalho de cada elemento, visto que houve diversos momentos em que uma de nós analisava e desenvolvia o processamento que  o código deveria fazer em papel, enquanto que outra passava o processamento para linhas de código.<br>
> Deste modo, ambos os elementos do grupo trabalharam igualmente no projeto, dando o seu máximo para a concretização do mesmo.

## Alterações desde a Demonstração do Projeto
> Desde a demonstração deste projeto foram efetuadas diversas alterações que gostaríamos, desde já, salientar. Foram efetuadas algumas reestruturações do código melhorando-o a vários níveis. Deste modo, o MVC pattern foi melhorado tornando-se bastante mais explícito e foram adicionados o State pattern e dois adapters (GameViewAdapter e MenuViewAdapter) para permitir o uso de Lanterna e Swing sem necessitar de alterações nas componentes Model e Controller. Para além disto, foram ainda adicionados testes para as classes implementadas e as funções de desenho da view que utiliza Swing foram alteradas passando a incluir um override da função paintComponent que permite usar funções de repaint invés de forçar o desenho diretamente.
