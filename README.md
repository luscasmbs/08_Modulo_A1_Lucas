# Aprender+

Aplicativo Android educacional desenvolvido em Kotlin com Jetpack Compose, Material 3 e Navigation Compose.

O projeto apresenta uma tela inicial com acesso a três atividades:

* Quiz My Brain;
* MemoCheck;
* Genius Play.

O desenvolvimento faz parte da atividade do Módulo A1. O objetivo desta entrega não é apresentar todas as funcionalidades finalizadas, mas demonstrar até onde foi possível avançar utilizando os conteúdos estudados até o momento, como criação de telas, componentes visuais, estado básico, botões, listas, organização em Composables e navegação entre telas.

## Como executar

1. Abra o projeto no Android Studio em uma versão estável.
2. Aguarde o Gradle Sync finalizar.
3. Selecione um emulador Android ou conecte um dispositivo físico.
4. Execute o aplicativo pelo botão **Run** do Android Studio.

Execução pelo terminal no Windows:

```powershell
.\gradlew.bat assembleDebug
```

Para instalar o aplicativo em um dispositivo ou emulador conectado:

```powershell
.\gradlew.bat installDebug
```

Caso o terminal não encontre o Java, é possível utilizar temporariamente o JDK incluído no Android Studio:

```powershell
$env:JAVA_HOME='C:\Program Files\Android\Android Studio\jbr'
.\gradlew.bat assembleDebug
```

## Funcionalidades implementadas

Até o momento, foram implementadas as seguintes funcionalidades:

* Tela inicial do aplicativo.
* Exibição das opções de atividades disponíveis.
* Navegação da tela inicial para as telas:

  * Quiz My Brain;
  * MemoCheck;
  * Genius Play.
* Uso de Navigation Compose.
* Botão de voltar nas telas.
* Retorno para a tela anterior utilizando `popBackStack()`.
* Cabeçalhos com título centralizado.
* Identidade visual baseada nas cores do projeto.
* Estrutura visual inicial do Quiz My Brain.
* Texto reservado para apresentação da pergunta.
* Botões iniciais “Encerrar” e “Próximo”.
* Estrutura visual inicial do MemoCheck.
* Exibição de oito cartas na tela do MemoCheck.
* Estrutura inicial da tela Genius Play.
* Organização do código em telas e componentes Composable.

## Funcionalidades pendentes

As funcionalidades principais dos jogos ainda não foram completamente implementadas.

### Tela inicial

Ainda falta implementar:

* Fechar o aplicativo ao clicar na opção “Sair”.
* Confirmar o encerramento do aplicativo, caso seja necessário.
* Testar todos os acessos às atividades.
* Ajustar a interface para diferentes tamanhos de tela.

A ação esperada para fechar o aplicativo pode utilizar a `Activity` atual:

```kotlin
val context = LocalContext.current

(context as? Activity)?.finish()
```

Essa funcionalidade ainda precisa ser conectada corretamente ao botão “Sair”.

## Quiz My Brain

A tela inicial do Quiz My Brain já possui:

* Ícone de voltar.
* Título “Quiz My Brain”.
* Área reservada para o texto da pergunta.
* Estrutura inicial do botão “Encerrar”.
* Estrutura inicial do botão “Próximo”.

A lógica completa do quiz ainda está pendente.

### Carregamento das questões

As questões devem ser recuperadas do arquivo:

```text
bancoQuestoes.json
```

O arquivo foi fornecido na pasta `media-files`.

Ainda falta implementar:

* Adicionar o arquivo JSON à estrutura adequada do projeto.
* Ler o conteúdo do JSON.
* Converter o JSON em objetos Kotlin.
* Criar os modelos de dados das questões.
* Recuperar o tipo de cada questão.
* Recuperar o peso de cada questão.
* Recuperar alternativas e respostas corretas.
* Controlar qual questão está sendo apresentada.
* Identificar quando todas as questões foram concluídas.

### Tipos de questão

O arquivo JSON pode possuir três tipos de questão:

