import java.io.File;  
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
import java.io.PrintWriter;


public class Main {
public static void main(String[] args) throws IOException{
	
/*------declaration ta3 Scanner-------*/	
Scanner rd=new Scanner(System.in);

/*------Bienvenu ------*/											System.out.println("\n\n\u001B[32m*********************| BIENVENUE |*********************\u001B[37m\n");							
									



/*---------Creation ta3 lfichier ------- */
String nomfich="My Company Service(MCS).txt";
String data="\n";
String data2="\n";
int cmp=0;
int cmp2=0;
float PrixTotal=0;	
int t=0;
try{
    
    
File obj=new File(nomfich);


if(obj.createNewFile()){
	t=1;
System.out.println("\n\u001B[33mUn nouveau fichier a été créé.\u001B[37m\n");

}else {
    
    System.out.println("\n\u001B[33m Le fichier existe déjà.\u001B[37m\n");
    
Scanner Rd2=new Scanner(obj);
while (Rd2.hasNextLine()){
        data = data+Rd2.nextLine()+"\n";
      }		
Rd2.close();


Scanner Rd3=new Scanner(obj);
while(Rd3.hasNext()){
data2=Rd3.next();
if(data2.equals("●PRODUIT")){
 cmp++; }} 
Rd3.close();


Scanner Rd4=new Scanner(obj);
while(Rd4.hasNext()){
data2=Rd4.next();

if(data2.equals("●PRODUIT")){
 cmp2++; }

if(data2.equals("PRODUITS:")&& cmp2==cmp){
 data2=Rd4.next();
 PrixTotal=Float.valueOf(data2);
 break; }        
}



obj.delete();

File obj1=new File(nomfich);

}




}catch(FileNotFoundException e){
 e.printStackTrace();  }



/* nedo 3la lutilsateur Nombr de produit*/												
int NBP;

do{
    
System.out.println("Saisissez le nombre de produits (au moins trois) :  \n ");
System.out.print("===>>> ");
NBP=rd.nextInt();

						}while(NBP<3);			

								
																
																				
												
	
										
												
double pu,pl,tr,pap,tot;
int qtcom;
int Nbpro=0;
Nbpro=cmp;		
char choix='5';



PrintWriter wt=new PrintWriter(nomfich,"UTF-8");





wt.print(data);

/*ndiro la date li da5al fiha lutilsateur*/
LocalDateTime myObj = LocalDateTime.now();
DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
String forma = myObj.format(myFormatObj);  
   
  
     
/*nektbo fel fichier l3onwan w la date..ex*/ 
if(t==1){      
wt.println("******************| FACTURE |******************\n\n");	
}else{
wt.println("************************************************");
}
wt.println("My Company Service (MCS)\n\n");
wt.println("    "+forma);							


												
do{
	
if(choix=='1'){
	NBP=1;
	}																																	
for(int i=0;i<NBP;i++){
	Nbpro=Nbpro+1;
System.out.println("\n-------------------------------------------------------");	
System.out.println("\n\n\u001B[31m ●Produit "+Nbpro+"\u001B[37m\n");

System.out.print(" Entrez la quantité: \n===>>> ");		

		qtcom=rd.nextInt();																
System.out.print("\n Entrez le prix du produit: \n===>>> ");

	pu=rd.nextDouble();													
																			       tot=pu*qtcom;			



System.out.printf("\n le prix ​​total sans redaction et sans livraison: \u001B[31m %.2f DA.\u001B[37m\n",tot);			


/*prix de livraison*/
if(tot <= 500){
pl=tot*0.02;	 }	else{pl=0;}									
											
System.out.printf(" le prix de livraison:\u001B[31m %.2f DA.	\u001B[37m\n",pl);															
																					/*prix de la redaction*/											
if(tot >=200 && tot<=1000){										tr=tot*0.05;																}else{	tr=tot*0.1;}							
																					System.out.printf(" le prix de la réduction: \u001B[31m %.2f DA.\u001B[37m\n",tr);															
									
																																					
																					pap=tot+pl-tr;																																																				
System.out.printf(" le prix qui payè de produit %d: \u001B[31m %.2f DA	\u001B[37m\n\n",Nbpro,pap);																														PrixTotal=(float )(PrixTotal+pap);																															

																			
																																																															//Ecrire dans le fichier											
																																																														
																						wt.println("\n\n\n●PRODUIT "+Nbpro+":\n");										
wt.printf("La quantité de produit: %d DA.\n",qtcom);

wt.printf("le prix ​​unitaire: %.2f DA.\n",pu);					
	wt.printf("le prix ​​total sans redaction et sans livraison: %.2f DA.\n",tot);
	
																											
wt.printf("le prix de livraison: %.2f DA.\n",pl);																						wt.printf("le prix de la réduction: %.2f DA.\n",tr);							
								
		
wt.printf("le prix qui payè de produit :  %.2f DA.\n",pap,Nbpro);									
																					}		

												
System.out.printf("\n\n\n\n\u001B[32mLE PRIX TOTAL PAYÉ POUR TOUS LES PRODUITS: %.2f DA.\n\n	\u001B[37m\n\n",PrixTotal);	

																																										/*wt.printf("\n\n\n\n  LE PRIX ​​TOTAL PAYÉ POUR TOUS LES PRODUITS: %.2f DA.\n",PrixTotal);	*/				
																																																					

System.out.print("\n Entrez 1 ---------------> pour saisir un nouveau produit.\n Entrez autre chose -----> pour Quiter.\n\n===>>> ");

choix=rd.next().charAt(0);

}while(choix=='1');													
wt.printf("\n\n\n\n  LE PRIX ​​TOTAL PAYÉ POUR TOUS LES PRODUITS: %.2f DA.\n",PrixTotal);	



																																										System.out.println("\n\n\u001B[32m*************************| MERCI |************************* \u001B[37m\n\n");							
																					
																					wt.println("\n\n\n\n************************************************");					

																																																		rd.close();									
	wt.close();																																																													
	}
}