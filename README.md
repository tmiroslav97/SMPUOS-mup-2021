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
CentralRegistryService | Servis vezan za centralni registar gradjana. |  8083 |  [Detaljno](CentralRegistryService/README.md)
CounterService | Servis vezan za poslovanje saltera. |  8084 |  [Detaljno](CounterService/README.md)
VehicleService | Servis vezan za sluzbe za vozila. |  8085 |  [Detaljno](VehicleService/README.md)
HealthService | Servis vezan za zdravstvo. |  8086 |  [Detaljno](HealthService/README.md)
PoliceService | Servis vezan za rad policijske sluzbe. |  8087 |  [Detaljno](PoliceService/README.md)
Frontend | Servis za frontend. |  3000 |  [Detaljno](frontend/README.md)
