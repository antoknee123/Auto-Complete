package second;

import java.lang.*;
//import BinarySearchDeluxe;
//import Term;
import java.util.Comparator;
import java.util.Arrays;

public class Autocomplete {
	private final Term[] terms;

    //Constructor
    public Autocomplete(final Term[] terms) { 
        this.terms = terms;
    }

    //Return all terms that start with the prefix in descending order of weights
    public int allMatches(final String prefix) { 
        int start = BinarySearchDeluxe.firstIndexOf(terms, prefix, 
Term.byPrefixOrder);
        final int end = BinarySearchDeluxe.firstIndexOf(terms, prefix, Term.byPrefixOrder);

        final Term[] matches = new Term[end - start];

        for(int i = 0; start <= end; i++, start++) { 
            matches[i] = this.terms[start];
        }

        return matches;
    }
}
}