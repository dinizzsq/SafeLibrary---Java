# SafeLibrary

Sistema de gerenciamento de biblioteca desenvolvido em Java utilizando Programação Orientada a Objetos (POO).

O projeto foi criado com foco em aprendizado prático de:

* CRUD
* Organização em camadas
* Exceptions customizadas
* Manipulação de listas
* Regras de negócio
* Estrutura de aplicações Java

---

#  Funcionalidades

 Cadastro de usuários
 Cadastro de bibliotecários
 Cadastro de livros
 Exclusão de registros
 Empréstimo de livros
 Devolução de livros
 Controle de limite de empréstimos
 Tratamento de exceções personalizadas

---

# 🛠️ Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos
* Collections (`ArrayList`)
* Exceptions customizadas
* Estrutura em camadas (`Service`, `Repository`, `Model`)

---



#  Conceitos Aplicados

##  Programação Orientada a Objetos

O projeto utiliza conceitos fundamentais de POO:

* Encapsulamento
* Classes e Objetos
* Responsabilidade de camadas
* Organização modular

---

##  Exceptions Customizadas

Foram criadas exceções próprias para melhorar o controle de erros do sistema:

```java
throw new BookNotFoundException("Livro não encontrado.");
```

Isso torna o código mais limpo e profissional.

---

##  Separação em Camadas

O sistema foi dividido em:

* `Model` → representa os objetos
* `Repository` → manipula armazenamento
* `Service` → regras de negócio
* `Program` → interação com usuário

---

#  Regras de Negócio

* Um usuário pode pegar no máximo 5 livros emprestados
* Livros emprestados são movidos para uma lista específica
* O sistema impede empréstimos de livros inexistentes

---

#  Objetivo do Projeto

Este projeto foi desenvolvido para praticar:

* lógica de programação
* arquitetura básica de sistemas Java
* tratamento de exceções
* organização de código
* boas práticas iniciais

---

#  Aprendizados

Durante o desenvolvimento foram praticados:

* uso de `switch`
* `try/catch`
* criação de exceptions
* manipulação de objetos
* validações
* fluxo de menu
* interação entre classes

---

#  Como Executar

1. Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

2. Abra o projeto na IDE

3. Execute a classe:

```bash
Menu.java
```

---

#  Autor
Dinizz
