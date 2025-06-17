
---

### 🧩 **Challenge 1: Student Enrollment System**

**Repository:** `student-enrollment-api`

#### 📌 Product Requirement:

Aplikasi ini digunakan untuk mencatat mahasiswa dan pendaftaran mereka ke dalam mata kuliah.

#### 🧠 Entities:

- `Student`: `id`, `name`, `email`
- `Course`: `id`, `title`, `credits`

#### 🔗 API Endpoints:

1. `POST /students` – Tambah mahasiswa
2. `POST /courses` – Tambah mata kuliah
3. `POST /students/{id}/enroll` – Mahasiswa mendaftar ke mata kuliah tertentu
4. `GET /students/{id}/courses` – Lihat semua mata kuliah yang diambil oleh mahasiswa

#### ✅ Validation:

- Email harus valid dan unik
- Setiap mahasiswa tidak boleh mengambil mata kuliah yang sama dua kali

---

### 🧩 **Challenge 2: Product & Category Management**

**Repository:** `product-catalog-api`

#### 📌 Product Requirement:

Admin ingin mengelola produk dan kategori agar customer bisa melihat katalog produk berdasarkan kategori.

#### 🧠 Entities:

- `Category`: `id`, `name`
- `Product`: `id`, `name`, `price`, `categoryId`

#### 🔗 API Endpoints:

1. `POST /categories` – Buat kategori baru
2. `POST /products` – Tambah produk ke kategori tertentu
3. `GET /categories/{id}/products` – Lihat produk dalam kategori
4. `GET /products/{id}` – Detail produk

#### ✅ Validation:

- Harga minimal Rp 1.000
- Nama produk wajib diisi

---

### 🧩 **Challenge 3: Appointment Booking**

**Repository:** `doctor-appointment-api`

#### 📌 Product Requirement:

Pasien dapat melihat dokter, membuat janji, dan dokter bisa melihat daftar janji yang dibuat untuknya.

#### 🧠 Entities:

- `Doctor`: `id`, `name`, `specialization`
- `Appointment`: `id`, `doctorId`, `patientName`, `appointmentTime`

#### 🔗 API Endpoints:

1. `POST /doctors` – Tambah dokter
2. `POST /appointments` – Buat janji dengan dokter
3. `GET /doctors/{id}/appointments` – Lihat janji temu untuk dokter
4. `GET /appointments/{id}` – Lihat detail janji tertentu

#### ✅ Validation:

- Tanggal janji harus > hari ini
- Nama pasien wajib diisi

---

### 🧩 **Challenge 4: Task & Project Management**

**Repository:** `project-task-api`

#### 📌 Product Requirement:

Manajer ingin membuat proyek dan menambahkan tugas dalam proyek tersebut.

#### 🧠 Entities:

- `Project`: `id`, `name`, `deadline`
- `Task`: `id`, `projectId`, `description`, `status`

#### 🔗 API Endpoints:

1. `POST /projects` – Buat proyek
2. `POST /projects/{id}/tasks` – Tambahkan task ke proyek
3. `GET /projects/{id}/tasks` – Lihat semua task dalam proyek
4. `PATCH /tasks/{id}/status` – Ubah status task

#### ✅ Validation:

- Status hanya: `TODO`, `IN_PROGRESS`, `DONE`
- Deadline tidak boleh tanggal lampau

---

### 🧩 **Challenge 5: Library Management**

**Repository:** `library-api`

#### 📌 Product Requirement:

Perpustakaan ingin mencatat buku, anggota, dan transaksi peminjaman.

#### 🧠 Entities:

- `Book`: `id`, `title`, `stock`
- `Member`: `id`, `name`, `email`

#### 🔗 API Endpoints:

1. `POST /books` – Tambah buku baru
2. `POST /members` – Tambah anggota
3. `POST /borrow` – Anggota meminjam buku
4. `GET /members/{id}/borrowed` – Lihat buku yang sedang dipinjam oleh anggota

#### ✅ Validation:

- Stock buku harus > 0 untuk dipinjam
- Email member unik

---

### 🧩 **Challenge 6: Order & Customer System**

**Repository:** `order-management-api`

#### 📌 Product Requirement:

Customer bisa mendaftar dan memesan produk tertentu.

#### 🧠 Entities:

- `Customer`: `id`, `name`, `email`
- `Order`: `id`, `customerId`, `orderDate`, `amount`

#### 🔗 API Endpoints:

1. `POST /customers` – Tambah customer
2. `POST /orders` – Buat pesanan
3. `GET /customers/{id}/orders` – Lihat semua pesanan customer
4. `GET /orders/{id}` – Lihat detail pesanan

#### ✅ Validation:

- `amount` > 0
- Email unik

---

### 🧩 **Challenge 7: Event & Ticketing**

**Repository:** `event-ticketing-api`

#### 📌 Product Requirement:

User dapat melihat event, membeli tiket, dan melihat daftar tiket miliknya.

#### 🧠 Entities:

- `Event`: `id`, `name`, `location`, `date`
- `Ticket`: `id`, `eventId`, `buyerName`

#### 🔗 API Endpoints:

1. `POST /events` – Tambah event
2. `POST /tickets` – Beli tiket
3. `GET /events/{id}/tickets` – Lihat tiket yang dibeli untuk event
4. `GET /tickets/{id}` – Lihat detail tiket

#### ✅ Validation:

- Tanggal event tidak boleh di masa lalu
- Nama pembeli wajib diisi

---

### 🧩 **Challenge 8: Blog & Comments**

**Repository:** `blog-comment-api`

#### 📌 Product Requirement:

Penulis dapat membuat blog post dan pembaca bisa memberi komentar.

#### 🧠 Entities:

- `Post`: `id`, `title`, `content`, `author`
- `Comment`: `id`, `postId`, `name`, `message`

#### 🔗 API Endpoints:

1. `POST /posts` – Buat blog post
2. `POST /posts/{id}/comments` – Tambah komentar
3. `GET /posts/{id}/comments` – Lihat komentar pada blog
4. `GET /comments/{id}` – Detail komentar

#### ✅ Validation:

- Judul minimal 5 karakter
- Komentar tidak boleh kosong

---
