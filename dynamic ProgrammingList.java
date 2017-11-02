import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author christopherdonoso
 */
public class Hw03 
{
    
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args)
    {
        File text = new File (args[0]);
        ArrayList<String> weight = new ArrayList<String>();
        ArrayList<String> benefit = new ArrayList<String>();
        ArrayList<String> data = new ArrayList<String>();

        int seperate = 0;


        //Opens and stores the content of the text file into an array.    
        try
        {
            //Reads in the text file.
            Scanner scanner = new Scanner(text);
            
            //Goes through the text field and stores string in an Array list.
            //More specifically, weights and values are being stored, with
            //number of problems and maximum hours.
            while(scanner.hasNextLine())
            {
                if(seperate > 1)
                {
                    String line = scanner.next();

                    if((seperate % 2) == 0)
                    {
                        weight.add(line);
                    }

                    else
                    {
                        benefit.add(line);
                    }
                }

                else
                {
                    String nextLine = scanner.next();
                    data.add(nextLine);
                }

                seperate++;
            }
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }


        System.out.println(text + " has " + data.get(0) + " problems over " + 
            data.get(1) + " hours");
        System.out.println("Pr#\tTime\tPoints");
        
        //Prints out the Weight and Benefit.
        for(int i = 0; i < Integer.parseInt(data.get(0)); i++)
        {
            System.out.print(i + 1);
            System.out.print("\t" + weight.get(i));
            System.out.println("\t" + benefit.get(i));
        }

        System.out.println();
        System.out.print("The selected  problems for the highest contest score are: ");
        System.out.println();
        System.out.println("\tProblem\tPoints");
        

        int n = weight.size();
        int maxWeight = Integer.parseInt(weight.get(weight.size() - 1).toString());
    
        schedule(knapSack(Integer.parseInt(data.get(1)), weight, benefit, n), n, maxWeight, weight, Integer.parseInt(data.get(1)), benefit);
        // System.out.println(knapSack(maxWeight, weight, benefit, n));

        // complexityIndicator();
    }

    static int[][] knapSack(int maxWeight, ArrayList weight, ArrayList benefit, int n)
    {
        int i, w;

        int table[][] = new int[n + 1][maxWeight + 1];

        ArrayList<Integer> test = new ArrayList<Integer>();

        for(i = 0; i <= n; i++)
        {
            for(w = 0; w <= maxWeight; w++)
            {
                if(i == 0 || w == 0)
                {
                    table[i][w] = 0;
                }

                else if(Integer.parseInt(weight.get(i - 1).toString()) <= w)
                {
                    table[i][w] = max(Integer.parseInt(benefit.get(i - 1).toString()) +
                                    table[i - 1][w - Integer.parseInt(weight.get(i-1).toString())],
                                    table[i - 1][w]);
                    test.add(max(Integer.parseInt(benefit.get(i - 1).toString()) +
                                    table[i - 1][w - Integer.parseInt(weight.get(i-1).toString())],
                                    table[i - 1][w]));
                }

                else
                {
                    table[i][w] = table[i - 1][w];
                }
            }
        } 

        return table;
    }

    static void schedule(int table[][], int n, int maxWeight, ArrayList weight, int weightLimit, ArrayList benefit)
    {
        ArrayList<Integer> in = new ArrayList<Integer>();

        int i = n, k = weightLimit;

        while(i > 0 && k > 0)
        {
            if(table[i][k] != table[i - 1][k])
            {
                in.add(i);    
                i = i - 1;
                k = k - Integer.parseInt(weight.get(i).toString());                           
            }

            else
            {
                i = i - 1;
            }
        }

        print(in, benefit);
    }

    static void print(ArrayList<Integer> in, ArrayList benefit)
    {
        int sum = 0;

        Collections.sort(in);

        for(int i = 0; i < in.size(); i++)
        {
            System.out.println("\t" + in.get(i) + "\t" + benefit.get(in.get(i) - 1));

            sum = Integer.parseInt(benefit.get(in.get(i) - 1).toString()) + sum;
        }

        System.out.println("");
        System.out.println("Target problem list yields " + sum + " points");
    }

    static int max(int a, int b) 
    { 
        return (a > b) ? a : b; 
    }

    static void complexityIndicator()
    {
        System.err.println("ch724936;2.0;20.0");
    }
}
