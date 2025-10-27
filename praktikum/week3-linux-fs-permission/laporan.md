
# Tugas Praktikum Minggu 3  
Topik: Manajemen File dan Permission di Linux  


--
## Identitas
- **Nama**  : [Dyah Retno Wulandari]  
- **NIM**   : [250202934]  
- **Kelas** : [1IKRB]

---

## A. Deskripsi Singkat
Pada praktikum minggu ini, mahasiswa akan mempelajari **pengelolaan file dan direktori menggunakan perintah dasar Linux**, serta konsep **permission dan ownership**.  
Praktikum berfokus pada:
- Navigasi sistem file dengan `ls`, `pwd`, `cd`, dan `cat`.
- Pengaturan hak akses file menggunakan `chmod`.
- Pengubahan kepemilikan file menggunakan `chown`.
- Dokumentasi hasil eksekusi dan pengelolaan repositori praktikum.

Tujuan utama dari praktikum ini adalah agar mahasiswa mampu **mengoperasikan perintah Linux dasar dengan benar**, memahami sistem izin (permission), dan mendokumentasikan hasilnya dalam format laporan Git.

---

## B. Tujuan
Setelah menyelesaikan tugas ini, mahasiswa mampu:
1. Menggunakan perintah `ls`, `pwd`, `cd`, `cat` untuk navigasi file dan direktori.
2. Menggunakan `chmod` dan `chown` untuk manajemen hak akses file.
3. Menjelaskan hasil output dari perintah Linux dasar.
4. Menyusun laporan praktikum dengan struktur yang benar.
5. Mengunggah dokumentasi hasil ke Git Repository tepat waktu.

---

## C. Langkah Pengerjaan
1. **Setup Environment**
   - Gunakan Linux (Ubuntu/WSL).
   - Pastikan folder kerja berada di dalam direktori repositori Git praktikum:
     ```
     praktikum/week3-linux-fs-permission/
     ```

2. **Eksperimen 1 – Navigasi Sistem File**
   Jalankan perintah berikut:
   ```bash
   pwd
   ls -l
   cd /tmp
   ls -a
   ```
   - Jelaskan hasil tiap perintah.
      
      Jawab: 
<html>
<head>
<body>
<table>
<tr>
   <th>Perintah</th>
   <th>Hasil</th>
   <th>Penjelasan</th>
</tr>
<tr>
   <td>pwd</td>
   <td>retnowulandari0504@LAPTOP-CA0KHU5V:~$ pwd
/home/retnowulandari0504</td>
   <td>untuk menampilkan direktori kerja saat diterminal</td>
</tr>
<tr>
   <td>ls -l</td>
   <td>retnowulandari0504@LAPTOP-CA0KHU5V:~$ ls -l
total 0</td>
<td>total 0 menunjukkan bawa tidak ada file atau folder didalam direktori saat ini</td>
</tr>
   <td>cd /tmp</td>
   <td>
retnowulandari0504@LAPTOP-CA0KHU5V:~$ cd /tmp</td>
   <td>Untuk berpindah ke direktori lain yaitu berpindah ke direktori /tmp</td>
</tr>
<tr>
   <td>ls -a</td>
   <td>retnowulandari0504@LAPTOP-CA0KHU5V:/tmp$ ls -a
   
.                 systemd-private-bb084cceb8684b5e810305794a461624-systemd-logind.service-DeoYCK

..                systemd-private-bb084cceb8684b5e810305794a461624-systemd-resolved.service-k0giK1

.X11-unix         systemd-private-bb084cceb8684b5e810305794a461624-systemd-timesyncd.service-cQutAU
snap-private-tmp</td>
   <td>Menunjukan direktori saat ini (/tmp), menunjukkan direktori induk yaitu (/), dan folder khusus untuk komunikasi antarproses gratis (layanan X11 pada sistem Linux)</td>
</table>
</body>
</head>
</html>
 
   - Catat direktori aktif, isi folder, dan file tersembunyi (jika ada).

Jawab :

  - Direktori aktif : /tmp
  - Isi folder : berisi beberapa folder sementara milik layanan sistem
  - File tersembunyi : . , .., dan X11-unix    
   

