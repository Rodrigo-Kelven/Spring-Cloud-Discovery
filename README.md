
## 📌 Spring Cloud Discovery – Exemplo Simples

[![My Skills](https://skillicons.dev/icons?i=spring,maven)](https://skillicons.dev)

Este projeto demonstra o funcionamento do Service Discovery utilizando Spring Cloud Netflix Eureka com três aplicações:

- *eureka-server* → Servidor de descoberta
- *servicea* → Serviço cliente
- *serviceb* → Serviço cliente


## 🏗 Arquitetura

            +-------------------+
            |   Eureka Server   |
            |     (8761)        |
            +-------------------+
               ↑             ↑
               |             |
       +--------------+  +--------------+
       |   Service A  |  |   Service B  |
       |    (8081)    |  |    (8082)    |
       +--------------+  +--------------+


## 🔎 Como funciona
### 1. Eureka Server (eureka-server)

#### É o servidor de registro de serviços.

### Configuração principal
    
    spring:
      application:
        name: eureka-server
    
    server:
      port: 8761
    
    eureka:
      client:
        register-with-eureka: false
        fetch-registry: false


### O que ele faz?

- Mantém um registro de todos os serviços ativos
- Permite que serviços encontrem outros serviços pelo nome

Disponível em: 
- http://localhost:8761/
    
      register-with-eureka: false
  #### Porque ele é o servidor, não precisa se registrar.


## 2. Service A (servicea)

    spring:
      application:
        name: servicea
    
    server:
      port: 8081

- Sobe na porta 8081
- Se registra automaticamente no Eureka
- Fica visível no painel do Eureka


## 3. Service B (serviceb)

    spring:
      application:
        name: serviceb
    
    server:
      port: 8082

- Sobe na porta 8082
- Também se registra automaticamente no Eureka
- Pode descobrir e chamar o servicea pelo nome


### 🔁 Fluxo de Funcionamento

- O Eureka Server sobe primeiro.
- servicea inicia e se registra no Eureka.
- serviceb inicia e se registra no Eureka.

#### O Eureka passa a saber:

      SERVICEA → localhost:8081
      SERVICEB → localhost:8082


#### Agora, ao invés de chamar:

    http://localhost:8081

#### Um serviço pode chamar:

    http://servicea

#### E o Eureka resolve automaticamente o endereço.


### 🚀 Ordem de Execução

- Subir eureka-server
- Subir servicea
- Subir serviceb

Acessar o painel:

    http://localhost:8761/


### 🎯 Benefícios do Service Discovery

- Não precisa fixar IP/porta
- Facilita escalabilidade
- Permite múltiplas instâncias do mesmo serviço
- Base para Load Balancing e Microservices

---


| Aplicação     | Função                     | Porta |
| ------------- | -------------------------- | ----- |
| eureka-server | Registro de serviços       | 8761  |
| servicea      | Serviço cliente registrado | 8081  |
| serviceb      | Serviço cliente registrado | 8082  |
