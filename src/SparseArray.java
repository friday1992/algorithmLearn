import java.io.*;
import java.lang.reflect.Array;

public class SparseArray {
    public static void main(String[] args) throws IOException {
        int array[][] = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
        System.out.println("二维数组11X11");
        for(int row[]:array){
           for(int i:row){
               System.out.printf("%d \t" ,i);
           }
            System.out.println();
        }
        //获取数组不为0的个数和数值
        int sum = 0;//计算总数
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if(array[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        int sparseArray[][] = new int[sum+1][3];//创建稀疏数组
        //初始化稀疏数组
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //把不为0的值放入稀疏数组
        int count = 1;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if(array[i][j]!=0){
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = count;
                    count++;
                }
            }
        }
        //遍历稀疏数组
        System.out.println("稀疏数组");
        FileWriter fileWriter = new FileWriter("F:/CODE/data/sparseArray.txt");
        for(int i = 0;i<sparseArray.length;i++){
            System.out.printf("%d\t %d\t %d\t",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
            System.out.println();
            //把稀疏数组写入磁盘
            String str = sparseArray[i][0]+" "+sparseArray[i][1]+" "+sparseArray[i][2]+"\n";
            fileWriter.write(str);
        }
        fileWriter.close();
        //从磁盘读取数组
        BufferedReader bufferedReader = new BufferedReader(new FileReader("F:/CODE/data/sparseArray.txt"));
        String line;
        System.out.println("读取文件：");
        System.out.println("第一行：");
        String firstLine = bufferedReader.readLine();
        String[] firstStr = firstLine.split(" ");
        int num = Integer.valueOf(firstStr[2]);
        int[][] sparseArray2 = new int[num+1][3];
        sparseArray2[0][0]=Integer.valueOf(firstStr[0]);
        sparseArray2[0][1]=Integer.valueOf(firstStr[1]);
        sparseArray2[0][2]=num;
        int countLine = 1;
        while((line=bufferedReader.readLine())!=null){
           System.out.println(line);
           String[] lineStr = line.split(" ");
           int a = Integer.valueOf(lineStr[0]);
           int b = Integer.valueOf(lineStr[1]);
           int c = Integer.valueOf(lineStr[2]);
            sparseArray2[countLine][0]=a;
            sparseArray2[countLine][1]=b;
            sparseArray2[countLine][2]=c;
            countLine++;
        }
        //把稀疏数组还原
        int a = sparseArray2[0][0];
        int b = sparseArray2[0][1];
        int[][] returnArray = new int[a][b];
        for(int i=1;i<sparseArray2.length;i++){
            returnArray[sparseArray2[i][0]][sparseArray2[i][1]] = sparseArray2[i][2];
        }
        //打印数组
        System.out.println("还原后的数组");
        for(int row[]:returnArray){
            for(int i:row){
                System.out.printf("%d \t" ,i);
            }
            System.out.println();
        }
    }
    //扩展 把稀疏数组存入硬盘
    public static void saveDate(int[][] array){

    }
}
