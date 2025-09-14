# 🏎️ Simulador de Treino de Fórmula 1

Sistema de automação para treinos de Fórmula 1 com controle de equipes, carros e voltas rápidas.

## 🎯 Funcionalidades

- 7 equipes com 2 carros cada (total de 14 carros)
- Máximo de 5 carros na pista simultaneamente
- Apenas 1 carro por equipe na pista por vez
- 3 voltas por piloto com registro de tempos
- Grid de largada ordenado pela volta mais rápida
- Sistema de semáforos para controle de acesso

## 🚀 Como executar

### Pré-requisitos
- JDK 8 ou superior
- Git instalado

### Passo a passo
1. Clone o repositório:
```bash
git clone https://github.com/GabrielGit10110/SimulacaoFormulaUm/tree/main
```

2. Acesse o diretório do projeto:
```bash
cd SimulacaoFormulaUm
```

3. Compile o código:
```bash
javac -d bin src/controller/*.java src/model/*.java src/utils/*.java src/view/*.java
```

4. Execute a aplicação:
```bash
java -cp bin view.FormulaUm
```

## 🏁 Equipes Participantes

- **Mercedes** 🟡
- **Ferrari** 🔴  
- **Mazda** 🟠
- **Red Bull Racing** 🟣
- **Alpine** 🔵
- **McLaren** 🟠
- **Williams** 🔵

## 🛠️ Tecnologias utilizadas
- Java SE
- Programação multithread
- Semáforos para controle de concorrência
- Algoritmos de ordenação
- Sistema de logs com timestamps
- JDK 8+

## 📋 Exemplo de saída

```
[14:30:25] 🏎️ Mercedes escolheu o carro: 1
[14:30:25] 🏎️ Ferrari escolheu o carro: 1
[14:30:25] 🏎️ Red Bull escolheu o carro: 1
[14:30:25] 🏎️ McLaren escolheu o carro: 1
[14:30:25] 🏎️ Alpine escolheu o carro: 1

[14:30:25] ⏳ Mercedes esta esperando para comecar a corrida
[14:30:25] 🚦 Mercedes - Carro: 1 Comecou a corrida!
[14:30:28] ✅ Mercedes - Carro: 1 Terminou uma volta em 12.3456s
[14:30:31] ✅ Mercedes - Carro: 1 Terminou uma volta em 12.1234s
[14:30:34] ✅ Mercedes - Carro: 1 Terminou uma volta em 11.9876s
[14:30:34] 🏁 Mercedes - Carro: 1 Terminou a corrida com o melhor tempo de: 11.9876 segundos

... [outras equipes completam] ...

=== RESULTADO FINAL ===

🥇 Equipe Mercedes com o carro: 1 - chegou em 1° lugar com o tempo de: 11.9876 segundos Vencendo a corrida! Parabens
🥈 Equipe Ferrari com o carro: 2 - chegou em 2° lugar com o tempo de: 12.1234 segundos
🥉 Equipe Red Bull com o carro: 1 - chegou em 3° lugar com o tempo de: 12.3456 segundos
4° Equipe McLaren com o carro: 1 - chegou em 4° lugar com o tempo de: 12.5678 segundos
5° Equipe Alpine com o carro: 2 - chegou em 5° lugar com o tempo de: 12.7890 segundos
... [até 14° lugar] ...

========= FIM DA CORRIDA =========
```

## ⚙️ Regras do Treino

- **Pista**: 200 metros por volta
- **Voltas**: 3 voltas obrigatórias por carro
- **Velocidade**: 20-40 metros por segundo
- **Controle de acesso**: 
  - Máximo 5 carros na pista
  - Apenas 1 carro por equipe
- **Tempo**: Melhor volta de cada carro determina o grid

## 🏆 Sistema de Classificação

- **Ordenação**: Do menor tempo para o maior
- **Grid**: Posições de 1° a 14° lugar
- **Melhor volta**: Tempo mais rápido das 3 voltas
- **Equipes**: Identificação por nome e número do carro

## 👨‍💻 Desenvolvido por
[GabrielGit10110](https://github.com/GabrielGit10110)

---

**Nota**: Este sistema simula com precisão as regras oficiais de treinos de Fórmula 1, incluindo o controle de acesso à pista, registro de tempos por volta e a formação do grid de largada baseado na melhor volta de cada piloto.
