import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        System.out.println(losowanieLiczb(10, 5,20));
//        System.out.println(Arrays.toString(wylosujDoTablicy(20, 50, 80)));
        //wypiszTablice(wylosujDoTablicy(20,50,80));

        System.out.println(Arrays.toString(sortowaniePrzezWybor(wylosujDoTablicy(10, 60, 120))));

        int tab[] = wylosujDoTablicy(20,50,100);
        ArrayList<Integer> listaLiczbLosowych = new ArrayList<>();

        sortowaniePrzezWybor(tab);
        sortowaniePrzezWybor(listaLiczbLosowych);

        Scanner klaw = new Scanner(System.in);

        System.out.println(Arrays.toString(tab));
        System.out.println("Podaj szukana: ");

        int szukana = klaw.nextInt();
        int iSzukanejLiniowej = wyszukiwanieLiniowe(tab, szukana);
        if(iSzukanejLiniowej > -1){
            System.out.println(String.format("%d znaleziono na indeksie: %d", szukana, iSzukanejLiniowej));
        }
        else{
            System.out.println(String.format("Nie znaleziono szukanej"));
        }

        int iSzukanejBinarnie = wyszukiwanieBinarne(tab, szukana);
        if(iSzukanejBinarnie > -1){
            System.out.println(String.format("%d znaleziony na indeksie: %d", szukana, iSzukanejBinarnie));
        }
        else{
            System.out.println("No szukana, bajo jajo");
        }
    }

    private static ArrayList<Integer> losowanieLiczb(int n, int poczatek, int koniec){
        ArrayList<Integer> wylosowane = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i<n; i++){
            wylosowane.add(random.nextInt(poczatek,koniec+1));
        }
        return wylosowane;
    }
    private static int[] wylosujDoTablicy(int n, int pocz, int kon){
        int[] wylosowaneLiczby = new int[n];
        Random losowy = new Random();
        for(int i = 0; i<n; i++){
            wylosowaneLiczby[i] = losowy.nextInt(pocz,kon+1);
        }
        return wylosowaneLiczby;
    }
    private static void wypiszTablice(int[] tablicaDoWyp){
        for(int i = 0; i<tablicaDoWyp.length; i++){
            System.out.println(tablicaDoWyp[i]);
        }
    }

    // -------------------- WYSZUKIWANIE LINIOWE --------------------
    private static int wyszukiwanieLiniowe(int[] liczby, int szukana){
        for(int i = 0; i<liczby.length; i++){
            if(liczby[i] == szukana){
                return i;
            }
        }
        return -1;
    }
    private static int wyszukiwanieLiniowe(ArrayList<Integer> liczbyLista, int szukana){
        for(int i = 0; i<liczbyLista.size(); i++){
            if(liczbyLista.get(i) == szukana){
                return liczbyLista.indexOf(i);
            }
        }
        return -1;
    }

    // -------------------- SORTOWANIE PRZEZ WYBÓR --------------------
    private static int[] sortowaniePrzezWybor(int[] tabLiczby){
        int najmIndeks = 0;
        for(int i = 0; i<tabLiczby.length-1; i++){
            najmIndeks = i;
            for(int j = i+1; j<tabLiczby.length; j++){
                if(tabLiczby[j] < tabLiczby[najmIndeks]){
                    najmIndeks = j;
                }
            }
            if(najmIndeks != i){
                int temp = tabLiczby[najmIndeks];
                tabLiczby[najmIndeks] = tabLiczby[i];
                tabLiczby[i] = temp;
            }
        }
        return tabLiczby;
    }

    private static ArrayList<Integer> sortowaniePrzezWybor(ArrayList<Integer> tabLiczby){
        tabLiczby = new ArrayList<>();
        int najmIndeks = 0;
        for(int i = 0; i<tabLiczby.size()-1; i++){
            najmIndeks = i;
            for(int j = i+1; j<tabLiczby.size(); j++){
                if(tabLiczby.get(j) < tabLiczby.get(najmIndeks)){
                    najmIndeks = j;
                }
            }
            if(najmIndeks != i){
                int temp = tabLiczby.get(najmIndeks);
                tabLiczby.set(najmIndeks, tabLiczby.get(i));
                tabLiczby.set(i, temp);
            }
        }
        return tabLiczby;
    }

    // -------------------- WYSZUKIWANIE BINARNE --------------------
    private static int wyszukiwanieBinarne(int[] liczbyTablica, int szukana){
        int poczatek = 0;
        int koniec = liczbyTablica.length-1;
        int srodek = 0;

        while(poczatek <= koniec){
            srodek = (poczatek + koniec)/2;
            if(liczbyTablica[srodek] == szukana){
                return srodek;
            }
            if(liczbyTablica[srodek] < szukana){
                poczatek = srodek + 1;
            }
            else{
                koniec = srodek - 1;
            }
        }
        return -1;
    }
    private static int wyszukiwanieBinarne(ArrayList<Integer> listaL, int szukanaLiczba){
        int start = 0;
        int end = listaL.size()-1;
        int mid = 0;

        while(start <= end){
            mid = (start+end)/2;
            if(listaL.get(mid) == szukanaLiczba){
                return mid;
            }
            if(listaL.get(mid) < szukanaLiczba){
                start = mid + 1;
            }
            else if(listaL.get(mid) > szukanaLiczba){
                end = mid - 1;
            }
        }
        return -1;
    }

}
