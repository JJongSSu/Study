package thebrains.pim.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import thebrains.pim.model.Member;

public class MemberFileWriter<T> {
	//BufferedWriter bw = null;
	FileWriter fw = null;
	public MemberFileWriter(File f) throws IOException {
		fw = new FileWriter(f);
		//bw = new BufferedWriter(fw); // bufferedWriter를 사용하여
	}
	public void saveMember(List<T> memberList) throws IOException {
		for(T memeber : memberList) {
			try {
				Member m = (Member) memeber;
				fw.write(m.getMno() + "\t");
				fw.write(m.getEmail() + "\t");
				fw.write(m.getPw() + "\t");
				fw.write(m.getName() + "\t");
				fw.write(m.getPhone() + "\t");
				fw.write(m.getAddress() + "\n");
				//fw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		fw.close();		
	}
}
