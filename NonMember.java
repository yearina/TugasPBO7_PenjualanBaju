public class NonMember extends Pembeli{

    @Override
    public double potongan(double total) {
        if(total>=500000){
            return 0.01*total;
        }
        return 0;
    }
}