# MUP - SMPUOS projekat

Fakultetski projekat iz predmeta softversko modelovanje procesa u organizacionim sistemima.

Ovde je dat pregled svih mikroservisa koji su implementirani i link ka njihovom detaljnom opisu.

Autori:
* [Dragana Prodanovic](https://github.com/)
* [Jovan Jovkic](https://github.com/)
* [Nikola Arsenijevic](https://github.com/)
* [Dragan Jovic](https://github.com/)
* [Miroslav Tomic](https://github.com/tmiroslav97)

### Spisak mikroservisa

Naziv mikroservisa | Kratak opis | Port | Detljano
------------ | ------------- | ------------- | -------------
EurekaService | Za konfiguraciju service discovery je koriscena eureka. |  8761 |  [Detaljno](EurekaService/README.md)
Zuul | Za service gateway je koriscen zuul. |  8082 |  [Detaljno](Zuul/README.md)
HealthService | Servis vezan za zdravstvo. |  8086 |  [Detaljno](HealthService/README.md)
