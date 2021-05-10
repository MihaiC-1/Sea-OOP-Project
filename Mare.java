public class Mare {
    private String nume;
    private long arie_suprafata;

    Mare(String nume, long arie)      // Constructorul pentru clasa Mare
    {
        this.nume = nume;                // atribuirea de nume si arie variabilelor din clasa ale valorilor citite
        this.arie_suprafata = arie;
    }

    public float procentaj(long maxim)
    {
        float arie  = this.arie_suprafata;        // Calculare procentajului ariei de suprafata fata de o arie
        return (arie/ (float) maxim)*100;         // maxima data sau citita
    }

    public boolean compare_string(String nume)
    {
        return this.nume.compareTo(nume) < 0;
    }

    public String get_nume() {return this.nume;}                             // Get pentru valoarea nume
    public long get_arie_suprafata() {return this.arie_suprafata;}           // Get pentru valoarea arie_suprafata
}
