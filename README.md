<h1 align="center">
<br>
  <img src="img/logo.jpg"  width="120">
<br>
<br>
 Matrix Tecnologia - Sistema de Gestão de Contratos (REACT + Spring Boot)
 
</h1>

<p align="center">
Este é um sistema de gestão de contratos, desenvolvido para fins de avaliação, que utiliza **React** no frontend para a interface de usuário e **Spring boot** no backend para a leitura e manipulação de dados. O sistema permite a exibição de uma lista de contratos , além de funcionalidades para cadastrar novos contratos.</p>

<p align="center">
  <a href="#">
    <img src="https://img.shields.io/badge/License-MIT-blue.svg" alt="License MIT">
  </a>
</p>

<div align="center">

### Login

<img src="img/login.png" alt="web" align="center" width="525"><br>

### Contratos


  <img src="img/contratos.png" alt="web" align="center" 
  width="525"><br>

 

  ### Cadastro de Contratos

  <img src="img/cadastrocontrato.png" alt="web" align="center" width="525"><br>

   ### Usuarios

  <img src="img/usuarios.png" alt="web" align="center" width="525"><br>

 ### Cadastro de Usuarios
  <img src="img/cadastrousuario.png" alt="web" align="center" width="525"><br>

### Erro 404
<img src="img/erro404.png" alt="web" align="center" width="525"><br>

### Spring boot
<img src="img/backend API.png" alt="web" align="center" width="525"><br>
  
  <br> 

</div>

 
 ### 🔍 Front End
```sh
 Crie uma pequena aplicação SPA para cadastro de contratos com os campos valor (decimal) , usando REACTJS, onde exista uma página de login com usuário e senha.

Devem haver dois perfis na aplicação: gestor e usuário

Perfil Gestor:

- Cadastra novos usuários para a aplicação

- Cadastra novos contratos na aplicação

Perfil Usuário:

- Cadastra novos contratos na aplicação



```


<hr />

## Frontend - React

```sh
- **React**: A biblioteca JavaScript usada para criar interfaces de usuário baseadas em componentes. O sistema utiliza React para renderizar a tabela de contratos e implementar as interações, como paginação e ordenação.


- **CSS**: Estilização personalizada da interface de usuário utilizando CSS e módulos de CSS.

 
```



🛠️ Backend - Spring Boot
```sh
Spring Boot: Um framework Java que facilita o desenvolvimento de aplicações Java. Utiliza configurações automáticas e fornece uma estrutura robusta para criar APIs RESTful.

MySQL: Um sistema de gerenciamento de banco de dados relacional que armazena os dados da aplicação de forma estruturada e eficiente.


Foi usado apenas duas tabela no banco de dados:
usuario
Contrato
Servico

Usuarios (gestor)
david orion , email: david.foxmulder@gmail.com   senha: 102030

Usuario( não Gestor)

João jessica , email: joao@example.com  senha: 102030

Cadastro e Autenticação de Usuários: Permite que usuários se registrem e façam login na aplicação.

Gerenciamento de Contratos: Usuários podem cadastrar, visualizar e gerenciar contratos através da interface.

Sistema de Perfis: Diferentes perfis de usuário (usuário comum e gestor) para controle de acesso às funcionalidades da aplicação.


```
## Funcionalidades

🛠️ Frontend
```sh
- **Listagem de contratos**: Exibe uma tabela com os contratos cadastrados, mostrando informações como ID, data, título,valor  e nome do usuário.

- **Listagem do usuarios**: Exibe uma tabela com os usuarios cadastros somente se usuario tive perfil de gestor podera cadastra novos usuarios

- **Cadastro de novos contratos**: Um botão na interface leva o usuário a uma tela de cadastro para adicionar novos contratos ao sistema.

- **Cadastro de novos usuarios**: Um botão na interface leva o usuário a uma tela de cadastro para adicionar novos usuarios ao sistema.

Observação: Tenho conhecimento no REACT usar react-table, adicionaria paginação e manipulação do dados da tabela com por exemplo ordenação, somente não foi implatando afim de segurança do sistema funcionar exatidão na avaliação

```

🛠️ Backend - Spring Boot
```sh
O backend da aplicação foi desenvolvido utilizando Spring Boot, proporcionando uma estrutura robusta e eficiente para construir uma API RESTful. Este backend é responsável pela lógica de negócios e pela manipulação de dados, interagindo diretamente com o banco de dados MySQL.

Funcionalidades Implementadas

Cadastro de Usuários: Implementação de endpoints para cadastrar novos usuários, com validação de dados.

Autenticação: Sistema de autenticação que permite aos usuários fazer login e gerenciar suas sessões.

Gerenciamento de Contratos: Criação de funcionalidades para adicionar, listar, atualizar e excluir contratos.

Gerenciamento de Perfis: Controle de acesso baseado em diferentes perfis de usuário, garantindo que apenas usuários autorizados possam acessar determinadas funcionalidades.

Validação de Dados: Utilização de anotações para validação de campos de entrada, garantindo a integridade dos dados.

```
## Dependências Utilizadas

```sh
As seguintes dependências foram utilizadas no projeto, facilitando o desenvolvimento e a integração com outras tecnologias:

Spring Web: Para criar APIs RESTful e manipular requisições HTTP.

Spring Data JPA: Para simplificar a interação com o banco de dados usando o padrão JPA (Java Persistence API).

MySQL Driver: Para conectar o Spring Boot ao banco de dados MySQL.

Spring Security: Para implementar autenticação e controle de acesso na aplicação.

Lombok: Para reduzir o boilerplate de código, facilitando a criação de classes e métodos.

Spring Boot DevTools: Para melhorar a experiência de desenvolvimento com reinicialização automática e suporte a HotSwap.

```

## Configuração do Banco de Dados
```sh
O banco de dados MySQL deve ser configurado no arquivo application.properties com as seguintes informações:

spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=usuario
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update


```

### Pré-requisitos

- Node.js e npm/yarn (para rodar o frontend)
- PHP (para rodar o backend)
- Servidor MySQL ou outro banco de dados relacional
- BD esta na pasta "BD" tem modelo de banco de dados em SQL
## 📧 Contato

Caso tenha alguma dúvida, entre em contato:

E-mail: david.foxmulder@gmail.com<br>
LinkedIn: [david orion](https://www.linkedin.com/in/davidmuldersilva/)





