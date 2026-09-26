# Sistema de Controle de Alunos — Estrutura de Dados

Aplicação desenvolvida em Java para manipulação e ordenação de registros em memória, utilizando estruturas de dados heterogêneas e algoritmos clássicos de ordenação.

## 📌 Contexto Acadêmico

- **Instituição:** Fatec
- **Curso:** Análise e Desenvolvimento de Sistemas (ADS) — 3º semestre
- **Disciplina:** Estrutura de Dados
- **Docente:** Prof. Alexandre
- **Autor:** Igor Rodrigues David

## 🎯 Objetivo do Projeto

Desenvolver um sistema via terminal (CLI) que permita o cadastro e processamento de informações acadêmicas de alunos, implementando regras de negócio e ordenações manuais através de algoritmos clássicos vistos em aula (**Selection Sort** e **Bubble Sort**), sem o uso de métodos utilitários pré-fabricados como `Collections.sort()`, para fins de fixação de conceitos algorítmicos.

## ⚙️ Regras de Negócio e Modelo de Dados

Cada registro de `Aluno` armazena os seguintes atributos:

| Campo | Tipo | Descrição |
|---|---|---|
| nome | String | Nome completo do discente |
| ra | int | Registro Acadêmico numérico |
| idade | int | Idade em anos |
| sexo | char | Caractere identificador (M, F) |
| media | double | Média final informada |
| resultado | String | Status acadêmico calculado automaticamente pelo sistema |

**Lógica do campo `resultado`:** não é informado manualmente pelo operador — é calculado pelo sistema com base na média:
- Média **≥ 6.0** → `Aprovado`
- Média **< 6.0** → `Reprovado`

## 📋 Funcionalidades (Menu Principal)

1. **Cadastrar Alunos** — leitura interativa dos campos via terminal (`Scanner`) e inserção dos objetos em um array (capacidade de até 100 alunos).
2. **Relatório por Nome (Crescente)** — ordenação alfabética (A–Z) de todos os registros utilizando **Bubble Sort** com `.compareToIgnoreCase()`.
3. **Relatório por RA (Decrescente)** — ordenação numérica do maior RA para o menor utilizando **Selection Sort**.
4. **Relatório de Aprovados (Crescente por Nome)** — filtro que lista apenas alunos com resultado `"Aprovado"`, mantendo a ordenação alfabética por nome.
5. **Sair** — finaliza a execução do programa com segurança.

## 🏗️ Arquitetura do Software

```
src/
 ├── Aluno.java   # Modelo de dados (encapsulamento, atributos e getters)
 └── Main.java    # Ponto de entrada, menu, laço de repetição, Scanner e lógica de negócio
```

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java Development Kit (JDK 17 ou superior instalado)
- Git configurado (opcional, para clonagem)

### Execução via linha de comando

```bash
git clone https://github.com/igorrod-star/Estrutura-de-Dados-1-Bimestre.git
cd Estrutura-de-Dados-1-Bimestre/src
javac *.java
java Main
```

## 💻 Demonstração de Saída do Terminal

```
===============================
       SISTEMA DE ALUNOS
===============================
1 - Cadastrar alunos
2 - Relatorio por nome
3 - Relatorio por RA
4 - Relatorio de aprovados
0 - Sair
===============================
Escolha uma opcao:
```

## 👤 Autor

**Igor Rodrigues David**
GitHub: [@igorrod-star](https://github.com/igorrod-star)