| Tipo  | Significado         | Tela correspondente         |
| ----- | ------------------- | --------------------------- |
| `ME`  | Múltipla Escolha    | QuizMyBrain-MultiplaEscolha |
| `VF`  | Verdadeiro ou Falso | QuizMyBrain-TrueFalse       |
| `REL` | Relacione           | QuizMyBrain-Relacione       |

O aplicativo deverá verificar o tipo da questão atual e apresentar os componentes correspondentes.

Uma possível estrutura para essa decisão será:

```kotlin
when (questao.tipo) {
    "ME" -> {
        // Apresentar múltipla escolha
    }

    "VF" -> {
        // Apresentar verdadeiro ou falso
    }

    "REL" -> {
        // Apresentar questão de relacionar
    }
}
```

Essa seleção dinâmica de telas ainda não foi implementada.

## Quiz My Brain — Múltipla Escolha

### Componentes visuais solicitados

A tela de múltipla escolha deverá apresentar:

* Ícone de voltar.
* Texto “Quiz My Brain”.
* Texto da questão.
* Caixas com as alternativas.
* Letra de cada alternativa.
* Texto de cada alternativa.
* Botão “Encerrar”.
* Botão “Próximo”.

### Funcionalidades pendentes

Ainda falta implementar:

* Carregar os dados da questão pelo JSON.
* Garantir que a questão apresentada seja do tipo `ME`.
* Exibir as letras das alternativas.
* Exibir os textos das alternativas.
* Permitir selecionar uma alternativa.
* Destacar visualmente a alternativa selecionada.
* Remover o destaque da opção anterior quando outra for escolhida.
* Permitir apenas uma alternativa selecionada.
* Manter a tela somente na orientação retrato.
* Comparar a alternativa selecionada com a resposta correta.
* Atualizar o score conforme o peso da questão.

O botão “Próximo” deverá possuir dois comportamentos.

No primeiro clique:

1. Verificar a resposta selecionada.
2. Destacar a resposta correta com uma terceira cor.
3. Manter a questão atual na tela.
4. Somar o peso ao score em caso de acerto.

No segundo clique:

1. Limpar a seleção atual.
2. Avançar para a próxima questão.
3. Apresentar a tela adequada ao tipo da próxima questão.

Ao clicar em “Encerrar”, o aplicativo deverá:

1. Encerrar imediatamente o questionário.
2. Apresentar o score obtido até aquele momento.
3. Retornar para a tela inicial.

## Quiz My Brain — Verdadeiro ou Falso

### Componentes visuais solicitados

A tela de verdadeiro ou falso deverá apresentar:

* Ícone de voltar.
* Texto “Quiz My Brain”.
* Texto da questão.
* Caixa com o texto “Falso”.
* Caixa com o texto “Verdadeiro”.
* Botão “Encerrar”.
* Botão “Próximo”.

### Funcionalidades pendentes

Ainda falta implementar:

* Carregar a questão pelo arquivo JSON.
* Garantir que a questão apresentada seja do tipo `VF`.
* Selecionar a opção “Falso” por clique.
* Selecionar a opção “Verdadeiro” por clique.
* Destacar visualmente a opção selecionada.
* Remover o destaque da opção contrária.
* Permitir somente uma seleção.
* Manter a tela apenas na orientação retrato.
* Comparar a resposta com a resposta correta do JSON.
* Atualizar o score conforme o peso da questão.

Também deverá ser possível selecionar a resposta por meio do movimento físico do dispositivo.

O comportamento solicitado é:

* Giro no sentido horário seleciona a opção posicionada à direita.
* Giro no sentido anti-horário seleciona a opção posicionada à esquerda.
* Selecionar uma opção desmarca automaticamente a opção contrária.
* O usuário pode responder por clique ou pelo giro do aparelho.

Ao entrar na tela, também deve ser apresentada uma animação 2D explicando o funcionamento da seleção por rotação.

Essas funcionalidades de sensores e animação ainda não foram implementadas.

Ao clicar em “Encerrar”, o questionário deverá:

1. Ser finalizado imediatamente.
2. Exibir a pontuação atual.
3. Retornar para a tela inicial.

