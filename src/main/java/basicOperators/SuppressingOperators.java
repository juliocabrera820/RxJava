package basicOperators;

import io.reactivex.Observable;

public class SuppressingOperators {
    public static void main(String[] args) {
        Integer[] numbers = {10,11,8,22,11,-10,3,21,7,9,18,12,18,18,14,13,20};

        Observable.fromArray(numbers).map(x -> "["+x+"] ")
                                     .subscribe(x -> System.out.print(x+" "));
        System.out.println("\n"+"Numeros pares");
        Observable.fromArray(numbers).filter(x -> x%2==0)
                                     .subscribe(x -> System.out.print(x+" "));
        System.out.println("\n"+"Toma los 4 ultimos numeros pares");
        Observable.fromArray(numbers).filter(x -> x%2==0)
                                     .takeLast(4)
                                     .subscribe(System.out::println);
        System.out.println("\n"+"Toma los primeros 2 numeros pares");
        Observable.fromArray(numbers).filter(x -> x%2==0)
                                     .take(2)
                                     .subscribe(System.out::println);
        System.out.println("\n"+"Salta los primeros 5 numeros");
        Observable.fromArray(numbers).skip(5)
                                     .subscribe(x -> System.out.print(x+" "));
        System.out.println("\n"+"Toma numeros mientras no sean igual a 9");
        Observable.fromArray(numbers).takeWhile(x -> x!=9)
                                     .subscribe(x -> System.out.print(x +" "));
        System.out.println("\n"+"Imprimer numeros sin que se repitan");
        Observable.fromArray(numbers).distinct()
                                     .subscribe(x -> System.out.print(x+" "));
    }
}
