Feature: Login Page

  Scenario Outline: Check access url login page
    Given Input url web "<Url>"
    Then Menampilkan halaman login "<Status>"

    Examples:
      | Url                                        | Status |
      | https://flow-dev.dikahadir.com/auth1/login | false  |
      | https://flow-dev.dikahadir.com/auth/login  | true   |

  Scenario Outline: Check login page
    When User input username "<Username>"
    And User input password "<Password>"
    And Klik tombol Sign In "<msgResponses>"
    Then Berhasil login dan menampilkan halaman dashboard "<msgResponses>"

    Examples:
      | Username | Password | msgResponses |
      | noviar   | 12345678 | Failed       |
      | noviar   |       23 | Dashboard    |