Ao clicar em “Próximo”, deverá:

1. Verificar a resposta.
2. Atualizar o score.
3. Carregar a próxima questão.
4. Apresentar a tela correspondente ao novo tipo de questão.

## Quiz My Brain — Relacione

### Componentes visuais solicitados

A tela de relacionar deverá apresentar:

* Ícone de voltar.
* Texto “Quiz My Brain”.
* Texto da questão.
* Três caixas contendo os termos.
* Três caixas contendo os conceitos.
* Botão “Encerrar”.
* Botão “Próximo” ou “Avançar”.

### Funcionalidades pendentes

Ainda falta implementar:

* Carregar os termos pelo arquivo JSON.
* Carregar os conceitos pelo arquivo JSON.
* Garantir que a questão apresentada seja do tipo `REL`.
* Apresentar a tela somente na orientação paisagem.
* Permitir arrastar um termo.
* Detectar a caixa de conceito em que o termo foi solto.
* Relacionar visualmente o termo e o conceito.
* Impedir que um item seja relacionado mais de uma vez.
* Permitir corrigir uma relação.
* Verificar se as relações estão corretas.
* Atualizar o score conforme o peso da questão.

O resultado da relação deverá seguir o formato apresentado no briefing.

Exemplo:

```text
Termo: TI
Conceito: Tecnologia da Informação

Resultado: Tecnologia da Informação: TI
```

Ao clicar em “Encerrar”, o aplicativo deverá:

1. Finalizar o questionário.
2. Apresentar o score obtido.
3. Retornar para a tela inicial.

Ao clicar em “Avançar” ou “Próximo”, deverá:

1. Verificar as relações realizadas.
2. Atualizar o score.
3. Carregar a próxima questão.
4. Alterar a interface e a orientação conforme o novo tipo.

## Score do Quiz My Brain

O score deverá representar a soma dos pesos das questões respondidas corretamente.

Cada questão possui um peso recuperado do arquivo JSON.

Uma possível lógica será:

```kotlin
if (respostaSelecionada == questao.respostaCorreta) {
    score += questao.peso
}
```

Ainda falta implementar:

* Variável para armazenar o score.
* Recuperação do peso pelo JSON.
* Comparação das respostas.
* Soma dos pesos.
* Proteção contra pontuação duplicada.
* Preservação do score ao mudar de questão.
* Preservação do score durante recomposições.
* Exibição do resultado final.

Ao terminar todas as questões, o aplicativo deverá:

1. Somar os pesos das questões acertadas.
2. Apresentar a pontuação total.
3. Informar que o quiz foi finalizado.
4. Retornar para a tela inicial.

## MemoCheck

A tela inicial do MemoCheck já possui:

* Botão de voltar.
* Título “MemoCheck”.
* Oito cartas organizadas visualmente.
* Uso das cores da identidade visual.

A lógica do jogo da memória ainda não foi implementada.

### Funcionalidades pendentes

Ainda falta implementar:

* Permitir clicar nas cartas.
* Virar a carta selecionada.
* Exibir um símbolo, número ou imagem.
* Criar quatro pares.
* Embaralhar as posições das cartas.
* Armazenar a primeira carta selecionada.
* Armazenar a segunda carta selecionada.
* Comparar as duas cartas.
* Manter abertas as cartas iguais.
* Virar novamente as cartas diferentes.
* Bloquear temporariamente novos cliques durante a comparação.
* Contabilizar os pares encontrados.
* Detectar o término da partida.
* Apresentar uma mensagem de conclusão.
* Criar uma opção para reiniciar o jogo.
* Preservar o estado das cartas durante recomposições.

Uma possível estrutura de dados para uma carta será:

```kotlin
data class MemoCard(
    val id: Int,
    val value: String,
    val isFlipped: Boolean,
    val isMatched: Boolean
)
```

Essa estrutura ainda precisa ser criada e integrada à tela.

## Genius Play

A tela Genius Play possui atualmente apenas sua estrutura inicial e o botão de voltar.

Ainda falta criar a interface e toda a lógica do jogo.

