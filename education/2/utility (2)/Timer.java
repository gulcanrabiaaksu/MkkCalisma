package com.mkk.ugd.utility;


// kaynak: http://hrzafer.com/java-ile-gecen-surenin-olculmesi 

/**
 * Kronometre vazifesi gören bu sınıf geçen süreyi nanosaniye, milisaniye ya da saniye cinsinden hesaplar.
 * @author hrzafer
 */
public class Timer 
{
 
    private static long start;
    private static long end;
    private static boolean started;
 
    /**
     * Kronometre durmuş vaziyette mi ?
     */
    private static boolean isStopped() {
        return !started;
    }
 
    /**
     * Kronometre başlamış vaziyette mi ?
     * @return 
     */
    private static boolean isStarted() {
        return started;
    }
 
    /**
     * Kronometreyi başlatır. Eğer zaten başlamış durumda ise RunTimeException hatası fırlatır.
     */
    public static void start() {
        if (isStopped()) {
            startTimer();
        } else {
            throw new RuntimeException("Hata: Kronometre (Timer) zaten başlatılmış durumda!!!\n");
        }
    }
 
    private static void startTimer() {
        start = System.nanoTime();
        started = true;
    }
 
    /**
     * Kronometreyi durdurur.  Eğer zaten başlamış durumda ise RunTimeException hatası fırlatır.
     */
    public static void stop() {
        if (isStarted()) {
            stopTimer();
        } else {
            throw new RuntimeException("Hata: Kronometre (Timer) başlatılamadı!!!\n");
        }
    }
 
    private static void stopTimer() {
        end = System.nanoTime();
        started = false;
    }
 
    /**
     * Timer.start() ile Timer.stop() arasında geçen süreyi nanosaniye olarak döndürür.
     */
    public static long getElapsedTime() {
        if (isStopped()) {
            return end - start;
        } else {
            throw new RuntimeException("Hata: Kronometre (Timer) durdurulmad�!!!\n");
        }
 
    }
 
    /**
     * Timer.start() ile Timer.stop() arasında geçen süreyi milisaniye cinsinden döndürür.
     */
    public static double getElapsedMilliseconds() {
        double seconds = (double) getElapsedTime() / 1000000.0;
        return seconds;
    }
 
    /**
     * Timer.start() ile Timer.stop() arasında geçen süreyi saniye cinsinden döndürür.
     */
    public static double getElapsedSeconds() {
        double seconds = (double) getElapsedTime() / 1000000000.0;
        return seconds;
    }  
}
