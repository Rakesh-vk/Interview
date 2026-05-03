package practice.basics;

public class restrictedProductBatch {
    public static void main(String[] args) {
        int[] productBatches= {101,102,103,104,105,106,107};
        for(int i:productBatches){
            if(i==105){
                System.out.println("Restricted batch found : " +i);
                break;
            }
            System.out.println("product in stock "+i);
        }
    }
}
