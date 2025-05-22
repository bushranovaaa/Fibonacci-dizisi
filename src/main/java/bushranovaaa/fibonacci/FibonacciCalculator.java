import java.util.InputMismatchException; // Bu satır, Java'nın "InputMismatchException" adında özel bir hatayı kullanmamızı sağlar.
                                        // Bu hata, kullanıcıdan sayı beklerken harf veya yanlış bir şey girerse ortaya çıkar.
import java.util.Scanner;             // Bu satır, Java'nın "Scanner" sınıfını kullanmamızı sağlar.
                                        // "Scanner" sınıfı, klavyeden veya başka bir yerden girdi (veri) almak için kullanılır.
                                        // Yani, kullanıcının yazdığı sayıyı okuyabilmek için buna ihtiyacımız var.

/**
 * Bu kısım, kod hakkında genel bilgi veren bir yorum bloğudur.
 * Genellikle kodun ne işe yaradığını, kimin yazdığını vb. bilgileri içerir.
 *
 * Bu sınıf (yani bu dosyadaki ana yapı), kullanıcının belirlediği terim sayısına göre Fibonacci dizisini hesaplar
 * ve sonuçları ekrana yazdırır.
 *
 * Fibonacci dizisi, her sayının kendisinden önceki iki sayının toplamı olduğu özel bir sayı dizisidir.
 * Örneğin, 0 ve 1 ile başlarsak:
 * 0 (ilk sayı)
 * 1 (ikinci sayı)
 * 0 + 1 = 1 (üçüncü sayı)
 * 1 + 1 = 2 (dördüncü sayı)
 * 1 + 2 = 3 (beşinci sayı)
 * ... ve bu böyle devam eder.
 */
public class Fibonacci { // Bu, Java'daki ana sınıfımızın adıdır. Dosya adıyla aynı olmalı (Fibonacci.java).
                          // "public" demek, bu sınıfın her yerden erişilebilir olduğu anlamına gelir.
                          // "class" ise, Java'da kodumuzu düzenlediğimiz ana yapıdır.

    // Bu, Java programlarının başlangıç noktasıdır. Program çalıştığında ilk olarak buradaki kodlar çalışır.
    // "public" her yerden erişilebilir demek.
    // "static" demek, bu metoda (fonksiyona) sınıfın bir nesnesini oluşturmadan doğrudan erişebiliriz demek.
    // "void" demek, bu metodun herhangi bir değer geri döndürmediği anlamına gelir.
    // "main" metodun adıdır, Java programları buradan başlar.
    // "(String[] args)" ise, programa dışarıdan argümanlar (bilgiler) gönderebileceğimizi belirtir,
    // şu an için çok önemli değil.
    public static void main(String[] args) {
        // Kullanıcıdan girdi almak için bir "Scanner" nesnesi oluşturuyoruz.
        // "new Scanner(System.in)" demek, klavyeden (System.in) girdi alacak yeni bir "Scanner" oluştur demek.
        Scanner inputScanner = new Scanner(System.in);
        int numberOfTerms; // Kullanıcının girmek istediği Fibonacci terim sayısını tutacak bir değişken tanımlıyoruz.
                           // "int" demek, bu değişkenin tam sayı (örneğin 5, 10, 100 gibi) tutacağı anlamına gelir.

        // Kullanıcıya hoş geldin mesajı ve programın ne işe yaradığını anlatıyoruz.
        // "System.out.println()" ekrana bir şeyler yazdırır ve sonra alt satıra geçer.
        System.out.println("Merhaba! Fibonacci Serisi hesaplayıcıya hoş geldin.");
        System.out.println("--------------------------------------------------");

        // Bu bir "sonsuz döngü"dür ("while(true)").
        // Kullanıcıdan geçerli bir sayı alana kadar bu döngü tekrar tekrar çalışacak.
        // Geçerli bir sayı girildiğinde, "break;" komutu ile döngüden çıkacağız.
        while (true) {
            try { // "try" bloğu, hata oluşabilecek kodları buraya yazarız.
                  // Eğer bu kodlar çalışırken bir hata (exception) olursa, program çökmez,
                  // bunun yerine "catch" bloğuna gider.

                // Kullanıcıdan kaç terim istediğini soruyoruz.
                // "System.out.print()" ekrana bir şeyler yazdırır ama alt satıra geçmez.
                System.out.print("Kaç terimlik Fibonacci serisi istersiniz? (Pozitif bir tam sayı girin): ");
                numberOfTerms = inputScanner.nextInt(); // Kullanıcının klavyeden girdiği bir sonraki tam sayıyı oku
                                                        // ve bunu "numberOfTerms" değişkenine ata.

                // Kullanıcının girdiği sayının pozitif olup olmadığını kontrol ediyoruz.
                // Eğer sayı 0 veya daha küçükse (negatifse)...
                if (numberOfTerms <= 0) {
                    System.out.println("Hata: Lütfen pozitif bir tam sayı girin."); // Hata mesajı göster.
                } else {
                    // Eğer sayı pozitif ve geçerliyse, döngüden çık.
                    break;
                }
            } catch (InputMismatchException e) { // "catch" bloğu, "try" bloğunda belirli bir hata (burada InputMismatchException)
                                                 // oluştuğunda çalışır. "e" ise oluşan hatanın detaylarını tutan bir değişkendir.
                // Kullanıcı sayı yerine harf veya başka bir karakter girerse bu blok çalışır.
                System.out.println("Hata: Geçersiz giriş! Lütfen bir tam sayı girin.");
                inputScanner.next(); // Bu çok önemli! Eğer kullanıcı yanlış bir şey girerse, o yanlış girdi "Scanner"da kalır.
                                     // "inputScanner.next()" diyerek o yanlış girdiyi tüketip atıyoruz,
                                     // böylece döngü tekrar başladığında aynı yanlış girdiyi tekrar okumaya çalışmaz
                                     // ve sonsuz döngüye girmez.
            }
        }

        // Kullanıcıdan geçerli bir terim sayısı aldıktan sonra,
        // Fibonacci serisini hesaplayıp ekrana yazdıracak metodu çağırıyoruz.
        // "FibonacciCalculator.printFibonacciSeries(numberOfTerms)" demek,
        // "FibonacciCalculator" sınıfındaki "printFibonacciSeries" metodunu çağır ve
        // ona "numberOfTerms" değerini gönder demek.
        // (Bu metod, daha önce verdiğim FibonacciCalculator.java dosyasının içinde yer alıyor.)
        System.out.print("Fibonacci Serisi (" + numberOfTerms + " terim): ");
        com.bushranovaaa.fibonacci.FibonacciCalculator.printFibonacciSeries(numberOfTerms); // Tam yolu belirttim, çünkü bu sınıf farklı bir dosyada.

        // "Scanner" nesnesini kapatıyoruz. Bu, bilgisayar kaynaklarını düzgün bir şekilde serbest bırakmak için iyi bir alışkanlıktır.
        inputScanner.close();
        System.out.println("\n--------------------------------------------------"); // Bir boş satır ve ayırıcı çizgi
        System.out.println("Hesaplama tamamlandı. Güle güle!"); // Programın bittiğini belirten mesaj
    }
}
