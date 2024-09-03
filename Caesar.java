import java.util.*;
public class Caesar{

	public static void main(String[] arg){

		Scanner sc=new Scanner(System.in);

		System.out.println("Select your option(Encypt-0 | Decrypt-1) :");
		
		int option=sc.nextInt();
		sc.nextLine();
		if(option==0){
			System.out.print("Enter your text to encrypt :");
			String text=sc.nextLine();
			System.out.print("Enter your key :");
			int key=sc.nextInt();
			encrypt(text,key);
		}else{
			System.out.print("Enter your text to decrypt :");
			String text=sc.nextLine();
			System.out.print("Enter your key :");
			int key=sc.nextInt();
			decrypt(text,key);
		}

	}

	public static void encrypt(String text,int key){
		String encryptedText="";
		for(int i=0;i<text.length();i++){
			encryptedText+=(char)((text.charAt(i)+key-'A')%26 + 'A');
		}
		System.out.println("Encrypted Text :"+encryptedText);
	}

	public static void decrypt(String text,int key){
		String encryptedText="";
		for(int i=0;i<text.length();i++){
			encryptedText+=(char)((text.charAt(i)-(key%26)-'A')%26 + 'A');
		}
		System.out.println("Encrypted Text :"+encryptedText);
	}
}