### Componentes visuais pendentes

A tela deverá possuir:

* Título “Genius Play”.
* Botões coloridos.
* Botão para iniciar.
* Indicação da rodada.
* Indicação do score.
* Mensagem de erro ou acerto.
* Opção para reiniciar.

### Funcionalidades pendentes

Ainda falta implementar:

* Criar os botões coloridos.
* Gerar uma sequência aleatória.
* Armazenar a sequência gerada.
* Apresentar a sequência ao usuário.
* Destacar cada botão durante a apresentação.
* Controlar o intervalo entre os destaques.
* Permitir que o usuário repita a sequência.
* Armazenar os cliques do usuário.
* Comparar a sequência do usuário com a sequência correta.
* Avançar de rodada após o acerto.
* Aumentar a sequência a cada rodada.
* Encerrar a partida após um erro.
* Exibir a pontuação final.
* Reiniciar o jogo.

Uma possível representação inicial das cores será:

```kotlin
val sequence = mutableListOf<Int>()
```

Cada número poderá representar um botão colorido. Entretanto, a geração, apresentação e comparação da sequência ainda precisam ser estudadas e implementadas.

## Arquitetura e organização

A estrutura principal do projeto está organizada por responsabilidade:

| Pacote ou pasta   | Responsabilidade                             |
| ----------------- | -------------------------------------------- |
| `ui.screens`      | Telas principais do aplicativo               |
| `ui.components`   | Componentes reutilizáveis                    |
| `navigation`      | Rotas e navegação entre telas                |
| `ui.theme`        | Cores, tipografia e tema                     |
| `model`           | Modelos de dados que ainda serão utilizados  |
| `data`            | Leitura do JSON e armazenamento das questões |
| `res` ou `assets` | Arquivos de recursos e banco de questões     |

Estrutura aproximada do projeto:

```text
br.senai.aprenderplus
├── data
├── model
├── navigation
│   └── AppNavigation.kt
├── ui
│   ├── components
│   ├── screens
│   │   ├── Home.kt
│   │   ├── QuizMyBrain.kt
│   │   ├── MemoCheck.kt
│   │   └── GeniusPlay.kt
│   └── theme
└── MainActivity.kt
```

Os pacotes `data` e `model` ainda poderão ser criados ou ampliados durante a implementação do JSON e das regras dos jogos.

## Navegação

O aplicativo utiliza Navigation Compose.

As rotas atuais são:

| Rota          | Função                  |
| ------------- | ----------------------- |
| `home`        | Tela inicial            |
| `QuizMyBrain` | Tela inicial do quiz    |
| `MemoCheck`   | Tela do jogo da memória |
| `GeniusPlay`  | Tela do Genius          |

A navegação é controlada pelo `NavController`.

Exemplo para abrir uma tela:

```kotlin
navController.navigate("QuizMyBrain")
```

Exemplo para voltar:

```kotlin
navController.popBackStack()
```

Ainda falta organizar as rotas das diferentes telas do quiz ou definir se os três tipos de questão serão exibidos dentro de uma única rota.

## Estado no Jetpack Compose

As telas atuais possuem principalmente estado visual básico.

Para concluir as funcionalidades, será necessário controlar estados como:

* Questão atual.
* Alternativa selecionada.
* Resposta correta revelada.
* Score.
* Tipo da questão.
* Primeira carta selecionada.
* Segunda carta selecionada.
* Pares encontrados.
* Sequência do Genius.
* Posição atual da sequência.
* Rodada atual.

Possíveis recursos que deverão ser utilizados:

```kotlin
remember
```

```kotlin
mutableStateOf
```

```kotlin
rememberSaveable
```

Também poderá ser necessário utilizar um `ViewModel`, principalmente para manter os dados do quiz e evitar que o score seja perdido durante mudanças de configuração.

## Dificuldades encontradas

### Organização com Row e Column

Uma das dificuldades iniciais foi compreender a diferença entre os componentes:

* `Column`, que organiza os elementos verticalmente.
* `Row`, que organiza os elementos horizontalmente.

