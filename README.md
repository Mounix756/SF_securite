# SF_securite
Plateforme d'échange de fichiers sécurisée utilisant les algorithmes de chiffrement AES et DES


premier projet sur la sécurité informatique concernant les algorithmes de chiffrement AES et DES
Titre du projet : Plateforme d'échange de fichiers sécurisée utilisant les algorithmes de chiffrement AES et DES


Objectifs du projet :
1. Concevoir une interface utilisateur conviviale permettant aux utilisateurs de s'inscrire, de se connecter et de gérer leurs fichiers.
2. Implémenter les algorithmes de chiffrement AES et DES pour sécuriser les fichiers échangés.
3. Mettre en place un système de gestion des clés pour garantir la confidentialité des données.
4. Assurer l'intégrité des fichiers échangés en utilisant des fonctions de hachage sécurisées.
5. Mettre en œuvre des mécanismes de contrôle d'accès pour limiter l'accès aux fichiers uniquement aux utilisateurs autorisés.

Fonctionnalités principales :
1. Inscription et authentification des utilisateurs : Les utilisateurs pourront créer un compte sécurisé en fournissant leurs informations personnelles. Ils devront également fournir un mot de passe fort qui sera utilisé pour chiffrer et déchiffrer leurs fichiers.
2. Gestion des fichiers : Les utilisateurs pourront télécharger, stocker et supprimer leurs fichiers sur la plateforme. Les fichiers seront automatiquement chiffrés avant d'être stockés sur le serveur.
3. Chiffrement et déchiffrement des fichiers : Lorsqu'un utilisateur télécharge un fichier, il sera automatiquement chiffré à l'aide de l'algorithme AES ou DES. Lorsqu'un utilisateur souhaite accéder à un fichier, il sera déchiffré à l'aide de la clé correspondante.
4. Gestion des clés : Les clés de chiffrement seront générées de manière sécurisée et stockées de manière cryptée sur le serveur. Seuls les utilisateurs autorisés auront accès à leurs clés respectives.
5. Contrôle d'accès : Les utilisateurs pourront définir des autorisations d'accès pour leurs fichiers, en spécifiant les utilisateurs ou les groupes d'utilisateurs autorisés à y accéder.

Technologies utilisées :
1. Langage de programmation : Nous utiliserons un langage de programmation tel que Python ou Java pour développer la plateforme.
2. Base de données(Mysql server) : Nous utiliserons une base de données sécurisée pour stocker les informations des utilisateurs, les fichiers chiffrés et les clés de chiffrement.
3. Framework de développement web : Nous utiliserons un framework tel que Django ou Spring pour développer l'interface utilisateur et gérer les requêtes HTTP.


Ce projet vise à développer une plateforme d'échange de fichiers sécurisée en utilisant les algorithmes de chiffrement AES et DES. En garantissant la confidentialité et l'intégrité des données échangées, cette plateforme offrira aux utilisateurs un moyen sûr et fiable d'échanger des fichiers sensible


Outils nécessaires pour executer ce projet:
* Un PC configurer pour executer du code java, c'est à dire avec un jdk-19 installée;
* Un environnement de développement java : netbeans (la dernières versions, la version utilisée pour ce projet est la version 18) ou eclipse IDE;
* Un serveur local wampserver ou xamp (l'outils utilisé pour ce projet est xamp 64);
* Une base de données MySQL;
* Importer la base de donnée utilisée pour ce projet (fichier se trouvant dans l'emplacement src/ressources/bd/ de ce projet;
