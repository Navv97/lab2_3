package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SimilarityFinderTest {
    private SimilarityFinder similarityFinder;

    @Test
    public void testJackardSimilarityWithEmptyCollections() {
        similarityFinder = new SimilarityFinder((key, seq) ->  SearchResult.builder().build());
        int[] collection1 = {};
        int[] collection2 = {};
        Assert.assertThat(1.0d, is(equalTo(similarityFinder.calculateJackardSimilarity(collection1, collection2))));
    }

}