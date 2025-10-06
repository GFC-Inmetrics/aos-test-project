# Testes Automatizados - Advantage Online Shopping (UI)



Este projeto utiliza **Java + Cucumber + Playwright + JUnit** para automatizar testes de interface (UI) no site **Advantage Online Shopping**.

O foco principal é validar o **fluxo completo de compra** — desde o acesso à página inicial, navegação por categorias, seleção de produtos e checkout até a finalização do pagamento.

O projeto segue o padrão **Page Object Model (POM)**, garantindo código limpo, reutilizável e de fácil manutenção.

Além disso, cada execução gera **evidências automáticas (screenshots)**, armazenadas em `target/screenshots/`.

---

## Pré-requisitos

- **Java 15+**
- **Maven 3.8+**
- **Google Chrome** ou **Microsoft Edge** instalados

Para verificar a instalação e suas versões, abra o terminal e digite:

```bash
java -version
mvn -version
```

### 1. Clone do repositório

```bash
git clone https://github.com/seu-usuario/aos-test-project.git
cd aos-test-project
```

### 2. Instale as dependências do Maven

```bash
mvn clean install
```

Todas as dependências (Playwright, Cucumber, JUnit, Hamcrest, Rest-Assured) já estão configuradas no `pom.xml`.

### 3. Instale os navegadores do Playwright

Antes da primeira execução, instale os navegadores usados pelo Playwright:

```bash
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

---

## Estrutura dos Testes

### Cucumber Features

Localizadas em `src/test/resources/features/`, contêm arquivos `.feature` com cenários de teste da UI.

**Checkout.feature** — cenário principal de fluxo de compra, escrito em Gherkin:

```gherkin
Feature: Realizar compra de produto

  Scenario: Usuário realiza o checkout com sucesso
    Given que o usuário está na Home Page
    When ele seleciona uma categoria de produtos
    And escolhe um produto e adiciona ao carrinho
    And realiza o checkout
    Then a compra é finalizada com sucesso
```

### Steps Definitions

Localizadas em `src/test/java/steps/CheckOutSteps.java`, contêm a implementação dos passos do Cucumber, incluindo:

- Interações com as páginas modeladas (Home, Categoria, Produto, Checkout e Pagamento)
- Encadeamento das ações do usuário
- Utilização das classes Page Object para melhor manutenção e legibilidade

### Hooks

Localizados em `src/test/java/hooks/Hooks.java`, responsáveis pelo ciclo de vida dos testes:

- `@After`: captura evidências e encerra o navegador após a execução

### Utils

Localizados em `src/test/java/utils/`, contêm classes de apoio:

- **PlaywrightFactory.java** — inicializa e gerencia o navegador (Browser, Context, Page)
- **ScreenShotUtil.java** — captura screenshots automaticamente em caso de falha

As imagens são salvas em:

```
target/screenshots/
```

### Runner

Localizado em `src/test/java/runners/TestRunner.java`, responsável por executar os cenários do Cucumber.

Exemplo de configuração:

```java
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"steps", "hooks"},
    plugin = {"pretty", "json:target/cucumber-report.json"},
    monochrome = true
)
```

Execução filtrada por tags:

```bash
mvn test -Dcucumber.options="--tags @checkout"
```

---

## Estrutura de Pastas

```
src
 └── test
     ├── java
     │   ├── pages
     │   │   ├── HomePage.java
     │   │   ├── CategoryPage.java
     │   │   ├── ProductPage.java
     │   │   ├── CheckoutPage.java
     │   │   └── OrderPaymentPage.java
     │   ├── steps
     │   │   └── CheckOutSteps.java
     │   ├── hooks
     │   │   └── Hooks.java
     │   ├── utils
     │   │   ├── PlaywrightFactory.java
     │   │   └── ScreenShotUtil.java
     │   └── runners
     │       └── TestRunner.java
     └── resources
         └── features
             └── Checkout.feature
```

---

## Execução dos Testes

Os testes podem ser executados pela IDE (**IntelliJ IDEA, Eclipse, VS Code**) ou via terminal:

```bash
mvn test
```

Durante a execução, os relatórios e evidências são gerados na pasta:

```
target/
 ├── cucumber-reports/
 ├── surefire-reports/
 └── screenshots/
```

---

## Funcionamento dos Testes

1. **TestRunner** inicia a execução dos cenários definidos em features.
2. **Steps** executam as ações descritas nas páginas modeladas.
3. Em caso de falha, **ScreenShotUtil** registra automaticamente uma evidência.
4. Após a execução, **Hooks** encerra o navegador e finaliza o contexto do Playwright.

---

## Contato

Para dúvidas ou contribuições:

**Desenvolvedor:** Guilherme Clemente  
**Cargo:** QA Engineer / Test Automation  
**E-mail:** guilherme.clemente@inmetrics.com.br 
**LinkedIn:** [https://linkedin.com/in/guilherme-clemente](https://linkedin.com/in/guilherme-clemente)