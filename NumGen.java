import java.util.Random;

public class NumGen {

    static int[] generateArray(int number, int min, int max)
    {
        int[] randArray = new int[number];
        Random gr = new Random();
        for (int i=0; i<number;i++)
            randArray[i] = gr.nextInt(max+1-min)+min;
        return randArray;
    }
    static int[] generateAsc(int number, int min, int max)
    {
        int[] randArray = new int[number];
        int rang = max-min+1;
        int noel = number/rang;
        int reszta = number%rang;
        int k=0, i;
        for(i=min;i<=max;i++)
            for (int j=0;j<noel;j++)
                randArray[k++] = i;
        for (int j=0;j<reszta;j++)
            randArray[k++] = max;
        return randArray;
    }
    static int[] generateDesc(int number, int min, int max)
    {
        int[] randArray = new int[number];
        int rang = max-min+1;
        int noel = number/rang;
        int k=0, i;
        for(i=max;i>min;i--)
            for (int j=0;j<noel;j++)
                randArray[k++] = i;
        for (int j=0;j<number-(noel*rang);j++)
            randArray[k++] = min;
        return randArray;
    }
}
