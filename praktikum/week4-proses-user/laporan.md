# Tugas Praktikum Minggu 4  
Topik: Manajemen Proses dan User di Linux  

---

## Identitas
- **Nama**  : [Dyah Retno Wulandari]  
- **NIM**   : [250202934]  
- **Kelas** : [1IKRB]

---

## A. Deskripsi Singkat
Pada praktikum minggu ini, mahasiswa akan mempelajari **konsep proses dan manajemen user dalam sistem operasi Linux.**  
Mahasiswa akan memahami bagaimana sistem operasi:
- Membuat dan mengatur proses (process management).  
- Mengelola user, group, serta hak akses pengguna.  
- Menampilkan, menghentikan, dan mengontrol proses yang sedang berjalan.  
- Menghubungkan konsep user management dengan keamanan sistem operasi.

Eksperimen dilakukan melalui penggunaan perintah dasar seperti `ps`, `top`, `kill`, `adduser`, `passwd`, `id`, dan `groups`.

---

## B. Tujuan
Setelah menyelesaikan tugas ini, mahasiswa mampu:
1. Menjelaskan konsep proses dan user dalam sistem operasi Linux.  
2. Menampilkan daftar proses yang sedang berjalan dan statusnya.  
3. Menggunakan perintah untuk membuat dan mengelola user.  
4. Menghentikan atau mengontrol proses tertentu menggunakan PID.  
5. Menjelaskan kaitan antara manajemen user dan keamanan sistem.  

---

## C. Langkah Pengerjaan
1. **Setup Environment**
   - Gunakan Linux (Ubuntu/WSL).  
   - Pastikan Anda sudah login sebagai user non-root.  
   - Siapkan folder kerja:
     ```
     praktikum/week4-proses-user/
     ```

2. **Eksperimen 1 – Identitas User**
   Jalankan perintah berikut:
   ```bash
   whoami
   id
   groups
   ```
   - Jelaskan setiap output dan fungsinya. 

      Jawab :

         retnowulandari0504@LAPTOP-CA0KHU5V:~$ whoami
         retnowulandari0504
         retnowulandari0504@LAPTOP-CA0KHU5V:~$ id
         uid=1000(retnowulandari0504) gid=1000(retnowulandari0504) groups=1000(retnowulandari0504),4(adm),20(dialout),24(cdrom),25(floppy),27(sudo),29(audio) 30(dip),44(video),46(plugdev),117(netdev)
         retnowulandari0504@LAPTOP-CA0KHU5V:~$ groups
         retnowulandari0504 adm dialout cdrom floppy sudo audio dip video plugdev netdev


whoami = Menampilkan nama user yang sedang aktif/login di sistem Linux. Artinya user yang sedang menggunakan terminal saat ini bernama **retnowulandari0504**. Perintah ini sangat berguna untuk memastikan siapa user aktif saat ini.

id = Menampilkan informasi identitas user secara lengkap, termasuk:

- UID (User ID)

- GID (Group ID)

- Groups (keanggotaan grup)

<html>
<head>
<body>
   <table>
   <tr>
   <th>Bagian Output</th>
   <th>Fungsi</th>
   </tr>
   <tr>
   <td>uid=1000(retnowulandari0504)</td>
   <td> uid (User ID) adalah identitas unik untuk user ini.1000 biasanya menunjukkan user pertama yang dibuat di sistem (bukan root)</td>
    </tr>
   <tr>
   <td>gid=1000(retnowulandari0504)</td>
   <td> gid (Group ID) adalah identitas grup utama user, dalam hal ini grup dengan nama yang sama retnowulandari0504</td>
    </tr>
   <tr>
   <td>groups</td>
   <td>Menampilkan semua grup yang diikuti oleh user, beserta ID dan namanya. Tiap grup memberi hak akses tertentu</td>
   </table>
   </body>
   
   Berikut makna tiap grup: 
