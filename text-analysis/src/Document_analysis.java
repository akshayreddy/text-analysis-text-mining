


public class Document_analysis{
	int i,j,k;
	
	
	Structure_tf[] caltf(int count,Structure[] store){
	Structure_tf[] storetf=new Structure_tf[count];	
	
	  for(i=0;i<count;i++){
		  String[] x=store[i].getConcepts();
		  int[] tfvalue=new int[store[i].getConcepts().length];
		  
		         for(String y:x){
		        	 for(j=0;j<count;j++){
		        	 String[] z=store[j].getConcepts();
		        	 
		        	    for(String y1:z){
		        	    	if(y.matches(y1) ){
		        	    		tfvalue[k]++;
		        	    		break;
		        	    	}
		        	    	else if(!(y.matches(y1))){
		        	    		continue;
		        	    	}
		        	       break;
		        	    }
		        	 }
		        	 k++; 
		         }  
			 storetf[i]=new Structure_tf(tfvalue);
			 tfvalue=null;
			 k=0;
		 }
	  return storetf;
	}
	 }



