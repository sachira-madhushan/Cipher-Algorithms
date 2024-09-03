import java.util.*;
public class RailFence{

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
		String[][] fence=new String[key][text.length()];
		String encryptedText="";
		for(int i=0;i<key;i++){
			for(int j=0;j<text.length();j++){
				fence[i][j]=" ";
			}
		}

		boolean down=true;
		int row=0;
		for(int i=0;i<text.length();i++){
			if(down){
				fence[row][i]=String.valueOf(text.charAt(i));
				row+=1;
				if(row==(key-1)){
					down=false;
				}
			}else{
				fence[row][i]=String.valueOf(text.charAt(i));
				row-=1;
				if(row==0){
					down=true;
				}
			}
		}
		

		/*for(int i=0;i<key;i++){
			for(int j=0;j<text.length();j++){
				System.out.print(fence[i][j]);
			}
			System.out.println();
		}
		*/

		for(int i=0;i<key;i++){
			for(int j=0;j<text.length();j++){
				if(fence[i][j]!=" "){
					encryptedText+=fence[i][j];
				}
			}
			
		}
		return encryptedText;

	}

	public static String decrypt(String text,int key){
		String[][] fence=new String[key][text.length()];
		String decryptedText="";
		for(int i=0;i<key;i++){
			for(int j=0;j<text.length();j++){
				fence[i][j]=" ";
			}
		}

		boolean down=true;
		int row=0;

		for(int j=0;j<text.length();j++){
				if(down){
					fence[row][j]="*";
					row++;
					if(row==key-1){
						down=false;
					}
				}else{
					fence[row][j]="*";
					row--;
					if(row==0){
						down=true;
					}
				}
		}

		/*for(int i=0;i<key;i++){
			for(int j=0;j<text.length();j++){
				System.out.print(fence[i][j]);
			}
			System.out.println();
		}*/

		int index=0;
		down=true;
		for(int i=0;i<key;i++){
			for(int j=0;j<text.length();j++){
				if(fence[i][j]=="*"){
					fence[i][j]=String.valueOf(text.charAt(index));
					index++;
				}
			}
			
		}

		down=true;
		row=0;

		for(int i=0;i<text.length();i++){
			if(down){
				decryptedText+=fence[row][i];
				row++;
				if(row==key-1){
					down=false;
				}
			}else{
				decryptedText+=fence[row][i];
				row--;
				if(row==0){
					down=true;
				}
			}
		}

		// for(int i=0;i<key;i++){
		// 	for(int j=0;j<text.length();j++){
		// 		System.out.print(fence[i][j]);
		// 	}
		// 	System.out.println();
		// }

		return decryptedText;
		
	}
}