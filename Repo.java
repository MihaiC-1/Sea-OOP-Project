import java.util.Scanner;

public class Repo {
    private Service serv;

    public Repo() {
        this.serv = new Service();
    }       // constructorul default

    public Repo(Mare[] mari)
    {
        this.serv = new Service(mari);
    }     // constructorul cu parametru

    private String citire_string()
    {
        Scanner scn = new Scanner(System.in);            // citirea unei linii de la tastatura
        return scn.nextLine();
    }

    private long citire_long()
    {
        Scanner scn = new Scanner(System.in);             // citirea unui numar Long de la tastatura
        return scn.nextLong();
    }

    public void citire()
    {
        String nume;
        long arie;

        System.out.println("Introduce-ti numele si aria suprafetei marilor sau Stop si -1 pentru a va oprii.");
        while (true)                  // se citesc Obiecte de tip mare si se salveaza in lista pana se intra
        {                               // pe conditia cu break
            System.out.print("\tNumele : ");
            nume = citire_string();                                // se citeste numele
            System.out.print("\tAria supraffetei : ");
            arie = citire_long();                                   // se titeste aria
            if (nume.equals("Stop") || arie == -1)
                break;
            this.serv.adaugare(new Mare(nume, arie));           // se creaza si se adauga obiectul in lista
        }
    }

    public void alfabetic()
    {                                                 // modalitatea de afisare al tabelului in aranjarea alfabetica
        this.serv.alfabetic();
        String leftAlignFormat = "\t\t| %-18s | %18d |%n";

        System.out.format("\t\t+--------------------+--------------------+%n");
        System.out.format("\t\t|      Nume mare     |   Arie Suprafata   |%n");
        System.out.format("\t\t+--------------------+--------------------+%n");
        for (int i = 0; i < this.serv.get_length(); i++)
        {
            System.out.format(leftAlignFormat, get_nume(i), get_arie(i));
        }
        System.out.format("\t\t+--------------------+--------------------+%n");
    }

    public void descrescator()
    {                                       // modalitatea de afisare in tabel in aranjarea descrescatoare dupa arie
        this.serv.descrescator_arie();
        long max = this.serv.get_mare(0).get_arie_suprafata();// dupa aranjarea aria maxima este pe prima pozitie

        String leftAlignFormat = "\t\t| %-18s | %18d | %26.2f |%n";

        System.out.format("\t\t+--------------------+--------------------+----------------------------+%n");
        System.out.format("\t\t|      Nume mare     |   Arie Suprafata   | Proc. din suprafata maxima |%n");
        System.out.format("\t\t+--------------------+--------------------+----------------------------+%n");
        for (int i = 0; i < this.serv.get_length(); i++)
        {
            System.out.format(leftAlignFormat, get_nume(i), get_arie(i), get_procentaj(i, max));
        }
        System.out.format("\t\t+--------------------+--------------------+----------------------------+%n");
    }

    public String get_nume(int index)
    {
        return this.serv.get_mare(index).get_nume();
    } // numele marii de la o pozitie data

    public long get_arie(int index)
    {
        return this.serv.get_mare(index).get_arie_suprafata();
    } // aria marii de la o pozitie

    public float get_procentaj(int index, long max)
    {
        return this.serv.get_mare(index).procentaj(max);
    } // calculul de procentaj al suprafetei al marii fata de suprafata maxima de la o pozitie data
}
