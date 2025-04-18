Pour ceux qui ont finis plus tôt, je vous ajoute des exos supplémentaires pour vous entraîner :

Créer une table Fournisseur.

Insérer des lignes.

Rechercher un fournisseur par nom :
Demande à l’utilisateur de saisir un nom (ou une partie du nom) du fournisseur.

Recherche dans la base de données tous les fournisseurs dont le nom contient cette chaîne (utilise LIKE).

Affiche les résultats.


Rechercher un fournisseur par ID :
Demande à l’utilisateur de saisir un ID.

Requête SQL : SELECT * FROM fournisseur WHERE id = ?

Si le fournisseur existe, affiche ses infos, sinon affiche "Aucun fournisseur trouvé".


Insérer plusieurs fournisseurs :
Demande à l’utilisateur combien de fournisseurs il souhaite ajouter.

Pour chacun, demander le nom, puis insérer dans la base.


Supprimer tous les fournisseurs contenant un mot :
Demande à l’utilisateur un mot-clé.

Supprime tous les fournisseurs dont le nom contient ce mot.