package TrieImplementation;

public class Trie {

    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        //isEndOfWord will be true if this node represent the end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }

    }


    static TrieNode root;

    //If this key is not in trie,we will insert it
    //If the key is a prefix of a trie node ,make it leaf Node
    static void Insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode track = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (track.children[index] == null) {
                track.children[index] = new TrieNode();

                track = track.children[index];
            }
        }

        track.isEndOfWord = true;
    }

   static int count =0;
//Returns true if it is present in the trie
    static boolean search(String key) {
        int level;
        int index;
        int length = key.length();

        TrieNode track = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (track.children[index] == null) {
                return false;
            }

            track = track.children[index];
            count++;

        }

        return (track != null && track.isEndOfWord);


    }

    public static void main(String[] args) {
        /*String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
        root = new TrieNode();

        for(int i=0;i<keys.length;i++){
            Insert(keys[i]);
        }

        if(search("the")){
            System.out.println("Found");
        }*/
        root = new TrieNode();
        Insert("hack");
        Insert("hackerrank");

        search("hak");
        System.out.println(count);
    }
}
