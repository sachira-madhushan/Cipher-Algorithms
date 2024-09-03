import java.util.*;
public class Caesar{

	public static void main(String[] arg){

		Scanner sc=new Scanner(System.in);

		System.out.print("[?]Select your option(Encypt-0 | Decrypt-1) :");
		
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
			if(Character.isUpperCase(text.charAt(i))){
				encryptedText+=(char)((text.charAt(i)+key-'A')%26 + 'A');
			}else if(Character.isLowerCase(text.charAt(i))){
				encryptedText+=(char)((text.charAt(i)+key-'a')%26 + 'a');
			}else{
				encryptedText+=text.charAt(i);
			}
			
		}
		return encryptedText;
	}

	public static String decrypt(String text,int key){
		String decryptedText="";
		for(int i=0;i<text.length();i++){
			if(Character.isUpperCase(text.charAt(i))){
				decryptedText+=(char)((text.charAt(i)-(key%26)-'A')%26 + 'A');
			}else if(Character.isLowerCase(text.charAt(i))){
				decryptedText+=(char)((text.charAt(i)-(key%26)-'a')%26 + 'a');
			}else{
				decryptedText+=text.charAt(i);
			}
			
		}
		return decryptedText;
	}
}