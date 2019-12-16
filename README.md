# mtgCardSearcher

Projet scolaire d'introduction � la programmation mobile.

Cette application permet d'afficher la liste de toutes les cartes Magic The Gathering d'un set choisi.
Cliquer sur une carte permet d'afficher le texte oracle de cette carte. (Le texte oracle correspond aux r�gles mises � jour,
particuli�rement utile pour les cartes tr�s anciennes).

# Consignes respect�es :
- Affichage d'une liste avec RecyclerView
- Affichage d'information suppl�mentaires sur les �l�ments de la liste (le texte oracle)
- Architecture MVC
- Appels � une API REST (utilisation de https://magicthegathering.io/ et de leur SDK java)
- PLUS: Impl�mentation d'un �cran SPLASH
- PLUS: Impl�mentation d'une liste pour choisir les sets

# Probl�mes rencontr�s:

- Le plus gros probl�me rencontr� lors de ce projet (et qui m'a pris une semaine a r�soudre) fut celui dont je vous envoy� un mail vous demandant de l'aide (etienne@et.esiea.fr).
  Android studio m'emp�chait de compiler car il ne trouvait pas mes activity dans le manifeste android. Il semblerait que ma version d'android studio (3.3.0) comportait
  beaucoup de bugs et analysait mal les fichiers. J'ai fini par r�ussir a r�soudre le probl�me en passant � la version 3.3.2 et en ne gardant pas mes pr�f�rences.

- Un autre probl�me fut une erreur de thread. Mon appel API �tant g�r� par ma SDK, je l'appelais par erreur dans le thread d'affichage. J'ai donc du apprendre et utiliser
  AsyncTask.

- Un probl�me persistant encore dans l'application, certains sets ne s'affichent pas. Pourtant le texte oracle s'affiche lorsque l'on clique l� ou devraient etre les images.
  Je pense que cela vient de la base de donn�es magic qui ne contient pas les images de toutes les cartes pour chaque �dition.
  En effet ce probl�me survient uniquement lorsque le set choisi est un vieux set ou alors un set promotionnel qui a tr�s peu d'exemplaires, et les autres donn�es de la carte sont bien transmises.