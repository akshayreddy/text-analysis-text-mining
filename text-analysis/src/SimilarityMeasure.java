import java.awt.TextField;
import java.util.ArrayList;


public class SimilarityMeasure {
	
	
	static float FinalCl(String[] matchConf1,String[] matchConf2,float[] weight1,float[] weight2,float[] ratiol1,float[] ratiol2){
		
		float similarity=0;
		
		for(int i=0;i<matchConf1.length;i++){
			for(int j=0;j<matchConf2.length;j++){
				if(matchConf1[i].matches(matchConf2[j])){
					if(ratiol1[i]>=ratiol2[j]){
						similarity=similarity+ratiol1[i]*weight1[i]*weight2[j];
					}
					else{
						similarity=similarity+ratiol1[j]*weight1[i]*weight2[j];
					}
					
				}
			}
		}
         return similarity;
		
	}

	
    void Similarity(Similarity sim1,Similarity sim2,Similarity sim3,Similarity sim4,Similarity sim5,TextField view){

    	
		  ArrayList<String> concept1=new ArrayList<>();	
		  ArrayList<String> concept2=new ArrayList<>();
		  ArrayList<String> concept3=new ArrayList<>();
		  ArrayList<String> concept4=new ArrayList<>();
		  ArrayList<String> concept5=new ArrayList<>();
		  

		///////////////////////////  
			for(int i=0;i<sim1.sentence_count;i++){
	             String[] temp=sim1.store[i].getConcepts();
	            	 
	              for(String x:temp){
	            	  concept1.add(x);
	              }
	              temp=null;
	             
			}
			
			for(int i=0;i<sim2.sentence_count;i++){
	            String[] temp=sim2.store[i].getConcepts();
	           	 
	             for(String x:temp){
	           	  concept2.add(x);
	             }
	            temp=null;
			}
			
			for(int i=0;i<sim3.sentence_count;i++){
	            String[] temp=sim3.store[i].getConcepts();
	           	 
	             for(String x:temp){
	           	  concept3.add(x);
	             }
	            temp=null;
			}
			
			for(int i=0;i<sim4.sentence_count;i++){
	            String[] temp=sim4.store[i].getConcepts();
	           	 
	             for(String x:temp){
	           	  concept4.add(x);
	             }
	            temp=null;
			}
			
			for(int i=0;i<sim5.sentence_count;i++){
	            String[] temp=sim5.store[i].getConcepts();
	           	 
	             for(String x:temp){
	           	  concept5.add(x);
	             }
	            temp=null;
			}
			/////////////////////////////////
		
			////////////////////////////////////////
			
			
	        int[] ctf1=new int[concept1.size()];
	        int[] tf1=new int[concept1.size()];
	        int[] lf1=new int[concept1.size()];
	        int[] vlf1=new int[concept1.size()];
	        
	        int z=0;
			for(int i=0;i<sim1.sentence_count;i++){
	            int[] temp=sim1.store[i].getCtf();
	      
	             for(int x:temp){
	           	  ctf1[z]=x;
	             z++;
	             }
	            
			}
			
			    z=0;
				for(int i=0;i<sim1.sentence_count;i++){
		            int[] temp=sim1.store[i].getverbLength();
		      
		             for(int x:temp){
		           	  vlf1[z]=x;
		       
		              z++;
		             }
		            
				}
			
	        z=0;
			for(int i=0;i<sim1.sentence_count;i++){
	            int[] temp=sim1.store[i].getLength();
	           
	             for(int x:temp){
	           	  lf1[z]=x;
	          	 
	          	  z++;
	             }
	            
			}
			
			z=0;
			for(int i=0;i<sim1.sentence_count;i++){
	            int[] temp=sim1.storetf[i].getTf();
	         
	             for(int x:temp){
	           	  tf1[z]=x;
	           	  z++;
	             }
	            
			}
		///////////////////////////////////////////////////////////////	
			
			////////////////////////////////////////
			
	        int[] ctf2=new int[concept2.size()];
	        int[] tf2=new int[concept2.size()];
	        int[] lf2=new int[concept2.size()];
	        int[] vlf2=new int[concept1.size()];
	        
	        z=0;
			for(int i=0;i<sim2.sentence_count;i++){
	            int[] temp=sim2.store[i].getCtf();
	          
	             for(int x:temp){
	           	  ctf2[z]=x;
	              z++;
	             }
	            
			}
			
			  z=0;
				for(int i=0;i<sim2.sentence_count;i++){
		            int[] temp=sim2.store[i].getverbLength();
		      
		             for(int x:temp){
		           	  vlf2[z]=x;
		             z++;
		             }
		            
				}
			
		    z=0;
			for(int i=0;i<sim2.sentence_count;i++){
	            int[] temp=sim2.store[i].getLength();
	          
	             for(int x:temp){
	           	  lf2[z]=x;
	              z++;
	             }
	            
			}
			
		    z=0;
			for(int i=0;i<sim2.sentence_count;i++){
	            int[] temp=sim2.storetf[i].getTf();
	           
	             for(int x:temp){
	           	  tf2[z]=x;
	           	  z++;
	             }
	            
			}
	////////////////////////////////
			int i=0;
			for(String x:concept1){
				if(concept2.contains(x)){
					i++;
				}
				
			}
	
	String[] matchConf1=new String[i];
	int[] matchctf1=new int[i];
	int[] matchtf1=new int[i];
	int[] matchlf1=new int[i];
	int[] matchdf1=new int[i];
	int[] matchvlf1=new int[i];
	float[] weight1=new float[i];
	float[] ratiol1=new float[i];
	
	int c=0;
	int j=0;
	
	String[] Sconf1=new String[concept1.size()];
	Sconf1=concept1.toArray(Sconf1);
	
			for(i=0;i<Sconf1.length;i++){
				if(concept2.contains(Sconf1[i])){
					if(concept3.contains(Sconf1[i])){
						matchdf1[j]=3;
						if(concept4.contains(Sconf1[i])){
							matchdf1[j]=4;
							if(concept5.contains(Sconf1[i])){
								matchdf1[j]=5;
							}
						}
					}
					else{
					    matchdf1[j]=2;
					}
					if(i%2==0){
						matchvlf1[j]=Sconf1[i].length()+Sconf1[i+1].length()+vlf1[(int)i/2];
					}
					else{
						matchvlf1[j]=Sconf1[i].length()+Sconf1[i-1].length()+vlf1[(int)i/2];
					}
					
					matchConf1[j]=Sconf1[i];
					matchctf1[j]=ctf1[c];
					matchtf1[j]=tf1[c];
					matchlf1[j]=lf1[c];
					weight1[j]=((matchtf1[j]+matchctf1[j])*(float)(Math.log((float)5/matchdf1[j])));
					ratiol1[j]=(float) matchlf1[j]/matchvlf1[j];

					
					j++;
				}
				c++;
			}
			
			TabbedPane2 x=new TabbedPane2(matchConf1, matchctf1, matchtf1, matchlf1, matchdf1, matchvlf1,weight1,ratiol1);
		//	 x.setDefaultCloseOperation();
			 x.setBounds(750, 0, 600, 600);
			    x.setVisible(true);
			    
			    
				////////////////////////////////
			    i=0;
				for(String x1:concept2){
					if(concept1.contains(x1)){
						i++;
					}
					
				}
		
		String[] matchConf2=new String[i];
		int[] matchctf2=new int[i];
		int[] matchtf2=new int[i];
		int[] matchlf2=new int[i];
		int[] matchdf2=new int[i];
		int[] matchvlf2=new int[i];
		float[] weight2=new float[i];
		float[] ratiol2=new float[i];
		
		c=0;
		j=0;
		
		String[] Sconf2=new String[concept2.size()];
		Sconf2=concept2.toArray(Sconf2);
		
				for(i=0;i<Sconf2.length;i++){
					if(concept1.contains(Sconf2[i])){
						if(concept3.contains(Sconf2[i])){
							matchdf2[j]=3;
							if(concept4.contains(Sconf2[i])){
								matchdf2[j]=4; 
								if(concept5.contains(Sconf2[i])){
									matchdf2[j]=5; 
								}
							}
						}
						else{
						    matchdf2[j]=2;
						}
						if(i%2==0){
							matchvlf2[j]=Sconf2[i].length()+Sconf2[i+1].length()+vlf2[(int)i/2];
						}
						else{
							matchvlf2[j]=Sconf2[i].length()+Sconf2[i-1].length()+vlf2[(int)i/2];
						}
						
						matchConf2[j]=Sconf2[i];
						matchctf2[j]=ctf2[c];
						matchtf2[j]=tf2[c];
						matchlf2[j]=lf2[c];
						weight2[j]=(matchtf2[j]+matchctf2[j])*(float)(Math.log((float)5/matchdf2[j]));
						ratiol2[j]=(float)matchlf2[j]/matchvlf2[j];
						
						j++;
					}
					c++;
				}
				
				TabbedPane2 z1=new TabbedPane2(matchConf2, matchctf2, matchtf2, matchlf2, matchdf2, matchvlf2,weight2,ratiol2);
	//			 z1.setDefaultCloseOperation(TabbedPane.EXIT_ON_CLOSE);
				    z1.setBounds(750, 300, 600, 600);
				    z1.setVisible(true);
				    
				    
				    	    
		view.setText(String.valueOf(FinalCl(matchConf1,matchConf2,weight1,weight2,ratiol1,ratiol2)));
		
		}
}
