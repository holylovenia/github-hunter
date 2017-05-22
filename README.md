# github-hunter
A GitHub account searcher


------------------------------------------------------------------

JSON

JSON (Java Script Object Notation) adalah format atau sintaks yang digunakan untuk melakukan penyimpanan ataupun pertukaran data. JSON ditulis dalam bentuk teks yang dapat dibaca oleh manusia dan digunakan sebagai representasi struktur data dan objek.

- Pertukaran Data
  Ketika melakukan pertukaran data antara browser dan server, data hanya dapat berupa teks.
  Objek JavaScript dapat dikonversikan ke dalam JSON dan dikirim ke server, maupun sebaliknya.

- Pengiriman Data
  Data yang tersimpan dalam objek JavaScript dikonversikan ke JSON, lalu dikirim ke server.

- Penerimaan Data
  Data yang tersimpan dalam JSON dikonversikan ke objek JavaScript.

- Penyimpanan Data
  Format data yang digunakan untuk penyimpanan adalah teks, sehingga dapat dibaca dan digunakan oleh bahasa pemrograman manapun (language independent).

------------------------------------------------------------------

REST

REST (Representational State Transfer) adalah arsitektur berbasis standar web dan menggunakan HTTP Protocol untuk melakukan komunikasi data. REST berputar di sekitar sumber di mana setiap komponen dari sumber tersebut juga merupakan sumber dan sumber diakses oleh sebuah antarmuka umum menggunakan metode standar HTTP.
Dalam arsitektur REST, REST Server bertugas untuk menyediakan akses ke sumber, sedangkan REST Client bertugas untuk mengakses dan membawakan sumber. Setiap sumber diidentifikasi dengan URI (Uniform Resource Identifier) atau ID global. Beberapa representasi dari sumber yang digunakan oleh REST adalah teks, JSON, dan XML. Saat ini, format yang paling sering digunakan dalam web service adalah JSON.

- Metode HTTP
  1. GET: hanya dapat membaca sumber.
  2. PUT: digunakan untuk menciptakan sumber baru.
  3. DELETE: digunakan untuk menghapus sumber.
  4. POST: digunakan untuk memperbarui sumber yang sudah ada atau menciptakan sumber baru.
  5. OPTIONS: digunakan untuk memperoleh operasi yang didukung oleh suatu sumber.

- RESTful Web Service
  Web service adalah sebuah kumpulan dari protokol terbuka dan standar yang digunakan untuk melakukan pertukaran data melalui aplikasi atau sistem. Aplikasi perangkat lunak yang ditulis dalam berbagai bahasa pemrograman dan berjalan pada bermacam-macam platform dapat menggunakan web service untuk melakukan pertukaran data melalui jaringan komputer seperti internet dengan memperlakukannya seperti proses dalam sebuah komputer.
  Web service yang berbasis arsitektur REST dikenal sebagai RESTful Web Service. Web service jenis tersebut menggunakan metode HTTP untuk implementasi konsep dari arsitektur REST. RESTful Web Service biasa mendefinisikan URI, yaitu service yang menyediakan representasi sumber seperti JSON dan sekumpulan metode HTTP.

------------------------------------------------------------------

GitHub API

API (Application Program Interface) yang menyediakan kelas-kelas yang berhubungan dengan model domain dari GitHub, operasi-operasi yang dimiliki dan didefinisikan sebagai metode, dan referensi-referensi objek.

- Skema
  Akses yang dilakukan menggunakan HTTPS, dan diakses lewat https://api.github.com. Semua data dikirim dan diterima sebagai JSON.
  Blank field -> null (bukannya dihapus).
  Timestamp -> ISO 8601 (YYYY-MM-DDTHH:MM:SSZ).

- Representasi Ringkasan
  Saat pengguna memanggil daftar sumber, respon yang diberikan berisi himpunan bagian dari atribut sumber tersebut. Tidak semua atribut diberikan oleh API. Hal ini dikarenakan secara komputasi pemanggilan atribut-atribut tersebut mahal, sehingga untuk meningkatkan performa, hanya dilakukan pemanggilan untuk atribut-atribut utama.

- Parameter
  Banyak metode yang menggunakan parameter opsional.
  1. GET requests: parameter yang tidak dispesifikkan sebagai sebuah segmen dalam sebuah path dapat disampaikan sebagai HTTP query string parameter.
  2. POST, PUT, DELETE, PATCH requests: parameter yang tidak termasuk dalam URL harus dienkode sebagai JSON dengan tipe konten sebagai 'application/json'

- Client Errors
  1. Mengirimkan JSON yang invalid akan menghasilkan 400 Bad Request.
  2. Mengirimkan nilai JSON dengan tipe yang salah akan menghasilkan 400 Bad Request.
  3. Mengirimkan field yang invalid akan menghasilkan 422 Unprocessable Entity.

- HTTP Redirects
  Respon dari redirect akan mengandung Location header field yang memiliki URI dari sumber yang dituju oleh pengulangan request dari client.
  1. 301: permanent redirection, menggunakan URI baru untuk request ke depannya.
  2. 302, 307: temporary redirection, menggunakan URI yang sama untuk request ke depannya.

- HTTP Verbs
  1. HEAD: dapat digunakan untuk mendapatkan HTTP header info dari sumber manapun.
  2. GET: mendapat sumber.
  3. POST: membuat sumber.
  4. PATCH: memperbarui sumber dengan sebagian dari data JSON. Setiap sumber yang bersangkutan memiliki atribut title dan body. PATCH request dapat menerima satu atau lebih atribut untuk memperbarui sumber.
  5. PUT: menggantikan sumber atau koleksi.
  6. DELETE: menghapus sumber.