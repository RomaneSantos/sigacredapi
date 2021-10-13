# Siga Cred Api (Teste de Backend)

## Como executar
  1. Sera necessario ter no minimo o jdk 11
  2. Marven na versão 3 ou superior(Foi usada a versão 4)
  3. O editor de texto utilizado foi o Visual Studio Code, com as exetensões [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack), [Spring Boot Tools](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-spring-boot), [Spring Initializr Java Support](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-spring-initializr) e [Spring Boot Dashboard](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-spring-boot-dashboard)
  4. Apos instalar as extensões, o proprio VS Code identifica o projeto, e o lista na aba do Spring Boot Dashboard, onde fica de facil controle para execução.
  5. E possivel tambem gerar um pacote usando o Marven e apos isso executa-lo:
```bash
mvn clean package
java -jar target/nomedojarcriado.jar
```


## Endpoints


### /cidades
  1. Metodo GET(/cidades) - Retorna a lista de cidades cadastradas no seguinte formato:
```json
[
  {
    "id": 3, //Id-da-Cidade
    "nome": "Palmas", //Nome-da-Cidade
    "estado": { //Informações-do-Estado
      "id": 2, //Id-do-Estado
      "nome": "Tocantins", //Nome-do-Estado
      "sigla": "TO" //Sigla-do-Estado
    }
  }
]
```
  2. Metodo GET(/cidades/{id}) - Retorna uma cidade especifica com base no {id} no seguinte formato:
```json
{
  "id": 3, //Id-da-Cidade
  "nome": "Palmas", //Nome-da-Cidade
  "estado": { //Informações-do-Estado
    "id": 2, //Id-do-Estado
    "nome": "Tocantins", //Nome-do-Estado
    "sigla": "TO" //Sigla-do-Estado
  }
}
```
  3. Metodo POST(/cidades) - Envia um json no corpo da requisição para realizar o cadastro no banco de dados, e retorna o status 200 para sucesso e 404 para erro, o formato do json é:
```json
{
  "nome": "Nome da Cidade", //Nome-da-Cidade
  "estado_id": IdDoEstado, //Id-de-um-estado-ja-cadastrado
}
```
  4. Metodo PUT(/cidades/{id}) - E passado um id na url, envia um json no corpo da requisição para realizar a alteração no banco de dados, e retorna o status 200 para sucesso e 404 para erro (Devera passar somente os parametros que deseja alterar):
```json
{
  "nome": "Nome da Cidade", //Novo-da-Cidade
  "estado_id": IdDoEstado, //Novo-Id-de-um-estado-ja-cadastrado
}
```
  5. Metodo DELETE(/cidades/{id}) - É passado um id da cidade que dejesa excluir, e retorna o status 200 para sucesso e 404 para erro.


### /clientes
  1. Metodo GET(/clientes) - Retorna a lista de Clientes cadastradas no seguinte formato:
```json
[
  {
    "id": 1, //id-do-cliente
    "nome": "Romane Moreira", //nome-do-cliente
    "endereco": { //informações-de-endereço
        "id": 1, //id-do-endereço
        "cidade": { //informações-da-cidade
            "id": 1, //id-da-cidade
            "nome": "Palmas", //nome-da-cidade
            "estado": { //infomações-do-estado
                "id": 1, //id-do-estado
                "nome": "Tocantins", //nome-do-estado
                "sigla": "TO" //sigla-do-estado
            }
        },
        "cep": 99999999, //cep-cadastrado-no-endereço
        "rua": "Rua de exemplo", //rua-cadastrada-no-endereço
        "numero": 8 //numero-cadastrado-no-endereço
    },
    "telefone": 99999999999, //telefone-cdastrada-no-cliente
    "email": "exemplo@email.test" //email-cadastrado-no-cliente
  }
]
```
  2. Metodo GET(/clientes/{id}) - Retorna um Cliente especifico com base no {id} no seguinte formato:
