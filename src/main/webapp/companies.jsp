<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Entreprises - Gestion de Stages</title>
    <link rel="stylesheet" href="resources/css/styles.css" />
</head>
<body>
<nav>
    <a href="index.jsp">🏠 Accueil</a>
    <a href="students.jsp">👨‍🎓 Étudiants</a>
    <a href="companies.jsp">🏢 Entreprises</a>
    <a href="internships.jsp">💼 Stages</a>
</nav>

<h1>🏢 Gestion des Entreprises</h1>

<table>
    <thead>
    <tr><th>ID</th><th>Nom</th><th>Secteur</th><th>Ville</th><th>Actions</th></tr>
    </thead>
    <tbody id="companies-tbody"></tbody>
</table>

<h2>Ajouter une entreprise</h2>
<form id="company-form">
    <label>Nom: <input type="text" name="name" required /></label>
    <label>Secteur: <input type="text" name="sector" /></label>
    <label>Ville: <input type="text" name="city" /></label>
    <button type="submit">Créer</button>
</form>

<script src="resources/js/app.js?v=4"></script>
</body>
</html>
