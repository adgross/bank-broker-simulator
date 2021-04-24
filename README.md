To initialize minikube:
        minikube start

To build docker images inside minikube, first we need to setup some env vars:
        eval $(minikube -p minikube docker-env) # from `minikube docker-env`

Build springboot docker images:
        ./gradlew bootBuildImage

Build quarkus docker images:
        docker build -f src/main/docker/Dockerfile.native -t balance .

Deploy all kubernetes services/pods, run:
        kubectl apply -f kubefiles/base
        kubectl apply -f kubefiles/services

To make the deployed ingress work, we need to enable minikube's ingress:
        minikube addons enable ingress

Add the same ingress `hosts` name in your hosts file, so we can access by name in the browser/curl (without configuring a dns server).
        `minikube ip` return the IP we should use for the hostname.
        `minikube ip`    bankbroker.local

To follow logs, you can use [stern](https://github.com/stern/stern/).

