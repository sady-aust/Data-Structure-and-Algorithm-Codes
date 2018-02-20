package TrieImplementation;

public class TriePractice {

    public static final int ALPHABETSIZE = 26;

    static class TrieNode{
        boolean isWordFinished;
        TrieNode[] children = new TrieNode[ALPHABETSIZE];

        public TrieNode() {

            for(int i=0;i<ALPHABETSIZE;i++){
                children[i] = null;
            }
            isWordFinished = false;
        }
    }

   static TrieNode root;

    static void Insert(String key){
        TrieNode track = root;
        for(int i=0;i<key.length();i++){
            int index = key.charAt(i)-'a';
           // System.out.println(index);

            if(track.children[index]== null){
                track.children[index] = new TrieNode();
                track = track.children[index];
            }
        }

        track.isWordFinished = true;
    }

    static boolean search(String key){
        TrieNode track = root;

        for(int i=0;i<key.length();i++){
            int index = key.charAt(i)-'a';
            if(track.children[index]==null){
                return false;
            }
            track = track.children[index];
        }

        return true;
    }

    public static void main(String[] args) {
        root = new TrieNode();
        Insert("sady");
        System.out.println(search("sady"));
    }
}
