<h1>Ticket Analyzer API</h1>

A API Ticket Analyzer foi desenvolvida para gerenciar e analisar tickets de um sistema de suporte técnico, fornecendo ferramentas para consultar, filtrar e exportar dados sobre os tickets. Essa documentação abrange o funcionamento da API, as tecnologias utilizadas e os endpoints disponíveis.

<h2>Tecnologias Utilizadas</h2>

<h3>Spring Boot</h3>
O Spring Boot foi utilizado para a criação da aplicação, permitindo o desenvolvimento rápido de uma API RESTful. Ele gerencia a configuração do servidor e facilita a integração com as tecnologias utilizadas, como o PostgreSQL e o Apache POI.

<h3>Apache POI</h3>
A biblioteca Apache POI é utilizada para ler e processar arquivos Excel (.xlsx) contendo dados de tickets. A partir desses arquivos, os dados são extraídos e armazenados no banco de dados.

<h3>PostgreSQL</h3>
O banco de dados utilizado para armazenar os tickets é o PostgreSQL, um banco de dados relacional open-source amplamente utilizado em ambientes corporativos.

<h3>JPA (Java Persistence API)</h3>
A JPA é utilizada para interagir com o banco de dados de forma simplificada. As entidades de dados (como o Ticket) são mapeadas para tabelas no banco de dados, permitindo que as operações CRUD (Criar, Ler, Atualizar, Excluir) sejam realizadas de maneira eficiente.

<h3>Lombok</h3>
A biblioteca Lombok foi utilizada para reduzir a quantidade de código boilerplate, como getters, setters e métodos toString, equals e hashCode. Isso melhora a legibilidade e a manutenção do código.

<h2>Endpoints</h2>

<h3>Obter Ticket por ID</h3>

<ul>
<li>Método: GET</li>
<li>Endpoint: /tickets/{ticket}</li>
<li>Descrição: Retorna informações detalhadas de um ticket com base no seu identificador.</li>
<li>Exemplo de Requisição: GET /tickets/TDEV00000</li>
</ul>

<h4>Exemplo de Resposta:</h4>

```json
{
    "id": 7369,
    "statusTicket": "Aguardando Teste Funcional",
    "ticket": "TDEV00000",
    "descricaoTicket": "Descrição genérica do ticket.",
    "tipoAssociacao": "XXX",
    "identificacaoAssociacao": "YYY",
    "descricaoAssociacao": "Descrição genérica da associação.",
    "nomeSolicitante": "XXX",
    "nomeAvaliadorTecnico": "XXX",
    "tipoDesenvolvedor": "XXX",
    "nomeDesenvolvedor": "XXX",
    "prioridade": "Média",
    "motivoSolicitacao": "Melhorar Experiência do Usuário",
    "equipeTrabalho": "XXX",
    "modulo": "AAA",
    "etapa": "5 - Em teste funcional",
    "dataCriacaoTicket": "2024-01-26T10:35:52",
    "dataEncerramentoTicket": null,
    "statusDocumento": "Aprovado",
    "tipoSolicitacao": "Alterações no escopo",
    "documentoReprovado": "Não",
    "motivoReprovacao": "",
    "complexidade": "03 - Média",
    "volumeTrabalho": null,
    "totalEsforcoPrevisto": 17.0,
    "prazoEntregaDesenvolvimento": null,
    "totalEsforcoAdicional": 0.0,
    "esforcoPrevistoMaisHorasAdicionais": 17.0,
    "esforcoReal": 2.3497222222222223,
    "terminoRealDesenvolvimento": "2024-11-25T11:03:46",
    "statusDesenvolvimento": "Entregue abaixo do esforço previsto mas com atraso",
    "changeRequests": "Ticket não gerou change request -",
    "dataAtual": "2025-01-29T12:54:30",
    "dataTratada": null,
    "dataConvertida": "2024-06-18T09:00:00"
}
```

<h3> Obter Tickets por Status</h3>
<ul>
<li>Método: GET</li>
<li>Endpoint: /tickets/status/{status}</li>
<li>Descrição: Retorna uma lista de tickets com base no status.</li>
<li>Exemplo de Requisição: GET /tickets/status/Aguardando Teste Funcional</li>
</ul>

<h4>Exemplo de Resposta:</h4>

