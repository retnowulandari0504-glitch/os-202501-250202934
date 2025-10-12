
# Laporan Praktikum Minggu [1]
Topik: "Arsitektur Sistem Operasi dan Kernel"

---

## Identitas
- **Nama**  : [Dyah Retno Wulandari]  
- **NIM**   : [250202934]  
- **Kelas** : [IKRB]

---

## Tujuan
Tuliskan tujuan praktikum minggu ini.  

> Mahasiswa mampu menjelaskan fungsi utama sistem operasi dan peran kernel serta system call.

---

## Dasar Teori
Tuliskan ringkasan teori (3–5 poin) yang mendasari percobaan.

Pada praktikum minggu ini, mahasiswa akan mempelajari arsitektur dasar sistem operasi: bagaimana komponen OS bekerja, serta bagaimana interaksi antara user, aplikasi, kernel, dan hardware terjadi.

Mahasiswa juga diperkenalkan pada:

⦁	Perbedaan mode eksekusi kernel mode dan user mode.

⦁	Mekanisme system call (panggilan sistem).

⦁	Perbandingan model arsitektur OS seperti monolithic kernel, layered approach, dan microkernel.

Eksperimen akan dilakukan menggunakan perintah dasar Linux untuk melihat informasi kernel dan modul aktif.
---

## Langkah Praktikum
1. Langkah-langkah yang dilakukan.  
 Setup Environment

   Pastikan Linux (Ubuntu/WSL) sudah terinstal.

   Pastikan Git sudah dikonfigurasi dengan benar:

   git config --global user.name "Nama Anda"

   git config --global user.email "email@contoh.com"


2. ## Diskusi Konsep

   Baca materi pengantar tentang komponen OS.

   Identifikasi komponen yang ada pada Linux/Windows/Android.

3. ## Eksperimen Dasar 
Jalankan perintah berikut di terminal:

uname -a

whoami

lsmod | head

dmesg | head

Catat dan analisis modul kernel yang tampil.

  
4. ## Membuat Diagram Arsitektur

⦁	Buat diagram hubungan antara User → System Call → Kernel → Hardware.

⦁	Gunakan draw.io atau Mermaid.

⦁	Simpan hasilnya di:

praktikum/week1-intro-arsitektur-os/screenshots/diagram-os.png

5. ## Penulisan Laporan

⦁	Tuliskan hasil pengamatan, analisis, dan kesimpulan ke dalam laporan.md.

⦁	Tambahkan screenshot hasil terminal ke folder screenshots/.
6. ## Commit & Push

git add .

git commit -m "Minggu 1 - Arsitektur Sistem Operasi dan Kernel"

git push origin main

---

## Kode / Perintah
Tuliskan potongan kode atau perintah utama:
```bash
uname -a
lsmod | head
dmesg | head
```

---

## Hasil Eksekusi
Sertakan screenshot hasil percobaan atau diagram:
![Screenshot hasil](screenshots/ubuntuW.png)
![Screenshot hasil](screenshots/diagram1.drawio.png)

---

## Analisis
- Jelaskan makna hasil percobaan.  
- Hubungkan hasil dengan teori (fungsi kernel, system call, arsitektur OS).  
- Apa perbedaan hasil di lingkungan OS berbeda (Linux vs Windows)?  

---

## Kesimpulan
Tuliskan 2–3 poin kesimpulan dari praktikum ini.

---

## Quiz
1. [Sebutkan tiga fungsi utama sistem operasi]  
   **Jawaban:**  
2. [Jelaskan perbedaan antara kernel mode dan user mode]  
   **Jawaban:**  
3. [Sebutkan contoh OS dengan arsitektur monolithic dan mickrokenel]  
   **Jawaban:**  

---

## Refleksi Diri
Tuliskan secara singkat:
- Apa bagian yang paling menantang minggu ini?  
- Bagaimana cara Anda mengatasinya?  

---

**Credit:**  
_Template laporan praktikum Sistem Operasi (SO-202501) – Universitas Putra Bangsa_