Também houve dificuldade para centralizar títulos e botões.

Foram utilizados recursos como:

```kotlin
Modifier.fillMaxWidth()
```

```kotlin
TextAlign.Center
```

```kotlin
Alignment.CenterVertically
```

```kotlin
Arrangement.Center
```

```kotlin
Modifier.weight(1f)
```

### Centralização do título

Como o botão de voltar ocupa espaço no lado esquerdo do cabeçalho, o título ficava deslocado.

Para compensar o espaço do botão, foi utilizado um `Spacer` de tamanho semelhante no lado direito:

```kotlin
Spacer(
    modifier = Modifier.width(48.dp)
)
```

Essa solução mantém o título visualmente centralizado sem utilizar uma `Box`.

### Navegação entre telas

Também houve dificuldade inicial para compreender o funcionamento do `NavController`.

Foi necessário aprender:

* Como criar uma rota.
* Como abrir uma tela.
* Como voltar para a tela anterior.
* Como passar funções de navegação para os Composables.

### Leitura do arquivo JSON

Ainda não sei implementar completamente a leitura do arquivo `bancoQuestoes.json`.

Será necessário estudar:

* Onde salvar o arquivo.
* Como abrir o arquivo no Android.
* Como ler seu conteúdo.
* Como converter o JSON em objetos Kotlin.
* Como representar tipos diferentes de questão.
* Como tratar campos diferentes para `ME`, `VF` e `REL`.

### Mudança dinâmica dos tipos de questão

Outra dificuldade é alterar os componentes visuais conforme o tipo da questão.

A interface precisa mudar sem perder:

* A questão atual.
* A resposta selecionada.
* O score.
* A posição do usuário no quiz.

Ainda é necessário definir se cada tipo terá um Composable próprio ou se todos serão controlados por uma tela principal.

### Orientação da tela

Ainda não sei implementar corretamente as funções relacionadas à orientação da tela.

O briefing exige:

* Questões `ME` somente no modo retrato.
* Questões `VF` somente no modo retrato.
* Questões `REL` somente no modo paisagem.

Também será necessário voltar para a orientação correta quando a próxima questão tiver um tipo diferente.

As principais dificuldades são:

* Bloquear a tela em retrato.
* Bloquear a tela em paisagem.
* Alterar a orientação durante o quiz.
* Preservar os estados após a rotação.
* Evitar que os componentes saiam da tela.
* Criar layouts adaptáveis.

Recursos que ainda precisam ser estudados:

* `LocalConfiguration`.
* `requestedOrientation`.
* `ActivityInfo.SCREEN_ORIENTATION_PORTRAIT`.
* `ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE`.
* `rememberSaveable`.
* Configurações no `AndroidManifest.xml`.

### Seleção por movimento no Verdadeiro ou Falso

A questão `VF` precisa permitir selecionar uma resposta girando o dispositivo.

Ainda não sei implementar essa funcionalidade.

Será necessário estudar:

* `SensorManager`.
* Acelerômetro.
* Giroscópio.
* Registro de sensores.
* Detecção do sentido do movimento.
* Limites mínimos para considerar um giro.
* Prevenção contra várias seleções involuntárias.
* Atualização de estados do Compose a partir de sensores.

Também será necessário diferenciar o movimento usado para selecionar uma resposta da mudança real da orientação da tela.

### Animação 2D

A tela `VF` deverá apresentar uma animação em 2D mostrando ao usuário que ele pode girar o aparelho.

Ainda não sei criar essa animação.

Será necessário estudar:

* `animateFloatAsState`.
* `Animatable`.
* Rotação de componentes com `graphicsLayer`.
* Controle de duração da animação.
* Execução da animação quando a tela for aberta.

### Drag-and-drop

A tela `REL` exige relacionar os termos e conceitos por meio de arrastar e soltar.

Ainda não sei implementar essa funcionalidade.

Será necessário estudar:

* Eventos de gesto.
* `detectDragGestures`.
* Posição dos componentes.
* Deslocamento dos itens.
* Áreas de destino.
* Verificação da caixa em que o item foi solto.
* Atualização visual da relação.
* Validação da resposta.

