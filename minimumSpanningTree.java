import java.util.*;
import java.lang.*;
public class minimumSpanningTree 
{
	public int e,v;
	Edge []edge;
	
	 minimumSpanningTree(int e,int v)
	 {
		 this.e=e;
		 this.v=v;
		 edge=new Edge[e];
		 for(int i=0;i<e;i++)
			 edge[i]=new Edge();
		
	 }
	
	class Edge implements Comparable<Edge>
	{
		int src;
		int des;
		int weight;
		
		public int compareTo(Edge compareEdge)
		{
			return this.weight-compareEdge.weight;
		}
		
	}
	
   public int findParent(int v,int []parent)
   {
	   if(parent[v]==v)
		   return v;
	   return findParent(parent[v],parent);
   }
	public void kruskals(int e,int v) 
	{
		Arrays.sort(edge);
		Edge result[]=new Edge[v-1];
	   int parent[]=new int[v];
	   for(int i=0;i<v;i++)
		   parent[i]=i;
	   int count=0;
	   int i=0;
	   
	   while(count!=v-1)
	   {
		   Edge nextEdge=edge[i];
		   
		   int x=findParent(nextEdge.src,parent);
		   int y=findParent(nextEdge.des,parent);
		   
		   if(x!=y)
		   {
			   result[count]=nextEdge;
			   count++;
			   parent[x]=y;
		   }
		   i++;
		   
	   }
	   printArray(result);
	}
	
	public void printArray(Edge []result)
	{
		for(int i=0;i<v-1;i++)
		
		{
			System.out.println("src="+result[i].src+" des="+result[i].des+" weight="+result[i].weight);
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
	
	   minimumSpanningTree tree=new minimumSpanningTree(e,v);
		
	   for(int i=0;i<e;i++)
	   {
		   tree.edge[i].src=sc.nextInt();
		   tree.edge[i].des=sc.nextInt();
		   tree.edge[i].weight=sc.nextInt();
	   }
		
	   tree.kruskals(e,v);
	   
	}


}
