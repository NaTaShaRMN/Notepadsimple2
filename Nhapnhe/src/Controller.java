import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
	public Controller() {
		
	}
	BufferedWriter bw = null;
	FileWriter fw = null;
	public void Savefile(String str) {
		try {
			fw = new FileWriter("File/Doanxem.txt");
			bw = new BufferedWriter(fw);
			bw.write(str);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
