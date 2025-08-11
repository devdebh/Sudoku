# 🧩 Sudoku - Java

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)  ![DIO](https://img.shields.io/badge/DIO-00AEEF?style=for-the-badge)  ![Santander](https://img.shields.io/badge/Santander-FF0000?style=for-the-badge)

## 📌 Sobre o projeto  
Projeto de **Sudoku** desenvolvido em **Java**, jogado diretamente pelo **terminal**.  
Foi criado como parte do **Bootcamp DIO + Santander** e aplicado com foco em **prática de lógica de programação**, **boas práticas de orientação a objetos** e **testes unitários**.

A aplicação conta com:
- Arquitetura organizada em pacotes **model**, **service** e **util**  
- **Enum** (`GameStatusEnum`) para controle de status do jogo  
- Validações completas de jogadas através do `GameService`  
- **Testes automatizados** com **JUnit** para garantir a integridade do código  
- Utilização de **Java Stream API** para validações e verificações do tabuleiro  
- Possibilidade de reiniciar, alterar e limpar valores no tabuleiro  

---

## 🗂 Estrutura do projeto

```bash
📂 src/br/com/dio
├── model/
│   ├── Board.java
│   ├── BoardTest.java
│   ├── GameService.java
│   ├── GameStatusEnum.java
│   └── Space.java
├── util/
│   └── BoardTemplate.java
└── Main.java
```

---

## 🎯 Funcionalidades  
✅ Inicialização do tabuleiro com template padrão  
✅ Inserção de valores com validação automática  
✅ Remoção de valores  
✅ Detecção de erros no preenchimento  
✅ Verificação de jogo completo e correto  
✅ Testes unitários para garantir funcionamento  

---

## 💡 Tecnologias utilizadas  
- **Java**  
- **JUnit** para testes automatizados  
- **Java Stream API**  
- **Paradigma de Orientação a Objetos (POO)**

---

## ✨ Aprendizados  
Durante o desenvolvimento deste projeto, aprimorei:
- **Organização de código em camadas** para facilitar manutenção e expansão  
- **Encapsulamento e coesão** dentro da POO  
- **Validação de regras complexas** usando estruturas de repetição e condições  
- **Testes unitários** para garantir robustez  
- Lógica para resolução e verificação de **Sudoku**  

---

## 📜 Autor  
💜 Criado com prática, dedicação e código por **Déborah Nascimento**  
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/devdebh)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/deborahdsnascimento/)
