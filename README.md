# SuggestionBox_API
Princípios de uma API de forma 100% prática utilizando Spring Boot.

## As atualizações da Suggestion foram executadas por mim, Valdelaine e Gabriel Pedro.

Challenge
1. Remover a opção de criar as entidades automaticamente do aplication-test.properties e substituir por none.
2. Criar um script que crie a entidade category e inclua 3 categorias.
3. Crie uma funcionalidade no controlador que responda à uma requsição no recurso http://localhost/category/all com um JSON que represente uma lista com todas as categorias cadastradas na base de dados.
4. Criar uma requisição no Postman/ThunderClient para o recurso http://localhost/category/new com o método POST contendo o corpo da requisição que inclua um registro na entidade category.
Verifique o registro na base de dados H2.

Segue tabela do banco antes da requisição http://localhost/category/new:

![h2_console](https://github.com/douglashugo/SuggestionBox_API/assets/95046698/2750098e-92ba-4870-94c2-c000989704d0)

Segue tabela do banco após a requisição http://localhost/category/new:

![h2_console_v2](https://github.com/douglashugo/SuggestionBox_API/assets/95046698/d4129e72-0756-4af7-bb8e-9e1f247cd137)

Chamada da requisição http://localhost/category/new:

![category_all_v2](https://github.com/douglashugo/SuggestionBox_API/assets/95046698/5de5b0ea-5e93-4195-8b7b-b57dacb8b81c)