```json
{
    "id": 1, //id-do-cliente
    "nome": "Romane Moreira", //nome-do-cliente
    "endereco": { //informações-de-endereço
        "id": 1, //id-do-endereço
        "cidade": { //informações-da-cidade
            "id": 1, //id-da-cidade
            "nome": "Palmas", //nome-da-cidade
            "estado": { //infomações-do-estado
                "id": 1, //id-do-estado
                "nome": "Tocantins", //nome-do-estado
                "sigla": "TO" //sigla-do-estado
            }
        },
        "cep": 99999999, //cep-cadastrado-no-endereço
        "rua": "Rua de exemplo", //rua-cadastrada-no-endereço
        "numero": 8 //numero-cadastrado-no-endereço
    },
    "telefone": 99999999999, //telefone-cdastrada-no-cliente
    "email": "exemplo@email.test" //email-cadastrado-no-cliente
 }
```
  3. Metodo POST(/clientes) - Envia um json no corpo da requisição para realizar o cadastro no banco de dados, e retorna o status 200 para sucesso e 404 para erro, o formato do json é:
```json
{
    "nome": "Romane Moreira",
    "endereco_id": 1, //Id-do-endereço-ja-cadastrado
    "telefone": 99999999999,
    "email": "exemplo@email.test"
}
```
  4. Metodo PUT(/clientes/{id}) - E passado um id na url, envia um json no corpo da requisição para realizar a alteração no banco de dados, e retorna o status 200 para sucesso e 404 para erro (Devera passar somente os parametros que deseja alterar):
```json
{
    "nome": "Romane Moreira",
    "endereco_id": 1, //Id-do-endereço-ja-cadastrado
    "telefone": 99999999999,
    "email": "exemplo@email.test"
}
```
  5. Metodo DELETE(/clientes/{id}) - É passado um id do Cliente que dejesa excluir, e retorna o status 200 para sucesso e 404 para erro.


### /marcas
  1. Metodo GET(/marcas) - Retorna a lista de Marcas cadastradas no seguinte formato:
```json
[
    {
        "id": 1, //id-da-marca
        "nome": "Positivo" //nome-da-marca
    }
]
```
  2. Metodo GET(/marcas/{id}) - Retorna uma Marca especificada com base no {id} no seguinte formato:
```json
{
  "id": 1, //id-da-marca
  "nome": "Positivo" //nome-da-marca
}
```
  3. Metodo POST(/marcas) - Envia um json no corpo da requisição para realizar o cadastro no banco de dados, e retorna o status 200 para sucesso e 404 para erro, o formato do json é:
```json
{
  "nome": "Positivo" //nome-da-marca
}
```
  4. Metodo PUT(/marcas/{id}) - E passado um id na url, envia um json no corpo da requisição para realizar a alteração no banco de dados, e retorna o status 200 para sucesso e 404 para erro (Devera passar somente os parametros que deseja alterar):
```json
{
  "nome": "Positivo" //novo-nome-da-marca
}
```
  5. Metodo DELETE(/marcas/{id}) - É passado um id da Marca que dejesa excluir, e retorna o status 200 para sucesso e 404 para erro.


### /equipamentoes
  1. Metodo GET(/equipamento) - Retorna a lista de Equipamentos cadastradas no seguinte formato:
```json
[
    {
      "id": 1, //id-do-equipamentos
      "tipo": { //dados-do-tipo-de-equipamento
        "id": 1, //id-do-tipo-de-equipamento
        "nome": "Notebook" //nome-do-tipo-de-equipamento
      },
      "marca": { //informações-da-marca-do-equipamento
        "id": 1, //id-da-marca-do-equipamento
        "nome": "Positivo" //nome-da-marca-do-equipamento
      }
    }
]
```
  2. Metodo GET(/equipamento/{id}) - Retorna um Equipamento especificada com base no {id} no seguinte formato:
```json
{
      "id": 1, //id-do-equipamentos
      "tipo": { //dados-do-tipo-de-equipamento
        "id": 1, //id-do-tipo-de-equipamento
        "nome": "Notebook" //nome-do-tipo-de-equipamento
      },
      "marca": { //informações-da-marca-do-equipamento
        "id": 1, //id-da-marca-do-equipamento
        "nome": "Positivo" //nome-da-marca-do-equipamento
      }
}
```
  3. Metodo GET(/equipamento/tipo/{id}) - Retorna um Equipamento especificada com base no {id} do tipo cadastrado, no seguinte formato:
