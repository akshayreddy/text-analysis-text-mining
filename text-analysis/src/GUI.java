import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	static Similarity sim1;
	static Similarity sim2;
	static Similarity sim3;
	static Similarity sim4;
	static Similarity sim5;
	static int f=1;
	static int g=0;
	final static JButton add1=new JButton("CHOOSE FILE 1");
	final static JButton add2=new JButton("CHOOSE FILE 2");
	final static JButton add3=new JButton("CHOOSE FILE 3");
	final static JButton add4=new JButton("CHOOSE FILE 4");
	final static JButton add5=new JButton("CHOOSE FILE 5");
	final static JButton comp1=new JButton("FIND SIMILARITY MEASURE");
	final static JButton refresh=new JButton("REFRESH");
	final static JLabel mesur=new JLabel("SIMILARITY MEASURE");
	final static TextField view3=new TextField(30);


	
	public static void main(String args[]) {

	final JFrame f1 = new JFrame("TEXT MINING");
	final JFrame f2 = new JFrame("Frame 2");
	
	final JFrame file1info = new JFrame("FILE 1 COMPUTATION VALUES");
	final JFrame file2info = new JFrame("FILE 2 COMPUTATION VALUES");
	
	final TextArea view1=new TextArea();
	final TextArea view2=new TextArea();
		
	final JFileChooser fc= new JFileChooser();
	
	JPanel Center_pan=new JPanel();
	JPanel bottom_pan=new JPanel();
	JPanel Center_N=new JPanel();
	JPanel Center_S=new JPanel();
	
	JLabel head=new JLabel("CONCEPT BASED SIMILARITY MEASURE");
	
	

	comp1.setForeground(Color.GRAY);
	refresh.setForeground(Color.BLUE);
	final JButton close=new JButton("EXIT");
	close.setForeground(Color.RED);
	
	
	f1.setLayout(new BorderLayout());
	Container contentPane = f1.getContentPane();
	contentPane.add(head,BorderLayout.NORTH);
	Center_N.add(add1);
	Center_N.add(add2);
	Center_N.add(add3);
	Center_N.add(add4);
	Center_N.add(add5);
	Center_S.add(comp1);
	Center_pan.add(Center_N);
	Center_pan.add(Center_S);
	
	bottom_pan.add(mesur);
	bottom_pan.add(view3);
	bottom_pan.add(refresh);
	bottom_pan.add(close);
	file1info.add(view1);
	file2info.add(view2);
	contentPane.add(Center_pan,BorderLayout.CENTER);
	contentPane.add(bottom_pan,BorderLayout.SOUTH);
	
	 class ButtonClick implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				if (e.getSource() == add1) {
					
			        int returnVal = fc.showOpenDialog(f2);

			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			        	
			        	
			           File file = fc.getSelectedFile();
			          
			     	   try {  
			            SentenceFormer obj1=new SentenceFormer();   
			            sim1=obj1.sentenceformer(file);
			            add1.setForeground(Color.BLUE);
			            refresh.setForeground(Color.RED);
			            g++;
			            if(g==5){
			            	comp1.setForeground(Color.DARK_GRAY);
			            }
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			        }
			       
			   }
			}
	 }
	add1.addActionListener(new ButtonClick());
	
	
	 class ButtonClick1 implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
	
	 if (e.getSource() == add2) {
			
	        int returnVal = fc.showOpenDialog(f2);

	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	           File file = fc.getSelectedFile();
	     	   try {
	     		SentenceFormer obj2=new SentenceFormer();   
	     		sim2=obj2.sentenceformer(file);
	     		add2.setForeground(Color.BLUE);
	     		refresh.setForeground(Color.RED);
	     		g++;
	     		 if(g==5){
		            	comp1.setForeground(Color.DARK_GRAY);
		            }
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	        }
	       
	      }
	    }
	 }
	add2.addActionListener(new ButtonClick1());
	
	
	class ButtonClick2 implements ActionListener{
		
		public void actionPerformed(ActionEvent e){

 if (e.getSource() == add3) {
		
        int returnVal = fc.showOpenDialog(f2);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
           File file = fc.getSelectedFile();
     	   try {
     		SentenceFormer obj3=new SentenceFormer();   
			sim3= obj3.sentenceformer(file);
			add3.setForeground(Color.BLUE);
			refresh.setForeground(Color.RED);
			g++;
			 if(g==5){
	            	comp1.setForeground(Color.DARK_GRAY);
	            }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        }
       
      }
    }
 }	
