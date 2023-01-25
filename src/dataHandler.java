import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class dataHandler {
	ArrayList<Data> datas = new ArrayList<>();
	private String name;

	public dataHandler(String fileName)
	{
		name = fileName;
	}

	public ArrayList<Data> GetDataFromFile() {
		ArrayList<Data> daaaaaaaa = new ArrayList<>();
		  try {
	            File file = new File(name +".txt");
				Scanner reading = new Scanner(file);
				while(reading.hasNextLine())
				{
					String[] line = reading.nextLine().split(",");
					daaaaaaaa.add(new Data(line[0], Integer.parseInt(line[1])));
				}
				reading.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return daaaaaaaa;
	    }
	public void UploadData() {
		try {
            FileWriter fw = new FileWriter(name+".txt");        
            for (int i =0;i<datas.size();i++)
			{
            	Data v = (datas.get(i));
            	fw.write(v.toString());
			}
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public ArrayList<Data> GetData() {
		return datas;
	}
	public void setData (ArrayList<Data> datas) {
		this.datas = datas;
	}

	//Bubble Sort
	public static void BubbleSort(ArrayList datas)
	{
		int n = datas.size();
		Data obj1, obj2, temp;
		double a, b;
		for (int i=0; i<n; i++)
		{
			for(int j = 1; j < (n-1); j ++)
			{
				obj1 = (Data)datas.get(j-1);
				obj2 = (Data)datas.get(j);
				a = obj1.getQuan();
				b = obj2.getQuan();

				if(a > b)
				{
					temp = obj1;
					datas.set(j-1, obj2);
					datas.set(j, temp);				
				}
			}
		}
	}
		
	}
	
