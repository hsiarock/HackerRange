package com.kph;

import reactor.core.publisher.Flux;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {

    static int x = 0;

    public static int fun() {
        return ++x;
    }

    public static void main(String[] args) {

        System.out.println(fun());

        MySingleton.INSTANCE.doSomething();
        String something = MySingleton.INSTANCE.getSomething();
        System.out.println("return from singleton : " + something);

        /*try {
            throw 10; // compile failed. must be Throwable
        } catch ( int e) {
            System.out.println("got exception " + e);
        }*/

        // multi-thread
        Flux.range(0, 10).parallel().subscribe(e -> System.out.println(e));


        System.out.println("\nDecorateOutString -------------------------------");
        byte[] message = new byte[]{0x48, 0x65, 0x6c, 0x6c, 0x6f, 0x2c, 0x20, 0x77, 0x6f, 0x72, 0x6c, 0x64, 0x21};
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            DecoratorStream decoratorStream = new DecoratorStream(baos, "First line: ");
            decoratorStream.write(message);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(baos.toByteArray()), "UTF-8"))) {
                System.out.println(reader.readLine());  //should print "First line: Hello, world!"
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Icecreate topping + ingredins
        IceCreamMachine machine = new IceCreamMachine(new String[]{"vanilla", "chocolate", "top1", "top2"  },
                                                      new String[]{"chocolate sauce", "source1"});
        List<IceCreamMachine.IceCream> scoops = machine.scoops();

        /*
         * Should print:
         * vanilla, chocolate sauce
         * chocolate, chocolate sauce
         */
        System.out.println("\n----------- Icecreame -----------");
        for (IceCreamMachine.IceCream iceCream : scoops) {
            System.out.println(iceCream.ingredient + ", " + iceCream.topping);
        }
        System.out.println("\n----------- RouteMatrixExists -----------");
        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true}
        };

        System.out.printf("\n Recursive result:%b", routeExists(0, 0, 2, 2, mapMatrix));

        // Math
            Roots roots = QuadraticEquation.findRoots(2, 10, 8);
            System.out.println("\nRoots: " + roots.x1 + ", " + roots.x2);

        System.out.println("----findtwoSum\n");
        HashSet<String> indices = Test1.findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            for (String n: indices)
               System.out.println(n);
        }

        System.out.println("----DoubleLink\n");
        DoubleLink train = new DoubleLink();
        train.attachWagonFromLeft(1);
        train.attachWagonFromLeft(2);
        train.attachWagonFromLeft(3);
        train.attachWagonFromLeft(5);

        DoubleLink.Train insertNode = train.head.next.next.next; // 3
        train.insertAfter(insertNode, 99);
        System.out.println(train.detachWagonFromRight()); // 5
        System.out.println(train.detachWagonFromLeft()); // 1

        train.printTrainList();


    }


    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        System.out.printf("check FromRow: %d, fromColumn:%d, toRow:%d, toColumn:%d\n",  fromRow,fromColumn, toRow, toColumn);
        if (mapMatrix.length == 0 || mapMatrix[0].length == 0) {
            return false;
        }
        if (fromRow+1 >= mapMatrix.length || fromColumn+1 >= mapMatrix[0].length) {
            System.out.printf("out of index FromRow: %d, fromColumn:%d\n", fromRow+1, fromColumn);
            return false;
        }
        if (fromRow == toRow && fromColumn == toColumn) {
            return true;
        }

        if (mapMatrix[fromRow+1][fromColumn] && mapMatrix[toRow][toColumn]) {
            System.out.printf("call FromRow: %d, fromColumn:%d, toRow:%d, toColumn:%d\n", fromRow+1,fromColumn, toRow, toColumn);
            if (routeExists(fromRow+1, fromColumn, toRow, toColumn, mapMatrix)) {
                return true;
            }
        }

        System.out.printf("2nd call FromRow: %d, fromColumn:%d, toRow:%d, toColumn:%d\n", fromRow,fromColumn+1, toRow, toColumn);
        if (mapMatrix[fromRow][fromColumn+1] && mapMatrix[toRow][toColumn]) {
            return routeExists(fromRow, fromColumn+1, toRow, toColumn, mapMatrix);
        }

        return false;
    }

    // count element
    public static int countNumbers(int[] sortedArray, int lessThan) {
        long ret = Arrays.stream(sortedArray)
                .parallel()
                .filter( r -> r < lessThan )
                .count();
        return (int) ret;
    }
    public class QuadraticEquation {
        public static Roots findRoots(double a, double b, double c) {

            double a1 = (Math.pow(b, 2) - 4 * a * c) ;
            double x1 = ((-1)* b + Math.sqrt(a1))/(2 * a);
            double x2 = ((-1)* b - Math.sqrt(a1))/(2 * a);

            return new Roots(x1, x2);
        }
    }

    public static class TextInput {
        List<Character> ctn = new ArrayList<Character>();

        public void add(char c) {
            ctn.add(c);
        }
        public String getValue() {
            StringBuilder builder = new StringBuilder(ctn.size());
            for(Character ch: ctn)
            {
                builder.append(ch);
            }
            return builder.toString();
        }
    }

}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
