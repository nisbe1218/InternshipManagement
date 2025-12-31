#  Internship Management System

Ce projet est une application de gestion de stages développée en Java avec Jakarta EE (anciennement Java EE). Elle permet de gérer les étudiants, les entreprises et les stages via une interface web et des services RESTful.

## Fonctionnalités principales
- Gestion des étudiants (CRUD)
- Gestion des entreprises (CRUD)
- Gestion des stages (CRUD)
- Interface web (JSP, CSS, JS)
- API REST pour l'intégration et l'automatisation

## Structure du projet
- **src/main/java/org/example/gestiondeprojet/entity/** : Entités JPA (Student, Company, Internship)
- **src/main/java/org/example/gestiondeprojet/dao/** : Accès aux données (DAO)
- **src/main/java/org/example/gestiondeprojet/service/** : Logique métier (Services)
- **src/main/java/org/example/gestiondeprojet/rest/** : Contrôleurs REST (Resources)
- **src/main/webapp/** : Interface utilisateur (JSP, CSS, JS)
- **src/main/resources/META-INF/** : Configuration JPA (persistence.xml, beans.xml)
- **src/main/webapp/WEB-INF/** : Configuration web (web.xml)


## Prérequis
- Java 11 ou supérieur
- Maven 3.6+
- Serveur d'application compatible Jakarta EE (ex: WildFly, TomEE)
- Base de données relationnelle (H2, MySQL, PostgreSQL, etc.)

## Architecture du projet

```
┌────────────┐      ┌────────────┐      ┌────────────┐
│ Interface  │◄────►│  REST API  │◄────►│  Services  │◄────►│ DAO/JPA │
│  Web (JSP) │      │ (JAX-RS)   │      │ (CDI/EJB)  │      │         │
└────────────┘      └────────────┘      └────────────┘      └─────────┘
```

## Utilisation de l'API REST

Exemple pour récupérer la liste des étudiants :

```
GET /api/students
Response: 200 OK
[
	{
		"id": 1,
		"name": "Alice Dupont",
		"email": "alice@example.com"
	},
	...
]
```

Ajouter un stage :
```
POST /api/internships
Content-Type: application/json
{
	"title": "Développeur Java",
	"companyId": 2,
	"studentId": 1,
	"startDate": "2025-01-10",
	"endDate": "2025-04-10"
}
```

## Navigation dans l'interface web

- **/index.jsp** : Page d'accueil
- **/students.jsp** : Liste et gestion des étudiants
- **/companies.jsp** : Liste et gestion des entreprises
- **/internships.jsp** : Liste et gestion des stages

## Exemple de configuration de la base de données (persistence.xml)

```xml
<persistence-unit name="gestiondeprojetPU">
		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
		<class>org.example.gestiondeprojet.entity.Student</class>
		<class>org.example.gestiondeprojet.entity.Company</class>
		<class>org.example.gestiondeprojet.entity.Internship</class>
		<properties>
				<property name="javax.persistence.jdbc.url" value="jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"/>
				<property name="javax.persistence.jdbc.user" value="sa"/>
				<property name="javax.persistence.jdbc.password" value=""/>
				<property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
				<property name="hibernate.hbm2ddl.auto" value="update"/>
				<property name="hibernate.show_sql" value="true"/>
		</properties>
</persistence-unit>
```

## Scénario d'utilisation

1. L'administrateur se connecte à l'interface web.
2. Il ajoute une nouvelle entreprise via le formulaire dédié.
3. Il inscrit un nouvel étudiant.
4. Il crée un stage en associant l'étudiant et l'entreprise.
5. Il consulte la liste des stages et peut les modifier ou les supprimer.

## Technologies utilisées
- Java
- Jakarta EE (JAX-RS, JPA, CDI)
- JSP, CSS, JavaScript
- Maven


