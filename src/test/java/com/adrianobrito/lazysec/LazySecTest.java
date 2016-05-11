package com.adrianobrito.lazysec;

import org.junit.Test;

import java.util.Iterator;

/**
 * Created by adriano on 10/05/16.
 */
public class LazySecTest {

    @Test
    public void shouldCreateLazySec(){
        LazyCommand<Integer> naturalNumbers = new LazyCommand<Integer>() {
            public LazySec<Integer> execute(Integer from) {
                return new LazySec<Integer>(from + 1 , this);
            }
        };

        Iterator<Integer> naturalNumbersList = new LazySec<Integer>(1, naturalNumbers);
        LazyCommand<Integer> naturalNumbersExcept3And4 = new LazyCommand<Integer>() {
            public LazySec<Integer> execute(Integer from) {
                Integer next = from + 1;                if(next == 3 || next == 4){
                    return new LazySec<Integer>(5 , this);
                }
                return new LazySec<Integer>(next , this);
            }
        };

        System.out.println("*********************** NATURAL ***************************");
        int i = naturalNumbersList.next();
        while(i < 10){
            System.out.println(i);
            i = naturalNumbersList.next();
        }

        System.out.println("*********************** NATURAL but no 3 and 4*********************");
        Iterator<Integer> naturalNumbersListExcept3And4 = new LazySec<Integer>(1, naturalNumbersExcept3And4);
        i = naturalNumbersListExcept3And4.next();
        while(i < 10){
            System.out.println(i);
            i = naturalNumbersListExcept3And4.next();
        }

    }


}