3. **Eksperimen 2 – Membaca File**
   Jalankan perintah:
   ```bash
   cat /etc/passwd | head -n 5
   ```
- Jelaskan isi file dan struktur barisnya (user, UID, GID, home, shell).
   
   Jawab : 

   - Username : Nama pengguna (contoh: root, daemon)
   - Password placeholder : biasanya berisi x, artinya password disimpan terenkripsi di file /etc/ shadow
   - UID (User ID) : Nomor identitas unik untuk user
   
   - GID (Group ID) : Nomor identitas grup utama user
   - User info/ Comment/ GECOS : Deskripsi singkat tentang user
   - Home Directory : Lokasi direktori utama user
   
   - Login Shell : Program shell yang dijalankan saat user

<html>
<head>
<body>
   <table>
   <tr>
   <th>No</th>
   <th>Username</th>
   <th>UID</th>
   <th>GID</th>
   <th>Home Directory</th>
   <th>Shell</th>
   <th>Keterangan</th>
   </tr>
   <tr>
   <td> 1 </td>
   <td>root</td>
   <td>0</td>
   <td>0</td>
   <td>/root</td>
   <td>/bin/bash</td>
   <td>Akun superuser (administrator sistem) dengan hak penuh.</td>
   </tr>
   <td> 2 </td>
     <td>daemon</td>
   <td>1</td>
   <td>1</td>
   <td>/usr/sbin</td>
   <td>/usr/sbin/nologin</td>
   <td>Akun sistem untuk layanan background (daemon, tidak bisa login.)</td>
   </tr>
   <td> 3 </td>
   <td>bin</td>
   <td>2</td>
   <td>2</td>
   <td>/bin</td>
   <td>/usr/sbin/nologin</td>
   <td>Akun sistem yang menunjukkan file biner penting.</td>
   </tr>
   <td> 4 </td>
   <td>sys</td>
   <td>3</td>
   <td>3</td>
   <td>/dev</td>
   <td>/usr/sbin/nologin</td>
   <td>Akun sistem yang menangani perangkat (device system).</td>
   <tr>
   <td> 5 </td>
   <td>sync</td>
   <td>4</td>
   <td>65534</td>
   <td>/bin</td>
   <td>/bin/sync</td>
   <td>Akun sistem khusus untuk menjalankan perintah sync (sinkronisasi data ke disk). Tidak bisa login interaktif 
   </tr>
      </table>
</body>
</head>
</html>
4. **Eksperimen 3 – Permission & Ownership**
   Buat file baru:

   ```bash
   echo "Hello <NAME><NIM>" > percobaan.txt
   ls -l percobaan.txt
   chmod 600 percobaan.txt
   ls -l percobaan.txt
   ```
   - Analisis perbedaan sebelum dan sesudah chmod.  
      Sebelum chmod

      retnowulandari0504@LAPTOP-CA0KHU5V:~$ ls -l percobaan.txt

         -rw-r--r-- 1 retnowulandari0504 retnowulandari0504 38 Oct 27 20:53 percobaan.txt
      
      Penjelasan :

  - -rw-r--r-- → izin akses file (permissions)

- → menandakan ini file biasa, bukan direktori.

- rw- → owner (pemilik) bisa membaca dan menulis.

- r-- → group hanya bisa membaca.

- r-- → others (user lain) juga hanya bisa membaca.

- 1 → jumlah link ke file.

- retnowulandari0504 → pemilik file (owner).

- retnowulandari0504 → grup file (group).

- 38 → ukuran file dalam byte.

- Oct 27 20:53 → waktu terakhir file diubah.

- percobaan.txt → nama file.

   Setelah chmod

      retnowulandari0504@LAPTOP-CA0KHU5V:~$ ls -l percobaan.txt

         -rw------- 1 retnowulandari0504 retnowulandari0504 38 Oct 27 20:53 percobaan.txt

   Penjelasan :

- rw------- artinya:

- Owner: boleh membaca dan menulis (rw-).

- Group: tidak punya izin (---).

- Others: tidak punya izin (---).

Kesimpulan : 

