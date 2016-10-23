import java.io.IOException;
import java.util.LinkedHashSet;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;





public class VerbFinder {
	
	   //---Finding the length of each verbs
 	
	 public	int[] verbLength(String[] verblist){
	 		int l=verblist.length;
	 		int[] verblength=new int[l];
	 		for(int j=0;j<l;j++){
	 			verblength[j]=verblist[j].length();
	 		}
	 		return verblength;
	 	}
	 //--end
	 
static LinkedHashSet<String> verbPhrases = new LinkedHashSet<>();  //No random positions and no duplicates
	    
String[] POSverb(String m) throws ClassNotFoundException, IOException{
	String tagged;
	
	MaxentTagger tagger = new MaxentTagger("taggers/left3words-wsj-0-18.tagger");
	tagged = tagger.tagString(m);
	String sp[]=tagged.split(" ");
	 for(int k=0;k<sp.length;k++){
		 String sl[]=sp[k].split("/");
		 if(sl[1].equals("VBG")||sl[1].equals("VB")||sl[1].equals("VBP")||sl[1].equals("VBD")||sl[1].equals("VBN")){
		 verbPhrases.add(sl[0]);
		 }
	 }
	 
	 String[] verblist=null;
	 verblist = new String[verbPhrases.size()];
	 verblist=verbPhrases.toArray(verblist);
	 verbPhrases.clear();
	 return verblist;
	
}
	     
}
