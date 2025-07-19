# Ventes Par Ville Et Annee

## Description
Cette application Java utilise Apache Spark pour analyser un fichier de ventes (`ventes.txt`).  
Elle calcule le total des ventes agrégées par ville et par année.

---

## Fonctionnalités

- Lecture d’un fichier texte contenant des données de ventes.
- Extraction de la date, ville, produit et prix.
- Agrégation des ventes par **ville** et **année**.
- Affichage des totaux par ville et année dans la console, triés par clé.

---

## Format attendu du fichier `ventes.txt`

Chaque ligne doit être au format suivant :
## YYYY-MM-DD Ville Produit Prix

## Exemple :
2022-02-18 Rabat ProduitB 180.97  
2023-02-23 Tanger ProduitB 373.7  
2024-02-26 Rabat ProduitA 206.79
## Prérequis

- Java 8 ou supérieur
- Apache Spark (version compatible avec ton code, ex: 3.3.2)
- Maven (pour gérer les dépendances)

---

## Compilation & Exécution

1. Compiler le projet avec Maven :

```bash
mvn clean package
```
1. Exécuter l’application :
```bash
   java -cp target/incidentapp-1.0-SNAPSHOT.jar ma.enset.VentesParVilleEtAnnee
```
# Note :
Assure-toi que le fichier ventes.txt est présent dans le répertoire de travail ou modifie le chemin dans le code.

# Dépendances principales
```bash
<dependency>
  <groupId>org.apache.spark</groupId>
  <artifactId>spark-core_2.12</artifactId>
  <version>3.3.2</version>
</dependency>
```
## Auteur
Abdelkarim El Hajbi – Full Stack Developer
