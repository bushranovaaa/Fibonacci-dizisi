import java.util.InputMismatchException; // Kullanıcıdan beklenen türde girdi alınamaması durumunda fırlatılan hata için.
import java.util.Scanner;             // Kullanıcıdan klavye girdisi almak için kullanılır.

import com.bushranovaaa.fibonacci.FibonacciCalculator; // Fibonacci hesaplama mantığını içeren sınıfı içeri aktarırız.

/**
 * Bu sınıf, kullanıcının belirlediği terim sayısına göre Fibonacci dizisini hesaplayan ana uygulamadır.
 * Kullanıcıdan girdi alır, hesaplama görevini FibonacciCalculator sınıfına devreder ve sonuçları ekrana yazdırır.
 *
 * Fibonacci dizisi: Her sayının kendisinden önceki iki sayının toplamı olduğu bir matematiksel dizidir (örn: 0, 1, 1, 2, 3, ...).
 */
public class Fibonacci {

    /**
     * Java programının başlangıç noktasıdır. Program çalıştığında ilk olarak bu metod çalışır.
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in); // Kullanıcı girdisi için Scanner nesnesi oluşturulur.
        int numberOfTerms; // Kullanıcının girmek istediği Fibonacci terim sayısını tutacak değişken.

        System.out.println("Merhaba! Fibonacci Serisi hesaplayıcıya hoş geldin.");
        System.out.println("--------------------------------------------------");

        // Kullanıcıdan geçerli (pozitif bir tam sayı) bir terim sayısı alana kadar döngüyü devam ettirir.
        while (true) {
            try {
                System.out.print("Kaç terimlik Fibonacci serisi istersiniz? (Pozitif bir tam sayı girin): ");
                numberOfTerms = inputScanner.nextInt(); // Kullanıcının girdisini oku.

                // Girdinin pozitif olup olmadığını kontrol et.
                if (numberOfTerms <= 0) {
                    System.out.println("Hata: Lütfen pozitif bir tam sayı girin.");
                } else {
                    // Geçerli bir sayı girildiğinde döngüden çık.
                    break;
                }
            } catch (InputMismatchException e) {
                // Kullanıcı sayı yerine geçersiz bir karakter (harf vb.) girerse hatayı yakalar.
                System.out.println("Hata: Geçersiz giriş! Lütfen bir tam sayı girin.");
                inputScanner.next(); // Hatalı girdiyi temizle, aksi takdirde sonsuz döngüye girer.
            }
        }

        // Kullanıcıdan alınan terim sayısına göre Fibonacci dizisini hesapla ve yazdır.
        // Hesaplama görevi FibonacciCalculator sınıfındaki printFibonacciSeries metoduna devredilir.
        System.out.print("Fibonacci Serisi (" + numberOfTerms + " terim): ");
        FibonacciCalculator.printFibonacciSeries(numberOfTerms);

        inputScanner.close(); // Scanner nesnesini kapat, kaynak sızıntısını önle.
        System.out.println("\n--------------------------------------------------");
        System.out.println("Hesaplama tamamlandı. Güle güle!");
    }
}