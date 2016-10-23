import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;


public class SentenceFormer{
	Structure_tf[] storetf;
	
	Similarity sentenceformer(File file) throws IOException, ClassNotFoundException{
		
		
		
	//EPIC
		
		String paragraph;
		String v=file.getPath(); 
       if(v.charAt(v.length()-1)!='t'){
    	   v = v.replaceAll("(?i).docx", ".txt");
    	   File f=new File(v); 
    	   paragraph=new String(Files.readAllBytes(f.toPath()));
        }
       else{
    	   paragraph=new String(Files.readAllBytes(file.toPath()));
       }
		
		
//Initializations		
	String[] verblist;
	String[] conceptlist;
	
	int[] ctfvalue;
	int[] conceptlength;
	int[] verblength;
	int Sentence_count,i=0;
	
	
//Instantiation	
	VerbFinder vb=new VerbFinder();
	Concept_term_frequency ct=new Concept_term_frequency();
	Document_analysis tf=new Document_analysis();

//Getting the input from the file	
	
//	File f=new File("D:/demo.txt");
	
	
	
//---Using OpenNLP sentence finder model   
   	
	InputStream is = new FileInputStream("en-sent.bin");
	SentenceModel model = new SentenceModel(is);
	SentenceDetectorME sdetector = new SentenceDetectorME(model);
	
//--end	

	String sentences[] = sdetector.sentDetect(paragraph);      //List of Sentences
	Sentence_count=sentences.length;
	
	Structure[] store=new Structure[Sentence_count];         //Creating array of structures
	
//Analyzing each sentence 

	for(String x:sentences){
		
	verblist=vb.POSverb(x);                       //List of verbs for this sentence
	verblength=vb.verbLength(verblist);
	conceptlist=ct.concepts(x, verblist);           //List of concepts for this sentence
	ctfvalue=ct.ctf(conceptlist);                   //List of CTF values for the concepts
	conceptlength=ct.conceptLength(conceptlist);    //List of length of concepts
	
	store[i]=new Structure(x,conceptlist,ctfvalue,conceptlength,verblist,verblength);
	

	ctfvalue=null;
	conceptlength=null;
	verblength=null;
    conceptlist=null;
    verblist=null;
	i++;

	}
	
	storetf=tf.caltf(Sentence_count, store);
	
    Similarity sim=new Similarity(store, storetf,Sentence_count);
	///tab
    TabbedPane tp = new TabbedPane(storetf,i,store);
 //   tp.setDefaultCloseOperation(TabbedPane.EXIT_ON_CLOSE);
    tp.setBounds(750, 0, 600, 600);
    tp.setVisible(true);
	///
    
    

	is.close();
	return sim; 

 }
}







