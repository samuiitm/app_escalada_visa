# 📌 Nom del Projecte: Aplicació de Gestió de Vies d'Escalada

## 📋 Descripció
Aquest projecte és una aplicació en Java que es connecta a una base de dades MySQL. El seu objectiu és gestionar les escoles d'escalada, les vies, els sectors, els escaladors i l'historial d'estats de les vies. Permet realitzar operacions bàsiques de CRUD (crear, llegir, actualitzar, eliminar) en cada una d'aquestes entitats, així com realitzar consultes personalitzades.

---

## ⚙️ Tecnologies Utilitzades

- **Java 17**
- **MySQL**
- **JDBC**
- **Docker**
- **Patró DAO + MVC**
- **Git + GitHub**

---

## 🧠 Decisions Tècniques

### 1. **Arquitectura MVC**
S'ha escollit una arquitectura basada en Model-Vista-Controlador (MVC) per separar la lògica de negoci, la interfície d'usuari i l'accés a la base de dades. Això fa que el codi sigui més fàcil d'entendre i mantenir.

### 2. **DAO per a cada entitat**
Hem decidit que cada entitat del sistema (escoles, sectors, vies, etc.) té la seva pròpia classe DAO (Data Access Object), que s'encarrega de gestionar la comunicació amb la base de dades de manera centralitzada. Això fa que el codi sigui més net i reutilitzable.

### 3. **Interfície CRUD**
S'ha creat una interfície genèrica `CRUD<T>` amb els mètodes bàsics per gestionar les entitats (insertar, llistar, actualitzar, eliminar, obtenir per nom i per ID). Cada classe DAO implementa aquesta interfície per gestionar les operacions amb les seves respectives entitats. Tant obtenir per nom com per ID han sigut una estratègia per a tenir una interfície més amigable amb el client que utilitzará el programa.

### 4. **Consultes Predefinides**
A la classe `ConsultesPrecreades` es guarden algunes consultes específiques que fan més fàcil obtenir informació com les vies disponibles en una escola o els sectors amb més de X vies. Aquesta classe centralitza les consultes més complexes.

### 5. **Gestió d'Estats amb Historial**
A la base de dades, hi ha una taula anomenada `historial_estats_vies` que guarda l'historial de canvis d'estat de les vies. Això permet realitzar consultes com mostrar les vies que han passat d'un estat diferent a "Apte" en els últims 3 mesos.

### 6. **Gestió d'Elements amb el Misme Nom**
Quan el sistema troba diversos elements amb el mateix nom (per exemple, diverses escoles amb el mateix nom), en comptes d'assumir quin s'ha de triar, es mostra un menú a l'usuari perquè pugui escollir quin vol seleccionar. Això millora l'experiència de l'usuari i evita confusions.

---

## 🌟 Funcionalitats Destacades

- ✅ **Control d'historial d'estats**: el programa pot dir quines vies han tornat a ser "Apte" després d'estar tancades o en obres, mirant els últims canvis dels últims 3 mesos.
- 🔁 **Gestió intel·ligent d'elements amb el mateix nom**: si busques una escola, via o sector que comparteix nom amb altres, el programa et mostra una llista amb informació extra perquè triïs el correcte.
- 🔍 **Consultes útils per a escaladors**: el sistema ajuda a trobar les vies més llargues, les escoles amb restriccions, o escaladors segons el seu nivell màxim.
- 🧱 **Codi modular i fàcil d’ampliar**: gràcies a l'estructura que hem seguit, afegir noves funcionalitats o entitats és molt senzill i ràpid.

---

## 🤝 Autors
- Samuel Cañadas & Victor Extremera