<html>
<head>
<body>
   <table>
   <tr>
   <th>ID Grup</th>
   <th>Nama Grup</th>
   <th>Fungsi</th>
   </tr>
   <tr>
   <td>1000</td>
   <td>retnowulandari0504</td>
   <td>Grup utama user</td>
   </tr>
    <tr>
   <td>4</td>
   <td>adm</td>
   <td>Dapat membaca log sistem (akses administratif ringan)</td>
   </tr>
    <tr>
   <td>20</td>
   <td>dialout</td>
   <td>Mengakses port serial, modem, atau perangkat komunikasi</td>
   </tr>
    <tr>
   <td>24</td>
   <td>cdrom</td>
   <td>Mengakses CD/DVD drive</td>
   </tr>
    <tr>
   <td>25</td>
   <td>floppy</td>
   <td>Mengakses floppy disk (jarang dipakai sekarang)</td>
   </tr>
    <tr>
   <td>27</td>
   <td>sudo</td>
   <td>Dapat menjalankan perintah dengan hak root (administrator)</td>
   </tr>
    <tr>
   <td>29</td>
   <td>audio</td>
   <td>Mengakses perangkat audio (speaker, mic)</td>
   </tr>
    <tr>
   <td>30</td>
   <td>dip</td>
   <td>Mengaatur koneksi jaringan (PPP,dial-up)</td>
   </tr>
    <tr>
   <td>44</td>
   <td>video</td>
   <td>Mengakses perangkat video seperti GPU, kamera</td>
   </tr>
    <tr>
   <td>46</td>
   <td>plugdev</td>
   <td>Mengakses perangkat eksternal seperti USB dan hard disk eksternal</td>
   </tr>
    <tr>
   <td>117</td>
   <td>netdev</td>
   <td>Mengakses atau mengatur perangkat jaringan (Wi-Fi, LAN)</td>
   </tr>
   </table>
   </body>

   - Groups digunakan untuk menampilkan daftar grup yang diikuti oleh user tertentu.

   Jika dijalankan tanpa argumen (groups saja), maka akan menampilkan grup dari user yang sedang login.
   
   Jika disertai nama user (groups retnowulandari0504), maka akan menampilkan grup milik user tersebut.
<html>
<head>
<body>
   <table>
   <tr>
   <th>Nama Grup</th>
   <th>Fungsi</th>
   </tr>
   <tr>
   <td>retnowulandari0504</td>
   <td>Grup utama memiliki user (grup default dengan nama yang sama)</td>
     </tr>
   <tr>
   <td>adm</td>
   <td>Mengizinkan user membaca log sistem (administrative logs)</td>
   </tr>
   <tr>
   <td>dialout</td>
   <td>Mengizinkan akses ke perangkat serial seperti modem atau port COM</td>
   </tr>
   <tr>
   <td>cdrom</td>
   <td>Memberi izin untuk menggunakan CD/DVD drive</td>
   </tr>
   <tr>
   <td>floppy</td>
   <td>Izin megakses floppy disk (jarang digunakan sekarang)</td>
   </tr>
   <tr>
   <td>sudo</td>
   <td>Mengizinkan user menjalankan perintah dengan hak root (administator)</td>
   </tr>
   <tr>
   <td>audio</td>
   <td>Memberi izin untuk menggunakan perangkat audio(mic,speaker)</td>
   </tr>
   <tr>
   <td>dip</td>
   <td>Izin menggunakan koneksi jaringan seperti dial-up atau PPP</td>
   </tr>
   <tr>
   <td>video</td>
   <td>Izin mengakses perangkat video (misalnya GPU, kamera)</td>
   </tr>
   <tr>
   <td>plugdev</td>
   <td>Izin untuk menggunakan perangkat eksternal seperti USB atau hard disk eksternal</td>
   </tr>
   <tr>
   <td>netdev</td>
   <td>Izin mengelola perangkat jaringan (Wi-Fi, Ethernet,dsbS)</td>
   </table>
   </body>

   - Buat user baru (jika memiliki izin sudo):
     ```bash
     sudo adduser praktikan
     sudo passwd praktikan
     ```
   - Uji login ke user baru.

