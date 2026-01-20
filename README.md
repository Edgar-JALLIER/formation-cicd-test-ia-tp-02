# TP2 — Tests unitaires assistés par Intelligence Artificielle

## Objectifs pédagogiques

À l’issue de ce TP, vous serez capables de :
* Générer des tests unitaires et fonctionnels à partir d’une spécification textuelle
* Utiliser une IA comme assistant pour concevoir des tests
* Implémenter du code Java en respectant des tests existants (approche TDD)
* Identifier les limites de l’IA dans les tests logiciels
* Intégrer votre travail dans une pipeline CI/CD GitHub Actions

L’IA n’est pas un oracle.
Elle aide, mais ne décide pas à votre place.

## Contexte du projet

Vous travaillez sur un projet Java Maven existant
De nouvelles fonctionnalités doivent être développées autour de la gestion d’utilisateurs.

Pour ce TP :
* le code métier est partiellement fourni
* aucun test n’est fourni
* votre mission est de concevoir les tests, puis d’implémenter le code

## Partie 1 — Génération de tests à partir d’une spécification (IA-first) 

### Spécification fonctionnelle : User

Une spécification textuelle détaillée vous est fournie (SPEC_USER.md).

### Consigne importante
Avant d’écrire la moindre ligne de code Java :
1. Lisez la spécification attentivement
2. Identifiez les règles métier
3. Listez les comportements attendus :
   - cas nominaux
   - cas limites
   - cas d’erreur
4. Conseil : faites cette étape sans IA dans un premier temps.
5. Utilisez une IA (ChatGPT, Copilot, etc.) pour proposer des cas de tests
4. Comparez vos test identifier sans l'IA avec ceux générer par l'IA

*Objectif : transformer une description métier en comportements testables.*

## Partie 2 — Implémentation des tests unitaires et fonctionnels
### Tests attendus

Vous devez implémenter, au minimum :
Tests unitaires
  * validation des règles sur User
  * méthode canAccessAdminArea()
  * gestion des erreurs (exceptions)

Tests fonctionnels légers
  * classe UserService
  * méthode register(...)
  * vérification du comportement global (création d’un utilisateur valide ou rejet)

*Les tests fonctionnels restent sans serveur, sans HTTP, sans base de données.*


## Partie 3 — Implémentation du code Java (TDD assisté par IA)
Une fois vos tests écrits :
* Implémentez les classes suivantes pour faire passer les tests :
* User
* Role
* UserService

Le squelette de ces classes est fourni :
* certaines méthodes sont vides
* certaines validations sont à implémenter
* les règles doivent respecter la spécification

*Vous ne devez pas modifier les tests pour qu’ils passent, mais adapter le code métier.*

Relecture de tests par l’IA
Une fois vos tests écrits, demandez à l’IA :

“Relis ces tests unitaires. Quels cas manquent ? Les assertions sont-elles suffisantes ?”

Comparez ses suggestions avec votre propre analyse.

## Partie 4 — Traçabilité IA & CI/CD
### Pipeline CI/CD

La pipeline GitHub Actions :
* compile le projet
* exécute les tests
* échoue si un test échoue

Assurez-vous que :
* tous les tests passent en local
* la pipeline passe sur GitHub

## Fichier AI_NOTES.md (obligatoire)

Créez un fichier AI_NOTES.md à la racine du projet contenant :
1. Outil IA utilisé
   * ChatGPT, Copilot, autre
2. Prompts utilisés
   * prompt initial
   * prompts améliorés
4. Comparez vos test identifier sans l'IA avec ceux générer par l'IA
5. Cas de tests proposés par l’IA
   * liste structurée
   * classification (nominal / limite / erreur)
6. Analyse critique
   * tests conservés
   * tests rejetés
   * décisions humaines

Exemple :
“L’IA proposait de tester un email avec un domaine internationalisé.
J’ai rejeté ce cas car hors périmètre fonctionnel.”

### Message clé à retenir
* Écrire des tests avec l’IA est facile.
* Écrire de bons tests reste une responsabilité humaine.

## Bonus - si vous avez du temps, amusez-vous :

Vous pouvez faire la méme chose pour 
- générer les tests unitaire à partir des specs dans le fichier SPEC_ORDER.md pour les class java dans le package com.devops.cicd.order
- puis implémenter les class java jusqu'a satisfaire les tests unitaire
- créer la pipeline cicd qui lance les tests à chaque push