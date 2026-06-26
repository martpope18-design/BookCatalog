package com.example.bookcatalog;

import java.util.ArrayList;
import java.util.List;

// This class holds all our book data - like a database
public class BookData {

    // Method that returns a list of all books
    public static List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book("The Last Ember", "Daniel Roth",
                "Historical Thriller",
                "A former archaeologist is pulled into a deadly conspiracy when ancient secrets buried beneath Rome resurface.",
                R.drawable.book1_the_last_ember));

        books.add(new Book("Quantum Mirage", "Lila Chen",
                "Science Fiction",
                "In a future where time travel is illegal, a rogue physicist must choose between saving the world or saving her daughter.",
                R.drawable.book2_quantum_mirage));

        books.add(new Book("Roots & Wings", "Maria Esteban",
                "Literary Fiction",
                "A moving generational story of a Cuban-American family searching for identity, belonging, and redemption.",
                R.drawable.book3_roots_wings));

        books.add(new Book("The Mind Sculptor", "Dr. Evan Shaw",
                "Psychology / Non-Fiction",
                "A groundbreaking look at neuroplasticity and how you can rewire your brain for success and happiness.",
                R.drawable.book4_mind_sculptor));

        books.add(new Book("Inbound: Chronicles of the Lost Library", "J.R. Faulkner",
                "Fantasy / Adventure",
                "A young librarian discovers that ancient books can open portals to other worlds—but not all stories have happy endings.",
                R.drawable.book5_inkbound));

        books.add(new Book("Startup Savage", "Nicole Vega",
                "Business / Entrepreneurship",
                "A brutally honest guide to launching a tech startup in the real world, full of failures, pivots, and unexpected wins.",
                R.drawable.book6_startup_savage));

        books.add(new Book("Beneath Crimson Skies", "Tomasz Novak",
                "Historical Fiction / WWII",
                "The intertwined lives of resistance fighters, spies, and survivors during the Nazi occupation of Warsaw.",
                R.drawable.book7_beneath_crimson));

        books.add(new Book("The Art of Stillness", "Tara Bell",
                "Self-Help / Mindfulness",
                "Learn how to find peace in a chaotic world by mastering the ancient wisdom of stillness.",
                R.drawable.book8_art_of_stillness));

        books.add(new Book("Neon Ghosts", "Khalid Jones",
                "Urban Fantasy / Mystery",
                "A private investigator with the ability to see spirits uncovers a supernatural conspiracy beneath the city's neon lights.",
                R.drawable.book9_neon_ghosts));

        books.add(new Book("Eat Green, Live Clean", "Dr. Sanjay Patel",
                "Health & Wellness",
                "A practical guide to plant-based nutrition and detox living, backed by science and easy recipes.",
                R.drawable.book10_eat_green));

        return books;
    }
}