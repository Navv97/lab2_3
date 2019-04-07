package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SimilarityFinderTest {
    private SimilarityFinder similarityFinder;

    @Test
    public void testJackardSimilarityOnEmptyCollections() {
        similarityFinder = new SimilarityFinder((key, seq) ->  SearchResult.builder().build());
        int[] collection1 = {};
        int[] collection2 = {};
        Assert.assertThat(1.0d, is(equalTo(similarityFinder.calculateJackardSimilarity(collection1, collection2))));
    }

    @Test
    public void testJackardSimilarityOnDifferentCollections() {
        similarityFinder = new SimilarityFinder((key, seq) -> SearchResult.builder().withFound(false).build());
        int[] collection1 = {1,2,3};
        int[] collection2 = {4,5,6};
        Assert.assertThat(0d, is(equalTo(similarityFinder.calculateJackardSimilarity(collection1, collection2))));
    }

    @Test
    public void testJackardSimilarityOnEqualCollections() {
        similarityFinder = new SimilarityFinder((key, seq) -> {
            if (key == seq[0] || key == seq[1] || key == seq[2] || key == seq[3])
                return SearchResult.builder().withFound(true).build();
            return SearchResult.builder().withFound(false).build();
        });
        int[] collection1 = {1,2,3,4};
        int[] collection2 = {1,2,3,4};
        Assert.assertThat(1d, is(equalTo(similarityFinder.calculateJackardSimilarity(collection1, collection2))));
    }

}