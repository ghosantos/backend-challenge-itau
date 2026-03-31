# 🚀 Desafio Itaú - API de Transações e Estatísticas

Este projeto foi desenvolvido como solução para o desafio técnico do Itaú Unibanco. A aplicação consiste em uma API REST para o recebimento de transações financeiras e cálculo de estatísticas dos eventos ocorridos nos últimos 60 segundos.

---

## 📋 Sobre o Projeto
O objetivo é gerenciar transações e fornecer métricas (soma, média, valor mínimo, valor máximo e contagem) filtradas por uma janela de tempo de 1 minuto.

### 🛠️ Tecnologias e Conceitos
* **Java 17**
* **Spring Boot 4.0**
* **Bean Validation:** Validações de campos nulos, valores negativos e datas futuras.
* **Strategy Pattern:** Organização das classes de validação de regra de negócio.
* **Java Time API (UTC):** Uso de `OffsetDateTime` e `Instant` para manipulação de datas.
* **Global Exception Handling:** Tratamento de erros para retorno do status HTTP 422.
* **Maven:** Gerenciamento do projeto.

---

## ⚙️ Endpoints

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **POST** | `/transaction` | Recebe uma transacao (valida valor e data). |
| **DELETE** | `/transaction` | Limpa a lista de transações. |
| **GET** | `/statistics` | Retorna estatísticas dos últimos 60 segundos. |

---

## 📐 Organização do Código

* **Validações:** Utilizei o Bean Validation no DTO para regras simples (como `@PositiveOrZero`). Para a regra de tempo (60 segundos), utilizei uma implementação customizada chamada `TransactionTimeValidator`.


* **Service:** O `TransactionService` utiliza uma lista de validadores injetados pelo Spring para garantir que a transação é válida antes de ser processada.


* **Datas:** O sistema utiliza `Clock.systemUTC()` para garantir consistência nas comparações de tempo, independente do fuso horário local.


* **Erros:** Centralizei o tratamento de exceções em um `GlobalExceptionHandler` para garantir que erros de validação retornem o status `422 Unprocessable Entity`.

---

## 🚀 Como Executar

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/itau-challenge.git](https://github.com/seu-usuario/itau-challenge.git)
   
2. **Compile e rode a aplicação:**
    ```bash
    mvn clean install
    mvn spring-boot:run

3. **Acesse a API:**
    ```bash
    http://localhost:8080.

