Jantar dos Filósofos

O problema do Jantar dos Filósofos modela um conjunto de N processos que alternam entre dois estados: pensar e comer. Para comer, cada filósofo precisa adquirir dois recursos compartilhados: os dois garfos ao seu lado, um à esquerda e outro à direita.

No protocolo ingênuo, cada filósofo tenta pegar primeiro um garfo e depois o outro. Entretanto, se todos pegarem simultaneamente o garfo da esquerda e aguardarem o da direita, ocorre um impasse (deadlock): nenhum processo consegue prosseguir e nenhum recurso é liberado.

Condições de Coffman

Segundo as condições clássicas de Coffman para deadlock, o protocolo ingênuo satisfaz todas as quatro:

Exclusão mútua – garfos não podem ser compartilhados simultaneamente.

Hold-and-wait (manter-e-esperar) – um filósofo segura um garfo enquanto aguarda o outro.

Não-preempção – recursos não podem ser retirados à força.

Espera circular – cada filósofo pode esperar por um recurso que outro está segurando, formando um ciclo.

Como todas essas condições estão presentes, o deadlock é possível.

Solução: Hierarquia de Recursos

A solução adotada consiste em impor uma ordem total aos recursos (por exemplo, ordenando os garfos por índice). Cada filósofo deve sempre adquirir primeiro o garfo de menor índice, depois o de maior índice.

Essa abordagem elimina a espera circular, pois impede a formação de ciclos de dependências: nenhum filósofo pode esperar por um recurso de índice menor enquanto já segura um recurso de índice maior.

Com isso, garante-se ausência de deadlock.

Considerações sobre Starvation

Embora a hierarquia de recursos elimine deadlocks, ainda pode haver risco de starvation (inanição), caso um filósofo nunca consiga acesso aos recursos. Para reduzir esse risco, recomendam-se:

mecanismos de sincronização com fairness (como locks ou semáforos com política FIFO);

políticas de re-tentativa com backoff, evitando que o mesmo filósofo monopolize tentativas.

