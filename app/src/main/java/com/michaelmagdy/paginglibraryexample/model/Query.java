package com.michaelmagdy.paginglibraryexample.model;

public class Query {

    private static String searchQuery;

    public static String getSearchQuery() {
        return searchQuery;
    }

    public static void setSearchQuery(String searchQuery) {
        Query.searchQuery = searchQuery;
    }
}
