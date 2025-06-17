Berikut adalah **4 challenge aplikasi kompleks** untuk pengembangan backend REST API menggunakan **Spring Boot** yang mencakup aspek **Security (JWT)**, **validasi**, dan **relasi antar entitas**. Masing-masing soal juga mencakup spesifikasi endpoint dan kebutuhan fitur utama.

---

### 🧩 **Challenge 1: Digital Loan Management System**

**Repository name:** `digital-loan-service`

#### 📌 Product Requirements:

Sebuah sistem pengajuan dan pengelolaan pinjaman digital:

- User bisa registrasi & login (JWT)
- User bisa mengajukan pinjaman
- Admin bisa melihat semua pengajuan
- Setiap pinjaman memiliki status: _PENDING_, _APPROVED_, _REJECTED_

#### 📡 Endpoints (Minimal 8):

1. `POST /auth/register` – register user
2. `POST /auth/login` – login user
3. `POST /loan/apply` – pengajuan pinjaman (hanya USER)
4. `GET /loan/my` – daftar pinjaman milik user (JWT User only)
5. `GET /loan/all` – semua pinjaman (hanya ADMIN)
6. `PUT /loan/{id}/approve` – approve pinjaman (ADMIN)
7. `PUT /loan/{id}/reject` – reject pinjaman (ADMIN)
8. `GET /loan/{id}` – detail pinjaman

#### 🧾 Entities:

- **UserEntity** (id, username, password, role)
- **LoanEntity** (id, user_id, amount, status, submitted_date)

---

### 🧩 **Challenge 2: Expense Tracker System**

**Repository name:** `expense-tracker-api`

#### 📌 Product Requirements:

Sistem untuk mencatat pengeluaran pribadi, dengan kategori & tanggal.

- Hanya user yang login bisa mengakses dan memanipulasi datanya
- Kategori disediakan oleh sistem, tidak bisa diubah user
- Semua API harus pakai JWT

#### 📡 Endpoints:

1. `POST /auth/signup`
2. `POST /auth/login`
3. `GET /categories`
4. `POST /expenses`
5. `GET /expenses` (filter by date & category)
6. `GET /expenses/summary` (group by category)
7. `PUT /expenses/{id}`
8. `DELETE /expenses/{id}`

#### 🧾 Entities:

- **User** (id, email, password, role)
- **Expense** (id, user_id, amount, date, category_id, note)
- **Category** (id, name)

---

### 🧩 **Challenge 3: Course Enrollment Platform**

**Repository name:** `course-platform-api`

#### 📌 Product Requirements:

Platform untuk registrasi kursus oleh mahasiswa dan pengelolaan oleh admin.

- Ada user dan admin
- Mahasiswa bisa melihat dan mendaftar ke kursus
- Admin bisa menambah dan menghapus kursus

#### 📡 Endpoints:

1. `POST /auth/register`
2. `POST /auth/login`
3. `GET /courses` – semua kursus
4. `POST /courses` – tambah kursus (admin only)
5. `DELETE /courses/{id}` – hapus kursus (admin only)
6. `POST /enrollments` – daftar kursus (student only)
7. `GET /enrollments/my` – lihat kursus yang diambil (JWT user)
8. `GET /courses/{id}` – detail kursus

#### 🧾 Entities:

- **User** (id, username, password, role: STUDENT/ADMIN)
- **Course** (id, title, description, createdBy)
- **Enrollment** (id, user_id, course_id, enrolled_date)

---

### 🧩 **Challenge 4: Support Ticket Management**

**Repository name:** `support-ticket-api`

#### 📌 Product Requirements:

Sistem ticket untuk layanan support:

- Pelanggan bisa buat dan melihat tiket
- Admin bisa menjawab dan update status tiket
- Tiket bisa diberi prioritas: LOW, MEDIUM, HIGH

#### 📡 Endpoints:

1. `POST /auth/register`
2. `POST /auth/login`
3. `POST /tickets`
4. `GET /tickets/my`
5. `GET /tickets/all` (ADMIN)
6. `PUT /tickets/{id}/respond` (ADMIN)
7. `PUT /tickets/{id}/status` (ADMIN)
8. `GET /tickets/{id}`

#### 🧾 Entities:

- **User** (id, email, password, role: CUSTOMER/ADMIN)
- **Ticket** (id, user_id, title, message, status, priority, response, created_at)

---

### ✅ Fitur Tambahan di Semua Soal:

- 🔐 JWT-based security
- ✅ Bean validation (misal `@NotBlank`, `@Size`, dll)
- 📦 DTO usage untuk request/response
- 📃 API tested via Postman (bonus)

Jika kamu ingin saya buatkan struktur folder, kode JWT-nya, atau request/response sample untuk salah satu dari challenge di atas, tinggal bilang ya!
