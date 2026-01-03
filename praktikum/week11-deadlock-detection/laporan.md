# Tugas Praktikum Minggu 11  
Topik: Simulasi dan Deteksi Deadlock

---

## Identitas
- **Nama**  : [Dyah Retno Wulandari]  
- **NIM**   : [250202934]  
- **Kelas** : [1IKRB]

## A. Deskripsi Singkat
Pada praktikum minggu ini, mahasiswa akan mempelajari **mekanisme deteksi deadlock** dalam sistem operasi.  
Berbeda dengan Minggu 7 yang berfokus pada *pencegahan dan penghindaran deadlock*, pada minggu ini mahasiswa diarahkan untuk **mendeteksi deadlock yang telah terjadi** menggunakan pendekatan algoritmik.

Mahasiswa akan membuat **program simulasi sederhana deteksi deadlock**, menjalankan dataset uji, serta menyajikan hasil analisis dalam bentuk tabel dan interpretasi logis.

---

## B. Tujuan
Setelah menyelesaikan tugas ini, mahasiswa mampu:
1. Membuat program sederhana untuk mendeteksi deadlock.  
2. Menjalankan simulasi deteksi deadlock dengan dataset uji.  
3. Menyajikan hasil analisis deadlock dalam bentuk tabel.  
4. Memberikan interpretasi hasil uji secara logis dan sistematis.  
5. Menyusun laporan praktikum sesuai format yang ditentukan.

---

## C. Ketentuan Teknis
- Bahasa pemrograman **bebas** (Python / C / Java / lainnya).  
- Program berbasis **terminal**, tidak memerlukan GUI.  
- Fokus penilaian pada **logika algoritma deteksi deadlock**, bukan kompleksitas bahasa.

Struktur folder (sesuaikan dengan template repo):
```
praktikum/week11-deadlock-detection/
├─ code/
│  ├─ deadlock_detection.*
│  └─ dataset_deadlock.csv
├─ screenshots/
│  └─ hasil_deteksi.png
└─ laporan.md
```

---

## D. Langkah Pengerjaan
1. **Menyiapkan Dataset**

   Gunakan dataset sederhana yang berisi:
   - Daftar proses  
   - Resource Allocation  
   - Resource Request / Need

   Contoh tabel:

   | Proses | Allocation | Request |
   |:--:|:--:|:--:|
   | P1 | R1 | R2 |
   | P2 | R2 | R3 |
   | P3 | R3 | R1 |

2. **Implementasi Algoritma Deteksi Deadlock**

   Program minimal harus:
   - Membaca data proses dan resource.  
   - Menentukan apakah sistem berada dalam kondisi deadlock.  
   - Menampilkan proses mana saja yang terlibat deadlock.

3. **Eksekusi & Validasi**

   - Jalankan program dengan dataset uji.  
   - Validasi hasil deteksi dengan analisis manual/logis.  
   - Simpan hasil eksekusi dalam bentuk screenshot.

4. **Analisis Hasil**

   - Sajikan hasil deteksi dalam tabel (proses deadlock / tidak).  
   - Jelaskan mengapa deadlock terjadi atau tidak terjadi.  
   - Kaitkan hasil dengan teori deadlock (empat kondisi).

5. **Commit & Push**

   ```bash
   git add
   git commit -m "Minggu 11 - Deadlock Detection"
   git push origin main
   ```

---

## E. Tugas & Quiz
### Tugas
1. Buat program simulasi deteksi deadlock.  
2. Jalankan program dengan dataset uji.  
3. Sajikan hasil analisis dalam tabel dan narasi.  
4. Tulis laporan praktikum pada `laporan.md`.

### Quiz
Jawab pada bagian **Quiz** di laporan:
1. Apa perbedaan antara *deadlock prevention*, *avoidance*, dan *detection*?  
   a)	Prevention : aturan ketat diterapkan sebelum proses berjalan, deadlock pasti tidak terjadi, mengorbankan efisiensi sistem
   
   b)	Avidance : membutuhkan informasi kebutuhan maksimum proses, deadlock dihindari, bukan dicegah mutlak

   c)	Detection : deadlock boleh terjadi, sistem bertindak setelah deadlock terdeteksi

2. Mengapa deteksi deadlock tetap diperlukan dalam sistem operasi?  
Jawab: Deadlock diperlukan karena :
   a)	Prevention dan avoidance tidak selalu efisien atau memungkinkan
   
   b)	Deadlock tetap bisa terjadi pada sistem kompleks

   c)	Deteksi memungkinkan pemanfaatan resource yang optimal

   d)	Menjadi dasar untuk melakukan recovery


3. Apa kelebihan dan kekurangan pendekatan deteksi deadlock?

Kelebihan :


   a.	 Pemanfaatan resource maksimal
   
   b.	Lebih fleksibel untuk sistem dinamis

   c.	Implementasi lebih realistis

   d.	Tidak menyebabkan starvation sejak awal proses

Kekurangan :

   
   a.	Deadlock sudah terjadi saat terdeteksi

   b.	Overhead deteksi memerlukan waktu dan sumber daya

   c.	Recovery berisiko, menghentikan proses/rollback dapat menyebabkan kehilangan data, inkosistensi sistem

   d.	Pemilihan korban (Victim selection) sulit menetukan proses mana yang harus dihentikan tidak sederhana atau salah pilih dapat merugikan proses penting
		

---

## F. Output yang Diharapkan
- Kode program deteksi deadlock di folder `code/`.  
- Dataset uji di `code/dataset_deadlock.csv`.  
- Screenshot hasil eksekusi di folder `screenshots/`.  
- Laporan lengkap di `laporan.md`.  
- Semua hasil telah di-*commit* ke GitHub.

---

## G. Referensi
1. Silberschatz, A., Galvin, P., Gagne, G. *Operating System Concepts*, 10th Ed.  
2. Tanenbaum, A. *Modern Operating Systems*, 4th Ed.  
3. OSTEP – Deadlock Detection.
