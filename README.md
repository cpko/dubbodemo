# a demo for alibaba dubbo framework

## how to run
- install zookeeper and start

- build service as daemon
  - fab -f build_service.py build:env=prod

- start service
  - ./services.sh start

- package web
  - mvn clean package -am -pl web -Dmaven.test.skip=true -Pprod

- deploy web,then you can visit
  - localhost:8080/api/user/1

