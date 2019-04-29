# Proposta de teste destinada à Senior Sistemas

## Sumário
* Introdução
* Proposta
* Informações iniciais
* Arquitetura do projeto
* Tecnologias envolvidas

## Introdução
Para que seja possível uma alocação, foi desenvolvido um projeto de teste para a Senior Sistemas, visando atender melhor suas necessidades. O projeto destina-se a avaliação de código fonte back-end, front-end e conhecimentos em banco de dados. à seguir, irei detalhar a proposta.
 
## Proposta
A proposta visa uma aplicação onde um produto é solicitado. Este produto precisa ter informações do solicitante, o valor destinado e o produto em si. Feita a solicitação, o almoxarife terá acesso às solicitações abetas, e poderá decidir em aprovar ou reprovar. Caso a proposta for reprovada, deverá informar um motivo. A administração poderá checar todas as propostas, aprovadas, reprovadas, ou pendentes, e poderá filtrar.
Para atender a proposta, foi criada uma tela de login, onde o usuário poderá ter um perfil de almoxarife ou administração. Caso não for feito login, o usuário terá somente a tela para fazer solicitações.

## Informações iniciais
Antes de mais nada, deve ser executado o script "script.sql", contido na raíz do projeto.
Existem dois projetos de back-end na raíz, porque inicialmente foi desenvolvido usando JAX-RS. Devido dificuldades com Cors, esse projeto foi abandonado, e iniciado outro, utilizando Spring Boot. O primeiro foi mantido porque se tratou de esforço/hora, para dar uma posição devido o tempo de desenvolvimento. Obviamente, o primeiro projeto deverá ser ignorado.
 
## Arquitetura do projeto
A arquitetura conta com a seguinte estrutura:
raiz
|
|__TesteSeniorFrontEnd (Código fonte da aplicação front-end)
|
|__TesteSeniorJAXRS (Projeto abandonado, apenas disponível para ler o código fonte)
|
|__TesteSeniorSB (Projeto Back-end oficial, que será usado para start da aplicação)
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
