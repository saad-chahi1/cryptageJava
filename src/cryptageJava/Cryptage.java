package cryptageJava;

import java.util.*;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Cryptage {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Hashtable ht = new Hashtable();
		
		HashMap<Integer, String> listeMotEncryptor = new HashMap<Integer, String>();
		
		ht.put(1, "Lundi");
		ht.put(2, "Mardi");
		ht.put(3, "Mercredi");
		ht.put(4, "Jeudi");
		ht.put(5, "Vendredi");
		ht.put(6, "Samedi");
		ht.put(7, "Dimenche");
		
		Enumeration en=ht.elements();
		int c=7;
		while(en.hasMoreElements()) {
			System.out.print(c+" : "+en.nextElement()+"     "); 
			c--;
		}	
		System.out.println(""); 
		int a=1;
		
		do {
		
		try {
		  System.out.println("Enter votre key(entre 1 et 7) : ");
		  int key = sc.nextInt();
	      Cryptage app = new Cryptage();
	      app.run(key,ht);
	      listeMotEncryptor.put(key,motCryptable);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("Si vous voulez crypter d'autre mot clique sur '1' sinon clique sur n'importe quelle chiffre");
		 a = sc.nextInt();
		
      }while(a==1);
    	  
		System.out.println(listeMotEncryptor);
		 
	}
	
	public static String motCryptable=" ";
	
	public void run(int k,Hashtable ht) 
    {
        try 
        {
            String text = (String) ht.get(k);
            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            motCryptable =new String(encrypted);
            //System.err.println(new String(encrypted));
            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));
            //System.err.println(decrypted);
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

}