Essa é uma das funcionalidades mais complexas do projeto porque envolve gestos, posições e regras de associação.

### Controle do score

O score precisa continuar existindo mesmo quando a interface muda entre questões de tipos diferentes.

Ainda é necessário estudar como:

* Manter o score em um estado superior.
* Impedir a soma duplicada de pontos.
* Preservar a pontuação em recomposições.
* Preservar a pontuação durante a rotação.
* Limpar o score ao iniciar um novo quiz.

Uma possível solução futura será utilizar um `ViewModel`.

### Funcionamento do MemoCheck

A principal dificuldade do MemoCheck é controlar duas cartas selecionadas ao mesmo tempo.

Será necessário armazenar:

* Primeira carta selecionada.
* Segunda carta selecionada.
* Cartas já encontradas.
* Cartas atualmente viradas.
* Momento em que as cartas devem ser escondidas novamente.

Também será necessário impedir que o usuário selecione uma terceira carta enquanto as duas anteriores estiverem sendo comparadas.

### Funcionamento do Genius Play

A principal dificuldade do Genius Play é controlar uma sequência que cresce a cada rodada.

Será necessário:

* Gerar valores aleatórios.
* Apresentar a sequência com intervalos.
* Bloquear os cliques durante a apresentação.
* Registrar os cliques do usuário.
* Comparar cada posição.
* Avançar ou finalizar a rodada.

Ainda não sei implementar corretamente o intervalo entre as cores e a animação dos botões.

## Decisões tomadas

Durante o desenvolvimento, foram priorizadas as funcionalidades já estudadas:

* Construção das telas.
* Navegação.
* Organização visual.
* Uso de `Row` e `Column`.
* Botões.
* Textos.
* Cores.
* Alinhamento.
* Componentes reutilizáveis.
* Controle inicial de eventos por funções lambda.

As funcionalidades mais avançadas foram deixadas como pendentes porque ainda exigem conteúdos não estudados ou que precisam de mais pesquisa, como:

* Sensores.
* Leitura e conversão de JSON.
* Mudança automática de orientação.
* Drag-and-drop.
* Animações.
* Controle avançado de estados.
* Sequências assíncronas.

## Testes realizados

Até o momento, foram realizados testes manuais para verificar:

* Abertura do aplicativo.
* Exibição da tela inicial.
* Abertura da tela Quiz My Brain.
* Abertura da tela MemoCheck.
* Abertura da tela Genius Play.
* Funcionamento do botão de voltar.
* Centralização dos títulos.
* Exibição dos oito quadrados do MemoCheck.
* Exibição da estrutura inicial do Quiz My Brain.
* Navegação entre as telas.

Ainda não foram criados testes unitários automatizados.

Também ainda precisam ser testados:

* Leitura do JSON.
* Cálculo do score.
* Seleção de alternativas.
* Sensores.
* Rotação de tela.
* Drag-and-drop.
* Lógica do MemoCheck.
* Sequência do Genius Play.
* Finalização do quiz.
* Botão “Sair”.

## Evidências

As evidências da execução poderão ser organizadas nos seguintes locais:

```text
EVIDENCIAS.md
evidencias/video-demo.mp4
evidencias/prints/
```

O arquivo `EVIDENCIAS.md` deverá relacionar cada imagem ou trecho do vídeo aos requisitos correspondentes.

Evidências recomendadas:

* Tela inicial.
* Navegação para o Quiz My Brain.
* Navegação para o MemoCheck.
* Navegação para o Genius Play.
* Botões de voltar.
* Cabeçalhos centralizados.
* Oito cartas do MemoCheck.
* Estrutura visual do Quiz My Brain.
* Estrutura visual do Genius Play.

Caso esses arquivos ainda não existam, eles deverão ser criados antes da entrega final.

## Limitações e pontos de atenção

