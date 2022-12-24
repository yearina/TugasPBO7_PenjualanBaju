public abstract class Pembeli {
    public int id_pembeli;
    public String nama;

    public void tambahData(int id_pembeli, String nama) {
        this.id_pembeli = id_pembeli;
        this.nama = nama;
    }

    public int updateData(int no, int id, String name){
        this.id_pembeli = id;
        this.nama = name;
        return no+1;
    }

    public void display(){
        System.out.println(" Id pembeli: "+getId_pembeli());
        System.out.println("\tNama: "+getNama());
    }

    abstract double potongan(double total);

    public int getId_pembeli() {
        return id_pembeli;
    }

    public String getNama() {return nama;}

}