# 📊 ControleFinanceiro

Aplicação web desenvolvida em **Java com Spring Boot** para **controle de finanças pessoais**, permitindo o registro e gerenciamento de **receitas e despesas**, além do acompanhamento do saldo financeiro de forma simples e organizada.

---

## 🚀 Funcionalidades

- ✅ Cadastro de receitas e despesas  
- ✅ Listagem de transações financeiras  
- ✅ Edição e exclusão de registros  
- ✅ Organização seguindo o padrão MVC  
- ✅ Persistência de dados com JPA/Hibernate  
- ✅ Estrutura pronta para expansão (relatórios, filtros, autenticação)

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **Hibernate**
- **Maven**
- **MySQL**
- **Lombok**
- **Swagger / OpenAPI** (se configurado)

---

## 📦 Pré-requisitos

- Java JDK 17+
- Maven
- MySQL
- IDE (opcional)

---

## 📥 Instalação

### Clone o repositório

```bash
git clone https://github.com/Choquinn/ControleFinanceiro.git
cd ControleFinanceiro
```

### Configure o banco de dados

```sql
CREATE DATABASE controle_financeiro;
```

Edite `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/controle_financeiro
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
```

---

## ▶️ Executando

```bash
mvn spring-boot:run
```

ou

```bash
mvn clean package
java -jar target/controlefinanceiro-0.0.1-SNAPSHOT.jar
```

---

## 🌐 Acesso

```
http://localhost:8080
```

Swagger (se disponível):

```
http://localhost:8080/swagger-ui.html
```

---

## 🤝 Contribuição

Fork → Branch → Commit → Push → Pull Request 🚀

---
