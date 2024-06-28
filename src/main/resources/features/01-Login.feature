Feature: Login Page

  Scenario Outline: Check access url login page
    Given Input url web lamar "<Url>"
    Then Menampilkan halaman login "<TxtLoginPage>"
    Examples:
      | Url                              | TxtLoginPage       |
      | https://flow-dev.dikahadir.com/auth1/login | 404 Page Not Found |
      | https://flow-dev.dikahadir.com/auth/login | Login Page         |

  Scenario Outline: Check login page
    When User input username "<Username>"
    And User input password "<Password>"
    And Klik tombol Sign In
    Then Berhasil login dan menampilkan halaman dashboard "<msgResponses>"

    Examples:
      | Username | Password  | msgResponses    |
      | bd       | dfjhgfd7y | Gagal!          |
      | bd234er  | 12345678  | Gagal!          |
      | bd       |           | true            |
      |          | dfjhgfd7y | true            |
      |          |           | true            |
      | bd       | 12345678  | Dashboard     |