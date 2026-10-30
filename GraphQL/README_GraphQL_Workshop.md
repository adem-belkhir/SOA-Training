# 🧠 GraphQL Workshop — Service-Oriented Architecture (SOA)


---

## 🎯 Workshop Objectives

The main goal of this workshop is to **design and develop a GraphQL web service** for managing the university’s academic modules.

By the end of the workshop, students will be able to:

1. Understand the difference between **REST and GraphQL** (philosophy, advantages, and limitations).  
2. Model the **GraphQL schema** representing the business entities.  
3. Implement **GraphQL operations** (queries and mutations).  
4. Set up a **GraphQL API using a Java backend**.  
5. Test and consume the API using **Postman** or **GraphiQL**.

---

## 🏗️ Project Context

The university aims to modernize its academic management system to improve the experience for students and faculty members.  
The project focuses on centralizing data and exposing core functionality through a **GraphQL API**, as an evolution from REST services.

The main entities are:

- **Module**  
- **Teaching Unit (Unité d’Enseignement / UE)**  

An enumeration is used to classify module types:

| TypeModule | Description |
|-------------|-------------|
| **TRANSVERSAL** | Common to several programs (e.g., Languages) |
| **PROFESSIONAL** | Focused on professional skills (e.g., projects, internships) |
| **RESEARCH** | Dedicated to research activities (e.g., dissertations, theses) |

---

## ⚙️ Features to Implement

### 🧩 A. Modules

1. Retrieve the list of all modules.  
2. Create a **new module** (returns `Boolean`).  
3. Update an existing module (by ID).  
4. Retrieve modules by **type**.  
5. Retrieve a module by **matricule**.  
6. Delete a module by **matricule**.

---

### 🧱 B. Teaching Units (UE)

1. Create a **new teaching unit**.  
2. Retrieve a teaching unit by its **unique code**.  
3. Retrieve all teaching units for a given **domain**.  
4. Retrieve all teaching units for a given **semester**.  
5. Update an existing teaching unit (by code).  
6. Delete a teaching unit (by code).

---

## 🧮 Task Requirements

A preconfigured Java project is provided, containing:

- **Entity classes** (`Module`, `Unite_enseignement`, etc.)  
- **Business classes** implementing domain logic

You are required to:

1. **Implement GraphQL queries and mutations** as described above.  
2. **Define the GraphQL schema** (`schema.graphql`) representing the data model.  
3. **Configure the GraphQL server**   
4. **Test operations** using Postman or GraphiQL.  
5. **Observe and explain** what happens when multiple queries are executed within the same GraphQL request.

---


## 📚 Project Structure

```
📦 graphql-workshop
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java
 ┃ ┃ ┃ ┣ 📂 com.esprit.graphql
 ┃ ┃ ┃ ┃ ┣ 📂 entity
 ┃ ┃ ┃ ┃ ┣ 📂 repository
 ┃ ┃ ┃ ┃ ┣ 📂 graphql
 ┃ ┃ ┃ ┃ ┣ 📜 GraphQLEndPoint.java
 ┃ ┃ ┣ 📂 resources
 ┃ ┃ ┃ ┣ 📜 schema.graphqls
 ┣ 📜 pom.xml
 ┣ 📜 README.md
```

---

## 🚀 Implementation Steps

1. **Analyze** the existing entities and business logic.  
2. **Create GraphQL resolvers**:  
   - `QueryResolver` for read operations  
   - `MutationResolver` for write operations  
3. **Define the GraphQL schema** (`schema.graphql`).  
4. **Configure the GraphQL server** within Spring Boot.  
5. **Test** queries and mutations using Postman or GraphiQL.  
6. **Document** your tests and observations.

---

## 🧪 Example GraphQL Operations

### Query Example
```graphql
query {
  allModules {
    code
    name
    type
  }
}
```

### Mutation Example
```graphql
mutation {
  createModule(code: "M001", name: "Web Services", type: PROFESSIONAL)
}
```

---

## 💡 To Explore Further

- REST vs GraphQL: structural and network differences.  
- Strong typing and introspection in GraphQL.  
- Resolver pattern and dependency injection.  
- Combining multiple queries in a single GraphQL request.

---

## 🧾 Deliverables

- Complete project folder (source code + schema + tests).  
- Summary report (PDF) including:  
  - Entity and schema descriptions.  
  - Example queries and mutations.  
  - Postman test screenshots.  
  - Observations about GraphQL flexibility.

---

## 👩‍🏫 Supervision

- **Module Coordinator:** Maroua Douiri  
- **Workshop Instructors:** Badiaa Bouhdid, Akrem Khémiri, Sarra Abidi, Donia Riahi  
- **Duration:** 6 hours (Hands-on Workshop)