add3.addActionListener(new ButtonClick2());



class ButtonClick3 implements ActionListener{
	
	public void actionPerformed(ActionEvent e){

if (e.getSource() == add4) {
	
    int returnVal = fc.showOpenDialog(f2);

    if (returnVal == JFileChooser.APPROVE_OPTION) {
       File file = fc.getSelectedFile();
 	   try {
 		SentenceFormer obj4=new SentenceFormer();   
		sim4= obj4.sentenceformer(file);
		add4.setForeground(Color.BLUE);
		refresh.setForeground(Color.RED);
		g++;
		 if(g==5){
         	comp1.setForeground(Color.DARK_GRAY);
         }
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
    }
   
  }
}
}	
add4.addActionListener(new ButtonClick3());

class ButtonClick4 implements ActionListener{
	
	public void actionPerformed(ActionEvent e){

if (e.getSource() == add5) {
	
    int returnVal = fc.showOpenDialog(f2);

    if (returnVal == JFileChooser.APPROVE_OPTION) {
       File file = fc.getSelectedFile();
 	   try {
 		SentenceFormer obj5=new SentenceFormer();   
		sim5= obj5.sentenceformer(file);
		add5.setForeground(Color.BLUE);
		refresh.setForeground(Color.RED);
		g++;
		 if(g==5){
         	comp1.setForeground(Color.DARK_GRAY);
         }
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
    }
   
  }
}
}	
add5.addActionListener(new ButtonClick4());

    class ButtonClick5 implements ActionListener{
	
	     public void actionPerformed(ActionEvent e){

         if (e.getSource() == comp1) {
        	f++; 
        	if(f==2){
       	     comp1.setText("NEXT SIMILARITY MEASURE");
    	     SimilarityMeasure x=new SimilarityMeasure();
             x.Similarity(sim1, sim2, sim3,sim4,sim5,view3);
             mesur.setText("SIMILARITY MEASURE BETWEEN 1 AND "+f);
             x=null;
        	}
        	if(f==3){
          	    comp1.setText("NEXT SIMILARITY MEASURE");
       	        SimilarityMeasure x=new SimilarityMeasure();
                x.Similarity(sim1, sim3, sim2,sim4,sim5,view3);
                mesur.setText("SIMILARITY MEASURE BETWEEN 1 AND "+f);
                x=null;
           	}
        	if(f==4){
          	    comp1.setText("NEXT SIMILARITY MEASURE");
       	        SimilarityMeasure x=new SimilarityMeasure();
                x.Similarity(sim1, sim4, sim2,sim3,sim5,view3);
                mesur.setText("SIMILARITY MEASURE BETWEEN 1 AND "+f);
                x=null;
           	}
        	if(f==5){
          	    comp1.setText("DONE.HIT REFRESH TO RUN AGAIN");
       	        SimilarityMeasure x=new SimilarityMeasure();
                x.Similarity(sim1, sim5, sim2,sim4,sim3,view3);
                mesur.setText("SIMILARITY MEASURE BETWEEN 1 AND "+f);
                x=null;
           	}

          }
         }
        }
         comp1.addActionListener(new ButtonClick5());
         
         
         class ButtonClick6 implements ActionListener{
        		
        		public void actionPerformed(ActionEvent e){

        	if (e.getSource() == close) {
        		
        	   System.exit(0);
        	  }
        	}
        	}	
        	close.addActionListener(new ButtonClick6()); 
        
         class ButtonClick7 implements ActionListener{
        		
        		public void actionPerformed(ActionEvent e){

        	if (e.getSource() == refresh) {
        		f=1;
        		g=0;
        		add1.setForeground(Color.BLACK);
        		add2.setForeground(Color.BLACK);
        		add3.setForeground(Color.BLACK);
        		add4.setForeground(Color.BLACK);
        		add5.setForeground(Color.BLACK);
        		comp1.setText("FIND SIMILARITY MEASURE");
        		comp1.setForeground(Color.GRAY);
        		refresh.setForeground(Color.BLUE);
        		mesur.setText("SIMILARITY MEASURE");
        		view3.setText("");

        	  }
        	}
        	}	
        	refresh.addActionListener(new ButtonClick7());	
	
	
	f1.setResizable(false);
	f1.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	f1.setBounds(100, 100, 650, 500);
	f1.setVisible(true);
	

	}
	
}