```json
[
  {
      "id": 1, //id-do-equipamentos
      "tipo": { //dados-do-tipo-de-equipamento
        "id": 1, //id-do-tipo-de-equipamento
        "nome": "Notebook" //nome-do-tipo-de-equipamento
      },
      "marca": { //informações-da-marca-do-equipamento
        "id": 1, //id-da-marca-do-equipamento
        "nome": "Positivo" //nome-da-marca-do-equipamento
      }
  }
]
```
  4. Metodo GET(/equipamento/marca/{id}) - Retorna um Equipamento especificada com base no {id} da marca cadastrada, no seguinte formato:
```json
[
  {
      "id": 1, //id-do-equipamentos
      "tipo": { //dados-do-tipo-de-equipamento
        "id": 1, //id-do-tipo-de-equipamento
        "nome": "Notebook" //nome-do-tipo-de-equipamento
      },
      "marca": { //informações-da-marca-do-equipamento
        "id": 1, //id-da-marca-do-equipamento
        "nome": "Positivo" //nome-da-marca-do-equipamento
      }
  }
]
```
  5. Metodo POST(/equipamento) - Envia um json no corpo da requisição para realizar o cadastro no banco de dados, e retorna o status 200 para sucesso e 404 para erro, o formato do json é:
```json
{
    "tipo_id": 1, //id-de-um-tipo-ja-cadastrado-no-sistema
    "marca_id": 1 //id-de-uma-marca-ja-cadastrada-no-sistema
}
```
  6. Metodo PUT(/equipamento/{id}) - E passado um id na url, envia um json no corpo da requisição para realizar a alteração no banco de dados, e retorna o status 200 para sucesso e 404 para erro (Devera passar somente os parametros que deseja alterar):
```json
{
    "tipo_id": 1, //id-de-um-tipo-ja-cadastrado-no-sistema
    "marca_id": 1 //id-de-uma-marca-ja-cadastrada-no-sistema
}
```
  7. Metodo DELETE(/equipamento/{id}) - É passado um id do registro que dejesa excluir, e retorna o status 200 para sucesso e 404 para erro.


### /estados
  1. Metodo GET(/estados) - Retorna a lista de Estados cadastradas no seguinte formato:
```json
[
    {
        "id": 1, //id-do-estado
        "nome": "Tocantins", //nome-do-estado
        "sigla": "TO" //sigla-do-estado
    },
    {
        "id": 2,
        "nome": "Paraná",
        "sigla": "PR"
    }
]
```
  2. Metodo GET(/estados/{id}) - Retorna um Estado especificada com base no {id} no seguinte formato:
```json
{
  "id": 1, //id-do-estado
  "nome": "Tocantins", //nome-do-estado
  "sigla": "TO" //sigla-do-estado
}
```
  3. Metodo POST(/estados) - Envia um json no corpo da requisição para realizar o cadastro no banco de dados, e retorna o status 200 para sucesso e 404 para erro, o formato do json é:
```json
{
  "nome": "Bahia" //nome-da-marca
  "sigla": "BA" //sigla-do-estado
}
```
  4. Metodo PUT(/estados/{id}) - E passado um id na url, envia um json no corpo da requisição para realizar a alteração no banco de dados, e retorna o status 200 para sucesso e 404 para erro (Devera passar somente os parametros que deseja alterar):
```json
{
  "nome": "Bahia" //nome-da-marca
  "sigla": "BA" //sigla-do-estado
}
```
  5. Metodo DELETE(/estados/{id}) - É passado um id do registro que dejesa excluir, e retorna o status 200 para sucesso e 404 para erro.


### /servicos
  1. Metodo GET(/servicos) - Retorna a lista de Serviços cadastradas no seguinte formato:
