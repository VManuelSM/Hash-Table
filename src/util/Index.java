/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.Normalizer;

/**
 *This class store the words in a array.
 * Contains the add, find and hash functions
 * to manager the words.
 * @author Victor
 */
public class Index {
    private Word[] index;
    private int size = 0;

    /**
     * Builder 
     * @param size int that initialize the index array
     * with the number of words we want to store.
     */
    public Index(int size) {
        this.size = size;
        index = new Word[size];
    }
    /**
     * This function add a word in the Word array.
     * Requires:
     * @param concept the String concept of a new word
     * @param definition the String definition of a new word 
     */
    public void addWord(String concept, String definition){
        Word newWord = new Word(concept, definition);
        System.out.println("Palabra: "+concept+"\n");
        System.out.print("\nFuncion add");
        if(index[hashFunction(cleanText(concept))]==null) 
            index[hashFunction(cleanText(concept))] = newWord; 
        else{
            index[hashFunction(cleanText(concept))].add(newWord);
        }
    }
    /**
     * Format the text to a new text without accents and weird signs.
     * Requires:
     * @param concept text is going to be formated
     * @return new formated text.
     */
    public static String cleanText(String concept) {
        String cleaned =null;
        if (concept !=null) {
            String value = concept;
            value = value.toUpperCase();
            cleaned = Normalizer.normalize(value, Normalizer.Form.NFD);
            cleaned = cleaned.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
            cleaned = Normalizer.normalize(cleaned, Normalizer.Form.NFC);
        }
        return cleaned;
    }
    /**
     * Find the word we want to know
     * Requires:
     * @param concept of the word saves in our index
     * @return a Word object, it can contains more than one Word
     * @return null if the Word in that position does not exists.
     */
    public Word findWord(String concept){
        return index[hashFunction(cleanText(concept))];
    }
    /**
     * Hash function, ubicates all words items inside the Word array
     * @param concept String concept which is split it to get each ASCII
     * value of its letters
     * @return int hash value
     */
    private int hashFunction(String concept){
        int asciiValue = 0;
        for(int i = 0; i < concept.length(); i++) asciiValue = asciiValue + concept.charAt(i);
        int hashValue = asciiValue % size;
        return hashValue;
    }
    
}
