/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;

/**
 *Atomic Class that acts as a node and as a List
 * Is instanced like a array in Index Class
 * @author Victor
 */

public class Word extends ArrayList<Word>{
    private String concept;
    private String definition;
    
    /**
     * Builder
     * @param concept the concept of the word we want to store.
     * @param definition the definition of the word we want to store. 
     */
    public Word(String concept, String definition) {
        this.concept = concept;
        this.definition = definition;
    }
    /**
     * Concept getter
     * @return String concept
     */
    public String getConcept() {
        return concept;
    }
    /**
     * Concept setter
     * @param concept String concept 
     */
    public void setConcept(String concept) {
        this.concept = concept;
    }
    /**
     * Definition getter
     * @return String definition
     */
    public String getDefinition() {
        return definition;
    }
    /**
     * Definition setter
     * @param definition String definition 
     */
    public void setDefinition(String definition) {
        this.definition = definition;
    }
    /**
     * To String Method
     * @return the concept and definition about this instance of Word.
     */
    @Override
    public String toString() {
        return concept+"\n"+definition; 
    }
    
    
}
