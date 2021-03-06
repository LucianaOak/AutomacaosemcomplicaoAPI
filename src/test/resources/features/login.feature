#language:pt


  @LoginSucesso
  Funcionalidade: Realizar Login
    Testes de API de login

    Cenario: Realizar Login com sucesso
      Dado que tenha payload valido da API de Login
      Quando envio uma requisicao do tipo POST de Login
      Entao valido que recebe status 200 no response
      E armazeno o token que recebo de Login


    @LoginInvalido
    Esquema do Cenario: Cenario: Realizar Login com <cenario>
        Dado que tenha um payload da API de Login com as seguintes informacoes
          | email | <email>|
          | senha | <senha>|

        Quando envio uma requisicao do tipo POST de Login
        Entao valido que recebo status 400 no response

        Exemplos:
          |cenario         | email             | senha|
          |usuario invalido| invalido@email.com|123456|
          |senha invalida  | aluno@email.com   |invalido|







