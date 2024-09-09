# 🚀 Fibonacci Dizisi - Java ile Sonsuz Matematik Yolculuğu! 🌟

**Fibonacci** serisini merak ediyor musunuz? Her sayının kendinden önceki iki sayının toplamı olduğu bu eşsiz matematik dizisini **Java** diliyle birlikte keşfetmeye hazır olun! 🔢

## 📚 Fibonacci Nedir?

Fibonacci serisi, her bir sayının kendisinden önceki iki sayının toplamı olduğu bir sayı dizisidir. Doğada sıkça karşılaşılan bu seri, matematiğin en güzel örneklerinden biridir! Serinin ilk birkaç sayısı şöyledir:


## 🔧 Ön Gereksinimler

- Java Development Kit (JDK) 8 veya üzeri
- Bir Java IDE (Eclipse, IntelliJ IDEA, vb.) veya terminal
  
 ## 🛠️ **Kullanım Talimatları**
##**Kurulum**

1. **Bu projeyi bilgisayarınıza klonlayın:**
    ```sh
       git clone https://github.com/bushra581/Fibonacci-Series.git

3. **Proje dizinine gidin:**
      ```bash
      cd Fibonacci-Series

4. **Projeyi derleyin ve çalıştırın:**
      ```bash
      javac Fibonacci.java
      java Fibonacci
      
 ## 🔍 Örnek Çıktı
Programı çalıştırdığınızda, kullanıcıdan terim sayısını girmenizi isteyecek ve örneğin 10 terimlik Fibonacci serisini şöyle gösterecek:

Fibonacci serisi için terim sayısını giriniz;10
ilk 10 Fibonacci sayısı: 0 1 1 2 3 5 8 13 21 34

 ## 💻Kod
Aşağıdaki Java kodu, Fibonacci serisini hesaplamak için kullanılan basit bir uygulamayı içerir:

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fibonacci serisi için terim sayısını giriniz: ");
        int n = scanner.nextInt();
        int[] fib_series = new int[n];

        if (n > 0) fib_series[0] = 0;
        if (n > 1) fib_series[1] = 1;

        for (int i = 2; i < n; i++) {
            fib_series[i] = fib_series[i - 1] + fib_series[i - 2];
        }

        System.out.print("İlk " + n + " Fibonacci sayısı: ");
        for (int num : fib_series) {
            System.out.print(num + " ");
        }
    }
}


 ## 📝Katkıda Bulunuma
Her türlü katkıya açığız! Pull request'lerinizi bekliyoruz. 🤝

 ## 📄Lisans
Bu proje MIT Lisansı altında lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasına bakın.

 ## 📬İletişim
Eğer herhangi bir sorunuz varsa, lütfen bana şu e-posta adresinden ulaşın:(kurtbusra956@gmail.com)
 

