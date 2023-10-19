Feature: End to End Feature functionality

  @VerifyShoppingCartss
  Scenario: Verify Amount on Shopping Cart
    Given User opens the Applications
    When User Add Product to Cart
    Then User should Verify Total Amount

   # @VerifyProductonShoppingCart
  Scenario: Verify Product name on Shopping Cart
    Given User opens the Applications
    When User Add MacBook and IPhone to Cart
    Then User should Verify Product Name

  Scenario: verify Product
    Given User opens the Applications
    When User Add Product to Cart
    Then User should Verify Total Amount