package com.adrianobrito.lazysec;

/**
 * Created by adriano on 10/05/16.
 */
public interface LazyCommand<T> {

    LazySec<T> execute(T t);

}
