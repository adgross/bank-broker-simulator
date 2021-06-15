# Bank Broker Simulator

This project create a simple bank broker simulation, where the user can buy and sell quotes. The system should escalate using kubernetes and kafka, the business logic is splited in small microservice instances.

### How it works

The microservices:
- stock-exchange-simulator generate a random value each 5 seconds, it acts as an external service from where our system gets monetary info.
- bank-broker receive the requests from the users (web back-end). It is responsible to process and store user transactions.
- frontend render the web page. Send to users the html, javascript and css.
- balance store the current user balance, works like a cache, it gets transactions from bank-broker (via kafka) and always store the current balance value (after transactions get processed).


### Dependencies

- Java 11.
- Build with Gradle.
- Docker
- Minikube

### Build and run

To initialize minikube:

        minikube start

To build docker images inside minikube, first we need to setup some env vars:

        eval $(minikube -p minikube docker-env) # from `minikube docker-env`

Build spring images:

        ./gradlew bootBuildImage

Build quarkus images: *(only for `balance` subproject)*

        docker build -f src/main/docker/Dockerfile.native -t balance .

Deploy all kubernetes services/pods:

        kubectl apply -f kubefiles/base
        kubectl apply -f kubefiles/services

To make the deployed ingress work, we need to enable minikube's ingress:

        minikube addons enable ingress

Add the same ingress `spec.rules.host` in your hosts file, so we can access by name in the browser/curl.

        `minikube ip` return the IP we should use for the hostname.
        `minikube ip`    bankbroker.local

### Useful
- To get the project list of pods, services and deployments:

        kubectl get all -n bankbroker

- We can directly use pod instances in development, example:

        kubectl -n bankbroker port-forward service/database 5432:5432

- To follow logs, you can use [stern](https://github.com/stern/stern/).
