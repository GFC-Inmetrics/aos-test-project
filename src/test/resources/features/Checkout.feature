@Scenarios
Feature: Checkout tela de pagamentos
  Scenario: Validar compra de produto sem possuir cadastro
    Given que estou na página Home do site Advantage Online Shopping
    When seleciono um produto ao carrinho de vendas
    And executo o processo de checkout
    Then solicitação de cadastro e login são exibidas em tela

  Scenario Outline: Validar compra de produto com login realizado
    Given que estou na página Home do site Advantage Online Shopping com login realizado "<user>", "<password>"
    When adiciono um produto ao carrinho de vendas
    And realizo o checkout
    Then o pagamento é concluído
    Examples:
      | user      | password          |
      | Guilherme | Teste@123         |

  Scenario Outline: Validar compra de produto através de novo registro
    Given que estou na página Home do site Advantage Online Shopping
    When adiciono um produto ao carrinho de vendas
    And inicio o processo de pagamento
    And realizo cadastro do meu usuário com "<login>", "<senha>", "<email>", "<nome>", "<sobrenome>"
    And realizo login com usuário gerado via api "<login>", "<senha>"
    And realizo o processo de checkout
    Then o pagamento é concluído e Ordem de pedido é gerada
    Examples:
      | login         | senha       | email                   | nome          | sobrenome |
      | usuario03     | Senha@123   | usuario03@test.com      | Guilherme3    | Silva     |
      | usuario04     | Senha@456   | usuario04@test.com      | Gfc4          | Oliveira  |

  Scenario: Validar cancelamento de compra de produto via checkout
    Given que estou na tela de checkout de pedido com log in realizado
    When removo todos os itens do meu pedido
    Then carrinho de compras é esvaziado
    And botão para continuar as compras é exibido

  Scenario: Validar edição de produto durante checkout
    Given que estou na tela de checkout de pedido com log in realizado
    When altero por edição a quantidade do produto
    And realizo o processo de checkout
    Then uma ordem de pedido é gerada

  Scenario: Validar retorno no processo de checkout de método de pagamento para detalhes de envio
    Given que estou na tela de checkout de pedido com log in realizado
    When avanço para a tela de pagamento
    And seleciono o campo de voltar para detalhes de envio
    Then tela exibe as informações de detalhes de envio e resumo do pedido

  Scenario: Validar edição de endereço de envio de um pedido
    Given que estou na tela de checkout de pedido com log in realizado
    When realizo a alteração de dados do endereço
    And realizo o processo de checkout
    Then  uma ordem de pedido é gerada
