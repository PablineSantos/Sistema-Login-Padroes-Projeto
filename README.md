# 🔐 Sistema de Login e Cadastro de Usuários

Aplicação web desenvolvida em **Java 21+ com Spring Boot** que implementa um sistema simples de **cadastro e autenticação de usuários**.  
O projeto foi criado com o objetivo de estudar e aplicar os padrões de projeto **Singleton** e **Adapter**, além de praticar conceitos de **arquitetura em camadas** utilizando o ecossistema Spring.

---

# 🎯 Objetivo do Projeto

Este projeto foi desenvolvido para:

- Estudar padrões de projeto na prática
- Aplicar **Singleton** e **Adapter**
- Praticar desenvolvimento web com **Spring Boot**
- Utilizar **Spring Data JPA** para persistência
- Criar interface web com **Thymeleaf**

---

# 🧠 Padrões de Projeto Aplicados

## 🔹 Singleton

O padrão **Singleton** foi utilizado na classe `LoginLogger`, responsável por registrar eventos de login e cadastro em arquivo de log.

O objetivo é garantir que **exista apenas uma instância do logger em toda a aplicação**, centralizando o registro de logs.

### Exemplo de uso

```java
LoginLogger.getInstance().log(usuario, true, "Login realizado com sucesso");
```

---

## 🔹 Adapter

O padrão **Adapter** foi utilizado para adaptar uma biblioteca de validação de senha ao formato esperado pela aplicação.

A aplicação utiliza a interface:

```java
ValidadorSenha
```

Enquanto a biblioteca existente utiliza:

```java
Validador
```

Para resolver essa incompatibilidade foi criado o adapter:

```java
ValidadorSenhaAdapter
```

### Fluxo de funcionamento

```text
UserService
    ↓
ValidadorSenha
    ↓
ValidadorSenhaAdapter
    ↓
Validador
    ↓
BibliotecaSeguranca
```

---

# 🏗 Arquitetura do Projeto

O sistema segue uma arquitetura em camadas:

```text
Controller
   ↓
Service
   ↓
Repository
   ↓
Entity
```

### Controller

Responsável por receber as requisições HTTP.

- `LoginController`
- `RegisterController`

---

### Service

Contém as regras de negócio da aplicação.

- `UserService`
- `LoginLogger`
- `ValidadorSenhaAdapter`
- `BibliotecaSeguranca`

---

### Repository

Camada responsável pela comunicação com o banco de dados.

- `UserRepository`

Utiliza **Spring Data JPA**.

---

### Entity

Representação da tabela no banco de dados.

- `User`

---

### View

Interface web criada com **Thymeleaf**.

- `login.html`
- `register.html`

---

# 🔄 Fluxo do Sistema

## Cadastro de usuário

```text
Usuário acessa /register
        ↓
RegisterController
        ↓
UserService
        ↓
Validação da senha (Adapter)
        ↓
UserRepository salva usuário
        ↓
LoginLogger registra log
```

---

## Login de usuário

```text
Usuário acessa /login
        ↓
LoginController
        ↓
UserService
        ↓
Busca usuário no banco
        ↓
Validação da senha
        ↓
LoginLogger registra log
```

---

# 🛠 Tecnologias Utilizadas

- **Java 21+**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Hibernate**
- **Thymeleaf**
- **Maven**

---

# 📂 Estrutura do Projeto

```text
src
 └─ main
     └─ java
         └─ log.singleton
             ├─ controller
             ├─ service
             ├─ repository
             └─ entity
```

---

# ▶ Como Executar o Projeto

### 1️⃣ Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

### 2️⃣ Abra o projeto na sua IDE (IntelliJ IDEA, por exemplo)

### 3️⃣ Execute a aplicação

Execute a classe principal do Spring Boot.

### 4️⃣ Acesse no navegador

```text
http://localhost:8080/register
```

ou

```text
http://localhost:8080/login
```

---

# 📌 Possíveis Melhorias Futuras

- Implementar **Spring Security**
- Adicionar **criptografia de senha (BCrypt)**
- Criar **API REST**
- Adicionar **JWT para autenticação**
- Criar dashboard após login

---

# 👩‍💻 Autor

**Pabline Pereira**

Estudante de Engenharia de Software, interessada em desenvolvimento backend e arquitetura de sistemas.
