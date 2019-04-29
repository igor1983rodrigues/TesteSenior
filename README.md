# Proposta de teste destinada � Senior Sistemas

## Sum�rio
* Introdu��o
* Proposta
* Informa��es iniciais
* Arquitetura do projeto
* Tecnologias envolvidas

## Introdu��o
Para que seja poss�vel uma aloca��o, foi desenvolvido um projeto de teste para a Senior Sistemas, visando atender melhor suas necessidades. O projeto destina-se a avalia��o de c�digo fonte back-end, front-end e conhecimentos em banco de dados. � seguir, irei detalhar a proposta.
 
## Proposta
A proposta visa uma aplica��o onde um produto � solicitado. Este produto precisa ter informa��es do solicitante, o valor destinado e o produto em si. Feita a solicita��o, o almoxarife ter� acesso �s solicita��es abetas, e poder� decidir em aprovar ou reprovar. Caso a proposta for reprovada, dever� informar um motivo. A administra��o poder� checar todas as propostas, aprovadas, reprovadas, ou pendentes, e poder� filtrar.
Para atender a proposta, foi criada uma tela de login, onde o usu�rio poder� ter um perfil de almoxarife ou administra��o. Caso n�o for feito login, o usu�rio ter� somente a tela para fazer solicita��es.

## Informa��es iniciais
Antes de mais nada, deve ser executado o script "script.sql", contido na ra�z do projeto.
Existem dois projetos de back-end na ra�z, porque inicialmente foi desenvolvido usando JAX-RS. Devido dificuldades com Cors, esse projeto foi abandonado, e iniciado outro, utilizando Spring Boot. O primeiro foi mantido porque se tratou de esfor�o/hora, para dar uma posi��o devido o tempo de desenvolvimento. Obviamente, o primeiro projeto dever� ser ignorado.
 
## Arquitetura do projeto
A arquitetura conta com a seguinte estrutura:
raiz
|
|__TesteSeniorFrontEnd (C�digo fonte da aplica��o front-end)
|
|__TesteSeniorJAXRS (Projeto abandonado, apenas dispon�vel para ler o c�digo fonte)
|
|__TesteSeniorSB (Projeto Back-end oficial, que ser� usado para start da aplica��o)
|
|__scripts.sql (Deve ser executado antes de startar a primeira vez)

## Tecnologias envolvidas
* Spring Boot
* Angular 7
* Bootstrap 4
* NGX Bootstrap
* NGX Currency
* Hibernate 5
* JPA 2
* JQuery
* Font Awesome
