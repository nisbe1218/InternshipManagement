<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Étudiants - Gestion de Stages</title>
    <link rel="stylesheet" href="resources/css/styles.css" />
</head>
<body>
<nav>
    <a href="index.jsp">🏠 Accueil</a>
    <a href="students.jsp">👨‍🎓 Étudiants</a>
    <a href="companies.jsp">🏢 Entreprises</a>
    <a href="internships.jsp">💼 Stages</a>
</nav>

<h1>👨‍🎓 Gestion des Étudiants</h1>

<table>
    <thead>
    <tr><th>ID</th><th>Prénom</th><th>Nom</th><th>Email</th><th>Promotion</th><th>Actions</th></tr>
    </thead>
    <tbody id="students-tbody">
    <!-- Rempli par JS -->
    </tbody>
</table>

<h2>Ajouter un étudiant</h2>
<form id="student-form">
    <label>Prénom: <input type="text" name="firstName" required /></label>
    <label>Nom: <input type="text" name="lastName" required /></label>
    <label>Email: <input type="email" name="email" required /></label>
    <label>Promotion: <input type="text" name="promotion" /></label>
    <button type="submit">Créer</button>
</form>

<script src="resources/js/app.js?v=4"></script>
</body>
</html>
