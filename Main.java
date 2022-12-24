import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Member mem = new Member();
        NonMember non = new NonMember();
        Kasir kas = new Kasir();
        Baju baj = new Baju();
        Import imp = new Import();
        Lokal lok = new Lokal();
        int menu, pilih, n, no, i;
        int[] id2 = new int[10];
        int[] id3 = new int[2];
        int id4, harga4, jumlah4;
        String[] name2 = new String[10];
        String[] name3 = new String[2];
        String[] notelp2 = new String[10];
        String tgl;
        char ulang, member, cetak;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\t\tDATA PENJUALAN TOKO BAJU");
            System.out.println("\t\t------------------------");
            System.out.println("Menu:");
            System.out.println("1. Daftar Baju");
            System.out.println("2. Data Pembeli");
            System.out.println("3. Data kasir");
            System.out.println("4. Transaksi");

            System.out.println("-------------------------------");
            System.out.print("Masukkan menu yang dipilih: ");
            menu = in.nextInt();

            switch(menu) {
                case 1:
                    System.out.println("Daftar baju");
                    System.out.println("-----------");
                    System.out.println("1. Import");
                    System.out.println("2. Lokal");
                    System.out.println("----------------------");
                    System.out.print("Masukkan pilihan anda: ");
                    pilih = in.nextInt();
                    if (pilih == 1) {
                        System.out.println("Baju Import");
                        System.out.println("-----------");
                        baj.dataBaju();
                        imp.dataBaju("Jepang", "Amerika", "Australia");
                    }
                    if (pilih == 2) {
                        System.out.println("Baju Lokal");
                        System.out.println("-----------");
                        baj.dataBaju();
                        lok.dataBaju();
                    }
                    break;
                case 2:
                    System.out.println("Data Pembeli");
                    System.out.println("------------");
                    System.out.println("1. Member");
                    System.out.println("2. Non-Member");
                    System.out.println("----------------------");
                    System.out.print("Masukkan pilihan anda: ");
                    pilih = in.nextInt();
                    if (pilih == 1) {
                        System.out.println("Member");
                        System.out.println("------");
                        System.out.println("1. Tambah data");
                        System.out.println("2. Update data");
                        System.out.println("--------------");
                        System.out.print("Masukkan pilihan anda: ");
                        pilih = in.nextInt();
                        if (pilih == 1) {
                            System.out.println("Tambah data - Member");
                            System.out.println("--------------------");
                            System.out.print("Banyak data pembeli yang ingin diinputkan: ");
                            n = in.nextInt();
                            for (i = 0; i < n; i++) {
                                System.out.println("Data pembeli [" + (i + 1) + "]");
                                System.out.print("Masukkan id pembeli: ");
                                id2[i] = in.nextInt();
                                System.out.print("Masukkan nama: ");
                                name2[i] = in.next();
                                System.out.print("Masukkan no telp: ");
                                notelp2[i] = in.next();
                            }
                            System.out.println("\nOutput data pembeli");
                            i = 0;
                            while (name2[i] != null) {
                                mem.tambahData(id2[i],name2[i],notelp2[i]);
                                System.out.print("["+(i+1)+"]");
                                mem.display();
                                i++;
                            }
                        }

                        if (pilih == 2) {
                            if (id2[0] == 0){
                                System.out.println("Tambahkan data member terlebih dahulu!");
                            }
                            else {
                                System.out.println("Update Data - Member");
                                System.out.println("--------------------");
                                System.out.println("Output data pembeli");
                                i = 0;
                                while (name2[i] != null) {
                                    mem.tambahData(id2[i], name2[i], notelp2[i]);
                                    System.out.print("[" + (i + 1) + "]");
                                    mem.display();
                                    i++;
                                }
                                System.out.print("Masukkan nomor data yang ingin diubah: ");
                                no = in.nextInt();
                                no = no - 1;
                                System.out.print("Masukkan id pembeli: ");
                                id2[no] = in.nextInt();
                                System.out.print("Masukkan nama: ");
                                name2[no] = in.next();
                                System.out.print("Masukkan no telp: ");
                                notelp2[i] = in.next();
                                System.out.println("Mengubah data ke-" + mem.updateData(no, id2[no], name2[i], notelp2[no]) + "...");
                                System.out.println("Output setelah data pembeli diupdate");
                                i = 0;
                                while (name2[i] != null) {
                                    mem.tambahData(id2[i], name2[i], notelp2[i]);
                                    System.out.print("[" + (i + 1) + "]");
                                    mem.display();
                                    i++;
                                }
                            }
                        }
                    }

                    if(pilih==2){
                        System.out.println("Non-Member");
                        System.out.println("----------");
                        System.out.println("1. Tambah data");
                        System.out.println("2. Update data");
                        System.out.println("---------------------");
                        System.out.print("Masukkan pilihan anda: ");
                        pilih = in.nextInt();
                        if (pilih == 1) {
                            System.out.println("Tambah data - Non Member");
                            System.out.println("------------------------");
                            System.out.print("Banyak data pembeli yang ingin diinputkan: ");
                            n = in.nextInt();
                            for (i = 0; i < n; i++) {
                                System.out.println("Data pembeli [" + (i + 1) + "]");
                                System.out.print("Masukkan id pembeli: ");
                                id2[i] = in.nextInt();
                                System.out.print("Masukkan nama: ");
                                name2[i] = in.next();
                            }
                            System.out.println("\nOutput data pembeli");
                            i = 0;
                            while (name2[i] != null) {
                                non.tambahData(id2[i],name2[i]);
                                System.out.print("["+(i+1)+"]");
                                non.display();
                                i++;
                            }
                        }
                        if (pilih == 2) {
                            if (id2[0] == 0){
                                System.out.println("Tambahkan data member terlebih dahulu!");
                            }
                            else {
                                System.out.println("Update Data - Non Member");
                                System.out.println("------------------------");
                                System.out.println("Output data pembeli");
                                i = 0;
                                while (name2[i] != null) {
                                    non.tambahData(id2[i], name2[i]);
                                    System.out.print("[" + (i + 1) + "]");
                                    non.display();
                                    i++;
                                }
                                System.out.print("Masukkan nomor data yang ingin diubah: ");
                                no = in.nextInt();
                                no = no - 1;
                                System.out.print("Masukkan id pembeli: ");
                                id2[no] = in.nextInt();
                                System.out.print("Masukkan nama: ");
                                name2[no] = in.next();
                                System.out.println("Mengubah data ke-" + non.updateData(no, id2[no], name2[i]) + "...");
                                System.out.println("Output setelah data pembeli diupdate");
                                i = 0;
                                while (name2[i] != null) {
                                    non.tambahData(id2[i], name2[i]);
                                    System.out.print("[" + (i + 1) + "]");
                                    non.display();
                                    i++;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Data Kasir");
                    System.out.println("----------");
                    System.out.println("1. Tambah data");
                    System.out.println("2. Update data");
                    System.out.println("---------------");
                    System.out.print("Masukkan pilihan anda: ");
                    pilih = in.nextInt();
                    if (pilih == 1) {
                        System.out.println("Tambah Data");
                        System.out.println("-----------");
                        for (i = 0; i < 2; i++) {
                            System.out.println("Kasir "+(i+1));
                            System.out.print("Masukkan id kasir: ");
                            id3[i] = in.nextInt();
                            System.out.print("Masukkan nama: ");
                            name3[i] = in.next();
                        }
                        System.out.println("\nOutput data kasir");
                        for ( i = 0; i < 2; i++) {
                            System.out.println("Kasir "+(i+1));
                            kas.display(id3[i], name3[i]);
                        }
                    }
                    if (pilih == 2) {
                        if (id3[0] == 0){
                            System.out.println("Tambahkan data kasir terlebih dahulu!");
                        }
                        else {
                            System.out.println("Update Data");
                            System.out.println("-----------");
                            System.out.println("Output data kasir");
                            for (i = 0; i < 2; i++) {
                                System.out.println("Kasir " + (i + 1));
                                kas.display(id3[i], name3[i]);
                            }
                            System.out.print("Masukkan nomor data yang ingin diubah: ");
                            no = in.nextInt();
                            System.out.println("Kasir " + no);
                            System.out.print("Masukkan id_kasir: ");
                            id3[no] = in.nextInt();
                            System.out.print("Masukkan nama: ");
                            name3[no] = in.next();
                            System.out.println("\nOutput data kasir setelah diupdate");
                            for (i = 0; i < 2; i++) {
                                System.out.println("Kasir " + (i + 1));
                                kas.display(id3[i], name3[i]);
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Transaksi");
                    System.out.println("---------");
                    System.out.print("Masukkan id transaksi: ");
                    id4 = in.nextInt();
                    System.out.print("Masukkan tanggal beli: ");
                    tgl = in.next();
                    System.out.print("Masukkan banyak baju: ");
                    jumlah4 = in.nextInt();
                    System.out.print("Masukkan harga: ");
                    harga4 = in.nextInt();
                    System.out.print("Apakah pembeli merupakan member?(y/t): ");
                    member = in.next().charAt(0);
                    Transaksi trans = new Transaksi(id4,tgl,jumlah4,harga4);
                    System.out.println("------------------------------------------");
                    System.out.println("Struk Pembelian Baju");
                    System.out.println("--------------------");
                    System.out.println("Id transaksi: "+trans.getId_transaksi());
                    System.out.println("Tanggal beli: "+trans.getTgl_beli());
                    System.out.println("Banyak baju: "+trans.getJumlah());
                    System.out.println("Harga: "+trans.getHarga());
                    System.out.println("---------------------");
                    System.out.println("Total harga = "+trans.totalHarga(jumlah4, harga4));
                    System.out.println("Potongan harga = -"+trans.diskon(member));
                    System.out.println("Total bayar = "+trans.jumlahBayar(member));
                    System.out.print("\nIngin mencetak transaksi?(y/t): ");
                    cetak = in.next().charAt(0);
                    if (cetak == 'y'){
                        try {
                            FileWriter file = new FileWriter("Struk Transaksi.txt");
                            BufferedWriter out = new BufferedWriter(file);
                            out.write("+===============================+ \n");
                            out.write("|\t Struk Pembelian Baju \t\t|\n");
                            out.write("+===============================+ \n");
                            out.write("|Id transaksi: "+trans.getId_transaksi()+"\t\t\t\t|\n");
                            out.write("|Tanggal beli: "+trans.getTgl_beli()+"\t\t|\n");
                            out.write("|Banyak baju: "+trans.getJumlah()+"\t\t\t\t\t|\n");
                            out.write("|Harga: "+trans.getHarga()+"\t\t\t\t\t|\n");
                            out.write("|-------------------------------+ \n");
                            out.write("|Total harga = "+trans.totalHarga(jumlah4, harga4)+"\t\t\t|\n");
                            out.write("|Potongan harga = -"+trans.diskon(member)+"\t\t|\n");
                            out.write("|Total bayar = "+trans.jumlahBayar(member)+"\t\t\t|\n");
                            out.write("+===============================+ \n");
                            out.close();
                            file.close();
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    System.out.println("Menu yang dipilih tidak tersedia!!!");
            }
            System.out.print("\nPilih menu lainnya (y/t): ");
            ulang = in.next().charAt(0);
        } while(ulang != 't');
    }
}