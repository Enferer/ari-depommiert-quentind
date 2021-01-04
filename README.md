# PROJET ARI 1

## Auteurs

- Thibaut Dépommier : thibaut.depommier.etu@univ-lille.fr
- Dylan Quentin : dylan.quentin.etu@univ-lille.fr

## Installation du projet

### Build
``mvn build``

### Lancement 
``mvn spring-boot:run``

## Information

Deux users sont crées au lancement de l'application :  
 Premier utilisateur : 
 - Login : user1
 - Mot de passe : password
    
 Deuxiéme utilisateur :   
 - Login : user2
 - Mot de passe : password
 
 Les données sont stocké dans une base de donné H2, les données sont réinitialisé à chaque lancement de l'application
 
## Fonctionnalité implémenté  


#### Utilisateur

- Inscription
- Connexion

#### Livre

- Création liée à un auteur
- Suppression

#### Auteurs

- Création
- Suppression

#### Location

- Location de livre lié à un user


## Détails

Attention il est impossible de supprimer un livre si il est lié à une location, et de même pour un auteur s'il est lié à un livre