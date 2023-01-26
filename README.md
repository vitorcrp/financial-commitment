# Projeto para calcular o comprometimento financeiro de uma empresa

O presente projeto se baseia na construção de um serviço que calcula o comprometimento financeiro de uma empresa através de sua estrutura societária.

## Aspectos importantes:

Foi disponibilizado um endpoint que recebe um número inteiro, referente ao Id da empresa, no path. Para retornar o valor da soma do total de bens imóveis dessa
determinada empresa e de seus sócios.

### Recursos técnicos utilizados:

- Gerenciador de dependências: Maven
- Banco de dados em memória utilizando o H2
- Lombok
- JPA

### Sobre o algoritmo utilizado:

Para percorrer a estrutura societária, foi utilizado o algoritmo de busca em largura, uma vez que, essa estrutura se assemelha a de um grafo, e houve a necessidade de percorrer 
todos os vértices que estão relacionados. Um ponto importante foi necessário marcar as empresas e sócios que já foram contabilizados, uma vez que a busca não deve entrar em loop ou contabilizar os bens imóveis de um sócio ou empresa mais de uma vez.

Para incluir registros no banco de dados foi utilizado um script localizado no package Resources, no qual é possível incluir as estrutura societaria, uma vez que existe a tabela de pessoas fisicas e juridicas, e outra utilizada pra estabelecer a relação de sócios.
