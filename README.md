# 5TWIN4-G3-projet2 DEVOPS 


## ENTITY 

Departement Entity 

## DOCKER COMPOSE 

MYSQL + ANGULAR(+NGINX Web Server) + SPRINGBOOT


## BUIDL DOCKER IMAGE

docker build -t my-angular-app .

## RUN ON NGINX WEB SERVER 

docker run -d -p 80:80 my-angular-app


