# healthlab2

1- Para rodar siga as configurações a baixo:

1.2- como o banco utilizado é o postgres pela aws precisa configurar as chaves

spring.datasource.url=jdbc:postgresql://APP_HOST:APP_PORT/APP_DB
spring.datasource.username=APP_USERNAME
spring.datasource.password=APP_PASSWORD

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=false

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto=update
