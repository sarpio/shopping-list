# Shopping list
Application works as list of planned shopping
Easy Add and remove item from the list if reach the basket

## Dockerized application
Application consists of ackend part working on post 8080 and Frontend part working on port 4200

Each component has its own Dockerfile and both are deployed on docker using docker compose command stored in docker-compose.yaml file

### Forntend
Based on Angular 17 framework

### Backend
Java 21, Sring Boot 3.2 application

### Installation
It is recommended to have docker installed before  application installation. Eventually you can deploy application manually following to standard procedure for java and angular application. Detailed commands are in `docker-compose.yaml` file.

#### Docker installation
just run `docker compose up -d`