Sebelum diubah, file dapat dibaca oleh semua orang (owner, group, dan others). Sedangkan setelah chmod  hanya pemilik file yang bisa membuka atau mengedit file.
User lain tidak bisa membaca maupun menulis ke file tersebut.
Ini meningkatkan keamanan file pribadi.
      
- Ubah pemilik file (jika memiliki izin sudo):
   ```bash
   sudo chown root percobaan.txt
   ls -l percobaan.txt
   ```
- Catat hasilnya.

      retnowulandari0504@LAPTOP-CA0KHU5V:~$ sudo chown root percobaan.txt

      [sudo] password for retnowulandari0504:
      retnowulandari0504@LAPTOP-CA0KHU5V:~$ ls -l percobaan.txt
      -rw------- 1 root retnowulandari0504 38 Oct 27 20:53 percobaan.txt

5. **Eksperimen 4 – Dokumentasi**
   - Ambil screenshot hasil terminal dan simpan di:
     ```
     praktikum/week3-linux-fs-permission/screenshots/
     ```
   - Tambahkan analisis hasil pada `laporan.md`.

6. **Commit & Push**
   ```bash
   git add .
   git commit -m "Minggu 3 - Linux File System & Permission"
   git push origin main
   ```

---

## D. Tugas & Quiz
### Tugas
1. Dokumentasikan hasil seluruh perintah pada tabel observasi di `laporan.md`.  
2. Jelaskan fungsi tiap perintah dan arti kolom permission (`rwxr-xr--`).  
Jawab :
 
 - rwx :	User (pemilik file)	Bisa membaca (r), menulis (w), dan menjalankan (x) file

- r-x	 : Group (kelompok pengguna)	Bisa membaca dan menjalankan, tapi tidak bisa mengubah file

- r-- : Others (pengguna lain)	Hanya bisa membaca, tidak bisa menulis atau menjalankan


3. Analisis peran `chmod` dan `chown` dalam keamanan sistem Linux.  
Jawab :
   - `chmod` berfungsi mengontrol hak akses (read, writer, execute) sehingga hanya pengguna yang berwenang dapat membaca, mengubah, atau menjalankan file.
   - `chown` berfungsi memastikan file atau direktori dimiliki oleh pengguna dan grup yang  benar,mencegah akses atau manipulasi oleh pihak yang tidak berhak.

4. Upload hasil dan laporan ke repositori Git sebelum deadline.

### Quiz
Tuliskan jawaban di bagian **Quiz** pada laporan:
1. Apa fungsi dari perintah `chmod`?  
   Jawab : `chmod` berfungsi untuk menetukan siapa yang boleh membaca, menulis, atau mengeksekusi suatu file/direktori
2. Apa arti dari kode permission `rwxr-xr--`?  
   Jawab : `rwxr-xr--` berarti :

      - Pemilik (user) memiliki izin penuh : membaca, menulis, dan mengeksekusi file
      - Grup hanya dapat membaca dan mengeksekusi tetapi bisa dapat mengubah dapat mengubah file
      - Pengguna lain (others) hanyabdapat membaca file saja
3. Jelaskan perbedaan antara `chown` dan `chmod`.  
Jawab :
   - `chown` digunakan untuk mengubah kepemilikan file atau direktori (siapa pemilik dan grupnya)
   - `chmod` digunakan untuk mengubah izin akses file atau direktori (siapa yang boleh membaca, menulis, atau mengeksekusi)

---

## E. Output yang Diharapkan
- Hasil observasi perintah Linux dimasukkan ke dalam `laporan.md`.  
- Screenshot hasil eksekusi disimpan di `screenshots/`.  
- Laporan lengkap tersimpan di `laporan.md`.  
- Semua hasil telah di-*commit* ke GitHub tepat waktu.  

---

## F. Referensi
1. Abraham Silberschatz, Peter Baer Galvin, Greg Gagne. *Operating System Concepts*, 10th Edition, Wiley, 2018.  
2. Andrew S. Tanenbaum, Herbert Bos. *Modern Operating Systems*, 4th Edition, Pearson, 2015.  
3. Linux Manual Pages (`man chmod`, `man chown`, `man ls`).  
4. OSTEP – *Operating Systems: Three Easy Pieces*, 2018.  
