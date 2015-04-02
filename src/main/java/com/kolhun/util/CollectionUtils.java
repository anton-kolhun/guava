package com.kolhun.util;


import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;

public class CollectionUtils {
    public static void main(String[] args) {
        transformLists();
        filterIterables();

        filterSets();

        filterLists();
    }


    public static void transformLists() {
        List<Integer> literals = Arrays.asList(1, 2, 3);

        Function<Integer, Integer> func = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer o) {
                return o + 1;
            }
        };
        List<Integer> newList = Lists.transform(literals, func);
    }

    public static void filterIterables() {
        List<String> literals = Arrays.asList("1", "2", "3");
        Iterable<String> filtered = Iterables.filter(literals, new Predicate<String>() {

            @Override
            public boolean apply(String input) {
                return input.equals("1");
            }
        });

        System.out.println(Iterables.toString(filtered));

        Iterator<String> filtered2 = Iterators.filter(literals.iterator(), new Predicate<String>() {

            @Override
            public boolean apply(String input) {
                return input.equals("1");
            }
        });

        System.out.println(Iterators.toString(filtered2));
    }

    public static void filterSets() {
        Set<String> words = new HashSet<>();
        words.add("1");
        words.add("2");
        words.add("3");
        Set<String> filteredSet = Sets.filter(words, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.equals("1");
            }
        });


        System.out.println(Iterables.toString(filteredSet));

    }

    public static void filterLists() {
        List<String> words = Arrays.asList("1", "2", "3");

        Iterable<String> filteredIt = Iterables.filter(words, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.equals("2");
            }
        });

        List<String> filteredList = Lists.newArrayList(filteredIt);
        System.out.println(Iterables.toString(filteredList));

    }

}
