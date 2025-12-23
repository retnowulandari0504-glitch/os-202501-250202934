Tugas Praktikum Minggu 9
Topik: Simulasi Algoritma Penjadwalan CPU

Nama : Dyah Retno Wulandari
NIM : 250202934
Kelas : 1IKRB

A. Deskripsi Singkat
Pada praktikum minggu ini, mahasiswa akan mengimplementasikan program simulasi sederhana algoritma penjadwalan CPU, khususnya FCFS dan SJF.
Berbeda dengan Minggu 5–6 yang berfokus pada perhitungan manual, pada minggu ini mahasiswa mulai mengotomatisasi perhitungan menggunakan program, menjalankan dataset uji, serta menyajikan hasil dalam bentuk tabel atau grafik.

Praktikum ini menjadi jembatan antara pemahaman konseptual dan implementasi komputasional algoritma sistem operasi.

B. Tujuan
Setelah menyelesaikan tugas ini, mahasiswa mampu:

Membuat program simulasi algoritma penjadwalan FCFS dan/atau SJF.
Menjalankan program dengan dataset uji yang diberikan atau dibuat sendiri.
Menyajikan output simulasi dalam bentuk tabel atau grafik.
Menjelaskan hasil simulasi secara tertulis.
Mengunggah kode dan laporan ke Git repository dengan rapi dan tepat waktu.
C. Ketentuan Teknis
Bahasa pemrograman bebas (Python / C / Java / lainnya).
Tidak wajib GUI, cukup program berbasis terminal.
Fokus penilaian pada logika algoritma dan keakuratan hasil, bukan kompleksitas bahasa.
Struktur folder (sesuaikan dengan template repo):

praktikum/week9-sim-scheduling/
├─ code/
│  ├─ scheduling_simulation.*
│  └─ dataset.csv
├─ screenshots/
│  └─ hasil_simulasi.png
└─ laporan.md
D. Langkah Pengerjaan
Menyiapkan Dataset

Buat dataset proses minimal berisi:

Proses	Arrival Time	Burst Time
P1	0	6
P2	1	8
P3	2	7
P4	3	3
Implementasi Algoritma

Program harus:

Menghitung waiting time dan turnaround time.
Mendukung minimal 1 algoritma (FCFS atau SJF non-preemptive).
Menampilkan hasil dalam tabel.
Eksekusi & Validasi

Jalankan program menggunakan dataset uji.
Pastikan hasil sesuai dengan perhitungan manual minggu sebelumnya.
Simpan hasil eksekusi (screenshot).
Analisis

Jelaskan alur program.
Bandingkan hasil simulasi dengan perhitungan manual.
Jelaskan kelebihan dan keterbatasan simulasi.
Commit & Push

git add .
git commit -m "Minggu 9 - Simulasi Scheduling CPU"
git push origin main
E. Tugas & Quiz
Tugas
Buat program simulasi FCFS atau SJF.
Jalankan program dengan dataset uji.
Sajikan output dalam tabel atau grafik.
Tulis laporan praktikum pada laporan.md.
Quiz
Jawab pada bagian Quiz di laporan:

Mengapa simulasi diperlukan untuk menguji algoritma scheduling?
Apa perbedaan hasil simulasi dengan perhitungan manual jika dataset besar?
Algoritma mana yang lebih mudah diimplementasikan? Jelaskan.
F. Output yang Diharapkan
Kode program simulasi di folder code/.
Dataset uji di code/dataset.csv.
Screenshot hasil eksekusi di screenshots/.
Laporan lengkap di laporan.md.
Semua hasil telah di-commit ke GitHub.
G. Referensi
Silberschatz, A., Galvin, P., Gagne, G. Operating System Concepts, 10th Ed.
Tanenbaum, A. Modern Operating Systems, 4th Ed.
OSTEP – Scheduling.