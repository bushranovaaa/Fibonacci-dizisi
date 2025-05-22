package com.bushranovaaa.fibonacci; // Test sınıfının da aynı pakette olması önemlidir

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * FibonacciCalculator sınıfının metotlarını test eden birim test sınıfı.
 * Bu testler, Fibonacci serisi hesaplama mantığının doğru çalıştığından emin olmak için yazılmıştır.
 */
public class FibonacciCalculatorTest {

    // Konsol çıktısını yakalamak için kullanılacak stream'ler
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Her test metodundan önce çalışacak setup metodu.
     * Konsol çıktısını yakalamak için System.out'u yönlendirir.
     */
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Her test metodundan sonra çalışacak teardown metodu.
     * System.out'u orijinal haline geri getirir ve yakalanan çıktıyı temizler.
     */
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset(); // Yakalanan çıktıyı bir sonraki test için temizle
    }

    /**
     * n=1 için Fibonacci serisinin doğru çıktısını kontrol eder (sadece 0).
     */
    @Test
    @DisplayName("1 terim için Fibonacci serisi testi")
    void testFibonacciForOneTerm() {
        FibonacciCalculator.printFibonacciSeries(1);
        // trim() metodu, çıktıdaki baştaki/sondaki boşlukları kaldırır
        assertEquals("0", outContent.toString().trim(), "1 terim için çıktı '0' olmalı.");
    }

    /**
     * n=2 için Fibonacci serisinin doğru çıktısını kontrol eder (0 1).
     */
    @Test
    @DisplayName("2 terim için Fibonacci serisi testi")
    void testFibonacciForTwoTerms() {
        FibonacciCalculator.printFibonacciSeries(2);
        assertEquals("0 1", outContent.toString().trim(), "2 terim için çıktı '0 1' olmalı.");
    }

    /**
     * n=5 için Fibonacci serisinin doğru çıktısını kontrol eder (0 1 1 2 3).
     */
    @Test
    @DisplayName("5 terim için Fibonacci serisi testi")
    void testFibonacciForFiveTerms() {
        FibonacciCalculator.printFibonacciSeries(5);
        assertEquals("0 1 1 2 3", outContent.toString().trim(), "5 terim için çıktı '0 1 1 2 3' olmalı.");
    }

    /**
     * n=10 için Fibonacci serisinin doğru çıktısını kontrol eder (0 1 1 2 3 5 8 13 21 34).
     */
    @Test
    @DisplayName("10 terim için Fibonacci serisi testi")
    void testFibonacciForTenTerms() {
        FibonacciCalculator.printFibonacciSeries(10);
        assertEquals("0 1 1 2 3 5 8 13 21 34", outContent.toString().trim(), "10 terim için çıktı '0 1 1 2 3 5 8 13 21 34' olmalı.");
    }

    /**
     * n=0 veya negatif bir sayı için (geçersiz giriş) test.
     * printFibonacciSeries metodu pozitif sayılar için tasarlandığından,
     * bu testler genellikle ana uygulama katmanında (Fibonacci.java'daki gibi)
     * giriş doğrulaması yapıldığında daha anlamlı olur.
     * Ancak burada, metodun bu tür girişlerde ne yaptığını görmek için bir örnek.
     * Mevcut implementasyonda 0 veya negatif girildiğinde çıktı boş olacaktır.
     */
    @Test
    @DisplayName("0 terim için Fibonacci serisi testi (boş çıktı bekleriz)")
    void testFibonacciForZeroTerms() {
        FibonacciCalculator.printFibonacciSeries(0);
        assertEquals("", outContent.toString().trim(), "0 terim için çıktı boş olmalı.");
    }

    @Test
    @DisplayName("Negatif terim için Fibonacci serisi testi (boş çıktı bekleriz)")
    void testFibonacciForNegativeTerms() {
        FibonacciCalculator.printFibonacciSeries(-5);
        assertEquals("", outContent.toString().trim(), "Negatif terim için çıktı boş olmalı.");
    }
}