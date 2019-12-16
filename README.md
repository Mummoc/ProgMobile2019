# mtgCardSearcher

Projet scolaire d'introduction à la programmation mobile.

Cette application permet d'afficher la liste de toutes les cartes Magic The Gathering d'un set choisi.
Cliquer sur une carte permet d'afficher le texte oracle de cette carte. (Le texte oracle correspond aux règles mises à jour,
particulièrement utile pour les cartes très anciennes).

# Consignes respectées :
- Affichage d'une liste avec RecyclerView
- Affichage d'information supplémentaires sur les élèments de la liste (le texte oracle)
- Architecture MVC
- Appels à une API REST (utilisation de https://magicthegathering.io/ et de leur SDK java)
- PLUS: Implèmentation d'un écran SPLASH
- PLUS: Implèmentation d'une liste pour choisir les sets

# Problèmes rencontrés:

- Le plus gros problème rencontré lors de ce projet (et qui m'a pris une semaine a résoudre) fut celui dont je vous envoyé un mail vous demandant de l'aide (etienne@et.esiea.fr).
  Android studio m'empèchait de compiler car il ne trouvait pas mes activity dans le manifeste android. Il semblerait que ma version d'android studio (3.3.0) comportait
  beaucoup de bugs et analysait mal les fichiers. J'ai fini par réussir a résoudre le problème en passant à la version 3.3.2 et en ne gardant pas mes préférences.

- Un autre problème fut une erreur de thread. Mon appel API étant géré par ma SDK, je l'appelais par erreur dans le thread d'affichage. J'ai donc du apprendre et utiliser
  AsyncTask.

- Un problème persistant encore dans l'application, certains sets ne s'affichent pas. Pourtant le texte oracle s'affiche lorsque l'on clique là ou devraient etre les images.
  Je pense que cela vient de la base de données magic qui ne contient pas les images de toutes les cartes pour chaque édition.
  En effet ce problème survient uniquement lorsque le set choisi est un vieux set ou alors un set promotionnel qui a très peu d'exemplaires, et les autres données de la carte sont bien transmises.