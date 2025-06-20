import java.io.*;
public class item{

public static void split(){

 int count = 0;
 int linesWritten =0;
 // enter number of lines you want in one small chunk file
 int linespersplit = 2000;

 // place the file location  that contains records
 String  inputFilepath =  "/Users/shaliniamith/Downloads/items_1906_refined.txt";
 // place the headers of the file menas the file contains only the database table column names
 String  inputFilepat =  "/Users/shaliniamith/Downloads/items_1906_1.txt";

 // place the file location where you want to  save the small chunk files
 String output = "/Users/shaliniamith/Downloads/FILES/";
 
 File input = new File(inputFilepath);
 File input1 = new File( inputFilepat);

 try{
 InputStream inputstream = new BufferedInputStream(new FileInputStream(input));
 InputStream inputstrea = new BufferedInputStream(new FileInputStream(input1));

 BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
 BufferedReader reade = new BufferedReader(new InputStreamReader(inputstrea));
 String outfilename = output+"items";
 String line = reader.readLine();
 String line1 = reade.readLine();

 while(line != null){
 if(count > 0){
 File outFile = new File(outfilename+"_"+count+".txt");
 Writer writer = new OutputStreamWriter(new FileOutputStream(outFile));
 writer.write(line1 + System.lineSeparator());
 while(line !=null && linesWritten < linespersplit){
 
 writer.write(line + System.lineSeparator());
 line = reader.readLine();
 linesWritten++;
 }
 writer.close();
 linesWritten = 0;
 count++;
 }else{
 File outFile = new File(outfilename+"_"+count+".txt");
 Writer writer = new OutputStreamWriter(new FileOutputStream(outFile));
 linesWritten--;
 while(line !=null && linesWritten < linespersplit){
 
 writer.write(line + System.lineSeparator());
 line = reader.readLine();
 linesWritten++;
 }
 writer.close();
 linesWritten = 0;
 count++;

 }
 
 }

 reader.close();
 reade.close();
 } catch (Exception e){}
 }


}