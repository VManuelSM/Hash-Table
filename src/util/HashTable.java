/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author victo
 */
public class HashTable {
    private Dictionary Dictionary;
    
    public static enum Index
   {
     A, B, C, D, E, F, G, H, I, J, K, L, M, N, Ñ, O, P, Q, R, S, T, U, V, W, X, Y, Z;
     private Index() {} }
    
    public void insertWord(String concept, String definition){
    Word word = this.getDictionary().get(Index.A.ordinal()).get(0);
    }
    
    public Word getWord(String key){
    Word foundWord = null;
    String ejemplo = "Este es un ejemplo";
    char[] array = ejemplo.toCharArray();
    Word word = this.getDictionary().get(Index.A.ordinal()).get((int)array[0]);
    return foundWord;
    }
    
    public Dictionary getDictionary() {
        return Dictionary;
    }

    public void setDictionary(Dictionary Dictionary) {
        this.Dictionary = Dictionary;
    }
}