```json
[
  {
    "id": 1, //id-do-serviço
    "cliente": { //informações-do-cliente
        "id": 1, //id-do-cliente
        "nome": "Romane Moreira", //nome-do-cliente
        "endereco": { //infomrações-do-endereço-do-cliente
            "id": 1, //id-do-endereço
            "cidade": { //informações-da-cidade-do-endereço
                "id": 1, //id-da-cidade
                "nome": "Palmas", //nome-da-cidade
                "estado": { //informações-do-estado-da-cidade
                    "id": 1, //id-do-estado
                    "nome": "Tocantins", //nome-do-estado
                    "sigla": "TO" //sigla-do-estado
                }
            },
            "cep": 99999999, //cep-do-endereço-do-cliente
            "rua": "Rua de exemplo", //rua-do-endereço-do-cliente
            "numero": 8 //numero-do-endereço-do-cliente
        },
        "telefone": 99999999999, //telefone-do-cliente
        "email": "exemplo@email.test" //email-do-cliente
    },
    "equipamento": { //informações-do-equipamento-do-cliente
        "id": 1, //id-do-equipamento
        "tipo": { //informações-sobre-tipo-de-equipamento
            "id": 1, //id-do-tipo
            "nome": "Notebook" //nome-do-tipo
        },
        "marca": { //informações-sobre-a-marca
            "id": 1, //id-da-marca
            "nome": "Positivo" //nome-da-marca
        }
    },
    "problema": { //Informações-sobre-o-problema-do-dispositivo
        "id": 1, //id-do-problema
        "descricao": "Aparelho não inicializa" //descrição-do-problema
    },
    "registros": null, //lista-de-registro-Informações-extras-sobre-o-serviço(ver-no-proximo-exemplo)
    "status": { //informações-sobre-o-status
        "id": 1, //id-do-status
        "nome": "Finalizado" //nome-do-status
    },
    "created": "2021-10-13T13:05:08.451+00:00", //data-que-o-serviço-foi-criado
    "finalized": null, //data-que-o-serviço-foi-finalizado
    "updated": "2021-10-13T13:05:08.451+00:00" //data-da-ultima-atualização-dos-dados
  }
]
```
  2. Metodo GET(/servicos/{id}) - Retorna um Serviço especificada com base no {id} no seguinte formato:
```json
{
    "id": 1,
    "cliente": {
        "id": 1,
        "nome": "Romane Moreira",
        "endereco": {
            "id": 1,
            "cidade": {
                "id": 1,
                "nome": "Palmas",
                "estado": {
                    "id": 1,
                    "nome": "Tocantins",
                    "sigla": "TO"
                }
            },
            "cep": 99999999,
            "rua": "Rua de exemplo",
            "numero": 8
        },
        "telefone": 99999999999,
        "email": "exemplo@email.test"
    },
    "equipamento": {
        "id": 1,
        "tipo": {
            "id": 1,
            "nome": "Notebook"
        },
        "marca": {
            "id": 1,
            "nome": "Positivo"
        }
    },
    "problema": {
        "id": 1,
        "descricao": "Aparelho não inicializa"
    },
    "registros": [ //lista-de-registros
        {
            "id": 1,
            "created": "2021-10-13T13:23:41.635+00:00",
            "updated": "2021-10-13T13:23:41.635+00:00",
            "descricao": "Inicio do serviço"
        }
    ],
    "status": {
        "id": 1,
        "nome": "Finalizado"
    },
    "created": "2021-10-13T13:05:08.451+00:00",
    "finalized": "2021-10-13T13:23:41.635+00:00", //data-de-finalização
    "updated": "2021-10-13T13:25:12.813+00:00"
}
```
  3. Metodo GET(/servicos/pendentes) - Retorna os Serviços pendentes (Com base no Status diferente de "Finalizado").

  4. Metodo POST(/servicos) - Envia um json no corpo da requisição para realizar o cadastro no banco de dados, e retorna o status 200 para sucesso e 404 para erro, o formato do json é:
```json
{
    "cliente_id": 1,
    "equipamento_id": 1,
    "problema_id": 1,
    "registro_id": 1, //Parametro-Opcional
    "status_id": 1,
    "created": "2021-10-13T13:05:08.451+00:00", //Parametro-Opcional
    "finalized": "2021-10-13T13:05:08.451+00:00" //Parametro-Opcional
}
```
  5. Metodo PUT(/servicos/{id}) - E passado um id na url, envia um json no corpo da requisição para realizar a alteração no banco de dados, e retorna o status 200 para sucesso e 404 para erro (Devera passar somente os parametros que deseja alterar):
