package basicOperators;


import io.reactivex.Observable;

public class ActionOperators {
    public static void main(String[] args) {
        Integer[] nums = {10,5,11,2,2,6,12,28,30};
        Observable.fromArray(nums).doOnNext(x -> System.out.println(x))
                                  .map(x -> -x)
                                  .doOnSubscribe(x -> System.out.println("Empezando"))
                                  .doOnTerminate(() -> System.out.println("Terminando"))
                                  .subscribe(System.out::println);


    }
}
