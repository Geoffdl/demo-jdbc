Ajoutez à l’interface FournisseurDao une méthode :
List<Fournisseur> findByKeyword(String keyword);

🔹 Implémentez-la dans FournisseurDaoJdbc : elle doit retourner tous les fournisseurs dont le nom contient le mot-clé donné.
🔹 Créez une classe TestRechercheFournisseur avec un Scanner pour demander le mot-clé à l’utilisateur et afficher les résultats.


Ajoutez une méthode à FournisseurDao :
int deleteByKeyword(String keyword);

🔹 Implémentez-la : elle supprime tous les fournisseurs dont le nom contient le mot-clé donné et retourne le nombre de suppressions effectuées.
🔹 Créez une classe TestSuppressionParMotCle qui demande à l’utilisateur un mot-clé, supprime les fournisseurs concernés, et affiche combien ont été supprimés.


Ajoutez une méthode à FournisseurDao :
Fournisseur findById(int id);

🔹 Implémentez-la dans FournisseurDaoJdbc.
🔹 Créez une classe TestRechercheParId qui demande un ID à l’utilisateur, affiche les infos du fournisseur si trouvé, ou un message d’erreur sinon.