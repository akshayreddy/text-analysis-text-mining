import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.StringTokenizer;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;


public class Concept_term_frequency {
	
	static int l;
	String[] concepts(String s,String[] v) throws IOException{
	
//Initializations		
	String input=s;
    String verb[]=v;
    int l=verb.length;
    String  concept[]=new String[2*l];
    String x="";
    String newinput="";
    int i,c=0,j=0,k;


//Using OpenNLP Tokenizer model 
    
			InputStream is = new FileInputStream("en-token.bin");
			TokenizerModel model = new TokenizerModel(is);
			Tokenizer tokenizer = new TokenizerME(model);
			
//---Removal of Stop Words from each sentence
			
			File f=new File("taggers/StopWords.txt");            //text file containing list of English Stop Words
	    	String paragraph=new String(Files.readAllBytes(f.toPath()));
	    	String StopWordsTokens[] = tokenizer.tokenize(paragraph);
	    	
			ArrayList<String> test = new ArrayList<String>();
			String pretokens[] = tokenizer.tokenize(input);
			
			for(String m:pretokens){
				test.add(m);
			}
			
			for(String m:StopWordsTokens){
				test.remove(m);
			}
			
			for (String m :test ){
			    x += m + " ";
			}
			
//--end		
			
//---Removing of delimiters	
			
	        String delim="[,;:!@#$%^&*()_+?/>.<[]{}|]";
	   		StringTokenizer in=new StringTokenizer(x,delim);//Tokenization
			
			while(in.hasMoreTokens()){
				newinput=newinput+in.nextToken().toString();
				}

//--end

//---Finding the concepts for each sentence			
		for(i=0;i<l;i++){
			
			ArrayList<String> list1 = new ArrayList<String>();
			ArrayList<String> list2 = new ArrayList<String>();
			
			String tokens[] = tokenizer.tokenize(newinput);
			k=j+1;
			
			for (String a : tokens){
				if (!(a.matches(verb[i])) && c==0){
	            list1.add(a);    
				
				}
				else{
				   list2.add(a);
				   c=1;
				}
			
		    }
			
			concept[j]="";
			concept[k]="";
			
			for (String m : list1)
			{
			    concept[j] += m + " ";
			}
			list1.clear();
			
			list2.remove(verb[i]);
			for (String m : list2)
			{
			    concept[k] += m + " ";
			}
			list2.clear();
			newinput=concept[k];
			j=j+2;
			c=0;
		    }
			is.close();
			return concept;
	
	}
//--end
	
//---Finding the Ctf values for each concepts	
	
	int[] ctf(String[] conceptlist){
         l=conceptlist.length;
         int[] conceptvalue=new int[l];      
         
         for(int j=l-1;j>=0;j--){
        	 conceptvalue[j]=l/2;
        	 j--;
        	 conceptvalue[j]=l/2;
        	 l=l-2;
         }
         return conceptvalue;
         
	}

//--end	
	
//---Finding the length of each concepts
	
	int[] conceptLength(String[] conceptlist){
		l=conceptlist.length;
		int[] conceptlength=new int[l];
		for(int j=0;j<l;j++){
        
			conceptlength[j]=(conceptlist[j].length());
		}
		return conceptlength;
	}
//--end	

}