* O botão “Sair” ainda não fecha o aplicativo.
* O arquivo `bancoQuestoes.json` ainda não está integrado.
* As questões ainda não são carregadas dinamicamente.
* A tela de múltipla escolha ainda não possui alternativas funcionais.
* A tela verdadeiro ou falso ainda não foi implementada.
* A seleção por giro do aparelho ainda não foi implementada.
* A animação 2D ainda não foi implementada.
* A tela Relacione ainda não foi implementada.
* O drag-and-drop ainda não foi implementado.
* O score ainda não foi implementado.
* A mudança entre retrato e paisagem ainda não foi implementada.
* A lógica do MemoCheck ainda não foi implementada.
* A lógica do Genius Play ainda não foi implementada.
* Ainda não existem testes unitários automatizados.
* A adaptação para diferentes tamanhos de tela precisa ser verificada.
* Algumas telas possuem apenas a estrutura visual inicial.
* É necessário conferir se as cores, textos e dimensões estão de acordo com os wireframes fornecidos.

## Próximos passos

1. Implementar o botão “Sair”.
2. Criar os modelos das questões.
3. Integrar o arquivo `bancoQuestoes.json`.
4. Implementar as questões de múltipla escolha.
5. Implementar as questões de verdadeiro ou falso.
6. Estudar e implementar sensores.
7. Criar a animação 2D da tela `VF`.
8. Implementar a tela Relacione.
9. Estudar e implementar drag-and-drop.
10. Criar o controle de score.
11. Implementar a finalização do quiz.
12. Implementar a lógica das cartas do MemoCheck.
13. Implementar a lógica do Genius Play.
14. Ajustar a orientação das telas.
15. Criar testes manuais completos.
16. Criar testes unitários quando possível.
17. Registrar evidências em vídeo e imagens.
18. Atualizar este README conforme as funcionalidades forem concluídas.

## Checklist da entrega

### Estrutura geral

* [x] Projeto criado em Kotlin.
* [x] Uso de Jetpack Compose.
* [x] Uso de Material 3.
* [x] Navegação entre as telas.
* [x] Organização inicial em pacotes.
* [x] Tela inicial criada.
* [ ] Botão “Sair” funcionando.
* [ ] Testes completos em dispositivo físico.

### Quiz My Brain

* [x] Estrutura visual inicial.
* [x] Cabeçalho com botão de voltar.
* [x] Título centralizado.
* [x] Área inicial da pergunta.
* [x] Estrutura inicial dos botões.
* [ ] Leitura do JSON.
* [ ] Questões de múltipla escolha.
* [ ] Questões de verdadeiro ou falso.
* [ ] Questões de relacionar.
* [ ] Seleção de alternativas.
* [ ] Correção das respostas.
* [ ] Controle do score.
* [ ] Resultado final.
* [ ] Orientação retrato.
* [ ] Orientação paisagem.
* [ ] Sensores.
* [ ] Animação 2D.
* [ ] Drag-and-drop.

### MemoCheck

* [x] Tela inicial criada.
* [x] Cabeçalho criado.
* [x] Oito cartas exibidas.
* [ ] Cartas clicáveis.
* [ ] Pares embaralhados.
* [ ] Comparação de cartas.
* [ ] Controle de pares encontrados.
* [ ] Finalização da partida.
* [ ] Reinício da partida.

### Genius Play

* [x] Arquivo da tela criado.
* [x] Botão de voltar criado.
* [ ] Interface dos botões coloridos.
* [ ] Geração da sequência.
* [ ] Apresentação da sequência.
* [ ] Entrada do usuário.
* [ ] Comparação da sequência.
* [ ] Controle de rodadas.
* [ ] Pontuação.
* [ ] Reinício do jogo.

### Documentação

* [x] README com o estado atual.
* [x] Funcionalidades implementadas registradas.
* [x] Funcionalidades pendentes registradas.
* [x] Dificuldades encontradas registradas.
* [x] Decisões tomadas registradas.
* [ ] Arquivo `EVIDENCIAS.md`.
* [ ] Prints da execução.
* [ ] Vídeo demonstrativo.

## Considerações finais

Eu tentei fazer até onde meu conhecimento conseguia e nesse curto período, logo mais eu tento ler mais sobre essas funções
