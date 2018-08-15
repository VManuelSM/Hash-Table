/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.IOException;


/**
 *Dicctionary Class
 * This class includes the dicttionaryIndexes of type Index
 * @author Victor
 */
public class Dictionary {
    private Index dictionaryIndexes;
    /**
     * Builder
     * Requires:
     * @param size initialize the dictionaryIndexes 
     */
    public Dictionary(int size) {
        dictionaryIndexes = new Index(size);
    }
    /**
     * Initialize this instance of diccionary
     * Requires:
     * @param lineManager BufferedRedader that contains all words
     * that are stored in dictionaryIndexes
     * @throws IOException If the BufferedReader is null
     */
    public void initDictionary(BufferedReader lineManager) throws IOException {
        String line;
        String[] word;
        while((line =  lineManager.readLine()) != null){
            word = line.split("\t");
            if(word.length == 2) dictionaryIndexes.addWord(word[0].toUpperCase().trim(), word[1]);
            
            else System.out.println("This line has not the right text format");
        }
    }
    /**
     * dictionaryIndexes getter
     * @return Index dictionaryIndexes
     */
    public Index getDictionaryIndexes() {
        return dictionaryIndexes;
    }
    /**
     * dictionaryIndexes setter
     * Requires:
     * @param DictionaryIndexes Index dictionaryIndexes
     */
    public void setDictionaryIndexes(Index DictionaryIndexes) {
        this.dictionaryIndexes = DictionaryIndexes;
    }    
}
