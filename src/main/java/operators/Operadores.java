package operators;

import io.reactivex.Observable;

public class Operadores {
    public static void main(String[] args) {
        Integer[] numbers = {10,8,22,11,-10,3,21,7,9,18,12,18,10};

        Observable.fromArray(numbers).map(x -> "["+x+"] ")
                                     .subscribe(System.out::print);
    }
}