```json
{
    "equipamento_id": 1,
    "problema_id": 1,
    "registro_id": 1, //Parametro-Opcional
    "status_id": 1,
    "created": "2021-10-13T13:05:08.451+00:00", //Parametro-Opcional
    "finalized": "2021-10-13T13:05:08.451+00:00" //Parametro-Opcional
}
```
  A cada alteração onde é passada o id do registro, este por sua vez é incluido na lista, para edita-lo, deverar ser feito atraves do seu proprio endpoint, assim toda vez que for necessario inserir um novo registro basta passar somente ele na requisição:
```json
{
    "registro_id": 1, //Id-do-novo-registro-a-ser-adicionado-na-lista
}
```
  
  6. Metodo DELETE(/servicos/{id}) - É passado um id do registro que dejesa excluir, e retorna o status 200 para sucesso e 404 para erro.


### /status
  1. Metodo GET(/status) - Retorna a lista de Status cadastradas no seguinte formato:
```json
[
  {
    "id": 1, //id-do-status
    "nome": "Finalizado" //nome-do-status
  }
]
```
  2. Metodo GET(/status/{id}) - Retorna um Status especificada com base no {id} no seguinte formato:
```json
{
    "id": 1,
    "nome": "Finalizado"
}
```
  3. Metodo POST(/status) - Envia um json no corpo da requisição para realizar o cadastro no banco de dados, e retorna o status 200 para sucesso e 404 para erro, o formato do json é:
```json
{
    "nome": "NovoStatus"
}
```
  4. Metodo PUT(/status/{id}) - E passado um id na url, envia um json no corpo da requisição para realizar a alteração no banco de dados, e retorna o status 200 para sucesso e 404 para erro (Devera passar somente os parametros que deseja alterar):
```json
{
    "nome": "NomeEditado"
}
```
  
  5. Metodo DELETE(/status/{id}) - É passado um id do registro que dejesa excluir, e retorna o status 200 para sucesso e 404 para erro.


### /tipos
  1. Metodo GET(/tipos) - Retorna a lista de Tipos de equipamentos cadastradas no seguinte formato:
```json
[
  {
    "id": 1, //Id-do-tipo-de-equipamento
    "nome": "Notebook" //Nome-do-tipo-de-equipamento
  }
]
```
  2. Metodo GET(/tipos/{id}) - Retorna um Tipo de equipamento especificada com base no {id} no seguinte formato:
```json
{
    "id": 1,
    "nome": "Notebook"
}
```
  3. Metodo POST(/tipos) - Envia um json no corpo da requisição para realizar o cadastro no banco de dados, e retorna o status 200 para sucesso e 404 para erro, o formato do json é:
```json
{
    "nome": "NovoEquipamento"
}
```
  4. Metodo PUT(/tipos/{id}) - E passado um id na url, envia um json no corpo da requisição para realizar a alteração no banco de dados, e retorna o status 200 para sucesso e 404 para erro (Devera passar somente os parametros que deseja alterar):
```json
{
    "nome": "NomeEditado"
}
```
  
  5. Metodo DELETE(/tipos/{id}) - É passado um id do registro que dejesa excluir, e retorna o status 200 para sucesso e 404 para erro.


### /enderecos
  1. Metodo GET(/enderecos) - Retorna a lista de Endereços de equipamentos cadastradas no seguinte formato:
```json
[
    {
        "id": 1, //id-do-endereço
        "cidade": { //dados-da-cidade
            "id": 1,
            "nome": "Palmas",
            "estado": { //dados-do-estado
                "id": 1,
                "nome": "Tocantins",
                "sigla": "TO"
            }
        },
        "cep": 99999999, //cep-do-endereço
        "rua": "Rua de exemplo", //rua-do-endereço
        "numero": 8 //numero-do-endereço
    }
]
```
  2. Metodo GET(/enderecos/{id}) - Retorna um Endereço especificado com base no {id} no seguinte formato:
```json
{
  "id": 1, //id-do-endereço
  "cidade": { //dados-da-cidade
    "id": 1,
    "nome": "Palmas",
    "estado": { //dados-do-estado
      "id": 1,
      "nome": "Tocantins",
      "sigla": "TO"
    }
  },
  "cep": 99999999, //cep-do-endereço
  "rua": "Rua de exemplo", //rua-do-endereço
  "numero": 8 //numero-do-endereço
}
```
  3. Metodo POST(/enderecos) - Envia um json no corpo da requisição para realizar o cadastro no banco de dados, e retorna o status 200 para sucesso e 404 para erro, o formato do json é:
