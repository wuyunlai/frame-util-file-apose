package cn.wuyl.frame.util.file.apose;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import com.aspose.words.Document;
import com.aspose.words.ImportFormatMode;
import com.aspose.words.License;
import com.aspose.words.SectionStart;

public class AposeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadLicense();
		List<String> files = getFiles("D:\\testWord\\20150518\\1\\");//所以获取文件的path
		long startTime = System.currentTimeMillis(); //获取开始时间
		try {
			Document docAll = new Document();
			List<Document> docArrayList = getDocmentList(files);//doc=new Document(file);list.add(doc);
			int i = 0;
			for (Document doc : docArrayList) {
				//doc.getFirstSection().getPageSetup().setSectionStart(SectionStart.EVEN_PAGE);
				if(i++ == 0){
					docAll = doc;
				}else{
					docAll.appendDocument(doc,
							ImportFormatMode.KEEP_SOURCE_FORMATTING);
				}
			}
			docAll.save("D:\\merge.docx");
			System.out.println("----------------------------------ok");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis(); //获取结束时间
		System.out.println("---------------执行时间:： " + (endTime - startTime)
				+ "ms");
	}

	private static List<Document> getDocmentList(List<String> files) {
		// TODO Auto-generated method stub
		List<Document> dl = new ArrayList<Document>();
		for (String file : files) {
			try {
				Document d = new Document(file);
				dl.add(d);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dl;
	}

	private static List<String> getFiles(String path) {
		// TODO Auto-generated method stub
		List<String> files = new ArrayList<String>();
		files.add("D:\\A.docx");
		files.add("D:\\B.doc");
		return files;
	}

	private static void loadLicense(){
		String path = "D:\\DEV\\WORKSPACE\\MyEclipse6\\AposeTest\\src\\Aspose.Java.lic.txt" ;
		try {
			//加载license
			License lic = new License();
//			com.aspose.cells.License license = new com.aspose.cells.License();
//			license.setLicense(new FileInputStream(new File(path)));
//			lic.setLicense(new FileInputStream(new File(path)));
//			com.aspose.pdf.License pdflicense = new com.aspose.pdf.License();
//			pdflicense.setLicense(new FileInputStream(new File(path)));
			com.aspose.words.License wordlicense = new com.aspose.words.License();
			wordlicense.setLicense(new FileInputStream(new File(path)));
			System.out.println("载入授权文件成功!");
		} catch (Exception e1) {
			System.out.println("载入授权文件失败!path="+path);
			e1.printStackTrace();
		}
	}
}
