package com.akash.interviews.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * immutable with list
 */
public class ImmutableWithList {

    private final String title;
    private final List<String> students;

    public ImmutableWithList(String title, List<String> students) {
        this.title = title;
        /* Defensive copy to prevent external modification */ 
        this.students = Collections.unmodifiableList(new ArrayList<>(students));
        List<String> copy = List.copyOf(this.students); /* Java 10+ Shortcut - Unmodifiable and safe */
        System.out.println(copy); /* returning immutable collections. */
    }

    public String getTitle() {
        return title;
    }

    public List<String> getStudents() {
        // Return an unmodifiable view (already safe)
        return students;
    }

    /*
     * Constructor creates a new copy of the input list.
     * That copy is wrapped with Collections.unmodifiableList() — making it read-only.
     * Getter returns that unmodifiable list, not the original.
     */

     public static void main(String[] args) {
        List<String> authors = new ArrayList<>();
        authors.add("Student A");
        authors.add("Student B");

        ImmutableWithList immutableWithList = new ImmutableWithList("Design Patterns", authors);
        authors.add("Malicious Student"); // won't affect the book

        System.out.println(immutableWithList.getTitle()); // [Author A, Author B]

     }
    
}