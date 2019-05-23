# [Class defines two or more one for one associated lists or arrays](http://fb-contrib.sourceforge.net/bugdescriptions.html#PL_PARALLEL_LISTS)

This class appears to maintain two or more lists or arrays whose contents are related in a parallel way.  That is,
			you have something like:  

    List<String> words = new ArrayList<String>();
    List<Integer> wordCounts = new ArrayList<String>();

			where the elements of the list at index 0 are related, the elements at index 1 are related and so on. 

			Consider creating a separate class to hold all the related
			pieces of information, and adding instances of this class to just one list or array, or if just two values, use
			a Map to associate one value with the other like:  

    private class WordAndCount{public String word;  public int count}

    List<WordAndCount> wordsAndCounts = new ArrayList<WordAndCount>();
    //or, for just two elements
    Map wordCounts = new HashMap();