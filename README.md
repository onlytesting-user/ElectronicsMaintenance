[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# API de Manutenção de Eletrônicos

Esta é uma simples API Java que fornece endpoints básicos para gerenciar serviços de manutenção de eletrônicos. Ela permite `criar`, `atualizar`, `deletar` e `listar` serviços, além de obter informações detalhadas sobre tais serviços de forma individual.

## Pré-requisitos

Para conseguir utilizar as funcionalidades deste softweare, é necessário possuir as ferramentas abaixo:

- **JDK:** um kit de ferramentas necessário para o desenvolvimento de aplicações Java. Atualmente, o JDK inclui o ambiente necessário para executar programas Java (JRE - Java Runtime Environment); o compilador (javac); e ferramentas que auxiliam o desenvolvimento, como _depuradores_, _bibliotecas_ e utilidades que facilitam o processo de criação, execução e testes de códigos Java.

    - **JDK:** https://www.oracle.com/java/technologies/downloads/#java17

<br>

- **Editor de código:** é uma ferramenta de software usada para escrever e editar o código-fonte de programas. Embora até mesmo o arcaico bloco de notas seja o suficiente para suprir tal função, é preferível utilizar um editor de código mais avançado que possua funcionalidades como: auto-complemento de código, destaque de sintaxe e integração com diversas ferramentas importantes ao desenvolvimento. Para funcionalidades avançadas de desenvolvimento, é recomendável o uso de uma `IDE` como o _IntelliJ_ ou _Eclipse_, mas se é necessário que o software seja portável, simples de usar e altamente customizável, o _Visual Studio Code_ torna-se ideal.

    - **Visual Studio Code:** https://code.visualstudio.com/download

<br>

- **Maven:** é uma ferramenta de automação de build e gerenciamento de dependências para projetos Java. Essencial utilizá-la para projetos que utilizem execução automática de testes, automação de build ou gerenciamento de bibliotecas externas, como é o caso deste projeto.

    - **Maven:** https://maven.apache.org/download.cgi?.

<br>

- **MySQL Server:** é um `sistema de gerenciamento de banco de dados` relacional que permite gerenciar, manipular e consultar dados armazenados em bancos de dados através da linguagem SQL. Sua eficiência, confiabilidade e suporte a grandes volumes de dados o fazem ser uma das opções mais populares para gerenciamento de dados. É rápido e eficiente no processamento de grandes volumes de dados, além de gratuito e disponível sob uma licença de código aberto (GPL). Uma solução alternativa é a utilização de um contêiner _Docker_ contendo a imagem do MySQL devidamente configurada para conexão com a aplicação.

    - **MySQL Server:** https://dev.mysql.com/downloads/mysql/

        Or

    - **Docker:** https://www.docker.com/products/docker-desktop/

<br>

- **MySQL Workbench:** Workbench é uma ferramenta gráfica (GUI) oficial fornecida para trabalhar com bancos de dados MySQL. Com ela, é possível escrever e executar consultas SQL com facilidade. Além disso, ela também oferece ferramentas para monitoramento de desempenho, otimização de performance, administração de usuários, permissões, backups, replicação, etc. Uma solução alternativa é a utilização do _DBeaver_, embora seja importante citar que ele não é uma interface de banco de dados exclusiva para o MySQL, abrangendo diversos dos mais famosos SGBDs relacionais do mercado em sua versão gratuita e até NoSQL em sua versão paga.

    - **MySQL Workbench:** https://dev.mysql.com/downloads/workbench/

        Or

    - **DBeaver:** https://dbeaver.io/download/

<br>

Embora possam ser considerados menos essenciais, sites como **Spring Initializr** e **Swagger Editor** são bastante úteis para gerar mais facilmente arquivos extremamente importantes para projetos Java, como o _pom.xml_ e o _swagger.yaml_, tendo ambos também a capacidade de automatizar a construção de diversos outros arquivos e testes do projeto. Ambos os sites agilizam enormemente o processo de desenvolvimento, tanto em sua fase de construção quanto em sua fase de testes.

- **Spring Initializr:** https://start.spring.io/

- **Swagger Editor:** https://editor.swagger.io/

## Versões

- **Java:** 17.0.12
- **Maven:** 3.9.9
- **MySQL Server:** 8.4.2
- **MySQL Workbench:** 8.0.38
- **Docker:** 27.2.0

## Extensões do VS Code:

Por não ser tão robusto quanto uma IDE, o VS Code necessita de plugins adicionais para poder alcançar um nível de desenvolvimento satisfatório para quem pretende usá-lo para programar em Java.

- **Extension Pack for Java:** Um pacote que engloba várias extensões extremamente importantes e necessárias para desenvolvimento com Java no VS Code. Sendo elas:

    - **Language Support for Java(TM) by Red Hat:** https://marketplace.visualstudio.com/items?itemName=redhat.java

    - **Debugger for Java:** https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug

    - **Test Runner for Java:** https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-test

    - **Maven for Java** https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven

    - **Project Manager for Java:** https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-dependency

    - **IntelliCode** https://marketplace.visualstudio.com/items?itemName=VisualStudioExptTeam.vscodeintellicode

## Endpoints

![Endpoints Swagger](assets/Imagem%20Endpoints%20Swagger.png)

### 1. Criar um novo serviço

#### POST `/services`
Cria um novo serviço de manutenção de eletrônicos.

### Corpo da requisição:

```json
{
  "nomeCliente": "João Victor",
  "telefoneContato": "+55 81 92897-4311",
  "emailContato": "joao.victor15@gmail.com",
  "tipoEletronico": "Notebook",
  "modeloEletronico": "Vaio FE15",
  "tipoServico": "Formatação",
  "statusServico": "PENDENTE",
  "valorServico": 149.99,
  "formaPagamento": "DINHEIRO"
}
```

### Resposta de sucesso:

- **Código:** 200 OK

### Corpo da resposta:

```json
{
  "idServico": "a3bb189e-8bf9-3888-9912-ace4e6543002",
  "nomeCliente": "João Victor",
  "telefoneContato": "+55 81 92897-4311",
  "emailContato": "joao.victor15@gmail.com",
  "tipoEletronico": "Notebook",
  "modeloEletronico": "Vaio FE15",
  "tipoServico": "Formatação",
  "statusServico": "PENDENTE",
  "valorServico": 149.99,
  "formaPagamento": "DINHEIRO",
  "dataInsercao": "2024-09-03T12:34:56Z",
  "dataAtualizacao": "2024-09-03T12:35:56Z"
}
```

<br>

### 2. Deletar um serviço por ID

#### DELETE `/services/delete/{id}`
Deleta um serviço existente com base em seu ID.

### Parâmetro:

- **`id` (UUID):** O identificador do serviço.

### Resposta de sucesso:

- **Código:** `204 No Content`

### Erro:

- **Código:** `404 Not Found`

<br>

### 3. Obter todos os serviços

#### GET `/services/all`
Retorna uma lista de todos os serviços cadastrados.

### Resposta de sucesso:

- **Código:** `200 OK`

<br>

### 4. Obter um serviço por ID

#### GET `/services/{id}`
Obtém os detalhes de um serviço específico.

### Parâmetro:

- **`id` (UUID):** O identificador do serviço.

### Resposta de sucesso:

- **Código:** 200 OK

### Erro:

- **Código:** 404 Not Found

<br>

### 5. Atualizar um serviço por ID

#### PUT `/services/update/{id}`
Atualiza os dados de um serviço existente.

### Parâmetros:

- **`id` (UUID):** O identificador do serviço.

#### Corpo da requisição:

```json
{
  "nomeCliente": "João Victor",
  "telefoneContato": "+55 81 92897-4311",
  "emailContato": "joao.victor15@gmail.com",
  "tipoEletronico": "Notebook",
  "modeloEletronico": "Vaio FE15",
  "tipoServico": "Formatação",
  "statusServico": "PENDENTE",
  "valorServico": 149.99,
  "formaPagamento": "DINHEIRO"
}
```

### Resposta de sucesso:

- **Código:** `200 OK`

### Erro:

- **Código:** `404 Not Found`

<br>

---

### Status de Respostas:

Código | Descrição
---|---
200	| Operação bem-sucedida
204 | Recurso deletado com sucesso
400 | Requisição mal formatada
404 | Recurso não encontrado

### Validações

Todos os objetos passados no corpo das requisições seguem os padrões definidos nos modelos `ServiceRequest` e `ServiceResponse`.

## Links para Documentação Oficial:

- **Java 17:** https://docs.oracle.com/en/java/javase/17/
- **Maven:** https://maven.apache.org/guides/
- **MySQL:** https://dev.mysql.com/doc/
- **MySQL Workbench:** https://dev.mysql.com/doc/workbench/en/
- **Docker:** https://docs.docker.com/
- **DBeaver:** https://dbeaver.com/docs/dbeaver/

## Licença

### The MIT License (MIT)

Copyright © 2024 <copyright holders>

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)
