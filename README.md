# BahasaKu

This is the source code for [my blog articles on creating dynamic language for Java Virtual Machine](https://thesolidsnake.wordpress.com/2013/11/27/menciptakan-bahasa-dinamis-di-java-part-1-membuat-front-end-dengan-antlr/).

BahasaKu adalah sebuah bahasa pemograman dinamis untuk JVM yang dibuat sebagai latihan di [artikel blog saya](https://thesolidsnake.wordpress.com/2013/11/27/menciptakan-bahasa-dinamis-di-java-part-1-membuat-front-end-dengan-antlr/).

## Cara Menjalankan

Proyek ini dilengkapi dengan Gradle wrapper.  Gunakan `gradlew.bat` di platform Windows atau `gradlew` untuk platform lainnya.

Untuk menghasilkan file instalasi, gunakan perintah:

    gradlew.bat installApp

Perintah di atas akan membuat file baru di `build\install\BahasaKu`.  Untuk menjalankan compiler, gunakan file `build\install\BahasaKu\bin\Bahasaku.bat`.

Untuk membuat compiler mengerjakan sebuah file berisi kode program BahasaKu, gunakan perintah berikut ini:

    gradlew.bat run

Lokasi file yang berisi kode program BahasaKu ditentukan oleh nilai variabel `sourceForRun` di file `build.gradle`.  Secara bawaan, ia akan mengerjakan kode program di `src/test/resources/Latihan.baku`.

## Contoh Kode Program BahasaKu

    a <- 10
    b <- 20
    c <- a + b
    tampilkan c
    tampilkan c * 2 + a * 2 - b * 2
    nama <- 'Solid Snake'
    tampilkan nama
    a <- iya
    tampilkan a
    b <- tidak
    tampilkan b
    acak <- buat java.util.Random()
    tampilkan acak.nextInt()
    f <- buat javax.swing.JFrame()
    f#setSize(100,100)#setDefaultCloseOperation(3)#setVisible(iya)

## Informasi Lebih Lanjut

Kunjungi [http://thesolidsnake.wordpress.com](http://thesolidsnake.wordpress.com).