3. **Eksperimen 2 – Monitoring Proses**
   Jalankan:
   ```bash
   ps aux | head -10
   top -n 1
   ```
   - Jelaskan kolom penting seperti PID, USER, %CPU, %MEM, COMMAND.  
   - Simpan tangkapan layar `top` ke:
     ```
     praktikum/week4-proses-user/screenshots/top.png
     ```

4. **Eksperimen 3 – Kontrol Proses**
   - Jalankan program latar belakang:
     ```bash
     sleep 1000 &
     ps aux | grep sleep
     ```
   - Catat PID proses `sleep`.  
   - Hentikan proses:
     ```bash
     kill <PID>
     ```
   - Pastikan proses telah berhenti dengan `ps aux | grep sleep`.

5. **Eksperimen 4 – Analisis Hierarki Proses**
   Jalankan:
   ```bash
   pstree -p | head -20
   ```
   - Amati hierarki proses dan identifikasi proses induk (`init`/`systemd`).  
   - Catat hasilnya dalam laporan.

6. **Commit & Push**
   ```bash
   git add .
   git commit -m "Minggu 4 - Manajemen Proses & User"
   git push origin main
   ```

---

## D. Tugas & Quiz
### Tugas
1. Dokumentasikan hasil semua perintah dan jelaskan fungsi tiap perintah.  
2. Gambarkan hierarki proses dalam bentuk diagram pohon (`pstree`) di laporan.  
3. Jelaskan hubungan antara user management dan keamanan sistem Linux.

   Jawab :  Hubungan antara user management dan keamanan sistem linux   adalah pengelolaan pengguna yang baik menjadi kunci utama dalam menjaga keamanan sistem. User management berperan langsung dalam mencegah penyalahgunaan, menlindungi data dan menjaga stabilitas serta integritas sistem Linux  
4. Upload laporan ke repositori Git tepat waktu.

### Quiz
Tuliskan jawaban di bagian **Quiz** pada laporan:
1. Apa fungsi dari proses `init` atau `systemd` dalam sistem Linux? 

   Jawab :

   •	Menginisialisasi sistem 

   •	Menjalankan layanan

   •	Mengatur urutan boot

   •	Mengelola proses

   •	Menangani shutdown dan reboot

2. Apa perbedaan antara `kill` dan `killall`? 

   Jawab : 

   •	`kill`  digunakan untuk menghentikan proses berdasarkan PID dan lebih spesifik karena mengarah langsung ke PID tertentu

   • `killall`	 digunakan untuk menghentikan proses berdasarkan nama proses dan menghenttikan semua proses dengan nama yang cocok

3. Mengapa user `root` memiliki hak istimewa di sistem Linux?

   Jawab : Karena user root  berfungsi sebagai pengendali penuh sistem Linux — bertanggung jawab atas konfigurasi, keamanan, dan pemeliharaan sistem.

---

## E. Output yang Diharapkan
- Hasil observasi seluruh perintah dimasukkan ke dalam `laporan.md`.  
- Screenshot hasil eksekusi disimpan di folder `screenshots/`.  
- Laporan lengkap tersimpan di `laporan.md`.  
- Semua hasil telah di-*commit* ke GitHub tepat waktu.

---

## F. Referensi
1. Abraham Silberschatz, Peter Baer Galvin, Greg Gagne. *Operating System Concepts*, 10th Edition, Wiley, 2018.  
2. Andrew S. Tanenbaum, Herbert Bos. *Modern Operating Systems*, 4th Edition, Pearson, 2015.  
3. Linux Manual Pages (`man ps`, `man top`, `man kill`, `man adduser`).  
4. OSTEP – *Operating Systems: Three Easy Pieces*, 2018.  

