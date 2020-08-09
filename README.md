# Zadanie rekrutacyjne

Zadanie polega na przygotowaniu usługi REST która zwróci:
- stronicowaną listę bohaterów Gwiezdnych Wojen
- szczegóły poszczególnych bohaterów.

API powinno wystawiać dwie końcówki:
```bash
GET /characters?page=x
```
```json
{
"count": 82,
"pages": 9,
"elements": [
{
"id": 1,
"name": "Luke Skywalker",
"height": "172",
"mass": "77",
"hairColor": "blond",
"skinColor": "fair",
"eyeColor": "blue",
"birthYear": "19BBY",
"gender": "male",
"homeworld": {
"name": "Tatooine",
"rotationPeriod": "23",
"orbitalPeriod": "304",
"diameter": "10465",
"climate": "arid",
"gravity": "1 standard",
"terrain": "desert",
"surfaceWater": "1",
"population": "200000"
},
"starships": [
{
"name": "X-wing",
"model": "T-65 X-wing",
"manufacturer": "Incom Corporation",
"costInCredits": "149999",
"length": "12.5",
"maxAtmosphericSpeed": "1050",
"crew": "1",
"passengers": "0",
"cargoCapacity": "110",
"consumables": "1 week",
"hyperdriveRating": "1.0",
"mglt": "100",
"starshipClass": "Starfighter"
},
{
"name": "Imperial shuttle",
"model": "Lambda-class T-4a shuttle",
"manufacturer": "Sienar Fleet Systems",
"costInCredits": "240000",
"length": "20",
"maxAtmosphericSpeed": "850",
"crew": "6",
"passengers": "20","cargoCapacity": "80000",
"consumables": "2 months",
"hyperdriveRating": "1.0",
"mglt": "50",
"starshipClass": "Armed government transport"
}
]
}
]
}
```
```bash
GET /characters/{id}
```
```json
{
"id": 1,
"name": "Luke Skywalker",
"height": "172",
"mass": "77",
"hairColor": "blond",
"skinColor": "fair",
"eyeColor": "blue",
"birthYear": "19BBY",
"gender": "male",
"homeworld": {
"name": "Tatooine",
"rotationPeriod": "23",
"orbitalPeriod": "304",
"diameter": "10465",
"climate": "arid",
"gravity": "1 standard",
"terrain": "desert",
"surfaceWater": "1",
"population": "200000"
},
"starships": [
{
"name": "X-wing",
"model": "T-65 X-wing",
"manufacturer": "Incom Corporation",
"costInCredits": "149999",
"length": "12.5",
"maxAtmosphericSpeed": "1050",
"crew": "1",
"passengers": "0",
"cargoCapacity": "110",
"consumables": "1 week",
"hyperdriveRating": "1.0",
"mglt": "100",
"starshipClass": "Starfighter"
},
{
"name": "Imperial shuttle",
"model": "Lambda-class T-4a shuttle",
"manufacturer": "Sienar Fleet Systems",
"costInCredits": "240000",
"length": "20",
"maxAtmosphericSpeed": "850",
"crew": "6",
"passengers": "20",
"cargoCapacity": "80000",
"consumables": "2 months",
"hyperdriveRating": "1.0",
"mglt": "50","starshipClass": "Armed government transport"
}
]
}
```

# Wymagania
Wymagania poza funkcjonalne
-powinna być w stanie obsłużyć 20 zapytań na sekundę (nie powinna zawierać oczywistych wąskich gardeł)
-pełny zestaw testów uruchamiany wraz z narzędziem budującym (Maven lub Gradle)
-dobry projekt i jakość kodu

Dodatkowe wymagania
- obsługa i logowanie błędów
- konfiguracja Swagger UI
- dokeryzacja aplikacji
- przygotowanie do monitorowania przy pomocy Prometheus

# Technologie
Wymagane technologie
- Java 11
Zalecane technologie:
- Spring
- Spock

# Dodatkowe uwagi
- Informację o bohaterach Gwiezdnych Wojen można znaleźć pod adresem: https://swapi.dev/.
- Zadanie można modyfikować o ile wszelkie zmiany zatną logicznie udokumentowane.
- Rozwiązanie należy umieścić na prywatnym repozytorium na https://github.com.
- Należy utworzyć Pull Request z dowolnego brancha do mastera.
- Nadać uprawnienia do zapisu naszemu użytkownikowi: NASK-DRSI
