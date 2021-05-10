import java.io.BufferedReader;
import java.io.FileReader;

public class RepoFile {

    private Service serv; 

    public RepoFile() {
        this.serv = new Service();
    }    // constructorul default

    public void citire_fisier()
    {                                               // gasirea fisierului dupa path
        try { BufferedReader fisIn = new BufferedReader(new FileReader("/Users/c.mihai/Documents/An2-UBB/" +
                "Metode_avansate_de_programare/Laborator/Laborator3/src/Mari.txt"));
            String st;           // string null

            while ((st = fisIn.readLine()) != null)      // citeste linie cu linie pana la valoarea null
            {                                                     // adica nu mai sunt valori in fisier
                String[] rupt = st.split(",");     // split dupa ",",
                String nume = rupt[0];                  // primul element este numele marii
                long arie = Long.parseLong(rupt[1]);      // al doilea este aria si se converteste in long
                this.serv.adaugare(new Mare(nume, arie));      // se creaza Obiectul mare si se adauga la liste
            }
            fisIn.close();        // se inchide fisierul
        }
        catch (Exception e)
        {
            System.out.println("Oops! S-a gresit la citirea din fisier!");
            e.printStackTrace();
        }

    }

    public Mare[] get_mari()
    {
        return this.serv.get_mari();
    }    // se returneaza lista de mari citite din fisier
}
