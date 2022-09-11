import java.util.Scanner;

/*
General Description
Implement your task and push to the public git repository. Share the link with the mentor.
Create a simple java class that will read data from the console and will print results to console.
Task 4 (Pascal Triangle, Array Challenge)
Have the function ArrayChallenge(arr) take arr which will be a partial row from Pascal's triangle.
Pascal's triangle starts with a [1] at the first row of the triangle. Then the second row is [1,1] and
the third row is [1,2,1].The next row begins with 1 and ends with 1,
and the inside of the row is determined by adding the k-1 and kth elements from the previous row.
The next row in the triangle would then be [1,3,3,1], and so on.
The input arr will be some almost completed row from the triangle,
for example [1,4,6,4] and your program should return the next element in that row.
In this example your program should return 1.
Another example: if arr is [1,5,10] your program should return 10.
If the whole row is entered as input and there is no next number, your program should return -1.

The input array will contain at least 3 elements so [1] and [1,1] will not occur as inputs.
Examples
Input: [1,3]
Output: 3

Input: [1,5,10,10]
Output: 5
 */
public class Pascal {

    /**
     * this method read string from the console which contains completed (or completed) row of Pascal Triangle
     * and transfer it into string array and then into int array.
     * Input can contain only numeric values delimited by " ", and must be not empty,
     * in other case method throws an NumberFormatException
     *
     * @return int array of input
     * @throws NumberFormatException bad input
     */
    public static int[] inputData() throws NumberFormatException {
        int[] arr;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input almost completed (or completed) row of Pascal Triangle" +
                "(at least 3 numbers) delimited with space characters");
        String input = scanner.nextLine();
        String[] temp = input.split(" ");
        if (temp.length == 0) {
            throw new NumberFormatException();
        }
        arr = new int[temp.length];
        //converting string array to int array
        for (int i = 0; i < temp.length; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }
        return arr;
    }

    /**
     * this method detecting the index of inputted row in Pascal triangle
     * then building all pascal triangle rows till detected index
     * and then returning next possible value or -1 if inputted row was completed
     *
     * @param arr int array
     * @return returning next possible value or -1 if inputted row was completed
     */
    public static int arrayChallenge(int[] arr) {
        //check if row is not completed
        if (arr[arr.length - 1] != 1) {
            //index of inputted row
            int row = arr[1] + 1;
            int[][] a = new int[row][];
            a[0] = new int[]{1};
            a[1] = new int[]{1, 1};
            //building pascal triangle rows till detected index
            for (int i = 2; i < row; i++) {
                a[i] = new int[i + 1];
                a[i][0] = 1;
                a[i][i] = 1;
                for (int j = 1; j < i; j++) {
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                }
            }
            return a[row - 1][arr.length];
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            System.out.println(Pascal.arrayChallenge(Pascal.inputData()));
        } catch (NumberFormatException e) {
            System.err.println("Bad input" +
                    "\nYou can enter only numerical and space characters");
        }
    }
}
