package com.count.services;

import com.count.model.Word;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WordCountService {
	
	private static WordCountService wcsInstance = null;
	private static String wcSentence="";
	
	private WordCountService() {
		//wordList = new ArrayList<Word>();
	}
	
	public static WordCountService getInstance() {
		if (wcsInstance == null) {
			wcsInstance = new WordCountService();
		}
		return wcsInstance;
	}	
  
    public List<Word> findWordCount(String sentence) {
    	
    	List<Word> wordList = new ArrayList<Word>();    	
    	
    	String words[];
    	Word word = null;
    	
    	if (!StringUtils.isEmpty(sentence)) {
    		wcSentence = wcSentence + " " + sentence;
    		wcSentence = wcSentence.trim();
    		words = wcSentence.split(" ");
    		
    		List<String> strList = (List<String>) Arrays.asList(words);
    		Set<String> pstrList = new HashSet<>();  
            for(String str: strList) {
            	str = str.trim();
            	if (!str.isEmpty()) {            		
                    int count = Collections.frequency(strList, str);
                    if (pstrList.add(str)) {
                    	word = new Word(str, count);
                    	wordList.add(word);
            	    }
            	}
            }  
    	}    	 	
        return wordList;
    }
    
    public String resetWordCount() {
    	String message = "Reset successful";    	
    	wcSentence = "";
    	return message;
   }    

}
