<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stages - Gestion de Stages</title>
    <link rel="stylesheet" href="resources/css/styles.css" />
</head>
<body>
<nav>
    <a href="index.jsp">🏠 Accueil</a>
    <a href="students.jsp">👨‍🎓 Étudiants</a>
    <a href="companies.jsp">🏢 Entreprises</a>
    <a href="internships.jsp">💼 Stages</a>
</nav>

<h1>💼 Gestion des Stages</h1>

<table>
    <thead>
    <tr><th>ID</th><th>Titre</th><th>Étudiant</th><th>Entreprise</th><th>Début</th><th>Fin</th><th>Actions</th></tr>
    </thead>
    <tbody id="internships-tbody"></tbody>
</table>

<h2>Ajouter un stage</h2>
<form id="internship-form">
    <label>Titre: <input type="text" name="title" required /></label>
    <label>Description: <textarea name="description"></textarea></label>
    <label>Début: <input type="date" name="startDate" /></label>
    <label>Fin: <input type="date" name="endDate" /></label>
    <label>Étudiant: <select id="studentId" name="studentId"></select></label>
    <label>Entreprise: <select id="companyId" name="companyId"></select></label>
    <button type="submit">Créer</button>
</form>

<script src="resources/js/app.js?v=4"></script>
</body>
</html>