```json
{
    "cidade_id": 1, //id-de-uma-cidade-ja-cadastrada-no-sitema
    "cep": 99999999,
    "rua": "Nova Rua",
    "numero": 9
}
```
  4. Metodo PUT(/enderecos/{id}) - E passado um id na url, envia um json no corpo da requisição para realizar a alteração no banco de dados, e retorna o status 200 para sucesso e 404 para erro (Devera passar somente os parametros que deseja alterar):
```json
{
    "cidade_id": 1,
    "cep": 99999999,
    "rua": "Nova Rua",
    "numero": 9
}
```
  
  5. Metodo DELETE(/enderecos/{id}) - É passado um id do registro que dejesa excluir, e retorna o status 200 para sucesso e 404 para erro.


### /registros
  1. Metodo GET(/registros) - Retorna a lista de Registros de um serviço, no seguinte formato:
```json
[
    {
        "id": 1, //id-do-registro
        "created": "2021-10-13T13:23:41.635+00:00", //data-de-criação-do-registro
        "updated": "2021-10-13T13:23:41.635+00:00", //data-de-atualização-do-registro
        "descricao": "Inicio do serviço" //decrição-do-registro
    }
]
```
  2. Metodo GET(/registros/{id}) - Retorna um Registro especificado com base no {id} no seguinte formato:
```json
{
  "id": 1, //id-do-registro
  "created": "2021-10-13T13:23:41.635+00:00", //data-de-criação-do-registro
  "updated": "2021-10-13T13:23:41.635+00:00", //data-de-atualização-do-registro
  "descricao": "Inicio do serviço" //decrição-do-registro
}
```
  3. Metodo POST(/registros) - Envia um json no corpo da requisição para realizar o cadastro no banco de dados, e retorna o status 200 para sucesso e 404 para erro, o formato do json é:
```json
{
  "descricao": "Inicio do serviço" //decrição-do-registro
}
```
  4. Metodo PUT(/registros/{id}) - E passado um id na url, envia um json no corpo da requisição para realizar a alteração no banco de dados, e retorna o status 200 para sucesso e 404 para erro (Devera passar somente os parametros que deseja alterar):
```json
{
  "descricao": "Inicio do serviço" //decrição-do-registro
}
```
  
  5. Metodo DELETE(/registros/{id}) - É passado um id do registro que dejesa excluir, e retorna o status 200 para sucesso e 404 para erro.


### /problemas
  1. Metodo GET(/problemas) - Retorna a lista de Problemas de equipamentos cadastradas no seguinte formato:
```json
[
  {
    "id": 1, //id-do-problema
    "descricao": "Aparelho não inicializa" //descrição-do-problema
  }
]
```
  2. Metodo GET(/problemas/{id}) - Retorna um Problema especificado com base no {id} no seguinte formato:
```json
{
  "id": 1,
  "descricao": "Aparelho não inicializa"
}
```
  3. Metodo POST(/problemas) - Envia um json no corpo da requisição para realizar o cadastro no banco de dados, e retorna o status 200 para sucesso e 404 para erro, o formato do json é:
```json
{
  "descricao": "Aparelho não inicializa"
}
```
  4. Metodo PUT(/problemas/{id}) - E passado um id na url, envia um json no corpo da requisição para realizar a alteração no banco de dados, e retorna o status 200 para sucesso e 404 para erro (Devera passar somente os parametros que deseja alterar):
```json
{
  "descricao": "Novo Problema"
}
```
  
  5. Metodo DELETE(/problemas/{id}) - É passado um id do registro que dejesa excluir, e retorna o status 200 para sucesso e 404 para erro.


## Como Usar
  ### Criação e busca de serviços
  Para criar um novo serviço, e necessario primeiramente ter um cliente, equipamento, problema e um status cadastrado no sistema, assim sera possivel fazer a inserção deles
  Esta configurado 3 tipos de busca para serviços, Geral (Busca todos os dados), Por ID, e Por Serviços Pendentes (Que tem o status diferente de "Finalizado")
