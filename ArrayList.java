package collections.list;

public class ArrayList implements List
{
   private int[] data;
   private int curIdx;

   public ArrayList()
   {
      System.out.print( "Original value of data: ");
      System.out.println(data);
      data = new int[10];
      System.out.print( "New value of data: ");
      System.out.println(data);
   }
   
   public int size()
   {
      return curIdx;
   }   
   public void clear()
   {
      curIdx = 0;
   }
   public boolean isFull()
   {
      return curIdx == data.length;
   }
   public boolean isEmpty()
   {
      return curIdx == 0;
   }
   public void set(int idx, int val)
   {
      if(idx < 0 || idx >= curIdx)
         throw new IndexOutOfBoundsException("Illegal index");
      data[idx] = val;

   }
   public int get(int idx)
   {
      if(idx < 0 || idx >= curIdx)
         throw new IndexOutOfBoundsException("Illegal index");
      return data[idx];

   }
   public int lastIndexOf(int val)
   {
      for(int i = curIdx - 1; i >= 0; i--)
      {
         if(data[i] == val)
            return i;
      }
      return -1;
   }
   public int indexOf(int val)
   {
      for(int i = 0; i < curIdx; i++)
      {
         if(data[i] == val)
            return i;
      }
      return -1;
   }
   public boolean contains(int val)
   {  
      boolean b = false;
      for(int i = 0; i < data.length; i++)
      {
         if(data[i] == val)
            b = true;
      }
      return b;
   }
   public int remove(int idx)
   {
      if(idx < 0 || idx >= curIdx)
         throw new IndexOutOfBoundsException("Illegal index");
      for(int i = idx; i < curIdx - 1; i++)
      {
         data[i] = data[i + 1];
      }
      curIdx--;
      
      
      
      int ret = data[idx];
      
      return ret;
   }
   public void add(int idx, int val)
   {
      if(idx < 0 || idx >= data.length)
         throw new IndexOutOfBoundsException();
       
      if(curIdx >= data.length)
      {
         int [] temp = new int[data.length*2];
         
         for(int i = 0; i < data.length; i++)
         {
            temp[i] = data[i];
         }
         data = temp;
      }

    
      for(int i = curIdx; i > idx; i--)
      {
         data[i] = data[i - 1];
      }
      data[idx] = val;
      curIdx++;
      
      
   }
   public void add(int val)
   {
      data[curIdx] = val;
      curIdx++;
      if(curIdx >= data.length)
      {
         int [] temp = new int[data.length*2];
         
         for(int i = 0; i< data.length; i++)
         {
            temp[i] = data[i];
         }
         data = temp;
      }
         
   }
   
   public String toString()
   {
      String ret = "[";
      for(int i = 0; i < curIdx; i++)
      {
         ret = ret + data[i] + " ";
      }
      ret = ret + "]";
      
      return ret;
   }
   
}