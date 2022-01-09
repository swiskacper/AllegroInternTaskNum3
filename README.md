# AllegroInternTaskNumber3

## Opis
Aplikacja RESTful stworzona w Javie 11 za pomocą frameworka Spring Boot. Aplikacja komunikuje się z GitHub REST
API i pozwala na:
*Listowanie repozytoriów danego użytkownika (nazwa repozytorium + liczba gwiazdek) + ewentualne następne strony paginacyjne<br>
*Zliczanie całkowitej liczby gwiazdek danego użytkownika (ze wszystkich repozytoriów)<br>
*Listowanie języków programowania używanych w repozytoriach przez danego użytkownika<br>

## Konfiguracja
Przed rozpoczęciem użytkowania aplikacji, należy skonfigurować "GithubToken"
(application.properties)


## Start



### Za pomocą IDE

1.Pobierz to repozytorium. <br>
2.Poczekaj, aż Maven pobierze zależności. <br>
3.Upewnij się, że skonfigurowałeś "GithubToken". <br>
4.Uruchom aplikację, poprzez klasę  AllegroInternTask. <br>

### Za pomocą dokera
1.Otwórz terminal. <br>
2.Pobierz Image za pomocą polecenia. <br>
```
docker pull swiskacper/allegro_intern_task
```
3.Uruchom container za pomocą polecenia: <br>
```
docker run -p 9090:8081 swiskacper/allegro_intern_task
```

## Dokumentacja

### Endpoints:
*GET, path: **/api/repos/{user}**<br>
Listowanie repozytoriów danego użytkownika (nazwa repozytorium + liczba gwiazdek)
```
curl -X GET "http://localhost:8081/api/repos/allegro" -H "accept: */*"
```
RESPONSE:
```json
{
    "userReposModel": {
        "nameOfUser": "allegro",
        "user_repos": [
            {
                "name": "akubra",
                "stargazers_count": 80
            },
            {
                "name": "allegro-api",
                "stargazers_count": 160
            },
            {
                "name": "allegro-tech-labs-iot",
                "stargazers_count": 1
            },
            {
                "name": "allegro-tech-labs-microservices",
                "stargazers_count": 7
            },
            {
                "name": "allegro.tech",
                "stargazers_count": 20
            },
            {
                "name": "allRank",
                "stargazers_count": 426
            },
            {
                "name": "atm-event-admin",
                "stargazers_count": 0
            },
            {
                "name": "atm-event-app",
                "stargazers_count": 5
            },
            {
                "name": "atm-event-scanner",
                "stargazers_count": 0
            },
            {
                "name": "atm-hero-generator",
                "stargazers_count": 2
            },
            {
                "name": "axion-release-plugin",
                "stargazers_count": 425
            },
            {
                "name": "banana-split",
                "stargazers_count": 5
            },
            {
                "name": "bigcache",
                "stargazers_count": 5369
            },
            {
            ...
            }
              {
                "name": "elasticsearch-analysis-morfologik",
                "stargazers_count": 65
            },
            {
                "name": "elasticsearch-reindex-tool",
                "stargazers_count": 43
            }
        ]
    },
    "uriModelsList": [
        {
            "direction": "Prev",
            "uri": "http://localhost:8081/api/repos/allegro?page=2&per_page=30"
        },
        {
            "direction": "Next",
            "uri": "http://localhost:8081/api/repos/allegro?page=4&per_page=30"
        }
    ]
}

```

*GET, path: **/api/stars/{user}**<br>
*Zliczanie całkowitej liczby gwiazdek danego użytkownika (ze wszystkich repozytoriów)
```
curl -X GET "http://localhost:8081/api/stars/allegro" -H "accept: */*"
```
RESPONSE:
```json
{
    "name": "allegro",
    "numberOfStars": 14473
}
```


*GET, path: **/api/details/{user}**<br>
*Listowanie języków używanych w repozytoriach przez danego użytkownika

```
curl -X GET "http://localhost:8081/api/details/swiskacper" -H "accept: */*"
```

RESPONSE:
```json
{
    "user": "swiskacper",
    "result": {
        "Java": 119688,
        "HTML": 939
    }
}
```
