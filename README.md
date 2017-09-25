# Geoxygene 3D applications  [![Build Status](https://travis-ci.org/IGNF/geoxygene-sig3d-appli.svg?branch=master)](https://travis-ci.org/IGNF/geoxygene-sig3d-appli)


![3D Image](https://raw.githubusercontent.com/IGNF/geoxygene-sig3d-appli/master/img/3Dimg.png)

This project contains a set of 3D GIS applications developed from GeOxygene3D module from [GeOxygene platform](https://github.com/IGNF/geoxygene). It includes several published works :
 - [Street profil calculation](#street-profil-calculation)   
 - [Sky openess calculation](#sky-openess-calculation)
 - [Generation of hulls and buildings from urban regulation](#Generation-of-hulls-and-buildings-from-urban-regulation)

## Things to know

This is research work, so it is very probable that the project constains some bugs and project is not actively maintained, but do not hesitate to send an e-mail if you need help to use it.

## Contact for questions and feedback

Mickaël Brasebin, [Lastig/COGIT](http://recherche.ign.fr/labos/cogit/cv.php?nom=Brasebin), mickael.brasebin at ign dot fr

Julien Perret, [Lastig/COGIT](http://recherche.ign.fr/labos/cogit/cv.php?nom=Perret), julien.perret at ign dot fr


## Street profil calculation


![Image of profile result](https://raw.githubusercontent.com/IGNF/geoxygene-sig3d-appli/master/img/StreetProfile.png)


This code (in the package streetprofile) was developed during a Msc training course. The thesis is available [here](http://recherche.ign.fr/labos/cogit/publiCOGITDetail.php?idpubli=5214).

The test class fr.ign.cogit.streetprofile.demo.Main.java is directly runnable as it uses data included in the project.


## Sky openess calculation

![Image of generated geometry](https://raw.githubusercontent.com/IGNF/geoxygene-sig3d-appli/master/img/openess.png )



This code (in the package exec) was developed for a research work about the influence of data quality on Sky openess calcaultion. The paper about this work is available [here](http://recherche.ign.fr/labos/cogit/publiCOGITDetail.php?idpubli=4759&portee=chercheur&id=59&classement=date&duree=100&nomcomplet=Brasebin%20Mickael&annee=2012&principale=)

## Generation of hulls and buildings from urban regulation

![Simulation image](https://raw.githubusercontent.com/IGNF/geoxygene-sig3d-appli/master/img/simul.png)

This code (in the package gru3d) was developed for a research work about assessing constructability from urban local regulation. The paper about this work is available [here](http://recherche.ign.fr/labos/cogit/publiCOGITDetail.php?idpubli=4120&portee=chercheur&id=59&classement=date&duree=100&nomcomplet=Brasebin%20Mickael&annee=2011&principale=)

## System requirements

+ Java (JDK 8 or more recent)
+ Eclipse
+ Maven
The necessary developpers tools are the same as necessary for GeOxygene project, you can find an installation manual [here](http://ignf.github.io/geoxygene/documentation/developer/install.html).

## Acknowledgments


+ This research is supported by the French National Mapping Agency ([IGN](http://www.ign.fr))
+ It is partially funded by the FUI TerraMagna project and by Île-de-France
Région in the context of [e-PLU projet](www.e-PLU.fr)
+ Marina Fund for the development of street profil module
