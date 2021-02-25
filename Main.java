import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    
    public static void main (String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCases = Integer.parseInt(br.readLine());

        String[] output = new String[numCases];

        String[] cases = new String[numCases];
        for(int i = 0; i < numCases; i ++) {
            cases[i] = br.readLine();
        }

        for(int i = 0; i < numCases; i ++) {
            double[] array = splitAndParse(cases[i]);
            output[i] = bubbleSort(array) + "\n";
        }

        for(int i = 0; i < numCases; i ++) {
            bw.write(output[i]);
        }

        br.close();
        bw.close();

    }

    public static double[] splitAndParse(String cases) {
        String[] caseToSplit = cases.split(" ");
        double[] caseToParse = new double[caseToSplit.length];
        for(int i = 0; i < caseToParse.length; i ++) {
            caseToParse[i] = Double.parseDouble(caseToSplit[i]);
        }
        return caseToParse;
    }

    public static String bubbleSort(double[] array) {
        double swaps = 0.0;
        double av = 0.0;
        String info = "";
        for(int i = 0; i < array.length; i ++) {
            double aux = 0.0;
            for(int j = 0; j < array.length-i-1; j++) {
                if(array[j] > array[j+1]) {
                    aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                    swaps ++;
                }
            }
        }
        av = swaps/(array.length-1);
        av = (double)(int)(av*100)/100.0;
        info = av + "-" + getSortedArrayInfo(array);
        return info;
    }

    public static String getSortedArrayInfo(double[] array) {
        String info = "";
        for(int i = 0; i < array.length; i ++) {
            if(i == array.length-1) {
                info += array[i];
            } else {
                info += array[i] + " ";
            }
        }
        return info;
    }

}
