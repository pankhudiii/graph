package ads;

import java.util.*;
import java.util.Scanner;
import java.util.Stack;
 
public class Graph
{
    private Stack<Integer> stack;
 
    public Graph()
    {
        stack = new Stack<Integer>();
    }
 
    public int[] path(int adjacency_matrix[][], int source)
            throws NullPointerException
    {
        int number_of_nodes = adjacency_matrix[source].length - 1;
        int[] arr = new int[number_of_nodes + 1];
        int pos = 1;
        int j;
        int visited[] = new int[number_of_nodes + 1];
        int element = source;
        int i = source;
        visited[source] = 1;
        stack.push(source);
        while (!stack.isEmpty())
        {
            element = stack.peek();
            while (i <= number_of_nodes)
            {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 1)
                {
                    if (stack.contains(i))
                    {
                        System.out.println("Path is not possible");
                        return null;
                    }
                }
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
                {
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                    continue;
                }
                i++;
            }
            j = stack.pop();
            arr[pos++] = j;
            i = ++j;
        }
        return arr;
    }
 
    public static void main(String... arg)
    {
        int number_no_nodes, source;
        Scanner scanner = null;
        int arr[] = null;
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_no_nodes = scanner.nextInt();
            int adjacency_matrix[][] = new int[number_no_nodes + 1][number_no_nodes + 1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 1; i <= number_no_nodes; i++)
                for (int j = 1; j <= number_no_nodes; j++)
                    adjacency_matrix[i][j] = scanner.nextInt();
            System.out.println("Enter the source for the graph");
            source = scanner.nextInt();
            System.out.println("Path from source is given by : ");
            Graph g1 = new Graph();
            arr = g1.path(adjacency_matrix, source);
            for (int i = arr.length - 1; i > 0; i--)
            {
                if (arr[i] != 0)
                    System.out.print(arr[i] + "\t");
            }
        }
        catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input format");
        }
        catch (NullPointerException nullPointer)
        {
        }
        scanner.close();
    }
}