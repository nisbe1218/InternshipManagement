// Minimal JS helper to fetch and render lists from REST API and submit simple create forms
const API_BASE = '/internship-management/api';

// Students
async function fetchStudents() {
    const res = await fetch(API_BASE + '/students');
    if (!res.ok) return [];
    return await res.json();
}

function renderStudents(students) {
    const tbody = document.getElementById('students-tbody');
    if (!tbody) return;
    tbody.innerHTML = '';
    students.forEach(s => {
        const tr = document.createElement('tr');
        tr.innerHTML = `<td>${s.id || ''}</td><td>${escapeHtml(s.firstName)}</td><td>${escapeHtml(s.lastName)}</td><td>${escapeHtml(s.email)}</td><td>${escapeHtml(s.promotion)}</td><td><button class="delete-btn" onclick="deleteStudent(${s.id})">🗑️ Supprimer</button></td>`;
        tbody.appendChild(tr);
    });
}

async function loadStudents() {
    const students = await fetchStudents();
    renderStudents(students);
}

async function submitStudentForm(ev) {
    ev.preventDefault();
    const form = ev.target;
    const data = {
        firstName: form.firstName.value,
        lastName: form.lastName.value,
        email: form.email.value,
        promotion: form.promotion.value
    };
    const res = await fetch(API_BASE + '/students', { method: 'POST', headers: {'Content-Type':'application/json'}, body: JSON.stringify(data) });
    if (res.ok) {
        form.reset();
        loadStudents();
    } else {
        alert('Erreur lors de la création: ' + res.status);
    }
}

// Companies
async function fetchCompanies() {
    const res = await fetch(API_BASE + '/companies');
    if (!res.ok) return [];
    return await res.json();
}

function renderCompanies(list) {
    const tbody = document.getElementById('companies-tbody');
    if (!tbody) return;
    tbody.innerHTML = '';
    list.forEach(c => {
        const tr = document.createElement('tr');
        tr.innerHTML = `<td>${c.id || ''}</td><td>${escapeHtml(c.name)}</td><td>${escapeHtml(c.sector)}</td><td>${escapeHtml(c.city)}</td><td><button class="delete-btn" onclick="deleteCompany(${c.id})">🗑️ Supprimer</button></td>`;
        tbody.appendChild(tr);
    });
}

async function loadCompanies() {
    const list = await fetchCompanies();
    renderCompanies(list);
}

async function submitCompanyForm(ev) {
    ev.preventDefault();
    const form = ev.target;
    const data = { name: form.name.value, sector: form.sector.value, city: form.city.value };
    const res = await fetch(API_BASE + '/companies', { method: 'POST', headers: {'Content-Type':'application/json'}, body: JSON.stringify(data) });
    if (res.ok) {
        form.reset();
        loadCompanies();
    } else alert('Erreur création company: ' + res.status);
}

// Internships
async function fetchInternships() {
    const res = await fetch(API_BASE + '/internships');
    if (!res.ok) return [];
    return await res.json();
}

function renderInternships(list) {
    const tbody = document.getElementById('internships-tbody');
    if (!tbody) return;
    tbody.innerHTML = '';
    list.forEach(i => {
        const tr = document.createElement('tr');
        const student = i.student ? (i.student.firstName + ' ' + i.student.lastName) : '';
        const company = i.company ? i.company.name : '';
        tr.innerHTML = `<td>${i.id || ''}</td><td>${escapeHtml(i.title)}</td><td>${escapeHtml(student)}</td><td>${escapeHtml(company)}</td><td>${escapeHtml(i.startDate || '')}</td><td>${escapeHtml(i.endDate || '')}</td><td><button class="delete-btn" onclick="deleteInternship(${i.id})">🗑️ Supprimer</button></td>`;
        tbody.appendChild(tr);
    });
}

async function loadInternships() {
    const list = await fetchInternships();
    renderInternships(list);
}

async function submitInternshipForm(ev) {
    ev.preventDefault();
    const form = ev.target;
    
    const data = {
        title: form.title.value,
        description: form.description.value,
        startDate: form.startDate.value || null,
        endDate: form.endDate.value || null,
        studentId: form.studentId.value ? parseInt(form.studentId.value) : null,
        companyId: form.companyId.value ? parseInt(form.companyId.value) : null
    };
    
    console.log('Envoi données:', data);
    const res = await fetch(API_BASE + '/internships', { method: 'POST', headers: {'Content-Type':'application/json'}, body: JSON.stringify(data) });
    if (res.ok) {
        form.reset();
        loadInternships();
        alert('Stage créé avec succès!');
    } else {
        const error = await res.text();
        alert('Erreur création stage: ' + res.status + ' - ' + error);
    }
}

// Helpers
function escapeHtml(str) {
    if (str === null || str === undefined) return '';
    return String(str).replace(/[&<>"']/g, s => ({'&':'&amp;','<':'&lt;','>':'&gt;','"':'&quot;',"'":"&#39;"}[s]));
}

// Populate select boxes for internships form
async function populateSelects() {
    const students = await fetchStudents();
    const companies = await fetchCompanies();
    const sSelect = document.getElementById('studentId');
    const cSelect = document.getElementById('companyId');
    if (sSelect) {
        sSelect.innerHTML = '<option value="">-- Choisir --</option>' + students.map(s => `<option value="${s.id}">${escapeHtml(s.firstName+' '+s.lastName)}</option>`).join('');
    }
    if (cSelect) {
        cSelect.innerHTML = '<option value="">-- Choisir --</option>' + companies.map(c => `<option value="${c.id}">${escapeHtml(c.name)}</option>`).join('');
    }
}

// On load handlers per page
// Fonctions de suppression
async function deleteStudent(id) {
    if (!confirm('Êtes-vous sûr de vouloir supprimer cet étudiant ?')) return;
    const res = await fetch(API_BASE + '/students/' + id, { method: 'DELETE' });
    if (res.ok) {
        loadStudents();
    } else {
        alert('Erreur lors de la suppression: ' + res.status);
    }
}

async function deleteCompany(id) {
    if (!confirm('Êtes-vous sûr de vouloir supprimer cette entreprise ?')) return;
    const res = await fetch(API_BASE + '/companies/' + id, { method: 'DELETE' });
    if (res.ok) {
        loadCompanies();
    } else {
        alert('Erreur lors de la suppression: ' + res.status);
    }
}

async function deleteInternship(id) {
    if (!confirm('Êtes-vous sûr de vouloir supprimer ce stage ?')) return;
    const res = await fetch(API_BASE + '/internships/' + id, { method: 'DELETE' });
    if (res.ok) {
        loadInternships();
    } else {
        alert('Erreur lors de la suppression: ' + res.status);
    }
}

document.addEventListener('DOMContentLoaded', () => {
    if (document.getElementById('students-tbody')) {
        loadStudents();
        const form = document.getElementById('student-form'); if (form) form.addEventListener('submit', submitStudentForm);
    }
    if (document.getElementById('companies-tbody')) {
        loadCompanies();
        const form = document.getElementById('company-form'); if (form) form.addEventListener('submit', submitCompanyForm);
    }
    if (document.getElementById('internships-tbody')) {
        loadInternships();
        const form = document.getElementById('internship-form'); if (form) form.addEventListener('submit', submitInternshipForm);
        populateSelects();
    }
});
