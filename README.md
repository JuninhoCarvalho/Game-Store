
[![GameStore](https://github.com/JuninhoCarvalho/Game-Store/actions/workflows/maven.yml/badge.svg)](https://github.com/JuninhoCarvalho/Game-Store/actions/workflows/maven.yml)

<div align="center">
<h1>Game Store Application</h1>

<h4>Repositório destinado ao projeto de C214 (Engenharia de Software)</h4></br>

[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/)
[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org)
![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)
![NodeJS](https://img.shields.io/badge/node.js-6DA55F?style=for-the-badge&logo=node.js&logoColor=white)
<br/><br/>

</div>

<h2 align="center">Sobre o Game Store</h2>
Desenvolvida para atender ao projeto da matéria de Engenheria de Software do Inatel. A aplicação da Game Store contará 
incialmente com o BackEnd desenvolvido em Java utilizando o framework SpringBoot. Ao final do projeto teremos uma 
aplicação completa com FrontEnd, CI, Testes e a documentação para uso.
<br/><br/>

<h2 align="center">Ferramentas Necessárias</h2>

* [GitBah](https://git-scm.com/downloads) para executar comandos Git.
* Para o BackEnd será necessário:
    * Ter instalado o [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) (mínimo requerido). Para configurar o Java siga o seguinte [link](https://mauriciogeneroso.medium.com/configurando-java-4-como-configurar-as-variáveis-java-home-path-e-classpath-no-windows-46040950638f).
    * Ter instalado o [Maven](https://maven.apache.org/download.cgi). Para configurar o maven siga o seguinte [link](https://mkyong.com/maven/how-to-install-maven-in-windows/).
    * IDE para Java à sua escolha. [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows) é recomendado.
* Para o FrontEnd será necessário a instalação do [NodeJs](https://nodejs.org/en/download/).

<h2 align="center">Como Executar o Projeto</h2>

* Abra o GitBash em um local que deseja clonar o repositório e execute o seguinte comando:

```
$ git clone https://github.com/JuninhoCarvalho/GoT_Project.git
```

* Antes de executarmos o BackEnd precisamos baixar as dependências, para isso é preciso abrir o GitBash na pasta GameStore e executar o seguinte comando:

    ```
    $ mvn clean install
    ```

* Com a IDE escolhida executar o arquivo GameStoreApplication.java localizado em:
src/main/java/br/com/inatel/gamestore/GameStoreApplication.java

* Para executar o FrontEnd, clique com o botão direito na pasta "FrontEnd" e abrir o terminal do GitBash. Após abrir execute os seguintes comandos:
    ```
    $ npm install
    $ npm start
    ```
* Feitos esses passos a aplicação já estará pronta para uso.
* Os testes podem ser executados das seguintes maneiras:
    * Pela IDE, abrir o arquivo StoreServiceTest.java e dar run, localizado em: src/test/java/br/com/inatel/gamestore/service/StoreServiceTest.java
    * Ou abrir um terminal na pasta GameStore e executar o seguinte comando:
        ```
        $ mvn clean test
        ```

<h2 align="center">Autores</h2>

[![Badge](https://img.shields.io/static/v1?label=&message=Francisco+Jr&color=informational&style=for-the-badge&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/francisco-cjunior/)](https://www.linkedin.com/in/francisco-cjunior/)
![Badge](https://img.shields.io/static/v1?label=&message=Estheferson+&color=informational&style=for-the-badge&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/francisco-cjunior/)
[![Badge](https://img.shields.io/static/v1?label=&message=Davi+Restani&color=informational&style=for-the-badge&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/davi-restani-76194017a/)](https://www.linkedin.com/in/https://www.linkedin.com/in/davi-restani-76194017a/)