class TabbedPane extends JFrame {
    
	
	private static final long serialVersionUID = 1L;

	public TabbedPane(Structure_tf[] storetf,int i,Structure[] store) {
		setTitle("File Result");


		JTable topic = new JTable(0,0);
		JTable sentence = new JTable(0,0);
		JTable verb = new JTable();
		
		int k;
		int[] ctfvalue;
		int[] conceptlength;
		int[] verblength;
		int[] tfvalue = null;
		
	
	      
		
		   DefaultTableModel dtmT = new DefaultTableModel(0, 0);
		   DefaultTableModel dtmS = new DefaultTableModel(0, 0);
		   DefaultTableModel dtmV = new DefaultTableModel(0, 0);
		   
		   String headerT[] = new String[] { "SENTENCE NO", "Topic", "ctf", "length", "df" };
		   String headerS[] = new String[] { "SENTENCE NO", "sentence" };
		   String headerV[] = new String[] { "SENTENCE NO","Verbs","length"};
		   
		   dtmT.setColumnIdentifiers(headerT);
	       topic.setModel(dtmT);
	       dtmS.setColumnIdentifiers(headerS);
	       sentence.setModel(dtmS);
	       dtmV.setColumnIdentifiers(headerV);
	       verb.setModel(dtmV);
	       
	       JScrollPane scrollPane = new JScrollPane( sentence );
	        getContentPane().add( scrollPane );
	       
	       dtmT.addRow(new Object[] {"SENTENCE NO.","Topic", "Concept term fequency(ctf)", "length", "term document frequency(df)"});
	       dtmS.addRow(new Object[] {"SENTENCE NO.","Sentence"});
	       dtmV.addRow(new Object[] {"SENTENCE NO.","Verbs","length"});
	       
	       for (int l=0;l<i;l++) {
	    	   
	    		tfvalue=storetf[l].getTf();
	    		ctfvalue=store[l].getCtf();
	    		conceptlength=store[l].getLength();
	    		verblength=store[l].getverbLength();
	    		
	    		dtmS.addRow(new Object[] { (l+1),store[l].getSname()});
	    		k=0;
	    		
			for(String x:store[l].getConcepts()){
				
				dtmT.addRow(new Object[] { (l+1),x,ctfvalue[k] ,conceptlength[k] ,tfvalue[k]});
				k++;
			}
			   k=0;
			for(String x:store[l].getVerbs()){
				dtmV.addRow(new Object[] {(l+1),x,verblength[k]});
				k++;
			}
			 
			tfvalue=null;
			ctfvalue=null;
			conceptlength=null;
	           
	    }
       
		      
        JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp);

        jtp.addTab("         SENTENCES                     ", sentence);
        jtp.addTab("             TOPICS                       ",topic);
        jtp.addTab("                 VERBS                       ", verb);
        
    }
}

class TabbedPane2 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TabbedPane2(String[] matchConf1,int[] matchctf1,int[] matchtf1,int[] matchlf1,int[] matchdf1,int[] matchvlf1,float[] weight1,float[] ratiol) {
	setTitle("MACHED CONCEPTS");


	JTable MatchedTopic = new JTable(0,0);
    
	DefaultTableModel dtmT = new DefaultTableModel(0, 0);
	
	String headerT[] = new String[] { "Topics", "Concept term frquency", "term frequency", "Concept length(CL)", "document frequency","Verb argument length(VL)","Concept weight","Ratio Of Cl & VL" };
	
	dtmT.setColumnIdentifiers(headerT);
    MatchedTopic.setModel(dtmT);
    
    dtmT.addRow(new Object[] {"Topics", "Concept term frquency", "term frequency", "Concept length(CL)", "document frequency","Verb argument length(VL)","weigth","Ratio Of Cl & VL"});
	
    for(int i1=0;i1<matchConf1.length;i1++){	
    	dtmT.addRow(new Object[] { matchConf1[i1],matchctf1[i1],matchtf1[i1],matchlf1[i1],matchdf1[i1],matchvlf1[i1],weight1[i1],ratiol[i1]});
		
	}
    
    JTabbedPane jtp = new JTabbedPane();
    getContentPane().add(jtp);

    jtp.addTab("         Matched topic details                    ", MatchedTopic);
    
	}
}
