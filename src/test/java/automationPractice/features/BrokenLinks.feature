@regressiontest1
Feature: All links and banners are redirecting corrrectly and none of the links are broken.

  Scenario Outline: broken links verification
    Given user is on home page
    When user clicks the "<links>"
    Then user should be able to navigate to "<correct page>"
    Examples:
      | links      | correct page                           |
      | contact us | Contact us - My Store                  |
      | sign in    | Login - My Store                       |
      | women      | Women - My Store                       |
      | dresses    | Dresses - My Store                     |
      | t shirt    | T-shirts - My Store                    |
      | cart       | Order - My Store                       |
      | top trends | PrestaShop - Free ecommerce software   |
      | our stores | Stores - My Store                      |
      | my orders  | Login - My Store                       |
      |youtube| Selenium Framework - YouTube - YouTube |