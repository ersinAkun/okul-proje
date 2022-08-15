package okul_temel_gereksinimler;

import java.util.*;

public class Ogretmen {
    static Scanner scan = new Scanner(System.in);
    static Map<String, String> ogretmenlerMap = new HashMap<>();

    public static void feykOgretmenEkle() {
        ogretmenlerMap.put("11111111111", "Ali, Can, 1980, Matematik");
        ogretmenlerMap.put("22222222222", "Veli, Yan, 1981, Fizik");
        ogretmenlerMap.put("33333333333", "Ayse, Can, 1982, Kimya");
        ogretmenlerMap.put("44444444444", "Can, Can, 1983, Kimya");
        ogretmenlerMap.put("55555555555", "Alp, Yan, 1984, Matematik");
    }

    public static void ogretmenMenu() throws InterruptedException {
        String tercih = "";
        do {
            System.out.println("=============YILDIZ KOLEJI=============\n" +
                    "===============ANA MENU================\n" +
                    "\n" +
                    "\t  1- Ogretmenler Listesi Yazdir\n" +
                    "\t  2- Soyisimden Ogretmen Bulma\n" +
                    "\t  3- Branstan Ogretmen Bulma \n" +
                    "\t  4- Bilgilerini Girerek Ogretmen Ekleme\n" +
                    "\t  5- Kimlik No Ile Kayit Silme \n" +
                    "\t  A- ANA MENU \n" +
                    "\t  Q- Cikis\n");
            tercih = scan.nextLine();

            switch (tercih){
                case "1" :  //Ogretmenler Listesi Yazdir
                    ogretmenListesiYazdir();
                    break;
                case "2" : // soyisimden ogretmen bulma
                    soyIsimdenOgretmenBulma();
                    break;
                case "3" :  // branstan ogretmen bulma
                    branstanOgretmenBulma();
                    break;
                case "4" :  //bilgilerini girerek ogretmen ekleme
                    ogretmenEkleme();
                    break;
                case "5" :  // kimlik no ile kayit silme
                    tcNoIleOgretmenSil();
                    break;
                case "A" :
                case "a" :
                    Depo.anaMenu();
                    break;
                case "Q" :
                case "q" :
                    break;
                default:
                    System.out.println("Lutfen gecerli tercih yapiniz");

            }

        } while (!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();

    }

    public static void tcNoIleOgretmenSil() {
        System.out.println("Silinecek ogretmen kimlik no giriniz");
        String silinecekOgretmen=scan.nextLine();
        String silinecekValue=ogretmenlerMap.get(silinecekOgretmen);


        String sonucValue = ogretmenlerMap.remove(silinecekOgretmen);
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz TC numarasi ilee ogretmen bulunamadi");
        }
    }

    public static void ogretmenEkleme() {
        System.out.println("TC no");
        String tcNo=scan.nextLine();
        System.out.println("isim");
        String isim = scan.nextLine();
        System.out.println("soyisim");
        String soyisim = scan.nextLine();
        System.out.println("Dogum yili");
        String dYili = scan.nextLine();
        System.out.println("Brans");
        String brans = scan.nextLine();

        String eklenecekValue = isim+", "+soyisim+", "+dYili+", "+brans;
        ogretmenlerMap.put(tcNo,eklenecekValue);

    }

    public static void branstanOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz Ogretmenin bransini giriniz");
        String istenenSoyisim = scan.nextLine();
        Set<Map.Entry<String,String>> ogretmenEntrySet=ogretmenlerMap.entrySet();
        System.out.println("=============YILDIZ KOLEJI=============\n" +
                "==============BRANS ILE OGRETMEN ARAMA==============\n"+
                "TC No       Isim   Soyisim   D.yili  Brans");
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String eachValuarr[]=eachValue.split(", ");
            if (istenenSoyisim.equalsIgnoreCase(eachValuarr[3])){

                System.out.printf("%11s  %-6s %-8s %4s   %s\n",eachKey,eachValuarr[0],eachValuarr[1],
                        eachValuarr[2],eachValuarr[3]);
            }
        }
        Thread.sleep(5000);

    }

    public static void soyIsimdenOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz Ogretmenin soyismini giriniz");
        String istenenSoyisim = scan.nextLine();
        Set<Map.Entry<String,String>> ogretmenEntrySet=ogretmenlerMap.entrySet();
        System.out.println("=============YILDIZ KOLEJI=============\n" +
                "=============SOYISIM ILE OGRETMEN ARAMA==============\n"+
                "TC No       Isim   Soyisim   D.yili  Brans");
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String eachValuarr[]=eachValue.split(", ");
            if (istenenSoyisim.equalsIgnoreCase(eachValuarr[1])){

                System.out.printf("%11s  %-6s %-8s %4s   %s\n",eachKey,eachValuarr[0],eachValuarr[1],
                        eachValuarr[2],eachValuarr[3]);
            }
        }
        Thread.sleep(5000);

    }

    public static void ogretmenListesiYazdir() throws InterruptedException {

        Set<Map.Entry<String,String>> ogretmenEntrySet=ogretmenlerMap.entrySet();
        System.out.println("=============YILDIZ KOLEJI=============\n" +
                "==============OGRETMEN LISTESI================\n"+
                "TC No       Isim   Soyisim   D.yili  Brans");
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuarr[]=eachValue.split(", ");
            System.out.printf("%11s  %-6s %-8s %4s   %s\n",eachKey,eachValuarr[0],eachValuarr[1],
                    eachValuarr[2],eachValuarr[3]);
        }
            Thread.sleep(5000);
    }
}
