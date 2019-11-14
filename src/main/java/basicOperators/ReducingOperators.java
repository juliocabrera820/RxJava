package basicOperators;

import io.reactivex.Observable;

public class ReducingOperators {
    public static void main(String[] args) {
        Integer[] nums = {10,5,11,2,2,6,12,28,30};
        Observable.fromArray(nums).filter(x -> x%2==0).distinct()
                                                      .count()
                                                      .subscribe(x -> System.out.println("Cantidad de pares no repetidos "+x));
        Observable.fromArray(nums).reduce(0,Integer::sum)
                                  .subscribe(x -> System.out.println("Total "+x));
        String[] palabras = {"star","software","repetidos","pares"};
        Observable.fromArray(palabras).all(x -> x.endsWith("s") || x.startsWith("s"))
                                      .subscribe(x -> System.out.println("Las palabras inician o terminan s "+x));
        Integer[] numbers = {10,8,10,2,2,6,12,28,30};
        Observable.fromArray(numbers).any(x -> x%2!=0)
                                     .subscribe(x -> System.out.println("Hay al menos un numero impar "+x));

    }
}
