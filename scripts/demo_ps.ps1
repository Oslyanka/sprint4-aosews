$ErrorActionPreference = "Stop"
$loginBody = @{ email = "ana@facul.edu"; password = "123456" } | ConvertTo-Json
$loginResp = Invoke-RestMethod -Uri "http://localhost:8080/api/auth/login" -Method POST -ContentType "application/json" -Body $loginBody
$TOKEN = $loginResp.accessToken
$headers = @{ Authorization = "Bearer $TOKEN"; "Content-Type" = "application/json" }
$clientBody = @{ name="Maria"; riskProfile="CONSERVADOR"; liquidity=15000 } | ConvertTo-Json
Invoke-RestMethod -Uri "http://localhost:8080/api/clients" -Method POST -Headers $headers -Body $clientBody
$assetBody = @{ ticker="TESOURO"; assetClass="RENDA_FIXA"; risk=0.05; expReturn=0.11 } | ConvertTo-Json
Invoke-RestMethod -Uri "http://localhost:8080/api/assets" -Method POST -Headers $headers -Body $assetBody
$recBody = @{ clientId=1; goal="aposentadoria"; horizonYears=20 } | ConvertTo-Json
Invoke-RestMethod -Uri "http://localhost:8080/api/recommendations/generate" -Method POST -Headers $headers -Body $recBody
