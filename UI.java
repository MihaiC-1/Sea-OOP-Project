import java.util.Scanner;

public class UI {
    public static void meniu_1()           // Afisarea primului meniu
    {
        System.out.println("\t 1.Citire date din fisier.");
        System.out.println("\t 2.Citire date de la tastatura.");
    }

    public static void meniu_2()            // Afisarea Meniului pentru citirea de la tastatura
    {
        System.out.println("\t\t 1.Citire date despre o noua mare.");
        System.out.println("\t\t 2.Afisare tabel in ordine alfabetica.");
        System.out.println("\t\t 3.Afisare tabel in ordine descrescatoare dupa aria suprafetei.");
        System.out.println("\t\t 4.Exit.");
    }

    public static void meniu_3()              // afisarea meniului pentru citirea din fisier
    {
        System.out.println("\t\t 1.Afisare tabel in ordine alfabetica.");
        System.out.println("\t\t 2.Afisare tabel in ordine descrescatoare dupa aria suprafetei.");
        System.out.println("\t\t 3.Exit.");
    }

    public static int citire_optiune()            // citirea unui numar intreg de la tastatura
    {
        System.out.print("Scrieti optiune dorita : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void main(String[] args)
    {
        int optiune;

        meniu_1();                         // afisarea primului meniu si nu se mai poate ajunge la acesta
        optiune = citire_optiune();            // citirea de optiune din primul meniu

        switch (optiune)
        {
            case 1:                                     // prelucrarea listei pentru citirea din fisier
                RepoFile repo_f = new RepoFile();
                repo_f.citire_fisier();

                Repo repoo = new Repo(repo_f.get_mari());
                while (true)
                {                                  // prelucrarea optiunilor meniului cu citire din fisier
                    meniu_3();

                    optiune = citire_optiune();

                    if (optiune == 1)
                        repoo.alfabetic();
                    else if (optiune == 2)
                        repoo.descrescator();
                    else
                        break;
                }
                break;
            case 2:
                Repo repo = new Repo();                 // prelucrarea listei pentru citirea de la tastatura
                while (true)
                {
                    meniu_2();                       // meniul pentru citirea de la tastatura

                    optiune = citire_optiune();
                                                        // prelucrarea optiunilor
                    if (optiune == 1)
                        repo.citire();
                    else if (optiune == 2)
                        repo.alfabetic();
                    else if (optiune == 3)
                        repo.descrescator();
                    else if (optiune == 4)
                        break;
                    else
                        System.out.println("Optiunea scrisa nu exista.");
                }
                break;
            default:
                System.out.println("La revedere!!");         // terminare de program
                break;
        }


    }


}
