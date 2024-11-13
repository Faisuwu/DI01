#Antoni Maqueda Bestard - DI01 - README.md


#Sketches de la UI:

Per començar, anem a mostrar els sketches de la UI.
La pàgina principal, on surt es logo amb el link de la web i el botó per fer login
Tal i com especifica l'enunciat:

![Main Screen](/images/Main.png)

La pàgina de login, amb un disseny simple peró efectiu:

![Login Screen](/images/Login.png)

Una vegada fet login, l'instructor ha de visualitzar els usuaris que està entrenant:

![Instructor Screen](/images/Instructor.png)

Quan es clica a un usuari, han de sortir els entrenaments que realitza:

![User Screen](/images/Usuari.png)

I si es clica l'entrenament, han de sortir les seves especificacions:

![Entrenament Screen](/images/Entrenament.png)

Aquests sketches son molt senzills peró no vull que l'UI de l'aplicació sigui molt complexa.
Potser canviaré el color de fons de blau a gris clar.



#Documentació:

El projecte està dividit seguint una estructura modular, repartida en packages ("connection", "interfaz", "model", "service"), cadascun amb una funció específica:

Connection: gestiona les connexions amb la base de dades. Aquí he posat la classe DataAccess, que actua com a intermediari amb la base de dades. També he inclòs BCryptUtils, ja que juga un paper important en la gestió i encriptació de les contrasenyes.

Interfaz: conté tots els panels del projecte, inclòs el de Login, que permet l'autenticació d'usuaris.

Model: agrupa les classes Exercici, Usuari i Workout, amb els seus respectius getters i setters per definir les dades que gestionarà l'aplicació.

Service: fa de pont entre DataAccess i els Panels, incloent-hi part de la lògica d'accés a la base de dades que no està a DataAccess.


#Funcionalitat Extra:

He implementat la funcionalitat de poder afegir, editar i eliminar exercicis, de la mateixa manera que ja es feia amb els Workouts. Per fer-ho, he actualitzat WorkoutService, afegint-hi els tres mètodes (create, update, delete) i, posteriorment, els he integrat a WorkoutPanel.


#Incidències i problemes trobats:

El principal problema amb el qual m'he trobat ha estat la configuració de la base de dades. Faig servir un ordinador amb macOS, on SQL Server ja no està disponible de forma nativa. Vaig intentar configurar un contenidor amb Docker per instal·lar SQL Server al meu ordinador, però aquest té un processador M1 d'Apple, que utilitza arquitectura ARM64, mentre que SQL Server només ofereix suport per a AMD64. A causa d'això, Docker no em funcionava correctament amb SQL Server.

Lamentablement, vaig començar el projecte massa tard, i no he tingut temps de trobar una solució alternativa per a la base de dades. Això ha fet que no hagi pogut iniciar l'aplicació en cap moment, i, per tant, no he pogut corregir errors que només es detecten en fase d'execució amb connexió a la base de dades.


#Recursos Utilitzats:

Sense tenir en compte els recursos de l'assignatura a l'aula virtual, he fet servir únicament ChatGPT.
L'he utilitzat per corregir algunes classes del projecte. Aixó es degut a que, a causa del problema amb el sistema gestor de bases de dades, no he pogut comprovar si l'execució era correcta ni detectar possibles errors en el funcionament de forma manual. Tot i aixi, dubt que l'aplicació funcioni del tot correctament.