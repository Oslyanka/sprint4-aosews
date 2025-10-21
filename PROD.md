# Produção rápida (Postgres + Flyway)

## Subir banco com Docker
```bash
docker compose up -d
```

## Rodar Advisor API em perfil prod (usa Postgres)
```bash
cd services/advisor-api
mvn -Dspring-boot.run.profiles=prod spring-boot:run
```

## Rodar Market Data
```bash
cd services/marketdata-service
mvn spring-boot:run
```

Acesse Swagger: http://localhost:8080/swagger-ui/index.html
