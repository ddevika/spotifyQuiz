import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;



public class ZipfSong {
	

	public static void main (String [] args) throws IOException
	{
		
		long startTime = System.currentTimeMillis();
		//number of songs in album
		//String NumSIA_str;
		
		//number of songs played
		//String NumPlay = null;
		//int  number of songs in album
		int NumSIA =0;
		//number of songs to select
		int NumSTS= 0;
		int i;

		
		//ArrayList<Long> fi = new ArrayList<Long>();
		//ArrayList<String> test = new ArrayList<String>();
		List<String> test = new ArrayList<String>();
		List<String> test2 = new ArrayList<String>();
		//ArrayList<Long> qi = new ArrayList<Long>();
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(isr);

		//get how many songs in album and songs to select
	
		//NumSIA_str = stdin.readLine();	
		
		test2.add(stdin.readLine());
		String[] pieces = test2.get(0).trim().split("[ ]+");
		
		//debug
		//System.out.print(test2);
		
		NumSIA = Integer.parseInt(pieces[0]);
		NumSTS = Integer.parseInt(pieces[1]);
		
		Long [] fi = new Long[NumSIA];
		String [] songNames = new String[NumSIA];
		
		//debug
		//System.out.print(NumSIA);
		//System.out.print(NumSTS);

		
		//for each N get number of times of a song being played and the 
		//name of the songs
			
		for (i=0; i<NumSIA; i++)
		{
			test.add(stdin.readLine());
			//String[] pieces2 = NumPlay.trim().split("\\s+");
			
			//debug
			//System.out.print("a" + pieces2.length);
			/*for (int j=0; j<pieces2.length; j++)
			{
				System.out.println("i" +j +"_"+ pieces2[j]);
			}*/
			//test.add(NumPlay);
			
			//fi.add(Long.parseLong(pieces2[0]));
			//fi[i] = Long.parseLong(pieces2[0]);
			//songNames.add(pieces2[1]);
			//songNames[i] = pieces2[1];
			
		}
		
		//System.out.println("test" + test);
		stdin.close();
		
		for (i=0; i<test.size(); i++)
		{
			String[] pieces2 = test.get(i).trim().split("\\s+");
			fi[i] = Long.parseLong(pieces2[0]);
			songNames[i] = pieces2[1];
		}
		
		//debug
		for (i=0; i<fi.length; i++)
		{
		System.out.println("fi "+ fi[i]);
		System.out.println("songNames:" + songNames[i]);
		}
		//showMemory("before calling two methods");
		
		//qi = countQuality(fi, songNames, NumSTS);
		countQuality(fi, songNames, NumSTS, NumSIA);
		//debug
		//System.out.print("qi" + qi);
		
		//sortQuality(fi, songNames, NumSTS);
		
		//qi = null;
		fi = null;
		System.gc();
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		//showMemory("main");
		System.out.println("total time main:"+ totalTime);
		
		
	}

/*	public static void showMemory(String a)
	{
		Runtime rt = Runtime.getRuntime();
		long free = rt.getRuntime().freeMemory();
		long total = rt.getRuntime().totalMemory();
		long used = total - free;
		System.out.print(a + "free " + free + "total " +total + "used " + used);
		
	}*/
	
	//public static void countQuality (ArrayList<Long> a, ArrayList<String> b, int numSTS, int NumSIA)
	//@SuppressWarnings("null")
	public static void countQuality( Long [] a,String [] b, int numSTS, int NumSIA)
	{
		long startTime = System.currentTimeMillis();
		
		//ArrayList<Long> fi = new ArrayList<Long>();
		//ArrayList<Float> zi = new ArrayList<Float>();
		Float [] zi = new Float[NumSIA];
		Long [] qi = new Long[NumSIA];
		//ArrayList<Long> qi = new ArrayList<Long>();
		int i;

		
		try
		{
		//fi - number of times a song actually has been played
		//for (String myInt : a)
		/*for (i=0; i<a.size(); i++)
		{
			
			//fi.add(Integer.valueOf(myInt));
			fi.add(Long.parseLong(a.get(i)));
			
		}*/
		
		//debug
		//System.out.println("a size" + a.size());
		//System.out.println("fi size" + fi.size());
		
		//count zi - number of times a song should have been played
		for (i=0 ; i<a.length; i++)
		{
			zi[i]= null;
			//zi.add((float) (1.0/(i+1)+0.1));	
		}
		for (i=0 ; i<a.length; i++)
		{
			zi[i] = ((float) (1.0/(i+1)+0.1));
		}
		
		
		//debug
		
		//count quality - qi = fi/zi
		for (i=0 ; i<a.length; i++)
		{
			qi[i]= null;
			//zi.add((float) (1.0/(i+1)+0.1));	
		}
		for (i= 0 ; i<a.length; i++)
		{
			//qi.add((long)((float)(a.get(i))/zi.get(i)));
			qi[i] = ((long)((float)(a[i]/zi[i])));
			
		}
	
		
		}
		catch (Throwable e)
		{
			//System.out.print("exit");
			System.exit(1);
		}
		//debug
		//System.out.print("qi" + qi);
		
		//return qi;
		sortQuality(qi, b, numSTS);
		qi = null;
		zi = null;
		System.gc();
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		//showMemory("main");
		//System.out.println("total time countQuality:"+ totalTime);
	
		
	}
	
	//sort Quality and output the songNames with the highest quality
	//public static void sortQuality(ArrayList<Long> a, ArrayList<String> b, int NumToSelect)
	public static void sortQuality(Long [] a, String[] b, int NumToSelect)
	{
		long startTime = System.currentTimeMillis();
		ArrayList<String> a3 = new ArrayList<String>();
		
		int i;
		ConcurrentHashMap<Long, String> map = new ConcurrentHashMap<Long, String>();
		
		try
		{
		for (i=0; i<a.length; i++)
		{
		//map.put(a.get(i), b.get(i));
		map.put(a[i], b[i]);
		}
		
		//debug
		//System.out.println("map is" + map);
		
		//sort the hashmap
		Map<Long, String> treeMap = Collections.synchronizedMap(new TreeMap<Long, String>(map));
		//debug
		//System.out.println("TreeMap is" + treeMap);

		
		//a2.addAll(treeMap.keySet());
		a3.addAll(treeMap.values());
		
		
		//debug
		//System.out.println("a2 is" + a2);
		//System.out.println("a3 is" + a3);
	
			
		//System.out.print("a3 size -1" + (a3.size()));
		for (i=(a3.size()-1); i>= (a3.size() - NumToSelect); i--)
		{
			//System.out.print("i"+ i);
			System.out.println(a3.get(i));
		}
		
		//a2 = null;
		}
		catch (Throwable e)
		{
			System.out.print("catch exception");
			System.exit(1);
		}
		a3 = null;
		map = null;
		//treeMap = null;
		System.gc();
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		//showMemory("main");
		//System.out.println("total time sortQuality:"+ totalTime);
		
	}
	
	
}
