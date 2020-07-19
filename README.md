# Инструкция по сборке

## Окружение

1. JDK Oracle версии 1.8
2. Maven версии 3.3.1 и выше
3. Сервер wildfly (работоспособность проверена на версии 13.0.0)
4. Должны быть установлены переменные окружения:

*JAVA_HOME=путь до JDK*\
*M2_HOME=путь до Maven*\
*WILDFLY_SERVER=путь до корневой директории сервера wildfly (не обязательно)*


## Добавление datasource в wildfly

1. Если переменная WILDFLY_SERVER установлена:

*остановить сервер, если запущен*
*mvn clean package -P add-datasource*
Это запустит сервер, добавит datasource и остановит его

2. Если переменная WILDFLY_SERVER не установлена:

*запустить сервер*
*mvn clean package -P add-datasource-running*
Это добавит datasource в запущенный сервер

3. Можно добавить datasource в wildfly руками (не рекомендую), база данных H2, логин и пароль - sa, JNDI - java:/argusStore. После чего:

*mvn clean package*


4. Итоговое war приложение в папке 

*<корень_проекта>\target*

5. Поместить в папку wildfly/standalone/deployments

### Home page: argus_test 