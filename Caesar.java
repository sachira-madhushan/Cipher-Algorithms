import java.util.*;
public class Caesar{

	public static void main(String[] arg){

		Scanner sc=new Scanner(System.in);

		System.out.println("[?]Select your option(Encypt-0 | Decrypt-1) :");
		
		int option=sc.nextInt();
		sc.nextLine();
		if(option==0){
			System.out.print("[?]Enter your text to encrypt :");
			String text=sc.nextLine();
			System.out.print("[?]Enter your key :");
			int key=sc.nextInt();
			System.out.println("[!]Encrypted Text :"+encrypt(text,key));
			
		}else{
			System.out.print("[?]Enter your text to decrypt :");
			String text=sc.nextLine();
			System.out.print("[?]Enter your key :");
			int key=sc.nextInt();
			System.out.println("[!]Decrypted Text :"+decrypt(text,key));
		}

	}

	public static String encrypt(String text,int key){
		String encryptedText="";
		for(int i=0;i<text.length();i++){
			encryptedText+=(char)((text.charAt(i)+key-'A')%26 + 'A');
		}
		return encryptedText;
	}

	public static String decrypt(String text,int key){
		String decryptedText="";
		for(int i=0;i<text.length();i++){
			decryptedText+=(char)((text.charAt(i)-(key%26)-'A')%26 + 'A');
		}
		return decryptedText;
	}
}