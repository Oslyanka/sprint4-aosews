@echo off
REM Define TOKEN antes: set TOKEN=eyJhbG...
curl -s -X POST http://localhost:8080/api/clients ^
 -H "Authorization: Bearer %TOKEN%" ^
 -H "Content-Type: application/json" ^
 -d "{\"name\":\"Maria\",\"riskProfile\":\"CONSERVADOR\",\"liquidity\":15000}"
echo.
curl -s -X POST http://localhost:8080/api/assets ^
 -H "Authorization: Bearer %TOKEN%" ^
 -H "Content-Type: application/json" ^
 -d "{\"ticker\":\"TESOURO\",\"assetClass\":\"RENDA_FIXA\",\"risk\":0.05,\"expReturn\":0.11}"
echo.
curl -s -X POST http://localhost:8080/api/recommendations/generate ^
 -H "Authorization: Bearer %TOKEN%" ^
 -H "Content-Type: application/json" ^
 -d "{\"clientId\":1,\"goal\":\"aposentadoria\",\"horizonYears\":20}"
echo.
pause