```json

    {
        "id": 7369,
        "statusTicket": "Aguardando Teste Funcional",
        "ticket": "TDEV00000",
        "descricaoTicket": "Descrição genérica do ticket.",
        "tipoAssociacao": "XXX",
        "identificacaoAssociacao": "YYY",
        "descricaoAssociacao": "Descrição genérica da associação.",
        "nomeSolicitante": "XXX",
        "nomeAvaliadorTecnico": "XXX",
        "tipoDesenvolvedor": "XXX",
        "nomeDesenvolvedor": "XXX",
        "prioridade": "Média",
        "motivoSolicitacao": "Melhorar Experiência do Usuário",
        "equipeTrabalho": "XXX",
        "modulo": "AAA",
        "etapa": "5 - Em teste funcional",
        "dataCriacaoTicket": "2024-01-26T10:35:52",
        "dataEncerramentoTicket": null,
        "statusDocumento": "Aprovado",
        "tipoSolicitacao": "Alterações no escopo",
        "documentoReprovado": "Não",
        "motivoReprovacao": "",
        "complexidade": "03 - Média",
        "volumeTrabalho": null,
        "totalEsforcoPrevisto": 17.0,
        "prazoEntregaDesenvolvimento": null,
        "totalEsforcoAdicional": 0.0,
        "esforcoPrevistoMaisHorasAdicionais": 17.0,
        "esforcoReal": 2.3497222222222223,
        "terminoRealDesenvolvimento": "2024-11-25T11:03:46",
        "statusDesenvolvimento": "Entregue abaixo do esforço previsto mas com atraso",
        "changeRequests": "Ticket não gerou change request -",
        "dataAtual": "2025-01-29T12:54:30",
        "dataTratada": null,
        "dataConvertida": "2024-06-18T09:00:00"
    }

```

<h3>Obter Contagem de Tickets por Status</h3>
<ul>
<li>Método: GET</li>
<li>Endpoint: /tickets/contagem-por-status</li>
<li>Descrição: Retorna a contagem de tickets agrupados por status.</li>
<li>Exemplo de Requisição: GET /tickets/contagem-por-status</li>
</ul>

<h4>Exemplo de Resposta:</h4>

```json
{
    "Validação Técnica": 1,
    "Aberta": 18,
    "Desenvolvimento": 20,
    "Aguardando Homologação": 79,
    "Aguardando Avaliação Técnica": 10,
    "Correção Desenvolvimento": 8,
    "Aguardando Teste Funcional": 188,
    "Aguardando Desenvolvimento": 29,
    "Concluída": 1219,
    "Desfazer Desenvolvimento": 112,
    "Correção de TD": 26,
    "Teste Funcional": 312,
    "Avaliação Técnica": 9,
    "Ticket de Desenvolvimento Pausado": 26,
    "Revisão de Requests/Deploy": 45,
    "Cancelada": 213,
    "Avaliação Técnica Fábrica": 2
}
```
<h3>Obter Tickets de Desenvolvedor com Status</h3>
<ul>
<li>Método: GET</li>
<li>Endpoint: /tickets/desenvolvedor/{nomeDesenvolvedor}</li>
<li>Descrição: Retorna a contagem de tickets agrupados pelo status de desenvolvimento para um desenvolvedor específico.</li>
<li>Exemplo de Requisição: GET /tickets/desenvolvedor/XXX</li>
</ul>
<h4>Exemplo de Resposta:</h4>

```json
{
    "Em dia": 1,
    "Entregue abaixo do esforço previsto mas com atraso": 10
}
```
<h3>Upload de Arquivo Excel</h3>
<ul>
<li>Método: POST</li>
<li>Endpoint: /tickets/upload</li>
<li>Descrição: Faz o upload de um arquivo Excel contendo dados dos tickets e processa as informações.</li>
<li>Exemplo de Requisição: POST /tickets/upload</li>
</ul>
<h4>Exemplo de Resposta:</h4>

```json
{
    "message": "File uploaded successfully!"
}
```

<h2>Licença</h2>

<p>Este projeto está licenciado sob a <a href="https://opensource.org/licenses/MIT" target="_blank">Licença MIT</a>.</p>


        Nota: Para fins de privacidade e segurança, informações pessoais, como nomes de solicitantes, avaliadores, desenvolvedores, e equipes de trabalho foram substituídas por "XXX" e "YYY" nas respostas acima, e o campo "modulo" foi alterado para "AAA". O campo ticket foi substituído por "TDEV00000" em todos os exemplos.