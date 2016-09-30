Enterprise & Mobile Project
=======================
> Dit is de ReadMe waar je allerlei informatie kan vinden rond ons project.

----------
Leden entmob2016_12
--------
> - Francesco Ventura
> - Joren Luykx
> - Kaan Köseoglu
> - Bunyamin Eren

--------------------
Doelstelling
-----------------

> De bedoeling is gebruik te maken van de TI SensorTag om data te verzamelen en deze in een use case te benutten. We hebben hiervoor een SensorTag ter beschikking gekregen.

-----------------
Werkwijze
---------------

> We zijn overeengekomen om een client te maken die de data gebruikt om de gebruiker te waarschuwen bij kans op neerslag. Hiervoor gaan we een combinatie aan sensoren gebruiken.


### Data

> Dit zijn de sensoren die we willen gebruiken.

> |Sensor | Waarom? |
> | --- | --- | 
> | Barometer | De luchtdruk daalt altijd voor het regent |
> | Humidity sensor | Een verhoogde vochtgehalte kan wijzen op neerslag |
> | Thermometer | Suggesties aan de hand van temperatuur |


### Verwerking

**Luchtdruk**

> Standaard is de atmosferische druk 1013 hPa ( 1013 mbar), dit verandert natuurlijk per klimaatzone. Gedurende de dag schommelt dit met enkele units. Bij hoge luchtdruk is het doorgaans mooi weer lichtbewolkt weer, terwijl bij lage luchtdruk het eerder slecht weer is, en indien laag genoeg, regenweer.

> ![Grafiek van luchtdruk per maand 1981-2010](http://www.meteo.be/meteo/download/nl/16230363/image/scaletomax-700-700/pressure_nl_1981_2010.png)

> Op deze grafiek kunnen we zien dat de laagste gemiddelde luchtdruk valt in de maand april, dat gevolgd wordt door de maanden oktober en november. Deze maanden worden in de volksmond ook typisch de regenmaanden genoemd.

**Vochtgehalte**

> De vochtgehalte is vooral handig bij hoge waarden. Meestal wordt het enkel 100% bij neerslag. We kunnen dus meten naar hoge vochtgehalten en dit combineren met onze luchtdrukmetingen.

**Temperatuur**

> De temperatuur staat er eigenlijk bij als extraatje. Bij metingen en interacties gerelateerd aan het weer is het meestal ook nuttig om de temperatuur te tonen. Dat is eigenlijk de standaard. Wat we ook wel van plan zijn is om dit te incorporeren in onze verwerking en suggesties aan te bieden bij bepaalde weercombinaties.

### Uitwerking

> Wat we uiteindelijk van plan zijn is het maken van een applicatie dat deze gegevens verzamelt van onze sensor. Op basis van de luchtdruk en vochtgehalte wordt er gekeken of er kans is op neerslag. In dat geval krijgt de gebruiker een melding. 
> We kunnen ook bij bepaalde combinaties (vochtig & warm, elk soort regenweer, etc) een extra melding doorsturen.

### Diagram
> Hier vindt u ons architectuur-tekening
> ![Architectuur-tekening](https://github.com/pxlit-projects/entmob2016_12/blob/master/Diagram/Diagram.png)
