package okul_temel_gereksinimler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogrenci {

    static Map<String, String> ogrenciMap = new HashMap<>();
    static Scanner scan = new Scanner(System.in);

    public static void feykOgrenciEkle() {
        ogrenciMap.put("11111111111", "Ali, Can, 2008, 3569, 12, A");
        ogrenciMap.put("22222222222", "Veli, Yan, 2008, 3559, 12, B");
        ogrenciMap.put("33333333333", "Ayse, Can, 2007, 4569, 12, A");
        ogrenciMap.put("44444444444", "Ali, San, 2009, 1569, 11, A");
        ogrenciMap.put("55555555555", "Alp, Yan, 2009, 3769, 11, A");

    }

    public static void ogrenciMenu() throws InterruptedException {
        String tercih = "";
        do {


            System.out.println("=============YILDIZ KOLEJI=============\n" +
                    "=============OGRENCI MENU==============\n" +
                    "\n" +
                    "\t  1- Ogrenci Listesi Yazdir\n" +
                    "\t  2- Soyisimden Ogrenci Bulma\n" +
                    "\t  3- Sinif ve Sube ile Ogrenci Bulma \n" +
                    "\t  4- Bilgilerini Girerek Ogrenci Ekleme\n" +
                    "\t  5- Kimlik No Ile Kayit Silme \n" +
                    "\t  A- ANA MENU \n" +
                    "\t  Q- Cikis\n");
            tercih = scan.nextLine();
            switch (tercih) {
                case "1":  // ogrenci listesi yazdir
                    ogrenciListeYazdir();
                    break;
                case "2":  // soyisimden ogrenci bulma
                    soyIsimdenOgrenciBulma();
                    break;
                case "3":  //Sinif ve Sube ile Ogrenci Bulma
                    sinifVeSubeIleOgrenciBulma();
                    break;
                case "4": //Bilgilerini Girerek Ogrenci Ekleme
                    ogrenciEkle();
                    break;
                case "5":
                    tcNoIleOgrenciSilme();
                    break;
                case "a":
                case "A":
                    Depo.anaMenu();
                    break;
                case "q":
                case "Q":
                    Depo.projeDurdur();
                    break;
                default:
                    System.out.println("Lutfen gecerli bir tercih giriniz");

            }

        } while (!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();
    }

    public static void tcNoIleOgrenciSilme() {

        System.out.println("Silinecek ogrenci kimlik no giriniz");
        String silinecekOgrenci = scan.nextLine();
        String silinecekValue = ogrenciMap.get(silinecekOgrenci);


        String sonucValue = ogrenciMap.remove(silinecekOgrenci);
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz TC numarasi ile ogrenci bulunamadi");
        }
    }

    public static void ogrenciEkle() {
        System.out.println("Tc no");
        String tcNo = scan.nextLine();
        System.out.println("isim");
        String isim = scan.nextLine();
        System.out.println("soyisim");
        String soyisim = scan.nextLine();
        System.out.println("Dogum yili");
        String dogumYili = scan.nextLine();
        System.out.println("okul no");
        String okulNo = scan.nextLine();
        System.out.println("sinif");
        String sinif = scan.nextLine();
        System.out.println("sube ");
        String sube = scan.nextLine();

         //String key = tcNo;
        String value = isim + ", " + soyisim + ", " + dogumYili + ", " + okulNo + ", "
                + sinif + ", " + sube;
        ogrenciMap.put(tcNo, value);

    }

    public static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {

        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();

        System.out.println("Istediginiz ogrenci sinifini yaziniz");
        String istenilenSinif = scan.nextLine();
        System.out.println("Istediginiz ogrenci subesini yaziniz");
        String istenilenSube = scan.nextLine();

        System.out.println("=============YILDIZ KOLEJI=============\n" +
                "=============OGRENCI LISTESI============\n");
        System.out.println("  TC No      Isim   Soyisim   D.Yili OkulNo  Sinif Sube");
        for (Map.Entry<String, String> each : myEntrySet) {

            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            if (istenilenSinif.equalsIgnoreCase(eachValueArr[4]) && istenilenSube.equalsIgnoreCase(eachValueArr[5])) {
                System.out.printf("%-12s  %-6s  %-8s %-6s %-8s %-4s %-3s\n", eachKey, eachValueArr[0], eachValueArr[1], eachValueArr[2], eachValueArr[3],
                        eachValueArr[4], eachValueArr[5]);
            }
        }
        Thread.sleep(5000);
    }

    private static void soyIsimdenOgrenciBulma() throws InterruptedException {

        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();

        System.out.println("Istediginiz ogrenci soyismini yaziniz");
        String istenilenSoyisim = scan.nextLine();

        System.out.println("=============YILDIZ KOLEJI=============\n" +
                "=============OGRENCI LISTESI============\n");
        System.out.println("  TC No      Isim   Soyisim   D.Yili OkulNo  Sinif Sube");
        for (Map.Entry<String, String> each : myEntrySet) {

            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            if (istenilenSoyisim.equalsIgnoreCase(eachValueArr[1])) {
                System.out.printf("%-12s  %-6s  %-8s %-6s %-8s %-4s %-3s\n", eachKey, eachValueArr[0], eachValueArr[1], eachValueArr[2], eachValueArr[3],
                        eachValueArr[4], eachValueArr[5]);
            }
        }
        Thread.sleep(5000);

    }

    public static void ogrenciListeYazdir() throws InterruptedException {

        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();

        System.out.println("=============YILDIZ KOLEJI=============\n" +
                "=============OGRENCI LISTESI============\n" +
                "  TC No      Isim   Soyisim   D.Yili OkulNo  Sinif Sube");
        for (Map.Entry<String, String> each : myEntrySet) {

            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            System.out.printf("%-12s  %-6s  %-8s %-6s %-8s %-4s %-3s\n", eachKey, eachValueArr[0], eachValueArr[1], eachValueArr[2], eachValueArr[3],
                    eachValueArr[4], eachValueArr[5]);
        }
        Thread.sleep(5000);
    }

}
