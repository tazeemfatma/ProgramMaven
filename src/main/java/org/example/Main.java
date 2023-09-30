package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Main {
    //WAP to convert list<list> to list using stream api
    public static void main(String[] args) throws IOException {
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });*/
       /* int n=4;
        int k=0;
        int r_q=4;
        int c_q=4;
        List<List<Integer>> obstacles = new ArrayList<>();
        List<Integer> obstacle=new ArrayList<>();*/
        /*obstacle.add(5); obstacle.add(5); obstacles.add(obstacle);obstacle=new ArrayList<>();;
        obstacle.add(4); obstacle.add(2); obstacles.add(obstacle);obstacle=new ArrayList<>();;
        obstacle.add(2); obstacle.add(3); obstacles.add(obstacle);obstacle=null;
*/


     /*   int result = QueenProblem.queensAttack(n, k, r_q, c_q, obstacles);
        System.out.print("Res="+result);*/
//{{0,1},{0,1},{0,1}}
        List<List<Integer>> numbers=new ArrayList<>();
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<3;i++) {
            List<Integer> num = new ArrayList<>();
            for (int j=0;j<2;j++) {

                num.add(i);
            }
            numbers.add(num);
        }
      int arr[][]= {{0,1,2},{0,1,4},{0,1,5}};
        List<Integer> rs = Arrays.stream(arr).map(Arrays::stream).map(IntStream::boxed).map(i -> i.collect(toList()))
                .flatMap(Collection::stream).collect(toList());
        System.out.print(rs);
        
        int arry[]={1,2,3,4,5};
        List<Integer> r = Arrays.stream(arry).boxed().collect(toList());
        //"tazeem fatma" ->Tazeem Fatma

    }
}