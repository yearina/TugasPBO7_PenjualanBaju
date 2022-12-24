public class Transaksi implements Hitung{
    private int id_transaksi;
    private String tgl_beli;
    private int jumlah;
    private int harga;
    private static int total;

    Member mem = new Member();
    NonMember non = new NonMember();

    public Transaksi(int id_transaksi, String tgl_beli, int jumlah, int harga) {
        this.id_transaksi = id_transaksi;
        this.tgl_beli = tgl_beli;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public String getTgl_beli() {
        return tgl_beli;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getHarga() {
        return harga;
    }

    @Override
    public int totalHarga(int jumlah, int harga){
        total = jumlah*harga;
        return total;
    }

    @Override
    public double diskon(char member){
        if(member == 'y'){
            return mem.potongan(total);
        }
        return non.potongan(total);
    }

    public final double jumlahBayar(char member){
        if(member == 'y'){
            return total-mem.potongan(total);
        }
        return total-non.potongan(total);
    }

}