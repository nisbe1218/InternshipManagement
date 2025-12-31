<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion de Stages - Accueil</title>
    <link rel="stylesheet" href="resources/css/styles.css" />
    <style>
        .hero {
            max-width: 1200px;
            margin: 0 auto;
            padding: 4rem 2rem 2rem;
            text-align: center;
        }
        
        .hero-title {
            font-size: 3.5rem;
            font-weight: 700;
            color: var(--text-dark);
            margin-bottom: 1rem;
            letter-spacing: -1px;
            line-height: 1.2;
        }
        
        .hero-subtitle {
            font-size: 1.25rem;
            color: var(--text-light);
            margin-bottom: 4rem;
            font-weight: 400;
            max-width: 600px;
            margin-left: auto;
            margin-right: auto;
        }
        
        .cards-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 2rem;
            margin-top: 3rem;
            padding: 0 2rem;
        }
        
        .feature-card {
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
            padding: 3rem 2rem;
            border-radius: 20px;
            text-decoration: none;
            box-shadow: 0 4px 20px var(--shadow);
            border: 1px solid var(--nude-200);
            transition: all 0.4s cubic-bezier(0.4, 0, 0.2, 1);
            position: relative;
            overflow: hidden;
        }
        
        .feature-card::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: linear-gradient(135deg, var(--nude-300), var(--nude-400));
            opacity: 0;
            transition: opacity 0.4s ease;
            z-index: 0;
        }
        
        .feature-card:hover::before {
            opacity: 1;
        }
        
        .feature-card:hover {
            transform: translateY(-8px);
            box-shadow: 0 12px 40px var(--shadow-lg);
            border-color: var(--nude-400);
        }
        
        .card-content {
            position: relative;
            z-index: 1;
            transition: color 0.3s ease;
        }
        
        .feature-card:hover .card-content {
            color: white;
        }
        
        .card-icon {
            font-size: 3.5rem;
            margin-bottom: 1.5rem;
            display: block;
            transition: transform 0.4s ease;
        }
        
        .feature-card:hover .card-icon {
            transform: scale(1.1);
        }
        
        .card-title {
            font-size: 1.75rem;
            font-weight: 700;
            margin-bottom: 0.8rem;
            color: var(--text-dark);
            transition: color 0.3s ease;
        }
        
        .feature-card:hover .card-title {
            color: white;
        }
        
        .card-description {
            color: var(--text-light);
            font-size: 1rem;
            line-height: 1.6;
            transition: color 0.3s ease;
        }
        
        .feature-card:hover .card-description {
            color: rgba(255, 255, 255, 0.95);
        }
        
        .stats-badge {
            display: inline-block;
            background: var(--nude-100);
            color: var(--text-dark);
            padding: 0.4rem 1rem;
            border-radius: 20px;
            font-size: 0.85rem;
            font-weight: 600;
            margin-top: 1rem;
            transition: all 0.3s ease;
        }
        
        .feature-card:hover .stats-badge {
            background: rgba(255, 255, 255, 0.3);
            color: white;
        }
        
        @keyframes float {
            0%, 100% { transform: translateY(0); }
            50% { transform: translateY(-10px); }
        }
        
        .feature-card:nth-child(1) { animation: float 6s ease-in-out infinite; }
        .feature-card:nth-child(2) { animation: float 6s ease-in-out infinite 0.2s; }
        .feature-card:nth-child(3) { animation: float 6s ease-in-out infinite 0.4s; }
        
        @media (max-width: 768px) {
            .hero-title {
                font-size: 2.5rem;
            }
            
            .hero-subtitle {
                font-size: 1.1rem;
                margin-bottom: 2rem;
            }
            
            .cards-grid {
                grid-template-columns: 1fr;
                padding: 0 1rem;
            }
            
            .feature-card {
                padding: 2rem 1.5rem;
            }
        }
    </style>
</head>
<body>
<nav>
    <a href="index.jsp">🏠 Accueil</a>
    <a href="students.jsp">👨‍🎓 Étudiants</a>
    <a href="companies.jsp">🏢 Entreprises</a>
    <a href="internships.jsp">💼 Stages</a>
</nav>

<div class="hero">
    <h1 class="hero-title">Plateforme de Gestion de Stages</h1>
    <p class="hero-subtitle">Gérez efficacement vos étudiants, entreprises partenaires et offres de stage en un seul endroit</p>

    <div class="cards-grid">
        <a href="students.jsp" class="feature-card">
            <div class="card-content">
                <span class="card-icon">👨‍🎓</span>
                <h3 class="card-title">Étudiants</h3>
                <p class="card-description">Gérez les profils des étudiants, leurs informations personnelles et suivez leur parcours académique</p>
                <span class="stats-badge">Gestion complète</span>
            </div>
        </a>

        <a href="companies.jsp" class="feature-card">
            <div class="card-content">
                <span class="card-icon">🏢</span>
                <h3 class="card-title">Entreprises</h3>
                <p class="card-description">Administrez votre réseau d'entreprises partenaires et maintenez à jour leurs coordonnées</p>
                <span class="stats-badge">Réseau partenaires</span>
            </div>
        </a>

        <a href="internships.jsp" class="feature-card">
            <div class="card-content">
                <span class="card-icon">💼</span>
                <h3 class="card-title">Stages</h3>
                <p class="card-description">Créez et gérez les offres de stage, associez étudiants et entreprises pour des opportunités réussies</p>
                <span class="stats-badge">Offres & placements</span>
            </div>
        </a>
    </div>
</div>
</body>
</html>