package com.javagda25.comparator.zadanie2;

// Stwórz klasę OfertaSprzedaży(String nazwaProduktu, double cena) a następnie stwórz komparator który
// sortuje OfertySprzedaży po cenie rosnąco lub malejąco. Wskazówka : dodaj do klasy komparatora dodatkowe
// pole (np. typu boolean) które w zależności od wartości inaczej sortuje obiekty.
//
// W mainie stwórz kilka instancji klasy OfertaSprzedaży i dodaj je do Listy. Po dodaniu posortuj listę i na
// ekran wypisz  wynik przed sortowaniem, oraz po sortowaniu. Spróbuj również sortowania 'w drugą stronę'.
//
// *Stwórz parser komend. Pozwól użytkownikowi w konsoli kontrolować aplikację. Parser powinien obsługiwać komendy:
// dodaj mleko 2.3
// listuj
// sortuj rosnaco (komenda nie listuje, tylko sortuje)
// sortuj malejaco (komenda nie listuje, tylko sortuje)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<OfertaSprzedazy> ofertaSprzedazies = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        ofertaSprzedazies.add(new OfertaSprzedazy("Acer", 2391.40));
        ofertaSprzedazies.add(new OfertaSprzedazy("Asus", 3321.59));
        ofertaSprzedazies.add(new OfertaSprzedazy("Lenovo", 1500.45));
        ofertaSprzedazies.add(new OfertaSprzedazy("HP", 2998.40));

//        Collections.sort(ofertaSprzedazies, new OfertaSprzedazyComparator(false));
//        Collections.sort(ofertaSprzedazies, new OfertaSprzedazyComparator(true));
//        System.out.println(ofertaSprzedazies);

        String komenda;
        do {
            System.out.println("Wybierz dostępną opcję: " + Arrays.toString(Komendy.values()));
            System.out.println("Aby wyjść z programu wpisz QUIT.");
            komenda = scanner.next();
            if (komenda.equalsIgnoreCase("quit")) {
                break;
            }

            try {
                Komendy komendy = Komendy.valueOf(komenda.toUpperCase());

                switch (komendy) {
                    case MLEKO_2_3:
                        ofertaSprzedazies.add(new OfertaSprzedazy("Mleko 2.3", 3.5));
                        break;
                    case LISTUJ:
                        System.out.println(ofertaSprzedazies);
                        break;
                    case SORTUJ_ROSNACO:
                        Collections.sort(ofertaSprzedazies, new OfertaSprzedazyComparator(true));
                        break;
                    case SORTUJ_MALEJACO:
                        Collections.sort(ofertaSprzedazies, new OfertaSprzedazyComparator(false));
                        break;
                    default:
                        continue;
                }

            } catch (IllegalArgumentException e) {
                System.err.println("Błąd. Nie ma takiego wyboru.");
                continue;
            }

        }
        while (!komenda.equals("quit"));
    }
}
