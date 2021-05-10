public class Service {
    private Mare[] mari;

    public Service(Mare[] mari) {
        this.mari = mari;
    }      // Constructorul pentru lista de obiecte Mare

    public Service() {}                 // Constructorul default

    public void adaugare(Mare mare)         // Adaugarea unui nou obiect Mare in lista de mari
    {
        int length;
        if (this.mari == null)                   // se verifica da lista este null
            length = 0;
        else
            length = this.mari.length;

        Mare[] m = new Mare[length+1];          // Se creaza o noua lista de mari de lungimea listei initiale +1
                                                // deoarece pe ultima pozitie va venii noul element
        for (int i = 0; i < length; i++)
            m[i] = this.mari[i];              // se copiaza lista initiala
        m[m.length-1] = mare;                // se adauga in coada noul element

        this.mari = m;                 // se salveaza noua lista
    }

    public void alfabetic()
    {
        for (int i = 0; i < this.mari.length-1; i ++)              // se parcurge lista pana la penultimul element
        {
            for (int j = i+1; j < this.mari.length; j++)        // se parcurge lista ramasa pentru fiecare element
            {                                                       // din for - ul de mai sus (adica i)
                if (this.mari[j].compare_string(this.mari[i].get_nume()))
                {                                                  // se comapara numele litera cu litera
                    Mare aux = this.mari[i];                    // cel mai mic se pune pe pozitia i
                    this.mari[i] = this.mari[j];                // cel ce era pe potia i merge pe pozitia j
                    this.mari[j] = aux;
                }
            }
        }
    }

    public void descrescator_arie()
    {
        boolean ok;

        do {
            ok = false;                                     // setez ok pentru conditia de oprire

            for (int i = 0; i < this.mari.length-1; i ++)                 // parcurg lista de mari
                if (this.mari[i].get_arie_suprafata() < this.mari[i+1].get_arie_suprafata())
                {                                                   // daca gasesc o mare mai mica ca cea urmatoare
                    Mare aux = this.mari[i];                        // le interschimb
                    this.mari[i] = this.mari[i+1];
                    this.mari[i+1] = aux;
                    ok = true;                        // setez ok - ul pentru a stii ca am facut o interschimbare
                }
        }while(ok);             // se opreste atunci cand se parcurge toata lista si nu s-au facut interschimbari
    }

    public Mare get_mare(int index)
    {
        return this.mari[index];          // returneaza un obiect de tip Mare din lista de mari de la o pozitie data
    }

    public int get_length()
    {
        return this.mari.length;       // returneaza lungimea listei de obiecte de tip Mare
    }

    public Mare[] get_mari()
    {
        return this.mari;           // returneaza intreaga lista de obiecte de tip Mare
    }
}
