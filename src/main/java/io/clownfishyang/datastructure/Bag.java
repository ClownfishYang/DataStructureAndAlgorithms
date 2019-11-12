package io.clownfishyang.datastructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2019/11/4 11:34<br>
 */
public interface Bag<Item> extends Iterable<Item>, Collection<Item> {

    @Override
    default boolean remove(Object o) {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    default boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    default boolean removeIf(Predicate<? super Item> filter) {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    default boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    default void clear() {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    default boolean contains(Object o) {
        Iterator<Item> iterator = iterator();
        if (o == null) {
            for (Iterator<Item> it = iterator; it.hasNext(); ) {
                Object e = it.next();
                if (e == null)
                    return true;
            }
        } else {
            for (Iterator<Item> it = iterator; it.hasNext(); ) {
                Object e = it.next();
                if (e.equals(o))
                    return true;
            }
        }
        return false;
    }


    @Override
    default boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }
}
