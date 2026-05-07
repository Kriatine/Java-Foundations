import java.sql.SQLOutput;

public class csdu8has {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        reverseArray(array);

        for(int num : array){
            System.out.println(num);
        }
    }
    public static void reverseArray(int[] nums) {
        int stopIndex = nums.length / 2;
        int numTemp1 = 0;
        for(int i = 0, j = nums.length-1; i < nums.length; i++, j--){
            numTemp1 = nums[i];
            nums[i] = nums[j];
            nums[j] = numTemp1;
            if(i == stopIndex)
                break;
        }
    }
}
