
public class Structure {

//Structure Fields	
	
	String Sname;
	String[] concepts;
	int[] ctf;
	int[] length;
	int[] verblength;
	String[] verbs;

//Storing values
	
	Structure(String Sname,String[] concepts,int[] ctf,int[] length,String[] verbs,int[] verblength){
		this.Sname=Sname;
		this.concepts=concepts;
		this.ctf=ctf;
		this.length=length;
		this.verblength=verblength;
		this.verbs=verbs;
	}
	
	String getSname(){
		return this.Sname;		
	}
	
	String[] getConcepts(){
		return this.concepts;
	}
	
	int[] getCtf(){
		return this.ctf;
	}
	
	int[] getLength(){
		return this.length;
	}
	
	int[] getverbLength(){
		return this.verblength;
	}
	
	String[] getVerbs(){
		return this.verbs;
	}

}

class Structure_tf{
	int[] tfvalue;
	
	Structure_tf(int[] tfvalue) {
		this.tfvalue=tfvalue;
	}
	
	int[] getTf(){
		return this.tfvalue;
	}
}


class Similarity{
	Structure[] store;
	Structure_tf[] storetf;
	int sentence_count;
	
	public Similarity(Structure[] store,Structure_tf[] storetf,int sentence_count) {
        this.store=store;
        this.storetf=storetf;
        this.sentence_count=sentence_count;
	}
	
	Structure[] getStore(){
		return this.store;
	}
	
	Structure_tf[] getStoretf(){
		return this.storetf;
	}
	
	int getSenenceCount(){
		return this.sentence_count;
	}
	
}

