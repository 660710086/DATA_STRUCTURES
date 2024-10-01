import java.util.Random;


public class Finding_Match {
    public int value[] = null;
    private int sizeArray;
    public int checkNull[]  ;// -1 = ชน || 0 = null || 1 = value

    // set size array
    public Finding_Match(int size) {
        this.sizeArray = size * 2;
        checkNull = new int[sizeArray];
        value = new int[sizeArray];

    }

    // Size Array
    public int getSize() {
        return sizeArray;
    }

    // hand funtion and inset
    public void handfuntion(int key) {
        int checkValue = key % sizeArray; // secrch address value have null but is null inset
        value[checkValue] = key;
        checkNull[checkValue] = 1;// have value

    }

    public void haveValue(int key) {
        boolean finish = false;
        int count = 1;
        while (!finish) {
            int c=  (key % sizeArray )+ count;
            if(checkNull[c] == 0){
                value[c] = key;
                checkNull[c] = -1;
                return ;
            }
            count++;

        }
        //end loop can't add but have value
        //check first secarch address null but inset value
        if (count == sizeArray) {
            for (int i = 0; i < checkNull.length; i++) {
                if (checkNull[i] == 0) {
                    value[i] = key;
                    checkNull[i] = -1;
                    return;
                }
            }
            
        }
    }

    public void showValue(){
        for (int i = 0; i < checkNull.length; i++) {
            
            if(checkNull[i] == 1 || checkNull[i] == -1){
                System.out.print(i+":"+value[i]);
            }
            else if (checkNull[i] == -1) {
                System.out.print("*");
                
            }else{
                continue;
            }
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = random.nextInt(10, 21);

        Finding_Match fM = new Finding_Match(size);
        System.out.println("--- Random Number[" + size + "]---");

        int sizeArray = size * 2;


        int CV [] = new int[sizeArray];
        System.out.println("sizeArray : " + sizeArray);
        for (int i = 0; i < size; i++) {

            int randomNumber = random.nextInt(101);
            int checkValue = randomNumber % sizeArray;

            System.out.println("key : " + randomNumber);
            System.out.println("insize : " + checkValue);

            if (fM.value[checkValue] == randomNumber)
            {
                System.out.print("!");
                i--;
            }
            else if(fM.checkNull[checkValue] == 1)
            {
                fM.haveValue(randomNumber);
            }
            else
            {
                
                fM.handfuntion(randomNumber);
            }

            System.out.print(randomNumber);
            System.out.print(" ");
            System.out.println();
            System.out.println("----");

        }

        System.out.println("--- Hash Table["+size+"]---");
        fM.showValue();

    
    }

    

}