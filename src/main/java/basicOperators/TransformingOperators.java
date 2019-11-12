package basicOperators;

import io.reactivex.Observable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class TransformingOperators {
    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Observable.just("01/03/2016", "05/09/2016", "10/12/2016").map(s -> LocalDate.parse(s, dtf))
                                                                 .subscribe(i -> System.out.println("Fecha: " + i));
        String[] langs = {"Java","Go","Ruby","Groovy","Kotlin","Javascript","Python"};
        Observable.fromArray(langs).startWith("Lenguajes de Programacion:")
                                   .subscribe(System.out::println);

        System.out.println("Lenguajes ordenados");
        Observable.fromArray(langs).sorted()
                                   .subscribe(System.out::println);

        System.out.println("Lenguajes ordenados de manera descendente");
        Observable.fromArray(langs).sorted(Comparator.reverseOrder())
                                   .subscribe(System.out::println);
        System.out.println("Repetir 2 veces las palabras que terminen con y");
        Observable.fromArray(langs).filter(x -> x.endsWith("y"))
                                   .map(String::toUpperCase)
                                   .repeat(2)
                                   .subscribe(System.out::println);
        System.out.println("Suma e imprime el numero anterior de la suma");
        Observable.just(5,3,0,-1,2,8).scan((actual,sig) -> actual+sig )
                                     .subscribe(System.out::println);
        System.out.println("Concatena");
        Observable.just("S","C","A","L","A").scan((actual,sig)-> actual+sig)
                                            .subscribe(System.out::println);

    }
}
