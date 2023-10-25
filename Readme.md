# Configurando e Executando Testes de API com RestAssured e Maven no IntelliJ IDEA

Este guia fornece instruções passo a passo para configurar e executar um projeto de teste de API usando Java, RestAssured e Maven no IntelliJ IDEA. Ele também inclui informações sobre como configurar as variáveis de ambiente para o Maven.

## Pré-requisitos

- IntelliJ IDEA (ou outra IDE de sua escolha)
- Java JDK instalado
- Maven instalado
- Git instalado (opcional, para clonar o repositório)

## Clonando o Repositório

1. Clone o repositório do projeto usando o seguinte comando Git:
   ```bash
   git clone https://gitlab.com/tobiascamilo/teste-sicredi.git

## Configurando o Projeto

1. Abra o IntelliJ IDEA.

2. Se você já clonou o repositório Git, siga as etapas abaixo. Caso contrário, pule para a próxima etapa.

    - Selecione "File" > "New" > "Project from Existing Sources" para importar um projeto existente.
    - Selecione a pasta raiz do seu projeto.
    - Escolha "Maven" como o modelo de projeto.
    - Clique em "Next" e siga as instruções para criar o projeto.

3. Se você está criando um novo projeto:

    - Selecione "File" > "New" > "Project".
    - Escolha "Maven" como o modelo de projeto.
    - Clique em "Next" e siga as instruções para criar o projeto.

## Configurando as Variáveis de Ambiente.

1. No IntelliJ IDEA, abra as configurações do projeto. Você pode acessá-las em "File" > "Project Structure".

2. Na janela de configurações, selecione "Project" no lado esquerdo.

3. Em "Project SDK", selecione a versão do Java que você instalou.

4. Em "Project language level", selecione a versão do Java correspondente.

5. Clique em "Apply" e "OK" para salvar as configurações do projeto.

6. Agora, vamos configurar as variáveis de ambiente para o Maven. Acesse "File" > "Settings" (ou "IntelliJ IDEA" > "Preferences" em macOS).

7. Na janela de configurações, expanda a seção "Build, Execution, Deployment" e selecione "Build Tools" > "Maven".

8. Em "Maven home directory", selecione o caminho para a instalação do Maven.

9. Clique em "Apply" e "OK" para salvar as configurações.

## Executando Testes de API

1. Abra o arquivo de teste que deseja executar.

2. Configure seus testes RestAssured conforme necessário.

3. Clique com o botão direito no arquivo de teste e selecione "Run".

4. Os testes serão executados e os resultados serão exibidos no IntelliJ IDEA.

Isso conclui as etapas para configurar e executar um projeto de teste de API com RestAssured, Maven e IntelliJ IDEA. Agora você está pronto para começar a testar suas APIs.
